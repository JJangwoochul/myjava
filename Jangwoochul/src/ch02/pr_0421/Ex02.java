package ch02.pr_0421;

//20260421 Ex02
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        byte b[] = new byte[50];
        try {
            fis = new FileInputStream("C:/myjava/Jangwoochul/src/ch02/pr_0421/data2.txt");
            // 절대경로 -> 파일위치/폴더명.txt
            fis.read(b);
            for (byte x : b)
                System.out.print((char) x);
        } catch (FileNotFoundException e) {
            System.out.println("data1.txt가 없습니다.");
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            } catch (NullPointerException e) {
                System.out.println("fis 가 null입니다.");
            }
        }
    }
}
