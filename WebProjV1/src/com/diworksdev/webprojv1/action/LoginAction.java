package com.diworksdev.webprojv1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
//必要なクラス (ArrayList, List, Map) をインポート
//Listはユーザー情報を格納し、Mapはセッション情報を管理する

import org.apache.struts2.interceptor.SessionAware;
//SessionAwareインターフェースを使うことで、セッション情報を扱えるようにします

import com.diworksdev.webprojv1.dao.LoginDAO;
import com.diworksdev.webprojv1.dto.LoginDTO;
import com.opensymphony.xwork2.ActionSupport;
//DAOやDTO、Struts2のActionSupportクラスをインポート
//LoginDAOはデータベース操作に、LoginDTOはデータのやり取りに使用

/**
 * LoginActionクラスは、ユーザーのログイン処理を行います。
 * Struts2のActionSupportクラスを継承し、SessionAwareインターフェースを実装することで
 * セッション管理を行います。
 */
public class LoginAction extends ActionSupport implements SessionAware {

    // ユーザー名を保存するフィールド
    private String username;

    // パスワードを保存するフィールド
    private String password;

    // データベースから取得したユーザー情報を保存するリスト
    private List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

    // セッション情報を管理するためのMap
    private Map<String, Object> session;

    /**
     * executeメソッドは、ログイン処理のエントリポイントです。
     * ユーザー名とパスワードが正しいかどうかを確認し、
     * セッションにユーザー情報を保存します。
     * @return ログイン成功ならSUCCESS、失敗ならERROR
     */
    public String execute() {
        // 初期状態ではログイン失敗を示す"ERROR"をセット
        String ret = ERROR;

        // デバッグ用のログ出力で、入力されたユーザー名とパスワードを確認
        System.out.println("入力されたユーザー名: " + username);
        System.out.println("入力されたパスワード: " + password);

        // LoginDAOを使って、データベースからユーザー情報を取得
        LoginDAO dao = new LoginDAO();
        loginDTOList = dao.select(username, password);

        // データベースから取得したユーザー情報が存在するか確認し、入力された情報と比較
        if (loginDTOList.size() > 0 &&
            this.username.equals(loginDTOList.get(0).getUsername()) &&
            this.password.equals(loginDTOList.get(0).getPassword())) {

            // ログイン成功時、セッションにユーザー情報を保存
            session.put("loginDTOList", loginDTOList);
            ret = SUCCESS; // ログイン成功を示す"SUCCESS"をセット
        } else {
            // ログイン失敗時、セッションにエラーメッセージを保存
            session.put("loginDTOList", loginDTOList);
            ret = ERROR; // ログイン失敗を示す"ERROR"をセット
        }

        // 結果を返す
        return ret;
    }

    // ユーザー名のgetterメソッド
    public String getUsername() {
        return username;
    }

    // ユーザー名のsetterメソッド
    public void setUsername(String username) {
        this.username = username;
    }

    // パスワードのgetterメソッド
    public String getPassword() {
        return password;
    }

    // パスワードのsetterメソッド
    public void setPassword(String password) {
        this.password = password;
    }

    // セッションのgetterメソッド
    public Map<String, Object> getSession() {
        return session;
    }

    // セッションのsetterメソッド
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
