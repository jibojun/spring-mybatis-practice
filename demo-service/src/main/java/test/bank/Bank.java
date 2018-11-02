package test.bank;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 10:54
 * @Description:
 */
public class Bank {
    //银行拥有的账户
    private List<Account> accountList;
    //账户转账操作处理器
    private AccountTransferProcessor accountTransferProcessor = new AccountTransferProcessor();
    //流水操作记录
//    private

    public Bank(List<Account> accountList) {
        this.accountList = accountList;
    }

    public void registerAccouns(List<Account> accountList) {
        this.accountList.addAll(accountList);
    }

    public void transfer(Account fromAccount, Account toAccount, BigDecimal transferAmount) {
        accountTransferProcessor.process(fromAccount, toAccount, transferAmount);
    }
}
