package ch02.pr_0420;

//20260420 Ex07
// SmartPhone.java , SmartPhoneEx01
public class SmartPhoneEx01 {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("구글", "안드로이드");

        String strObj = myPhone.toString();
        System.out.println(strObj);

        System.out.println(myPhone);
    }
}
