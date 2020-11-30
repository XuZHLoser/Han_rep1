import dao.BaseDAO;

import java.sql.SQLException;

public class Update {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException,
            ClassNotFoundException, SQLException {
        BaseDAO<Userinfo> dao = new BaseDAO<>();
        Userinfo userinfo = dao.get(Userinfo.class, 1000L);
        userinfo.setUsername("legendhan");
        userinfo.setPassword("123654");
        dao.updata(userinfo);
    }
}
