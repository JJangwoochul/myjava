package ch02.pr_0421;

//20260421 Ex03
import java.io.FileOutputStream;
import java.io.IOException;

public class Ex03 {
    public static void main(String[] args) {
        String content = "Hello java Programmers";
        byte[] bytes = content.getBytes();
        FileOutputStream fos = null;

        try {
            fos = new FileOutputStream("C:/myjava/Jangwoochul/src/ch02/pr_0421/data3.txt");
            fos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
