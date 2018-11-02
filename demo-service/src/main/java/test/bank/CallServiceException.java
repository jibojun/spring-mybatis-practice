package test.bank;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-01 14:51
 * @Description:
 */
public class CallServiceException extends CommonException {
    public CallServiceException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public String toString() {
        return String.format("调用接口异常，异常友好信息：%s", this.getErrorMessage());
    }
}
