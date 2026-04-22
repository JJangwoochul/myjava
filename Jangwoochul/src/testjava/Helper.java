package testjava;

import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

// Manageable 인터페이스 구현 (chat GPT도움)
public class Helper implements Manageable {
    private Book[] books; // 책 객체저장 배열
    private int bookno; // 배열에 저장된 책 갯수

    // 생성자 (배열 초기화)
    public Helper(int size) {
        books = new Book[size]; // 배열생성
        bookno = 0; // 배열에 저장된 책 갯수 -> 0 지정 (초기 저장데이터 0)
    }

    // 책 추가
    @Override
    // Manageable 인터페이스/책 데이터추가
    public void addItem(Book book) {
        // 배열 수 확인 ( 배열에 저장된 책 갯수 >=책 객체에 저장된배열길이 )
        if (bookno >= books.length) {
            System.out.println("배열이 가득 찼습니다. 더 이상 추가할 수 없습니다.");
            return;
        }
        // 배열에 저장 -> bookno++ (책 갯수) 1 증가
        // * ++위치 중요 * (chat GPT도움)
        books[bookno++] = book;
        System.out.println("성공적으로 저장되었습니다.");
    }

    // 저장된 책 목록 출력
    @Override
    // Manageable 인터페이스/목록출력
    public void displayAll() {
        // bookno가 0이면 등록된 책 x
        if (bookno == 0) {
            System.out.println("저장된 책이 없습니다.");
            return;
        }
        // 출력 ID 제목 저자
        System.out.println("ID     제목             저자");
        System.out.println("--------------------------------");

        // for문(반복문) 책 갯수만큼 출력
        for (int i = 0; i < bookno; i++) {
            // 책 객체를 저장하는 배열을 호출
            System.out.println(
                    books[i].getId() + "     " +
                            books[i].getTitle() + "          " +
                            books[i].getAuthor());
        }
    }

    // 파일 저장
    @Override
    // Manageable 인터페이스/파일저장
    public void saveToFile() {
        // try - cathc
        // 속도 향상 버퍼 (자바 스트림 추가파일)
        try (BufferedWriter bookwriter = new BufferedWriter(
                new FileWriter("C:/myjava/Jangwoochul/src/testjava/books.txt"))) {
            // 저장할때 사용할 파일 메서드 책 갯수(for문 안에 bookno)만큼 파일에 저장
            for (int i = 0; i < bookno; i++) {
                // books -> book객체에 저장된 책 갯수( ex)1번책 2번책 ) => csv문자열로 바꿈
                bookwriter.write(books[i].toFileString());
                bookwriter.newLine(); // 줄바꿈 -> 1번책 ~ ~ ->줄바꿈 -> 2번책 ~ ~
            }

            System.out.println("데이터가 파일에 저장되었습니다.");
            // 오류 발생시 try catch로 catch에 내려와서 오류발생 문구
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생");
            e.printStackTrace();
        }
    }

    // 파일 로드 (chat GPT도움)
    @Override
    public void loadFromFile() {
        // 파일 생성 , 파일경로(절대경로의 텍스트파일)
        File file = new File("C:/myjava/Jangwoochul/src/testjava/books.txt");

        // 만약 파일이 없으면 파일 종료 , 처음으로 돌아가서 새로시작
        /* 파일이 있을때 -> true , 없을때 false => !file.exists가 파일이 있으면 
        true를 받으니 ! 때문에 try 로 내려감 , 파일이 없을땐 false를 받아 if안으로 들어감
        새로시작 */
        if (!file.exists()) {
            System.out.println("기존 데이터 파일이 없습니다. 새로 시작합니다.");
            return;
        }
        // try catch , 속도 향상 버퍼 (자바 스트림 추가파일)
        // 파일에서 한 줄을 읽고, String line에 저장
        try (BufferedReader bookreader = new BufferedReader(
                new FileReader("C:/myjava/Jangwoochul/src/testjava/books.txt"))) {
            String line;

            // 파일을 한줄씩 읽어주기 line(한 줄)에 값이 null이면 종료,아니면 한 줄씩 읽고 null까지 반복
            while ((line = bookreader.readLine()) != null) {
                // 문자열을 , 를 추가해 보기 편하게만듦
                String[] data = line.split(",");
                // 각각의 문자열들을 각 변수로 변환시키기
                int id = Integer.parseInt(data[0]); // 정수로 변환
                String title = data[1];
                String author = data[2];
                // book 객체 생성, 저장
                books[bookno++] = new Book(id, title, author);
            }

            System.out.println("데이터 로드 완료");
            // 오류 발생시
        } catch (IOException e) {
            System.out.println("파일 로드 중 오류 발생 ");
            e.printStackTrace();
        }
    }
}
