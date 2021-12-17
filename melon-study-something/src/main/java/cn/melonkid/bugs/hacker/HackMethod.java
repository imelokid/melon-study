package cn.melonkid.bugs.hacker;

import javax.naming.Context;
import javax.naming.Name;
import javax.naming.spi.ObjectFactory;
import java.util.Hashtable;

/**
 * @author zhengyuanyuan05
 * @date 2021/12/17 14:53
 **/
public class HackMethod implements ObjectFactory {

    static{
        System.out.println("这是注入的代码");
    }

    @Override
    public Object getObjectInstance(Object obj, Name name, Context nameCtx, Hashtable<?, ?> environment) throws Exception {
        return new HackMethod();
    }
}
