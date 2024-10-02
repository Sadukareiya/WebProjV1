package com.diworksdev.webprojv1.dto;

/**
 * ユーザーのログイン情報を保持するDTOクラス
 * DTOは"Data Transfer Object"の略で、データのやり取りに使用します
 */
public class LoginDTO {
	//LoginDTOの定義

    // ユーザー名を格納するフィールド
	//usernameという変数を定義している
    private String username;

    // パスワードを格納するフィールド
    //passwordという変数を定義している
    private String password;

    /**
     * ユーザー名を取得するためのメソッド
     * usernameフィールドの値を取得するためのメソッド
     * @return ユーザー名
     */
    public String getUsername() {
        return username; //usernamaフィールドの値を返す
    }

    /**
     * ユーザー名を設定するためのメソッド
     * 引数として渡せれた値をusernameフィールドに設定るするためのメソッド
     * @param username ユーザー名
     */
    public void setUsername(String username) {
        this.username = username; //クラス内のフィールドを指し、引数のusernameはメソッドを呼び出し時に渡される値を示す
    }

    /**
     * パスワードを取得するためのメソッド
     * passwordフィールドの値を取得するためのメソッド
     * @return パスワード
     */
    public String getPassword() {
        return password;
    }

    /**
     * パスワードを設定するためのメソッド
     * 引数として渡された値をpasswordフィールドに設定するメソッド
     * @param password パスワード
     */
    public void setPassword(String password) {
        this.password = password;	 //クラスのフィールド（this.password）に引数のpasswordの値を代入
    }
}

/**まとめ
 * このクラスはユーザーのusername/passwordを保持し、これらの値を取得する
 * （get）および設定(set)するためのメソッドの提供
 * DTO（データ転送オブジェクト）です
 */
