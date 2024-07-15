package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entity.UserAccount;

public class UserAccountDAO {

    Connection con;

    public UserAccountDAO(Connection con) {
        this.con = con;
    }

    /**
     * ログイン認証します。
     * @param email メールアドレス
     * @param password パスワード
     * @return ユーザーアカウント
     * @throws SQLException 例外
     */
    public UserAccount login(String email, String password) throws SQLException {
        final String sql = "select * from user_account where email = ? and password = ?";
        UserAccount userAccount = null;

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    userAccount = new UserAccount(
                            rs.getInt("id"),
                            rs.getString("email"),
                            rs.getString("password"),
                            rs.getString("user_name"),
                            rs.getInt("age"),
                            rs.getString("address")
                            );
                }
            }
        }

        return userAccount;
    }
}
