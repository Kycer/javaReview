package Main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author yk
 * @version 1.0 Date: 2017/5/27
 */
public class ServerMain {

    private static final Logger logger = LoggerFactory.getLogger(ServerMain.class);

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "spring/spring-core.xml", "spring/spring-registry.xml" });
        context.start();
        logger.info("dubbo服务启动成功，按任意键退出。");
        System.in.read(); // 按任意键退出
        logger.info("dubbo服务已停止");
    }
}
