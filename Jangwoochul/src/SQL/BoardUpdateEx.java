package SQL;

// 데이터베이스 연동
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class BoardUpdateEx {
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
            // 매개변수화된 SQL문 작성
            String sql = new StringBuilder()
                    .append("UPDATE boards SET ")
                    .append("btitle=?, ")
                    .append("bcontent=?, ")
                    .append("bfilename=? ")
                    .append("WHERE bno=?")
                    .toString();
            // PreparedStatement 얻기 , 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "눈사람");
            pstmt.setString(2, "눈으로 만든 인간");
            pstmt.setString(3, "snowman.jpg");
            pstmt.setInt(4, 1);

            int rows = pstmt.executeUpdate();
            System.out.println("수정된 행 수 : " + rows);

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
