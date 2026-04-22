package testjava;

//20260422
import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        // 키보드 입력값
        Scanner scin = new Scanner(System.in);
        Helper lib = new Helper(150);

        // 프로그램 시작 시 데이터 로드 (인터페이스1)
        lib.loadFromFile();

        while (true) {
            System.out.println(" LIBRARY SYSTEM ");
            System.out.println("1. 책 등록");
            System.out.println("2. 책 목록 조회");
            System.out.println("3. 저장 및 종료");
            System.out.print("메뉴 선택 -> ");

            int menu = scin.nextInt(); // int 읽을 때
            // switch로 스캐너로 받은값 1,2,3중 1,2가 나오면 다시 while로 돌아가서 새로 출력
            // 3이 나오면 return으로(break도 가능하지만, switch만 탈출함(처음 출력문 반복)) 탈출
            switch (menu) {
                case 1:
                    // 책 등록
                    System.out.println("[도서 등록]");
                    // scanner로 int(숫자)형 ID값을 받음
                    System.out.print("ID: ");
                    int id = scin.nextInt(); // 키보드 입력값 int를 읽을때
                    scin.nextLine();
                    // scanner로 String(문자) 형 제목값을 받음
                    System.out.print("제목: ");
                    String title = scin.next(); // 키보드 입력값 String을 읽을때
                    // scanner로 String(문자) 형 저자값을 받음
                    System.out.print("저자: ");
                    String author = scin.next(); // 키보드 입력값 String을 읽을 때
                    // add를이용해 입력받은 책 정보 등록 (인터페이스2)
                    Book book = new Book(id, title, author);
                    lib.addItem(book);
                    break;

                case 2:
                    // 목록 출력 (인터페이스3)
                    lib.displayAll();
                    break;

                case 3:
                    // 저장 , 종료 (인터페이스4 , 인터페이스 모두 구현완료)
                    lib.saveToFile();
                    System.out.println("프로그램 종료");
                    return;

                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}
