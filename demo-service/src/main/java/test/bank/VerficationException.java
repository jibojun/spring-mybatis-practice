package test.bank;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-01 14:28
 * @Description: 请求参数校验异常
 */
public class VerficationException extends CommonException {
    public VerficationException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public String toString() {
        return String.format("参数校验异常，异常友好信息：%s", this.getErrorMessage());
    }
}
