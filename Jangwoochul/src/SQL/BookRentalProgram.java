package SQL;

// 데이터베이스 연동
import java.sql.*;
import java.util.Scanner;

public class BookRentalProgram {
    // 여러 메서드에서 사용하기때문에 전역 변수 선언
    static Connection conn;
    // 로그인 상태 저장
    static String loginId = null;
    static String loginRole = null;

    public static void main(String[] args) {
        // 지역변수Connection conn = null;
        // main 메서드 안에서만 사용가능하기때문에 다른 메서드에서도 사용하기위해 전역번수 선언
        try {
            // JDBC Driver 등록 , Database 연결 , 연결성공문
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "1234");
            System.out.println("연결 성공");
            // 시작 메뉴(반복문) 종료 전까지
            Scanner sc = new Scanner(System.in);

            while (true) {
                System.out.println("---도서관리 시스템---");
                System.out.println("1. 회원가입");
                System.out.println("2. 로그인");
                System.out.println("3. 종료");
                System.out.println("선택 : ");

                int choice = sc.nextInt();
                sc.nextLine();
                // 메뉴선택처리
                switch (choice) {
                    case 1:
                        signUp(conn);
                        break;
                    case 2:
                        login(conn);
                        // 로그인 성공했을 때 -> 유저인지 어드민인지 파악
                        if (loginId != null) { // 아이디가 널이 아닐때
                            menuByRole(conn);
                        }
                        break;
                    case 0:
                        System.out.println("종료");
                        return;
                    default:
                        System.out.println("입력오류");
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try { // 연결끊기
                    conn.close();
                    System.out.println("연결끊기");
                } catch (SQLException e) {
                }
            }
        }
    }

    // ------------------------------------------------------------------------------
    // 공통기능
    // 회원가입 기능 , 전역변수 설정한 이유1
    public static void signUp(Connection conn) {

        try {
            // 스캐너 선언 (키보드 입력값 받기)
            Scanner sc = new Scanner(System.in);
            // 사용자 입력값 받기
            System.out.print("아이디 입력 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 입력 : ");
            String password = sc.nextLine();
            System.out.print("이름 입력 : ");
            String name = sc.nextLine();
            System.out.print("핸드폰번호 : ");
            String phone = sc.nextLine();
            // ID중복체크 (PK)
            String idCheckSql = "SELECT memberid FROM MEMBER WHERE memberid=?";
            // ? 자리에 입력한 id 넣기
            PreparedStatement idCheckStmt = conn.prepareStatement(idCheckSql);
            idCheckStmt.setString(1, id);
            // Database에 실행 후 결과 받기
            ResultSet rs = idCheckStmt.executeQuery();
            // 중복확인
            if (rs.next()) { // 결과가 있으면 존재하는 아이디(true) , 결과가 없는아이디면 false
                System.out.println("존재하는 아이디. 생성실패.");
                return; // 회원가입 종료
            }
            // 회원가입 아이디 , 비밀번호 , 이름 , 번호 값 입력 (insert)
            String sql = "INSERT INTO MEMBER (memberid, password, name, phone) " +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            pstmt.setString(3, name);
            pstmt.setString(4, phone);
            // 성공하면 1 이상 반환
            int result = pstmt.executeUpdate();
            // 결과
            if (result > 0) {
                System.out.println("가입 성공");
            } else {
                System.out.println("가입 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인 기능 , 전역변수 설정한 이유2 , 로그인 성공시 role(id가 user인지 admin인지 가져오기)
    public static void login(Connection conn) { // conn -> DB연결 객체전달
        try {
            Scanner sc = new Scanner(System.in); // 스캐너 생성
            // 입력값 받기
            System.out.print("아이디 입력 : ");
            String id = sc.nextLine();
            System.out.print("비밀번호 입력 : ");
            String password = sc.nextLine();
            // 로그인 확인 (DB에서 id,비밀번호 일치하는지 확인)
            String sql = // memberid와 password가 둘 다 참일때
                    "SELECT role FROM MEMBER WHERE memberid =? AND password =?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            // 성공여부 확인
            if (rs.next()) { // 입력한 인덱스 1,2 아이디 비밀번호가 일치 시
                loginId = id;
                loginRole = rs.getString("role");
                System.out.println("로그인 완료 , " + "권한 :" + loginRole);
            } else { // 일치하지 않을 시
                System.out.println("로그인 실패");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인 이후 user , admin에 따른 메뉴
    public static void menuByRole(Connection conn) {
        Scanner sc = new Scanner(System.in);
        // 로그인할때 role가 유저일때
        if (loginRole.equals("USER")) {
            // 로그아웃전까지 반복
            while (true) {
                System.out.println("---사용자 메뉴---");
                System.out.println("1. 도서검색");
                System.out.println("2. 도서대여");
                System.out.println("3. 도서반납");
                System.out.println("4. 마이페이지");
                System.out.println("5. 개인정보 수정");
                System.out.println("0. 로그아웃");
                System.out.print("선택 : ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        searchBook(conn);
                        break;
                    case 2:
                        rentBook(conn);
                        break;
                    case 3:
                        returnBook(conn);
                        break;
                    case 4:
                        myPage(conn);
                        break;
                    case 5:
                        updateMember(conn);
                        break;
                    case 0:
                        System.out.println("로그아웃");
                        loginId = null;
                        loginRole = null;
                        return;
                    default:
                        System.out.println("오류발생");
                }
            }
        } else if (loginRole.equals("ADMIN")) {
            while (true) {
                System.out.println("\n[관리자 메뉴]");
                System.out.println("1. 도서관리");
                System.out.println("2. 회원관리");
                System.out.println("3. 대여/반납 총괄관리");
                System.out.println("0. 로그아웃");
                System.out.print("선택 : ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        manageBook(conn);
                        break;

                    case 2:
                        manageMember(conn);
                        break;

                    case 3:
                        manageRental(conn);
                        break;

                    case 0:
                        System.out.println("로그아웃");
                        loginId = null;
                        loginRole = null;
                        return;

                    default:
                        System.out.println("입력오류");
                }
            }
        }
    }

    // 도서 검색 기능 , 전역변수 설정한 이유3
    public static void searchBook(Connection conn) {
        try {
            Scanner sc = new Scanner(System.in);
            // 검색 키워드 입력 스캐너활용
            System.out.print("검색어 입력 (제목,저자,출판사) : ");
            String keyword = sc.nextLine();
            // SQL -> like 활용해서 검색하기
            String sql = "SELECT bookno, bookname, author, publisher, avilable " +
                    "FROM BOOK " +
                    "WHERE bookname LIKE ? OR author LIKE ? OR publisher LIKE ?";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            // SQL 문에서 포함 검색 -> '%ㅁㄴㅇ%' -< ㅁㄴㅇ가 들어가있는거 검색
            pstmt.setString(1, "%" + keyword + "%");
            pstmt.setString(2, "%" + keyword + "%");
            pstmt.setString(3, "%" + keyword + "%");

            ResultSet rs = pstmt.executeQuery(); // 실행
            System.out.println("검색결과");
            boolean found = false;

            while (rs.next()) {
                found = true;
                int bookno = rs.getInt("bookno");
                String name = rs.getString("bookname");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String available = rs.getString("available");

                System.out.println("번호 : " + bookno +
                        " | 제목 : " + name +
                        " | 저자 : " + author +
                        " | 출판사 : " + publisher +
                        " | 대여가능 : " + available);
            }
            if (!found) { // 결과가 없을 때
                System.out.println("결과 없음");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --------------------------------------------------------------------------------------
    // USER 기능 시작
    public static void rentBook(Connection conn) {
        System.out.println("도서 대여 기능 (미완 추후 구현");
    }

    public static void returnBook(Connection conn) {
        System.out.println("도서 반납 기능 (미완 추후 구현");
    }

    public static void myPage(Connection conn) {
        System.out.println("마이페이지 기능 (미완 추후 구현");
    }

    public static void updateMember(Connection conn) {
        System.out.println("회원정보수정 기능 (미완 추후 구현");
    }

    // --------------------------------------------------------------------------------------
    // ADMIN 기능 시작
    public static void manageBook(Connection conn) {
        System.out.println("도서 관리 기능 (미완 추후 구현)");
    }

    public static void manageMember(Connection conn) {
        System.out.println("회원 관리 기능 (미완 추후 구현)");
    }

    public static void manageRental(Connection conn) {
        System.out.println("대여,반납 관리 기능 (미완 추후 구현)");
    }
}
