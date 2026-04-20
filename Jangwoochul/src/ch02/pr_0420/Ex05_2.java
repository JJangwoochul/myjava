package ch02.pr_0420;

//20260420 Ex05
// Ex05_1,2 , Ex05
public class Ex05_2 {
    public static void main(String[] args) {
        Ex05_1 account = new Ex05_1();

        account.deposit(10000);
        System.out.println("예금액 : " + account.getBalance());

        try {
            account.withdraw(30000);
        } catch (Ex05 e) {
            String message = e.getMessage();
            System.out.println(message);
            System.out.println();
            e.printStackTrace();
        }
    }
}
