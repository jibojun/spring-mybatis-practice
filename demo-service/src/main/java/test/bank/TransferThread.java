package test.bank;

import java.math.BigDecimal;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 11:37
 * @Description:
 */
public class TransferThread implements Runnable {
    //操作的银行
    private Bank bank;
    //转出账户
    private Account fromAccount;
    //转入账户
    private Account toAccount;
    //操作金额
    private BigDecimal amount;

    public TransferThread(Bank bank, Account fromAccount, Account toAccount, BigDecimal amount) {
        this.bank = bank;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
    }

    @Override
    public void run() {
        bank.transfer(fromAccount, toAccount, amount);
    }
}
