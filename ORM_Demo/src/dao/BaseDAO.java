package dao;

import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dbtools.GetConnection;

public class BaseDAO<T> {
    //此方法模拟了Mybatis的save()方法，使用的技术本质上就是JDBC和反射
    public void save(T t) throws IllegalArgumentException,
            IllegalAccessException, ClassNotFoundException, SQLException {
        String sql = "insert into ";
        String colName = "";
        String colParam = "";
        String begin = "(";
        String end = ")";
        Class classRef = t.getClass();
        String tableName = classRef.getSimpleName().toLowerCase();
        sql = sql + tableName;
        List values = new ArrayList();
        Field[] fieldArray = classRef.getDeclaredFields();//获取类的成员变量
        for (int i = 0; i < fieldArray.length; i++) {
            Field eachField = fieldArray[i];
            eachField.setAccessible(true);
            String eachFieldName = eachField.getName();
            Object eachValue = eachField.get(t);
            colName = colName + "," + eachFieldName;
            colParam = colParam + ",?";
            values.add(eachValue);
        }
        colName = colName.substring(1);
        colParam = colParam.substring(1);
        sql = sql + begin + colName + end;
        sql = sql + " values" + begin + colParam + end;
        System.out.println(sql);
        for (int i = 0; i < values.size(); i++) {
            System.out.println(values.get(i));
        }
        Connection conn = GetConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < values.size(); i++) {
            ps.setObject(i + 1, values.get(i));
        }
        System.out.println(ps.toString());
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    //此方法模拟了mybatis的get()方法
    public T get(Class<T> classObject, long id) throws
            InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException{
        T t = null;
        String sql = "select * from " + classObject.getSimpleName().toLowerCase() + " where id = ?";
        Connection conn = GetConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setLong(1, id);
//        System.out.println(ps.toString());
        ResultSet rs = ps.executeQuery();
        while(rs.next()) {
            t = classObject.newInstance();
            Field[] fieldArray = classObject.getDeclaredFields();
            for (int i = 0; i < fieldArray.length; i++) {
                Field eachField = fieldArray[i];
                eachField.setAccessible(true);
                String fieldname = eachField.getName();
                Object value = rs.getObject(fieldname);
                if (value.getClass().getTypeName().equals("java.math.BigDecimal")) {
                    long longValue = Long.parseLong("" + value);
                    eachField.set(t, longValue);
                } else {
                    eachField.set(t, value);
                }
            }
        }
        rs.close();
        ps.close();
        conn.close();
        return t;
    }
    //此方法用于接受一个类来自动创建一个表单
    public void createTable(Class<T> classObject) throws IllegalArgumentException,
            IllegalAccessException, ClassNotFoundException, SQLException {
        Connection conn = GetConnection.getConnection();
        Statement stat = conn.createStatement();

        String tableName = classObject.getSimpleName().toLowerCase();
        String sql = "create table " + tableName;
        String start = "(";
        String end = ")";
        String subSql = "";
        Field[] fieldArray = classObject.getDeclaredFields();
        for (int i = 0; i < fieldArray.length; i++) {
            Field eachField = fieldArray[i];
            String fieldname = eachField.getName();
            String fieldtype = eachField.getType().getSimpleName();
            fieldtype = transform(fieldtype);
            subSql = subSql + "," + fieldname + " " + fieldtype;
        }
        subSql = subSql.substring(1);
        sql = sql + start + subSql + end;
        System.out.println(sql);
        //创建表
        stat.executeUpdate(sql);
        stat.close();
        conn.close();
    }
    public String transform(String type) {
        String trueType = "";
        if (type.equals("String")) {
            trueType = "varchar(20)";
        }
        else if (type.equals("long")) {
            trueType = "int";
        }
        return trueType;
    }
    public void updata(T t) throws IllegalArgumentException, IllegalAccessException,
            ClassNotFoundException, SQLException {
        String sql = "update " + t.getClass().getSimpleName().toLowerCase() + " set ";
        String whereSQL = " where id=?";
        String colName = "";
        Class classRef = t.getClass();
        List values = new ArrayList();
        Field[] fieldArray = classRef.getDeclaredFields();
        long idValue = 0;
        for (int i = 0; i < fieldArray.length; i++) {
            Field eachField = fieldArray[i];
            eachField.setAccessible(true);
            String eachFieldName = eachField.getName();
            if (!eachFieldName.equals("id")) {
                Object eachValue = eachField.get(t);
                colName = colName + "," + eachFieldName + "=?";
                values.add(eachValue);
            } else {
                Object eachValue = eachField.get(t);
                idValue = Long.parseLong(eachValue.toString());
            }
        }
        values.add(idValue);

        colName = colName.substring(1);
        sql = sql + colName + whereSQL;
        System.out.println(sql);
        Connection conn = GetConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        for (int i = 0; i < values.size(); i++) {
            ps.setObject(i + 1, values.get(i));
        }
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
    public void delete(T t) throws IllegalArgumentException, IllegalAccessException,
            ClassNotFoundException, SQLException, NoSuchFieldException, SecurityException{
        String sql = "delete from " + t.getClass().getSimpleName().toLowerCase();
        String whereSQL = " where id=?";
        Class classRef = t.getClass();
        Object value = new Object();
        Field idField = classRef.getDeclaredField("id");
        idField.setAccessible(true);
        Object object = idField.get(t);
        value = object;
        sql = sql + whereSQL;
//        for (int t = 0; i < values.size(); i++) {
////            System.out.println(values.get(i));
////        }
        System.out.println(value);
        Connection conn =GetConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setObject(1, value);
        ps.executeUpdate();
        ps.close();
        conn.close();
    }
}
