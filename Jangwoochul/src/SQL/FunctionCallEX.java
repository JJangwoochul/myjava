package SQL;

// 데이터베이스 연동
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;
import java.sql.CallableStatement;

public class FunctionCallEX {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            String sql = "{? = call user_login(?, ?)}";
            CallableStatement cstmt = conn.prepareCall(sql);

            cstmt.registerOutParameter(1, Types.INTEGER);
            cstmt.setString(2, "winter");
            cstmt.setString(3, "123456");

            cstmt.execute();
            int result = cstmt.getInt(1);

            cstmt.close();

            String message = switch(result) {
                case 0 -> "로그인 성공";
                case 1 -> "비밀번호 오류";
                case 2 -> "아이디 없음";
                default -> throw new IllegalArgumentException("Unexpected value: " + result);
            };
            System.out.println(message);

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
