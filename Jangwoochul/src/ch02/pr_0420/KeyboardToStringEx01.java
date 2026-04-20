package ch02.pr_0420;

//20260420 Ex13
import java.io.IOException;

public class KeyboardToStringEx01 {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[100];

        System.out.print("입력 : ");
        int readByteNo = System.in.read(bytes);

        String str = new String(bytes, 0, readByteNo - 2);
        System.out.println(str);
    }
}
