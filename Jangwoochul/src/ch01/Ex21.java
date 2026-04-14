package ch01;

public class Ex21 {
    public static void main(String[] args) {
        String userInput = "NaN";
        double val = Double.valueOf(userInput);

        double currentBalance = 10000.0;

        if(Double.isNaN(val)) {
            System.out.println("NaN이 입력돼 처리불가");
            val = 0.0;
        }
        currentBalance += val;
        System.out.println(currentBalance);
    }
}
