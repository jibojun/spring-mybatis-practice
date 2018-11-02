package test.bank;

import java.math.BigDecimal;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 11:26
 * @Description:
 */
public abstract class AbstractAccountBizProcessor<TFromAccount, TToAccount> {

    public void process(TFromAccount fromAccount, TToAccount toAccount, BigDecimal opAmount) {
        long currentTime = System.currentTimeMillis();
        try {
            verify(fromAccount, toAccount, opAmount);
            bizHandling(fromAccount, toAccount, opAmount);
        } catch (VerficationException e) {
            System.out.println(String.format("验证错误：%s", e.getErrorMessage()));
        } catch (BizException e) {
            System.out.println(String.format("业务错误：%s", e.getErrorMessage()));
        } catch (Exception e) {
            System.out.println(String.format("程序错误：%s", e.getMessage()));
        } finally {
            long finishTime = System.currentTimeMillis();
            System.out.println(String.format("处理时间：%s", finishTime - currentTime));
        }
    }

    protected abstract void verify(TFromAccount fromAccount, TToAccount toAccount, BigDecimal opAmount) throws VerficationException;

    protected abstract void bizHandling(TFromAccount fromAccount, TToAccount toAccount, BigDecimal opAmount) throws BizException;
}
