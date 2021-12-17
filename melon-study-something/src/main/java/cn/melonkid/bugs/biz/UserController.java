package cn.melonkid.bugs.biz;


import cn.melonkid.bugs.http.HandleGet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author zhengyuanyuan05
 * @date 2021/12/16 22:58
 **/
public class UserController {

    Logger logger = LogManager.getLogger(HandleGet.class);

    public String query(String name) {
        logger.info("name:{}", name);
        return "hello:" + name;
    }

}
