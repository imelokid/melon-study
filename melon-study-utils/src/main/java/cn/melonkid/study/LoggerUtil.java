package cn.melonkid.study;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.MessageFormatter;

/**
 * 日志工具类
 *
 * @author imelonkid
 * @date 2021/08/10 16:04
 **/
public class LoggerUtil {

    /** ERROR-LOGGER */
    private static Logger LOGGER = LoggerFactory.getLogger("ERROR-LOGGER");


    public static void debug(Logger logger, String msg, String...params) {
        String finalMsg = generateMsg(msg, params);
        logger.debug(finalMsg);
    }

    public static void info(Logger logger, String msg, String...params) {
        String finalMsg = generateMsg(msg, params);
        logger.info(finalMsg);
    }

    public static void warn(Logger logger, String msg, String...params) {
        String finalMsg = generateMsg(msg, params);
        logger.warn(finalMsg);
    }

    public static void error(String msg, String...params) {
        String finalMsg = generateMsg(msg, params);
        LOGGER.error(finalMsg);
    }

    private static String generateMsg(String msg, String[] params) {
        return MessageFormatter.arrayFormat(msg, params).getMessage();
    }
}
