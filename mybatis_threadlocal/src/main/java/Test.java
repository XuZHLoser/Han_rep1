import entity.Userinfo;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        SqlSession session = null;
        try {
            Userinfo userinfo1 = new Userinfo();
            userinfo1.setUsername("jshjs");
            userinfo1.setPassword("jfdfhsd");
            userinfo1.setAge(23);
            userinfo1.setInsertdate(new Date());

            Userinfo userinfo2 = new Userinfo();
            userinfo2.setUsername("jshjs");
            userinfo2.setPassword("sfsdfsfsdfsdfsdfsdfdsfsdfsdfsdfdsf" +
                    "sdfsdfdsfdsfdfdsfdsfsdfsdfsdfsdfdsfsdfsfsd" +
                    "sfsdfsdfsfsdfsdfsdddddddddfsdfsdfsdfsdfsdfsd" +
                    "sdfsdfsdfsdfdssdfsdfsdfsd");
            userinfo2.setAge(23);
            userinfo2.setInsertdate(new Date());
            // 测试回滚事务，若数据库中记录数目不变，说明已经回滚
            session = GetSqlSession.getSqlSession();
            UserinfoMapper mapper = session.getMapper(UserinfoMapper.class);
            mapper.insert(userinfo1);
            mapper.insert(userinfo2);
        } catch (Exception e) {
            e.printStackTrace();
            GetSqlSession.rollback();
        } finally {
            GetSqlSession.commit();
        }
    }
}
