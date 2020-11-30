import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class GetSqlSessionFactory {
    //工厂创建非常耗时，且工厂实例在程序执行期间应始终存在，因此最好的方式是
    // 使用单例模式创建Factory对象
    private static SqlSessionFactory factory;
    private GetSqlSessionFactory() {}

    synchronized public static SqlSessionFactory getSqlSessionFactory()
        throws IOException {
        if (factory == null) {
            String configFile = "mybatis-config.xml";
            InputStream configStream = Resources.getResourceAsStream(configFile);
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            factory = builder.build(configStream);
        }
        return factory;
    }
}
