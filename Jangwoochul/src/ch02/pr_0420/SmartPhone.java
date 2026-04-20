package ch02.pr_0420;

//20260420 Ex07
// SmartPhone.java , SmartPhoneEx01
public class SmartPhone {
    private String company;
    private String os;

    public SmartPhone(String company, String os) {
        this.company = company;
        this.os = os;
    }

    @Override
    public String toString() {
        return company + " , " + os;
    }
}
