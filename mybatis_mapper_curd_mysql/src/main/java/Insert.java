import entity.Userinfo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.Date;

public class Insert {
    public static void main(String[] args) throws IOException {
        Userinfo userinfo = new Userinfo();
        userinfo.setUsername("不灭定律");
        userinfo.setPassword("546");
        userinfo.setAge(100);
        userinfo.setInsertdate(new Date());

        SqlSession session = DBTools.getSqlSession();
        UserinfoMapper mapper = session.getMapper(UserinfoMapper.class);
        mapper.insertUserinfo(userinfo);
        session.commit();
        session.close();

        System.out.println("id=" + userinfo.getId());
    }
}
