package com.diworksdev.webprojv1.dao;

/**
 * Connection, PreparedStatement, ResultSet, SQLException は、JDBCの一部でデータベースのやり取りに使用
 * JDBC＝(Java Database Connectivity)
 * ArrayList, List は、複数のデータを保持するためのコレクション
 * LoginDTO は、データベースから取得したユーザー情報を保持するためのクラス
 * DBConnector は、データベース接続用のユーティリティクラス
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.diworksdev.webprojv1.dto.LoginDTO;
import com.diworksdev.webprojv1.util.DBConnector;

/**
 * LoginDAOクラスはデータベースからユーザー情報を取得するためのクラス。
 * 主にユーザー名とパスワードを使ってデータベースの検索を行います。
 */
public class LoginDAO {
//LoginDAOクラスの定義
	//このクラスはデータベースからユーザーのログイン情報を取得するためのDAOクラス

    // ユーザー名を保存する変数
	//usernameという変数の宣言
    public String username;

    // パスワードを保存する変数
    //passwordという変数を宣言
    public String password;

    // データベースの検索結果を保存するためのリスト
    //loginDTOListというリストを宣言
    //このリストはデータベースから取得したユーザー情報が格納される
    public List<LoginDTO> loginDTOList = new ArrayList<LoginDTO>();

    /**
     * selectメソッドは、データベースからユーザー名とパスワードを使ってユーザー情報を取得するメソッドです。
     * @param username ユーザー名
     * @param password パスワード
     * @return 検索結果としてLoginDTOのリストを返します
     * このメソッドはusername/passwordを引数として受け取ります。
     */
    public List<LoginDTO> select(String username, String password) {
        // データベースに接続するためのオブジェクト(Connection)を取得します
    	//Connectionオブジェクトを使用して、データベースに対して操作を行う
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        // データベースでユーザー名とパスワードを条件に検索するためのSQL文
        //データベースからuserテーブルのデータを取得するためのSQL文を定義
        String sql = "SELECT * FROM users WHERE user_name = ? AND password = ?";

        try {
            // SQLを実行するために準備します（PreparedStatementを使用）
        	//	SQL文を事前にコンパイルし、パラメータを設定できるため、効率的
            PreparedStatement ps = con.prepareStatement(sql);

            // SQLクエリの1番目の「?」にユーザー名をセットします
            ps.setString(1, username);

            // SQLクエリの2番目の「?」にパスワードをセットします
            ps.setString(2, password);

            // SQLを実行し、結果をResultSetオブジェクトに格納します
            //ResultSetはデータベースからの結果セットを表す
            ResultSet rs = ps.executeQuery();

            // 検索結果がある限り、ループして結果を処理します
            //re.next()は、ResultSet内の次の行に移動し、結果が存在すればtrueを返す
            while (rs.next()) {
                // LoginDTOオブジェクトを作成し、取得したユーザー名とパスワードをセットします
                LoginDTO dto = new LoginDTO();
                dto.setUsername(rs.getString("user_name"));
                dto.setPassword(rs.getString("password"));

                // リストにDTOを追加します
                //これにより、複数のユーザー情報をリストに蓄積できます
                loginDTOList.add(dto);
            }

            // もし検索結果がなかった場合は、"該当なし"のメッセージをDTOにセットしてリストに追加します
            //これにより、検索結果がない場合でもメッセージが表示される
            if (loginDTOList.size() <= 0) {
                LoginDTO dto = new LoginDTO();
                dto.setUsername("該当なし");
                dto.setPassword("該当なし");
                loginDTOList.add(dto);
            }

        } catch (SQLException e) {
            // SQLの実行に失敗した場合のエラーメッセージを表示します
            e.printStackTrace();
        } finally {
            // データベース接続を閉じます（必ず実行されます）
            try {
                con.close();
            } catch (SQLException e) {
                // 接続を閉じる際のエラーをキャッチします
                e.printStackTrace();
            }
        }

        // 検索結果のリストを返します
        return loginDTOList;
    }
}
