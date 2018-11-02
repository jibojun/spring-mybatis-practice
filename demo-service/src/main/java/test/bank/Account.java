package test.bank;

import java.math.BigDecimal;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 10:54
 * @Description:
 */
public class Account {

    private String accountId;
    private BigDecimal balance;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
