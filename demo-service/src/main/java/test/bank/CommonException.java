package test.bank;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-01 14:32
 * @Description: 自定义异常
 */
public class CommonException extends RuntimeException {
    /**
     * 友好错误信息
     */
    protected final String errorMessage;

    public CommonException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
