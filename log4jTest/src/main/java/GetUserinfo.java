import entity.Userinfo;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class GetUserinfo {
    public static void main(String[] args) {
        try {
            Userinfo queryUserinfo = new Userinfo();
            queryUserinfo.setUsername("%h%");
            queryUserinfo.setPassword("%4%");

            SqlSession sqlSession = GetSqlSession.getSqlSession();
            List<Userinfo> listUserinfo = sqlSession.selectList("getUserinfo", queryUserinfo);
            for (int i = 0; i < listUserinfo.size(); i++) {
                Userinfo userinfo = listUserinfo.get(i);
                System.out.println(userinfo.getUsername());
            }
            sqlSession.commit();
            sqlSession.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
