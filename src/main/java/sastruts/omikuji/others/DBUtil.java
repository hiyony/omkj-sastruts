package sastruts.omikuji.others;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * データベースを連結します。
 * @author h_kim
 * @version 1.0
 */
public class DBUtil {

	/**
	 * データベースドライバーでPostgresqlDBを連結します。
	 * @return Connection conn
	 */
    public static Connection getConnection() {
        String server = "jdbc:postgresql://localhost:5432/omikuji";
        String user_name = "root";
        String password = "1005";

        Connection conn = null;


        try {
            //No suitable driverエラーのために追加
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(server, user_name, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
