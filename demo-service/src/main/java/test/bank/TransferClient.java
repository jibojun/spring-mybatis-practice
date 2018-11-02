package test.bank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Bojun Ji
 * @Date: Created in 2018-11-02 14:13
 * @Description:
 */
public class TransferClient {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account();
        account1.setAccountId("1");
        account1.setBalance(new BigDecimal(1000));
        Account account2 = new Account();
        account2.setAccountId("2");
        account2.setBalance(new BigDecimal(100));
        List<Account> accountList = new ArrayList<>();
        accountList.add(account1);
        accountList.add(account2);
        Bank bank = new Bank(accountList);

        ExecutorService threadPool = Executors.newFixedThreadPool(60);
        long currentTime = System.currentTimeMillis();
        for (int i = 0; i < 60; i++) {
            TransferThread transferThread = new TransferThread(bank, account1, account2, new BigDecimal(33));
            threadPool.submit(transferThread);
        }
        threadPool.shutdown();
        while (!threadPool.awaitTermination(Long.MAX_VALUE, TimeUnit.MINUTES)) {
        }
        long endTime = System.currentTimeMillis();
        System.out.println(String.format("并发耗时:%s ms", endTime - currentTime));
        System.out.println(String.format("account1余额:%s", account1.getBalance()));
        System.out.println(String.format("account2余额:%s", account2.getBalance()));
    }
}
