package test.bank;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-01 11:19
 * @Description: 业务处理异常
 */
public class BizException extends CommonException {

    BizException(String errorMessage) {
        super(errorMessage);
    }

    @Override
    public String toString() {
        return String.format("业务异常，异常友好信息：%s", this.getErrorMessage());
    }
}
