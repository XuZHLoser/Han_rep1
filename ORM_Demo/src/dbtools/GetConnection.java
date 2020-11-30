package dbtools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLRecoverableException;

public class GetConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException{
//        String driverName = "oracle.jdbc.OracleDriver";
        String driverName = "com.mysql.cj.jdbc.Driver";
//        String url = "jdbc:oracle:thin:@localhost:1521:orcl";
        String url = "jdbc:mysql://localhost:3306/demo1?characterEncoding=UTF-8&serverTimezone=UTC";
        String username = "root";
        String password = "123";
        Class.forName(driverName);
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }
}
