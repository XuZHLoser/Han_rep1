import org.apache.ibatis.session.SqlSession;

import java.io.IOException;

public class GetSqlSession {
    private static ThreadLocal<SqlSession> t1 = new ThreadLocal<SqlSession>();

    public static SqlSession getSqlSession() throws IOException {
        SqlSession session = t1.get();
        if (session == null) {
            session = GetSqlSessionFactory.getSqlSessionFactory().openSession();
            t1.set(session);
        } else { }
        return session;
    }

    public static void commit() {
        if (t1.get() != null) {
            t1.get().commit();
            t1.get().close();
            t1.set(null);
        }
    }

    public static void rollback() {
        if (t1.get() != null) {
            t1.get().rollback();
            t1.get().close();
            t1.set(null);
        }
    }
}
