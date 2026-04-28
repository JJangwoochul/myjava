package SQL;

// 데이터베이스 연동
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class UserDeleteEx {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            String sql = "DELETE FROM users WHERE userid=? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            int rows = pstmt.executeUpdate();
            System.out.println("삭제된 행 수 : " + rows);

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
