package logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Objects;

import common.BussinessException;
import common.SystemException;
import dao.ConnectionManager;
import dao.UserAccountDAO;
import entity.UserAccount;

public class LoginLogic {

    /**
     * ログイン認証します。
     * @param email メールアドレス
     * @param password パスワード
     * @return ユーザーアカウント
     * @throws SystemException システム例外
     * @throws BussinessException 例外
     */
    public UserAccount login(String email, String password) throws SystemException, BussinessException {

        UserAccount userAccount = null;

        try (Connection con = ConnectionManager.getConnection()) {
            final UserAccountDAO userAccountDAO = new UserAccountDAO(con);
            userAccount = userAccountDAO.login(email, password);
        } catch (final SQLException e) {
            e.printStackTrace();
            throw new SystemException("システムエラーが発生しました。");
        }

        if (Objects.isNull(userAccount)) {
            throw new BussinessException("メールアドレスかパスワードに誤りがあります。");
        }

        return userAccount;
    }
}
