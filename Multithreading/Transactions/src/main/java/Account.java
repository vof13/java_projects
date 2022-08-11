package java;

public class Account {

    private volatile long money;
    private String accNumber;
    boolean block = false;

    public Account(String accNumber, long money) {
        this.accNumber = accNumber;
        this.money = money;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
}
