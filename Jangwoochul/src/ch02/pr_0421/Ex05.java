package ch02.pr_0421;

//20260421 Ex05
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex05 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        InputStreamReader reader = null;

        try {
            fis = new FileInputStream("C:/myjava/Jangwoochul/src/ch02/pr_0421/data5.txt");
            reader = new InputStreamReader(fis);
            int x;
            while ((x = reader.read()) != -1)
                System.out.print((char) x);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
