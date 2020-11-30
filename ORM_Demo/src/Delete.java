import dao.BaseDAO;

import java.sql.SQLException;

public class Delete {
    public static void main(String[] args) throws IllegalArgumentException,
            IllegalAccessException, ClassNotFoundException, SQLException,
            InstantiationException, NoSuchFieldException, SecurityException {
        BaseDAO<Userinfo> dao = new BaseDAO<>();
        Userinfo userinfo = dao.get(Userinfo.class, 1000L);
        dao.delete(userinfo);
    }
}
