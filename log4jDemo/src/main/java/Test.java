import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class Test {

    private static final Logger logger = LogManager.getLogger(Test.class);
    public static void main(final String... args) {
        logger.info("log4j test.");
        logger.error("this is error message .");
    }
}