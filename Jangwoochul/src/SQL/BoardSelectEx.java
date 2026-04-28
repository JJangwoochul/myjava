package SQL;

// 데이터베이스 연동
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

public class BoardSelectEx {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            String sql = "" +
                    "SELECT bno, btitle, bcontent, bwriter, bdate, bfilename " +
                    "FROM boards " +
                    "WHERE bwriter =? ";

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Board board = new Board();
                board.setbNo(rs.getInt("bno"));
                board.setbTitle(rs.getString("btitle"));
                board.setbContent(rs.getString("bcontent"));
                board.setbWriter(rs.getString("bwriter"));
                board.setbDate(rs.getDate("bdate"));
                board.setbFilename(rs.getString("bfilename"));
                System.out.println(board);
                
            }
            rs.close();

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
