package ch02.pr_0421;

//20260421 Ex06
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Ex06 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        try {
            bis = new BufferedInputStream(new FileInputStream("C:/myjava/Jangwoochul/src/ch02/pr_0421/data6.txt"));
            int x = 0;
            while ((x = bis.read()) != -1)
                System.out.print((char) x);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
