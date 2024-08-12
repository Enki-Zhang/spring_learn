package spring_pro.exception;

import spring_pro.result.BaseErrorInfoInterface;

/**
 * @ClassName BizException
 * @Description 自定义异常处理类
 * @Author Enki
 * @Date 2024/8/12 8:58
 * @Verison 1.0
 **/
public class MyException extends RuntimeException{

    private static final long serialVersionUID = -8298720077385993751L;
    /**
     * 错误码
     */
    protected String errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public MyException() {
        super();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface) {
        super(errorInfoInterface.getResultCode());
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMessage();
    }

    public MyException(BaseErrorInfoInterface errorInfoInterface, Throwable cause) {
        super(errorInfoInterface.getResultCode(), cause);
        this.errorCode = errorInfoInterface.getResultCode();
        this.errorMsg = errorInfoInterface.getResultMessage();
    }

    public MyException(String errorMsg) {
        super(errorMsg);
        this.errorMsg = errorMsg;
    }

    public MyException(String errorCode, String errorMsg) {
        super(errorCode);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException(String errorCode, String errorMsg, Throwable cause) {
        super(errorCode, cause);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
