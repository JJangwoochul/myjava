package ch02.pr_0420;

//20260420 Ex20
public class StringTrimEx01 {
    public static void main(String[] args) {
        String tel1 = "  02";
        String tel2 = "123   ";
        String tel3 = "  1234   ";

        String tel = tel1.trim() + tel2.trim() + tel3.trim();
        System.out.println(tel);
    }
}
