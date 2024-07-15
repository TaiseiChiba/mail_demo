package entity;

import lombok.Data;

/**
 * ユーザーアカウント
 */
@Data
public class UserAccount {

    /** ID */
    private int id;

    /** メールアドレス */
    private String email;

    /** パスワード */
    private String password;

    /** ユーザー名 */
    private String userName;

    /** 年齢 */
    private int age;

    /** 住所 */
    private String address;

    public UserAccount(int id, String email, String password, String userName, int age, String address) {
        super();
        this.id = id;
        this.email = email;
        this.password = password;
        this.userName = userName;
        this.age = age;
        this.address = address;
    }


}
