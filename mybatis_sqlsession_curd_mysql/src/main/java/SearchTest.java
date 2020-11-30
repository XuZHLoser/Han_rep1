import entity.Userinfo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;


public class SearchTest {
    public static void main(String[] args) throws IOException {
        long id = 1;


        SqlSession session = DBTools.getSqlSession();

        Userinfo userinfo = session.selectOne("getUserinfoById", id);
        System.out.println(userinfo.getId());
        session.commit();
        session.close();
    }
}
