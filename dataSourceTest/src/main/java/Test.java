import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        MysqlDataSource  mysqlDataSource = new MysqlDataSource();
        mysqlDataSource.setURL("jdbc:mysql://localhost:3306/demo2?serverTimezone=UTC");
        mysqlDataSource.setUser("root");
        mysqlDataSource.setPassword("123");

        DataSource dataSource = mysqlDataSource;

        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }


}
