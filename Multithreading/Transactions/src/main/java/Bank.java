package java;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicLong;

public class Bank {

    private Map<String, Account> accounts = new HashMap<>();
    private final Random random = new Random();

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    public void add(java.Account account){
        accounts.put(account.getAccNumber(), account);
    }

    public void transfer(String fromAccountNum, String toAccountNum, long amount) throws InterruptedException {
        Account fromAccount = accounts.get(fromAccountNum);
        Account toAccount = accounts.get(toAccountNum);
        if (fromAccount.isBlock() || toAccount.isBlock()){
            System.out.println("Transaction blocked!");
        } else if (fromAccountNum.compareTo(toAccountNum) < 0){
            synchronized (fromAccount) {
                synchronized (toAccount) {
                    fromAccount.setMoney(getBalance(fromAccountNum) - amount);
                    toAccount.setMoney(getBalance(toAccountNum)  + amount);
                }
            }
        } else {
            synchronized (toAccount){
                synchronized (fromAccount) {
                    fromAccount.setMoney(getBalance(fromAccountNum) - amount);
                    toAccount.setMoney(getBalance(toAccountNum)  + amount);
                }
            }
        }

        if (amount > 50000 && isFraud(fromAccountNum, toAccountNum,amount)) {
            fromAccount.setBlock(true);
            toAccount.setBlock(true);
        }
    }

    public long getBalance(String accountNum) {
       return accounts.get(accountNum).getMoney();
    }

    public long getSumAllAccounts() {
        AtomicLong sum = new AtomicLong();
        accounts.forEach((k, v) -> sum.addAndGet(v.getMoney()));
        return sum.get();
    }

    public Map<String, Account> getAccounts() {
        return accounts;
    }
}
