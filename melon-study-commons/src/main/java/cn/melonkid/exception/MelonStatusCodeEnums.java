package cn.melonkid.exception;

/**
 * Melon业务状态编码
 *
 * @author imelonkid
 * @date 2021/08/10 15:41
 **/
public enum MelonStatusCodeEnums {

    /** 业务处理成功 */
    OK("OK", "操作成功"),

    /** 系统异常 */
    SYSTEM_ERROR("SYSTEM_ERROR", "系统异常"),

    /** 参数异常 */
    PARAMS_ILLG("PARAMS_ILLG", "参数异常"),
    ;

    private String code;

    private String msg;

    MelonStatusCodeEnums(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
