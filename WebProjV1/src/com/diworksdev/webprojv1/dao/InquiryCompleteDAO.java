package com.diworksdev.webprojv1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/*データベース接続（Connection）
 * SQL文の実行（PreparedSyatement）
 * 結果セットの取得（ResultSet）
 * 例外処理（SQLException）に必要なクラスをインポート
 * ArrayListとListはデータ格納に使用
 */

import com.diworksdev.webprojv1.dto.InquiryDTO; //お問い合わせ情報を保持
import com.diworksdev.webprojv1.util.DBConnector; //データベース接続を管理

// InquiryCompleteDAO クラスは、データベースへの問い合わせデータの読み書きを行うクラスです
public class InquiryCompleteDAO {

    // InquiryDTO オブジェクトを格納するリスト
	//オブジェクトを格納するためのリストを初期化している
    List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

    // データベースからすべての問い合わせデータを取得するメソッド
    public List<InquiryDTO> select() {
        // DBConnectorを使ってデータベース接続を取得
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        // データベースに対するSQLクエリ
        //すべての問い合わせ情報を取得するためのSQLクエリを文字列として定義
        String sql = "select * from inquiry";

        try {
            // SQLクエリを実行する準備
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery(); //結果をResultSetオブジェクトに格納

            // 結果セットからデータを取り出し、DTOにセットしてリストに追加
            while (rs.next()) {
                InquiryDTO dto = new InquiryDTO();
                dto.setName(rs.getString("name"));        // 名前をセット
                dto.setQtype(rs.getString("qtype"));      // 問い合わせ種類をセット
                dto.setBody(rs.getString("body"));        // 問い合わせ内容をセット
                inquiryDTOList.add(dto);                  // リストに追加
            }
        } catch (SQLException e) {
            // 例外が発生した場合にエラーメッセージを出力
            e.printStackTrace();
        }

        try {
            // データベース接続を閉じる
            con.close();
        } catch (SQLException e) {
        	//接続が正常に閉じられない場合に、例外をキャッチしてエラーメッセージを出力します。
            e.printStackTrace();
        }

        // 問い合わせデータを格納したリストを返す
        return inquiryDTOList;
    }

    // データベースに新しい問い合わせデータを挿入するメソッド
    public int insert(String name, String qtype, String body) {
        int ret = 0; //挿入された件数をretに格納し、後で返す

        // DBConnectorを使ってデータベース接続を取得
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        // データベースにデータを挿入するためのSQLクエリ
        String sql = "insert into inquiry values(?,?,?)";

        try {
            // SQLクエリを実行する準備
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, name);  // 1番目のパラメータに名前をセット
            ps.setString(2, qtype); // 2番目のパラメータに問い合わせ種類をセット
            ps.setString(3, body);  // 3番目のパラメータに問い合わせ内容をセット

            // データベースに対して挿入を実行し、結果を確認
            int i = ps.executeUpdate();
            if (i > 0) {
                // データが挿入された場合のメッセージ
                System.out.println(i + "件登録されました");
                ret = i; // 挿入件数を返す
            }
        } catch (SQLException e) {
            // 例外が発生した場合にエラーメッセージを出力
            e.printStackTrace();
        }

        try {
            // データベース接続を閉じる
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // 挿入された件数を返す
        return ret;
    }
}
