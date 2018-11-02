package test.bank;

import java.math.BigDecimal;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 11:26
 * @Description:
 */
public class AccountTransferProcessor extends AbstractAccountBizProcessor<Account, Account> {

    @Override
    protected void verify(Account fromAccount, Account toAccount, BigDecimal opAmount) {
        //账户余额校验
        if (!isAccountBalanceEnough(fromAccount, opAmount)) {
            throw new VerficationException(String.format("账户:%s， 当前余额不足", fromAccount.getAccountId()));
        }
    }

    @Override
    protected void bizHandling(Account fromAccount, Account toAccount, BigDecimal opAmount) {
        synchronized (this) {
            transferOut(fromAccount, opAmount);
            transferIn(toAccount, opAmount);
        }
    }

    private void transferIn(Account account, BigDecimal amount) {
        account.setBalance(account.getBalance().add(amount));
    }

    private void transferOut(Account account, BigDecimal amount) {
        //并发情况再次校验，保证余额足够
        if (!isAccountBalanceEnough(account, amount)) {
            throw new VerficationException(String.format("其他线程操作扣款，账户:%s，余额不足", account.getAccountId()));
        }
        account.setBalance(account.getBalance().subtract(amount));
    }

    private boolean isAccountBalanceEnough(Account account, BigDecimal amount) {
        return account.getBalance().compareTo(amount) >= 0;
    }
}
