package cn.melonkid.util;

import cn.melonkid.exception.MelonException;
import cn.melonkid.exception.MelonStatusCodeEnums;

/**
 * @author imelonkid
 * @date 2021/09/04 17:54
 **/
public class AssertUtil {

    public static void assertTrue(boolean val, MelonStatusCodeEnums errorCode) {
        assertFalse(!val, errorCode);
    }

    public static void assertFalse(boolean val, MelonStatusCodeEnums errorCode) {
        if(val) {
            throw new MelonException(errorCode);
        }
    }
}
