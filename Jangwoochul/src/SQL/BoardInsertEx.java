package SQL;

// 데이터베이스 연동
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class BoardInsertEx {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            // 매개변수화된 SQL문 작성
            String sql = "" +
                    "INSERT INTO boards(bno , btitle , bcontent,bwriter,bdate,bfilename)" +
                    "VALUES (SEQ_BNO.NEXTVAL , ? , ? , ? , SYSDATE, ?)";

            // PreparedStatement 얻기 , 값 지정
            PreparedStatement pstmt = conn.prepareStatement(sql, new String[] { "bno" });
            pstmt.setString(1, "눈오는 날");
            pstmt.setString(2, "함박눈이 내려요.");
            pstmt.setString(3, "winter2");
            pstmt.setString(4, "snow.jpg");
            // pstmt.setBlob(5, new FileInputStream("src/SQL/snow.jpg"));
            // SQL문 실행
            int rows = pstmt.executeUpdate();
            System.out.println("저장된 행 수 : " + rows);
            // bno 값 얻기
            if (rows == 1) {
                ResultSet rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    int bno = rs.getInt(1);
                    System.out.println("저장된 bno : " + bno);
                }
                rs.close();
            }

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
