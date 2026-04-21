package ch02.pr_0421;

//20260421 Ex04
import java.io.FileWriter;
import java.io.IOException;

public class Ex04 {
    public static void main(String[] args) {
        char[] cbuf = { 'J', 'A', 'V', 'A' };
        String lang = "Language";
        FileWriter fos = null;

        try {
            fos = new FileWriter("C:/myjava/Jangwoochul/src/ch02/pr_0421/data4.txt");
            fos.write(cbuf);
            fos.write("\n-----------------------------\n");
            fos.write(lang);
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
