import entity.Userinfo;
import org.apache.ibatis.session.SqlSession;

import java.io.IOException;
import java.util.List;


public class Select {
    public static void main(String[] args) throws IOException {
//        long id = 2;


        SqlSession session = DBTools.getSqlSession();
        UserinfoMapper mapper = session.getMapper(UserinfoMapper.class);

//        Userinfo userinfo = mapper.getUserinfoById(id);
//        System.out.println(userinfo.getUsername());
        List<Userinfo> listUserinfo = mapper.getUserinfoByIds(1, 2);
        for (int i = 0; i < listUserinfo.size(); i++) {
            Userinfo userinfo = listUserinfo.get(i);
            System.out.println(userinfo.getUsername());
        }
        session.commit();
        session.close();
    }
}