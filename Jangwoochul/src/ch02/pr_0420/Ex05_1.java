package ch02.pr_0420;

//20260420 Ex05
// Ex05_1,2 , Ex05
public class Ex05_1 {
    private long balance;

    public Ex05_1() {
    }

    public long getBalance() {
        return balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) throws Ex05 {
        if (balance < money) {
            throw new Ex05("잔고부족 : " + (money - balance) + "모자람");
        }
        balance -= money;
    }
}
