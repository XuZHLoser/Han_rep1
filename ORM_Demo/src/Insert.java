import dao.BaseDAO;

import java.sql.SQLException;

public class Insert {
    public static void main(String[] args) throws IllegalArgumentException,
            IllegalAccessException, ClassNotFoundException, SQLException {
        Userinfo userinfo = new Userinfo();
        userinfo.setId(1000L);
        userinfo.setUsername("xuzhuohan");
        userinfo.setPassword("123456");
        BaseDAO<Userinfo> dao = new BaseDAO<>();
        dao.save(userinfo);
    }
}
