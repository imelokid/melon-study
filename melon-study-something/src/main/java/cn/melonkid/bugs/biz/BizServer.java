package cn.melonkid.bugs.biz;

import cn.melonkid.bugs.http.NettyServer;

/**
 * 业务代码-存在漏洞，并被黑客注入
 *
 * @author zhengyuanyuan05
 * @date 2021/12/16 20:48
 **/
public class BizServer {

    public static void main(String[] args) {
        NettyServer server = new NettyServer(8080);
        try {
            server.init();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("exception: " + e.getMessage());
        }
        System.out.println("server close!");

    }



}
