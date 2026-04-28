package SQL;

// 데이터베이스 연동
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedureCallEx {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            String sql = "{call user_create(?, ?, ?, ?, ?, ?)}";
            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.setString(1, "summer");
            cstmt.setString(2, "한여름");
            cstmt.setString(3, "12345");
            cstmt.setInt(4, 26);
            cstmt.setString(5, "summer@company.com");
            cstmt.registerOutParameter(6, Types.INTEGER);

            cstmt.execute();
            int rows = cstmt.getInt(6);
            System.out.println("저장된 행 수 : " + rows);

            cstmt.close();
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
