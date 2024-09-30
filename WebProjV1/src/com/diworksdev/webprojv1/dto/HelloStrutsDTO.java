package com.diworksdev.webprojv1.dto;
//このクラスがcom.diworksdev.webproj5.dtoパッケージに所属していることを示す

public class HelloStrutsDTO {
//HelloStrutsDTOというDTOクラスを宣言(publicなのでほかのクラスにアクセスできる)

    // ユーザーID
	//整数型のフィールドを宣言（privateなのでクラスの外から直接アクセスできない）
    private int userId;

    // ユーザー名
    //ユーザー名を保持する文字列型のフィールドを宣言
    private String userName;

    // パスワード
    //パスワードを保持する文字列型のフィールドを宣言
    private String password;

    // 処理結果
    //操作の結果を保持する文字列型のフィールドを宣言
    private String result;

    /**
     * userIdを取得するメソッド
     * @return userId ユーザーID
     */
    //userIDを取得するためのゲッターメソッド DTOに格納されているuserIdの値が返される
    public int getUserId() {
        return userId;
    }

    /**
     * userIdを設定するメソッド
     * @param userId 設定するユーザーID
     */
    //userIdを設定するためのセッターメソッド 引数として渡されたuserIdの値をこのクラスのuserIdフィールドに代入
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * userNameを取得するメソッド
     * @return userName ユーザー名
     */
    //userNameの値を取得するゲッターメソッド
    public String getUserName() {
        return userName;
    }

    /**
     * userNameを設定するメソッド
     * @param userName 設定するユーザー名
     */
    //userNameを設定するセッターメソッド
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * passwordを取得するメソッド
     * @return password パスワード
     */
    //Passwordの値を取得するゲッターメソッド
    public String getPassword() {
        return password;
    }

    /**
     * passwordを設定するメソッド
     * @param password 設定するパスワード
     */
    //Passwordを設定するセッターメソッド
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * resultを取得するメソッド
     * @return result 処理結果
     */
    //resultの値を取得するゲッターメソッド
    public String getResult() {
        return result;
    }

    /**
     * resultを設定するメソッド
     * @param result 設定する処理結果
     */
    //resultを設定するセッターメソッド
    public void setResult(String result) {
        this.result = result;
    }
}

//全体の流れ
//1,フィールド定義: このクラスには4つのフィールドがあり、それぞれユーザーID、ユーザー名、パスワード、操作結果を保持します。
//2,getUserIdやgetUserNameなどのメソッドを使って、他のクラスからフィールドの値にアクセス
//3,setUserIdやsetUserNameなどのメソッドを使って、他のクラスからフィールドに値をセット
//このクラスはデータの転送や保持に使用