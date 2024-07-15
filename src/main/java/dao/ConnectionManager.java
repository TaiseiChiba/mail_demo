package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {

    /** データベース接続URL */
    private static final String URL = "jdbc:mysql://localhost:3306/mail_demo";
    /** ユーザー名 */
    private static final String USER = "root";
    /** パスワード */
    private static final String PASSWORD = "password";

    /**
     * データベースの接続を取得する。
     *
     * @return データベースの接続
     */
    public static Connection getConnection() throws SQLException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (final SQLException e) {
            e.printStackTrace();
            throw e;
        } catch (final ClassNotFoundException e) {
            // TODO 自動生成された catch ブロック
            e.printStackTrace();
        }

        return con;
    }
}
