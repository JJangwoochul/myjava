package SQL;

// 데이터베이스 연동
import java.sql.*;
import java.util.Scanner;

public class BookRentalProgram {
    // 여러 메서드에서 사용하기때문에 전역 변수 선언
    static Scanner sc = new Scanner(System.in);
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
                    case 3:
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
            // 사용자 입력값 받기
            System.out.print("아이디 입력 : ");
            String id = sc.nextLine().trim();
            System.out.print("비밀번호 입력 : ");
            String password = sc.nextLine().trim();
            System.out.print("이름 입력 : ");
            String name = sc.nextLine().trim();
            System.out.print("핸드폰번호 : ");
            String phone = sc.nextLine().trim();
            // 필수 값 체크
            if (id.isEmpty() || password.isEmpty() || name.isEmpty()) {
                System.out.println("필수 입력값 누락");
                return;
            }
            // 연락처 형식 검증( - )
            if (!phone.matches("^010-\\d{4}-\\d{4}$")) {
                System.out.println("전화번호 형식오류 (010-1234-1234)");
                return;
            }
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
            rs.close();
            idCheckStmt.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인 기능 , 전역변수 설정한 이유2 , 로그인 성공시 role(id가 user인지 admin인지 가져오기)
    public static void login(Connection conn) { // conn -> DB연결 객체전달
        try {
            // 입력값 받기
            System.out.print("아이디 입력 : ");
            String id = sc.nextLine().trim();
            System.out.print("비밀번호 입력 : ");
            String password = sc.nextLine().trim();
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
            rs.close();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 로그인 이후 user , admin에 따른 메뉴
    public static void menuByRole(Connection conn) {
        // 로그인할때 role가 유저일때
        if ("USER".equals(loginRole)) {
            // 로그아웃전까지 반복
            while (true) {
                System.out.println("---사용자 메뉴---");
                System.out.println("1. 도서검색");
                System.out.println("2. 도서대여");
                System.out.println("3. 도서반납");
                System.out.println("4. 마이페이지");
                System.out.println("5. 개인정보 수정");
                System.out.println("6. 회원탈퇴");
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
                    case 6:
                        deleteMember(conn);
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
        } else if ("ADMIN".equals(loginRole)) {
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
            // 검색 키워드 입력 스캐너활용
            System.out.print("검색어 입력 (제목,저자,출판사) : ");
            String keyword = sc.nextLine().trim();
            // 필수 값 체크
            if (keyword.isEmpty()) {
                System.out.println("검색어를 입력.");
                return;
            }
            // SQL -> like 활용해서 검색하기
            String sql = "SELECT bookno, bookname, author, publisher, available " +
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
    // 도서 대여기능
    public static void rentBook(Connection conn) {
        try {

            System.out.println("도서번호 입력 : ");
            int bookno = sc.nextInt();
            sc.nextLine(); // 버퍼 정리
            // 정지여부 확인
            String checkMemberSql = "SELECT suspended FROM MEMBER WHERE memberid =?";
            PreparedStatement memberstmt = conn.prepareStatement(checkMemberSql);
            memberstmt.setString(1, loginId);
            ResultSet memberRs = memberstmt.executeQuery();

            if (memberRs.next()) {
                if ("Y".equals(memberRs.getString("suspended"))) {
                    System.out.println("정지된 회원 , 대여불가");
                    return;
                }
            }
            // 대여중인 도서 갯수 확인 (3권제한)
            String countSql = "SELECT COUNT(*) FROM RENTAL WHERE memberid =? AND returndate IS NULL";
            PreparedStatement countStmt = conn.prepareStatement(countSql);
            countStmt.setString(1, loginId);
            ResultSet countRs = countStmt.executeQuery();

            int rentCount = 0;
            if (countRs.next()) {
                rentCount = countRs.getInt(1);
            }
            if (rentCount >= 3) {
                System.out.println("1인당 3권까지 가능");
                return;
            }
            // 연체중인 도서 확인
            String overdueSql = "SELECT COUNT(*) FROM RENTAL " +
                    "WHERE memberid = ? AND returndate IS NULL AND overdue = 'Y'";
            PreparedStatement overdueStmt = conn.prepareStatement(overdueSql);
            overdueStmt.setString(1, loginId);
            ResultSet overdueRs = overdueStmt.executeQuery();

            int overdueCount = 0;
            if (overdueRs.next()) {
                overdueCount = overdueRs.getInt(1);
            }
            if (overdueCount > 0) {
                System.out.println("연체된 도서 존재 대여 불가");
                return;
            }
            // 프로시저 호출 (대여가능)
            String sql = "{ call rent_book_proc(?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            // 파라미터
            cstmt.setString(1, loginId); // 회원id
            cstmt.setInt(2, bookno); // 도서번호

            cstmt.execute(); // 실행
            System.out.println("대여완료.");
            memberRs.close();
            memberstmt.close();
            countRs.close();
            countStmt.close();
            overdueRs.close();
            overdueStmt.close();
            cstmt.close();
        } catch (SQLException e) {
            // 프로시저에서 나온 오류 발생 메세지
            System.out.println("대여 실패 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 도서 반납 기능
    public static void returnBook(Connection conn) {
        try {
            System.out.print("반납 도서번호 : ");
            int bookno = sc.nextInt();
            sc.nextLine(); //버퍼해결
            // 프로시저 호출
            String sql = "{ call return_book_proc(?,?)}";
            CallableStatement cstmt = conn.prepareCall(sql);
            // 파라미터
            cstmt.setString(1, loginId);
            cstmt.setInt(2, bookno);
            cstmt.execute();
            System.out.println("반납완료");
            cstmt.close();
        } catch (SQLException e) {
            System.out.println("반납실패 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 마이페이지 기능 구현
    public static void myPage(Connection conn) {
        try {
            System.out.println("--마이페이지--");
            System.out.println("회원 ID : " + loginId);
            // 대여중인 도서 조회
            String currentSql = "SELECT r.rentno, b.bookname, b.author, b.publisher, " +
                    "r.rentdate, r.duedate " +
                    "FROM RENTAL r " +
                    "JOIN BOOK b ON r.bookno = b.bookno " +
                    "WHERE r.memberid = ? " +
                    "AND r.returndate IS NULL " + // 대여중인 조건
                    "ORDER BY r.rentdate DESC";
            PreparedStatement currentStmt = conn.prepareStatement(currentSql);
            currentStmt.setString(1, loginId);

            ResultSet currentRs = currentStmt.executeQuery();
            boolean hasCurrent = false;

            while (currentRs.next()) {
                hasCurrent = true; // 데이터 추출
                System.out.println("--------------------------------");
                System.out.println("대여번호 : " + currentRs.getInt("rentno"));
                System.out.println("책 제목 : " + currentRs.getString("bookname"));
                System.out.println("저자 : " + currentRs.getString("author"));
                System.out.println("출판사 : " + currentRs.getString("publisher"));
                System.out.println("대여일 : " + currentRs.getDate("rentdate"));
                System.out.println("반납예정일 : " + currentRs.getDate("duedate"));
            }
            if (!hasCurrent) { // 데이터가 없을때
                System.out.println("대여내역이 없습니다.");
            }
            currentRs.close();// 정리
            currentStmt.close();
            // 과거 이력 조회
            System.out.println("--과거 반납 완료 이력--");

            String historySql = "SELECT r.rentno, b.bookname, b.author, b.publisher, " +
                    "r.rentdate, r.returndate, r.overdue " +
                    "FROM RENTAL r " +
                    "JOIN BOOK b ON r.bookno = b.bookno " +
                    "WHERE r.memberid = ? " +
                    "AND r.returndate IS NOT NULL " + // 반납완료조건
                    "ORDER BY r.returndate DESC";

            PreparedStatement historyStmt = conn.prepareStatement(historySql);
            historyStmt.setString(1, loginId);

            ResultSet historyRs = historyStmt.executeQuery();
            boolean hasHistory = false;

            while (historyRs.next()) {
                hasHistory = true;

                System.out.println("-------------------------");
                System.out.println("대여번호 : " + historyRs.getInt("rentno"));
                System.out.println("책 제목 : " + historyRs.getString("bookname"));
                System.out.println("저자 : " + historyRs.getString("author"));
                System.out.println("출판사 : " + historyRs.getString("publisher"));
                System.out.println("대여일 : " + historyRs.getDate("rentdate"));
                System.out.println("반납일 : " + historyRs.getDate("returndate"));
                System.out.println("연체 여부 : " + historyRs.getString("overdue"));
            }
            if (!hasHistory) {
                System.out.println("과거 대여 내역이없습니다.");
            }
            historyRs.close();
            historyStmt.close();

        } catch (SQLException e) {
            System.out.println("조회 실패 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 개인정보 수정 기능
    public static void updateMember(Connection conn) {
        try {
            // 사용자 확인
            System.out.println("--회원정보 수정--");
            System.out.println("현재 ID : " + loginId);
            // 변경 정보 입력
            System.out.print("새 비밀번호 입력 : ");
            String newPassword = sc.nextLine().trim();
            System.out.print("새 번호 입력 : ");
            String newPhone = sc.nextLine().trim();
            // 유효성검사 (전화번호)
            if (newPassword.isEmpty() || newPhone.isEmpty()) {
                System.out.println("입력값이 비어있습니다.");
                return;
            }
            if (!newPhone.matches("^010-\\d{4}-\\d{4}$")) {
                System.out.println("전화번호 형식 오류 (010-1234-1234)");
                return;
            }
            // SQL MEMBER 업데이트
            String sql = "UPDATE MEMBER " +
                    "SET password = ?, phone =? " +
                    "WHERE memberid =?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, newPassword);
            pstmt.setString(2, newPhone);
            pstmt.setString(3, loginId);
            // 회원정보 수정 결과
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("수정 성공");
            } else {
                System.out.println("수정 실패");
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("데이터베이스 오류 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 회원탈퇴 기능
    public static void deleteMember(Connection conn) {
        try {
            System.out.println("--회원탈퇴--");
            System.out.println("ID : " + loginId);
            // 미반납 도서 확인 SQL
            String checkSql = "SELECT COUNT(*) " + "FROM RENTAL " + "WHERE memberid = ? AND returndate IS NULL";

            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, loginId);

            ResultSet rs = checkStmt.executeQuery();
            int count = 0; // 결과확인
            if (rs.next()) {
                count = rs.getInt(1);
            }
            if (count > 0) { // 대여중인 도서가 있을때
                System.out.println("미반납 도서 확인, 탈퇴불가.");
                rs.close();
                checkStmt.close();
                return;
            }
            // 탈퇴 진행 SQL
            String sql = "DELETE FROM MEMBER " + "WHERE memberid = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, loginId);
            // 실행 , 결과
            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("탈퇴완료");
                loginId = null;// 로그인 초기화
                loginRole = null;
            } else {
                System.out.println("탈퇴 실패");
            }
            rs.close();
            checkStmt.close();
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("데이터베이스 오류 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // --------------------------------------------------------------------------------------
    // ADMIN 기능 시작
    // 관리자 도서 관리 기능
    public static void manageBook(Connection conn) {
        try {

            while (true) {
                System.out.println("--도서관리--");
                System.out.println("1. 도서 등록");
                System.out.println("2. 도서 수정");
                System.out.println("3. 도서 삭제");
                System.out.println("4. 도서 전체 조회");
                System.out.println("0. 뒤로가기");
                System.out.print("선택 : ");

                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1: // 도서 등록
                        System.out.print("ISBN : ");
                        String isbn = sc.nextLine().trim();
                        // isbn 중복체크
                        String checkSql = "SELECT COUNT(*) FROM BOOK WHERE isbn = ?";
                        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                        checkStmt.setString(1, isbn);
                        ResultSet checkRs = checkStmt.executeQuery();

                        if (checkRs.next() && checkRs.getInt(1) > 0) {
                            System.out.println("이미 존재하는 도서번호입니다. 등록실패");
                            break;
                        }

                        System.out.print("도서명 : ");
                        String bookname = sc.nextLine().trim();

                        System.out.print("저자 : ");
                        String author = sc.nextLine().trim();

                        System.out.print("출판사 : ");
                        String publisher = sc.nextLine().trim();
                        // 빈 값인지 확인
                        if (isbn.isBlank() || bookname.isBlank()) {
                            System.out.println("필수로 넣어야하는 값이 비었습니다");
                            break;
                        }

                        String sql1 = "INSERT INTO BOOK (bookno, isbn ,bookname ,author ,publisher, available) " +
                                "VALUES (BOOK_SEQ.NEXTVAL, ?, ? ,? ,? ,'Y')";
                        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                        pstmt1.setString(1, isbn);
                        pstmt1.setString(2, bookname);
                        pstmt1.setString(3, author);
                        pstmt1.setString(4, publisher);

                        pstmt1.executeUpdate();
                        System.out.println("등록 완료");
                        pstmt1.close();
                        break;
                    case 2: // 도서 수정
                        System.out.print("수정할 도서 번호 : ");
                        int bookno2 = sc.nextInt();
                        sc.nextLine();

                        System.out.print("새 도서명 : ");
                        String newName = sc.nextLine().trim();
                        System.out.print("새 저자 : ");
                        String newAuthor = sc.nextLine().trim();
                        System.out.print("새 출판사 : ");
                        String newPublisher = sc.nextLine().trim();

                        String sql2 = "UPDATE BOOK SET bookname=?, author=?, publisher=? WHERE bookno=? ";
                        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                        pstmt2.setString(1, newName);
                        pstmt2.setString(2, newAuthor);
                        pstmt2.setString(3, newPublisher);
                        pstmt2.setInt(4, bookno2);

                        int result2 = pstmt2.executeUpdate();
                        System.out.println(result2 > 0 ? "수정 성공" : "수정 실패");
                        pstmt2.close();
                        break;
                    case 3: // 도서 삭제
                        System.out.print("삭제할 도서 번호 : ");
                        int bookno3 = sc.nextInt();
                        // 대여중인지 확인
                        String rentCheckSql = "SELECT COUNT(*) FROM RENTAL WHERE bookno = ? AND returndate IS NULL";
                        PreparedStatement rentCheckStmt = conn.prepareStatement(rentCheckSql);
                        rentCheckStmt.setInt(1, bookno3);

                        ResultSet rentCheckRs = rentCheckStmt.executeQuery();

                        if (rentCheckRs.next() && rentCheckRs.getInt(1) > 0) {
                            System.out.println("대여중인 도서는 삭제불가");
                            break;
                        }

                        String sql3 = "UPDATE BOOK SET available='N' WHERE bookno=? ";
                        PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                        pstmt3.setInt(1, bookno3);

                        int result3 = pstmt3.executeUpdate();
                        System.out.println(result3 > 0 ? "삭제 성공" : "삭제 실패");
                        pstmt3.close();
                        rentCheckRs.close();
                        rentCheckStmt.close();
                        break;
                    case 4: // 전체 조회
                        String sql4 = "SELECT * FROM BOOK ORDER BY bookno";

                        PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                        ResultSet rs = pstmt4.executeQuery();

                        while (rs.next()) {
                            System.out.println(
                                    "번호 : " + rs.getInt("bookno") +
                                            " | 제목 : " + rs.getString("bookname") +
                                            " | 저자 : " + rs.getString("author") +
                                            " | 출판사 : " + rs.getString("publisher") +
                                            " | 상태 : " + rs.getString("available"));
                        }
                        rs.close();
                        pstmt4.close();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("오류발생");
                }
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 오류 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 관리자 회원 관리
    public static void manageMember(Connection conn) {
        try {
            while (true) { // 관리자(admin)시점의 회원관리 메뉴
                System.out.println("--회원 관리--");
                System.out.println("1. 전체 회원 조회");
                System.out.println("2. 회원 정보 조회");
                System.out.println("3. 회원 정지,해제");
                System.out.println("4. 회원 강제 탈퇴");
                System.out.println("0. 뒤로가기");
                System.out.print("선택 : ");

                int choice = sc.nextInt();
                sc.nextLine(); // 버퍼정리

                switch (choice) {
                    case 1: // 전체 회원조회
                        String sql1 = "SELECT memberid, name, phone, joindate, suspended, role FROM MEMBER";
                        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                        ResultSet rs1 = pstmt1.executeQuery();

                        System.out.println("--전체 회원 목록--");
                        while (rs1.next()) { // 회원 전체 출력
                            System.out.println(
                                    "ID : " + rs1.getString("memberid") +
                                            " | 이름 : " + rs1.getString("name") +
                                            " | 전화 : " + rs1.getString("phone") +
                                            " | 가입일 : " + rs1.getDate("joindate") +
                                            " | 정지여부 : " + rs1.getString("suspended") +
                                            " | 권한 : " + rs1.getString("role"));
                        }
                        rs1.close();
                        pstmt1.close();
                        break;
                    case 2: // 회원 정보 조회 , 대여기록 조회
                        System.out.print("조회 할 ID : ");
                        String id = sc.nextLine().trim();

                        String sql2 = "SELECT * FROM MEMBER WHERE memberid =?";

                        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                        pstmt2.setString(1, id);

                        ResultSet rs2 = pstmt2.executeQuery();
                        // 회원정보 조회
                        if (rs2.next()) {
                            System.out.println("--회원 상세 정보--");
                            System.out.println("ID : " + rs2.getString("memberid"));
                            System.out.println("이름 : " + rs2.getString("name"));
                            System.out.println("전화 : " + rs2.getString("phone"));
                            System.out.println("가입일 : " + rs2.getDate("joindate"));
                            System.out.println("정지여부 : " + rs2.getString("suspended"));
                            System.out.println("권한 : " + rs2.getString("role"));
                        } else {
                            System.out.println("회원이 없습니다.");
                            rs2.close();
                            pstmt2.close();
                            break;
                        }
                        rs2.close();
                        pstmt2.close();
                        // 대여기록조회
                        System.out.println("--회원 대여 기록--");
                        String rentSql = "SELECT r.rentno, b.bookname, r.rentdate, r.duedate, r.returndate, r.overdue "
                                +
                                "FROM RENTAL r " +
                                "JOIN BOOK b ON r.bookno = b.bookno " +
                                "WHERE r.memberid = ? " +
                                "ORDER BY r.rentdate DESC";

                        PreparedStatement rentStmt = conn.prepareStatement(rentSql);
                        rentStmt.setString(1, id);
                        ResultSet rentRs = rentStmt.executeQuery();
                        boolean hasRent = false;

                        while (rentRs.next()) {
                            hasRent = true;

                            System.out.println(
                                    "대여번호 : " + rentRs.getInt("rentno") +
                                            " | 도서명 : " + rentRs.getString("bookname") +
                                            " | 대여일 : " + rentRs.getDate("rentdate") +
                                            " | 반납예정 : " + rentRs.getDate("duedate") +
                                            " | 반납일 : " + rentRs.getDate("returndate") +
                                            " | 연체 여부 : " + rentRs.getString("overdue"));
                        }
                        if (!hasRent) {
                            System.out.println("대여 기록이 없습니다.");
                        }
                        rentRs.close();
                        rentStmt.close();
                        break;
                    case 3: // 회원 정지, 해제
                        System.out.print("ID 입력 : ");
                        String targetId = sc.nextLine().trim();

                        System.out.print("정지(Y) , 해제(N) : ");
                        String status = sc.nextLine().trim();
                        // Y,N 제외 불가능
                        if (!status.equals("Y") && !status.equals("N")) {
                            System.out.println("Y또는 N만 입력하시오.");
                            return;
                        }

                        String sql3 = "UPDATE MEMBER SET suspended = ? WHERE memberid =?";

                        PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                        pstmt3.setString(1, status);
                        pstmt3.setString(2, targetId);

                        int result3 = pstmt3.executeUpdate();

                        if (result3 > 0) {
                            System.out.println("상태 변경 완료");
                        } else {
                            System.out.println("상태 변경 실패");
                        }
                        pstmt3.close();
                        break;
                    case 4: // 회원 강제탈퇴
                        System.out.print("탈퇴시킬 회원ID : ");
                        String deleteId = sc.nextLine().trim();
                        // 대여중인 도서 확인
                        String checkSql = "SELECT COUNT(*) FROM RENTAL WHERE memberid = ? AND returndate IS NULL";
                        PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                        checkStmt.setString(1, deleteId);
                        ResultSet checkRs = checkStmt.executeQuery();

                        int count = 0;
                        if (checkRs.next()) {
                            count = checkRs.getInt(1);
                        }
                        // 대여줄일땐 탈퇴 불가능
                        if (count > 0) {
                            System.out.println("대여중인 도서가 있어서 탈퇴 불가능");
                            checkRs.close();
                            checkStmt.close();
                            break;
                        }
                        // 회원 삭제
                        String sql4 = "DELETE FROM MEMBER WHERE memberid = ?";

                        PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                        pstmt4.setString(1, deleteId);
                        int result4 = pstmt4.executeUpdate();

                        System.out.println(result4 > 0 ? "삭제완료" : "삭제실패");
                        pstmt4.close();
                        break;
                    case 0: // 관리자 메뉴 종료
                        return;
                    default:
                        System.out.println("알 수 없는 오류 발생");
                }
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 오류 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 관리자 대여관리
    public static void manageRental(Connection conn) {
        try {
            while (true) {// 관리자 시점 대여,반납 관리 메뉴
                System.out.println("--대여,반납 관리--");
                System.out.println("1. 전체 대여 현황");
                System.out.println("2. 연체자 조회");
                System.out.println("3. 강제 반납");
                System.out.println("0. 뒤로가기");
                System.out.print("선택 : ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1: // 대여 현황 조회
                        String sql1 = "SELECT r.rentno, m.memberid, b.bookname, " +
                                "r.rentdate, r.duedate, r.returndate, r.overdue " +
                                "FROM RENTAL r " +
                                "JOIN MEMBER m ON r.memberid = m.memberid " +
                                "JOIN BOOK b ON r.bookno = b.bookno " +
                                "ORDER BY r.rentdate DESC";

                        PreparedStatement pstmt1 = conn.prepareStatement(sql1);
                        ResultSet rs1 = pstmt1.executeQuery();

                        System.out.println("---전체 대여 현황---");

                        while (rs1.next()) {
                            System.out.println(
                                    "대여번호 : " + rs1.getInt("rentno") +
                                            " | 회원ID : " + rs1.getString("memberid") +
                                            " | 도서명 : " + rs1.getString("bookname") +
                                            " | 대여일 : " + rs1.getDate("rentdate") +
                                            " | 반납예정일 : " + rs1.getDate("duedate") +
                                            " | 반납일 : " + rs1.getDate("returndate") +
                                            " | 연체여부 : " + rs1.getString("overdue"));
                        }
                        rs1.close();
                        pstmt1.close();
                        break;

                    case 2: // 연체자 조회
                        String sql2 = "SELECT r.rentno, m.memberid, b.bookname, r.duedate " +
                                "FROM RENTAL r " +
                                "JOIN MEMBER m ON r.memberid = m.memberid " +
                                "JOIN BOOK b ON r.bookno = b.bookno " +
                                "WHERE r.returndate IS NULL " +
                                "AND r.duedate < SYSDATE ";
                        PreparedStatement pstmt2 = conn.prepareStatement(sql2);
                        ResultSet rs2 = pstmt2.executeQuery();

                        System.out.println("--연체자 목록--");
                        boolean found = false;

                        while (rs2.next()) {
                            found = true;

                            System.out.println(
                                    "대여번호 : " + rs2.getInt("rentno") +
                                            " | 회원ID : " + rs2.getString("memberid") +
                                            " | 도서명 : " + rs2.getString("bookname") +
                                            " | 반납예정일 : " + rs2.getDate("duedate"));
                        }
                        if (!found) {
                            System.out.println("연체자가 없습니다.");
                        }
                        rs2.close();
                        pstmt2.close();
                        break;
                    case 3: // 강제반납
                        System.out.print("강제 반납시킬 대여번호(rentno) 입력");
                        int rentno = sc.nextInt();

                        String sql3 = // rental 테이블 강제 반납처리
                                "UPDATE RENTAL " +
                                        "SET returndate = SYSDATE, overdue = 'Y' " +
                                        "WHERE rentno =?";

                        PreparedStatement pstmt3 = conn.prepareStatement(sql3);
                        pstmt3.setInt(1, rentno);

                        int result = pstmt3.executeUpdate();

                        String sql4 = // book 상태 강제 복구 (대여불가에서 대여가능으로)
                                "UPDATE BOOK " +
                                        "SET available = 'Y' " +
                                        "WHERE bookno = (SELECT bookno FROM RENTAL WHERE rentno =?)";

                        PreparedStatement pstmt4 = conn.prepareStatement(sql4);
                        pstmt4.setInt(1, rentno);
                        pstmt4.executeUpdate();

                        if (result > 0) {
                            System.out.println("강제 반납 완료");
                        } else {
                            System.out.println("실패");
                        }
                        pstmt3.close();
                        pstmt4.close();
                        break;
                    case 0: // 종료
                        return;
                    default:
                        System.out.println("시스템오류");
                }
            }
        } catch (SQLException e) {
            System.out.println("데이터베이스 오류 : " + e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
