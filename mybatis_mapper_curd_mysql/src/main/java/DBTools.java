import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class DBTools {
    public static SqlSession getSqlSession() throws IOException {
        String configFile = "mybatis-config.xml";
        InputStream configStream = Resources.getResourceAsStream(configFile);
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(configStream);
        return factory.openSession();
    }
}