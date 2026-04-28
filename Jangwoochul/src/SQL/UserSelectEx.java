package SQL;

// 데이터베이스 연동
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserSelectEx {
    public static void main(String[] args) {
        Connection conn = null;
        try {
            // JDBC Driver 등록
            Class.forName("oracle.jdbc.OracleDriver");
            // 연결
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            String sql = "" +
            "SELECT userid, username, userpassword, userage, useremail " +
            "FROM users " +
            "WHERE userid =? "; 

            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "winter");

            ResultSet rs = pstmt.executeQuery();
            if(rs.next()) {
                User user = new User();
                user.setUserId(rs.getString("userid"));
                user.setUserName(rs.getString("username"));
                user.setUserPassword(rs.getString("userpassword"));
                user.setUserAge(rs.getInt("userage"));
                user.setUserEmail(rs.getString("useremail"));
                System.out.println(user);
            } else {
                System.out.println("아이디가 없음.");
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
