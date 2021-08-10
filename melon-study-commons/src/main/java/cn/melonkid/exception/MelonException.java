package cn.melonkid.exception;

import org.slf4j.helpers.MessageFormatter;

/**
 * 异常处理
 *
 * @author imelonkid
 * @date 2021/08/10 15:38
 **/
public class MelonException extends RuntimeException {

    private MelonStatusCodeEnums statusCode;

    public MelonException(){

    }

    public MelonException(MelonStatusCodeEnums statusCode) {
        super(statusCode.getMsg());
        this.statusCode = statusCode;
    }

    public MelonException(MelonStatusCodeEnums statusCode, String errMsg) {
        super(errMsg);
        this.statusCode = statusCode;
    }

    public MelonException(MelonStatusCodeEnums statusCode, String errMsg, Object...errParams) {
        this(statusCode, MessageFormatter.arrayFormat(errMsg, errParams).toString());
    }


    public MelonStatusCodeEnums getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(MelonStatusCodeEnums statusCode) {
        this.statusCode = statusCode;
    }
}
