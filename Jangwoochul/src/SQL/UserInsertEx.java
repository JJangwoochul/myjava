package SQL;

// 데이터베이스 연동
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserInsertEx {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결
            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe",
                    "system",
                    "1234");
            // 매개변수화 된 SQL문 작성
            String sql = "" +
                    "INSERT INTO users(userid , username, userpassword,userage,useremail)" +
                    "VALUES (?,?,?,?,?)";
            // PreparedStatement 얻기 , 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter1");
            pstmt.setString(2, "한겨울1");
            pstmt.setString(3, "123456");
            pstmt.setInt(4, 25);
            pstmt.setString(5, "winter1@mycompany.com");
            // SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : " + rows);
            // PreparedStatement 닫기
            pstmt.close();
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
}
