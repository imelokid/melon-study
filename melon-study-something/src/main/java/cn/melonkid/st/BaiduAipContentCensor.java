package cn.melonkid.st;

import com.baidu.aip.contentcensor.AipContentCensor;
import org.json.JSONObject;

/**
 * AipContentCensor
 *
 * @author imelonkid
 * @date 2021/09/17 10:31
 **/
public class BaiduAipContentCensor {

    //设置APPID/AK/SK
    public static final String APP_ID = "24863642";
    public static final String API_KEY = "Ljt93VZbph4m7ZxRuafdCHVl";
    public static final String SECRET_KEY = "K3zBCy8FO2Ei5GGfkE2yDsoG2d9WGpjN";

    public static void main(String[] args) {
        // 初始化一个AipContentCensor
        AipContentCensor client = new AipContentCensor(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
//
//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "test.jpg";
        JSONObject res = client.textCensorUserDefined("江泽民人存在的意义在于社会我是谁，这应该是哲学中最基本也是最重要的问题。在《苏菲的世界》中就是以我是谁为起源，来延伸出哲学的相关介绍。而关于我是谁的讨论在哲学界也是争论不休。在世界的东方，老子是东方在世纪之初最著名的思想家。在物质世界不断丰富的当时，老子在名利与权势的迷宫中，破天荒的发现了人的生命价值，他认为生命贵于名利，追求名利是为了人的生命，如果名利损害人的生命，宁肯抛弃名利，也要保全自己的生命。");
        System.out.println(res.toString(2));

    }
}
