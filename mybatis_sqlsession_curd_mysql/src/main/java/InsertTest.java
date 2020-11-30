import entity.Userinfo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;

public class InsertTest  {
    public static void main(String[] args) throws IOException {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("legendhan");
        userinfo.setPassword("456");
        userinfo.setAge(100);
        userinfo.setInserdate(new Date());

        SqlSession session = DBTools.getSqlSession();
        session.insert("insertUserinfo", userinfo);
        session.commit();
        session.close();
    }
}
