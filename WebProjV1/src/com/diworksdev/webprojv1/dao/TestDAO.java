package com.diworksdev.webprojv1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webprojv1.dto.LoginDTO;
import com.diworksdev.webprojv1.util.DBConnector;

public class TestDAO {

    // ログイン情報を格納するリスト
    public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

    /**
     * 新規ユーザーを登録するメソッド
     *
     * @param username ユーザー名(引数として渡される)
     * @param password パスワード（引数として渡される）
     */
    public int insert(String username, String password) {
        int ret = 0;  // 結果の初期値は0
        DBConnector db = new DBConnector();  // DB接続用のオブジェクト
        Connection con = db.getConnection();  // DB接続の取得
        String sql = "insert into users(user_name, password) values(?,?)";  // SQL文

        try {
            // SQL文を準備して実行
        	//try-catch部特区：SQL文を実行し、例外が発生した場合にエラーメッセージを表示
            PreparedStatement ps = con.prepareStatement(sql); //SQL文を準備
            ps.setString(1, username);  // 1番目の?にユーザー名をセット
            ps.setString(2, password);  // 2番目の?にパスワードをセット
            int i = ps.executeUpdate();  // 実行結果を取得（登録件数）

            // 登録が成功した場合
            if (i > 0) {
                System.out.println(i + "件登録されました");
                ret = i;  // 成功した件数を返す
            }
        } catch (SQLException e) {
            e.printStackTrace();  // エラーが発生した場合の処理
        } finally {
            // 接続を閉じル処理を行い、接続がnullでないことと、開いていることを確認
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return ret;  // 登録件数を返す
    }

    /**
     * ユーザー情報を取得するメソッド
     *
     * @param username ユーザー名
     * @param password パスワード
     */
    public List<LoginDTO> select(String username, String password) {
        DBConnector db = new DBConnector();  // DB接続用のオブジェクト
        Connection con = db.getConnection();  // DB接続の取得
        String sql = "select * from users where user_name=? and password=?";  // SQL文
        //selectは、指定されたユーザー名とパスワードを一致するユーザー情報をデータベースから取得

        try {
            // SQL文を準備して実行
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);  // 1番目の?にユーザー名をセット
            ps.setString(2, password);  // 2番目の?にパスワードをセット
            ResultSet rs = ps.executeQuery();  // 実行結果を取得

            // 結果セットからデータを取り出す
            //取得したデータをLoginDTOオブジェクトに格納し、リストに追加します
            while (rs.next()) {
                LoginDTO dto = new LoginDTO();
                dto.setUsername(rs.getString("user_name"));  // ユーザー名をセット
                dto.setPassword(rs.getString("password"));   // パスワードをセット
                loginDTOList.add(dto);  // DTOをリストに追加
            }

            // 該当データがない場合の処理
            //該当するユーザーが存在しない場合、「該当なし」というダミーデータをリストに追加します
            if (loginDTOList.size() <= 0) {
                LoginDTO dto = new LoginDTO();
                dto.setUsername("該当なし");
                dto.setPassword("該当なし");
                loginDTOList.add(dto);  // 該当なしデータをリストに追加
            }
        } catch (SQLException e) {
            e.printStackTrace();  // エラーが発生した場合の処理
        } finally {
            // 接続を閉じる
            try {
                if (con != null && !con.isClosed()) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return loginDTOList;  // ログイン情報リストを返す
    }
}

