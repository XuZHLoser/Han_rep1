import dao.BaseDAO;

import java.sql.SQLException;

public class Create {
    public static void main(String[] args) throws IllegalArgumentException,
            IllegalAccessException, ClassNotFoundException, SQLException {

        BaseDAO<Userinfo> dao = new BaseDAO<>();
        dao.createTable(Userinfo.class);
    }
}
