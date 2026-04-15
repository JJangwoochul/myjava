//Ex20.java의 클래스
package ch02;

public class Car05 {
    // 필드
    int gas;

    // 생성자 , 메소드
    void setGas(int gas) {
        this.gas = gas;
    }

    boolean ifLeftGas() {
        if (gas == 0) {
            System.out.println("gas가 없습니다.");
            return false;
        }
        System.out.println("gas가 있습니다.");
        return true;
    }

    void run() {
        while (true) {
            if (gas > 0) {
                System.out.println("달립니다. (gas 잔량 : " + gas + ")");
                gas -= 1;
            } else {
                System.out.println("멈춥니다. (gas 잔량 : " + gas + ")");
                return;
            }
        }
    }
}
