package com.diworksdev.webprojv1.dao;
//このクラスがcom.diworksdev.webproj5.daoパッケージに属していることを示す

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//Connection,PreparedAtatement,ResultsetなどSQL関連のクラスや、他クラスを使用するためにインポート

import com.diworksdev.webprojv1.dto.HelloStrutsDTO;
import com.diworksdev.webprojv1.util.DBConnector;

public class HelloStrutsDAO {
//HelloStrutsDAOという名前の公開クラスを定義
//このクラスはデータベースからユーザー情報を取得するためのデータアクセスオブジェクト

    // HelloStrutsDTOのリスト
	//HelloStrutsDTOオブジェクトを格納するリストを定義（リストにデータベースから取得したユーザー情報を追加）
    private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<>();

    /**
     * データベースからユーザー情報を取得するメソッド
     */
    //ユーザー情報を取得するためのメソッド 戻り値でHelloStrutsDTOオブジェクトのリストを返す
    public List<HelloStrutsDTO> select() {

    	//DBConnectorクラスを使ってデータベース接続用のオブジェクトを生成
        DBConnector db = new DBConnector();
        Connection con = db.getConnection();

        //データベースからユーザー情報を取得するためのSQLクエリを定義 このクエリはuserテーブルの全ての行を取得;
        String sql = "SELECT * FROM users";

        try {
            // SQLの実行準備
            PreparedStatement ps = con.prepareStatement(sql);
            // クエリを実行し、結果セットを取得
            ResultSet rs = ps.executeQuery();

            // 結果セットからデータを取り出してリストに追加
            while (rs.next()) {
                // HelloStrutsDTOオブジェクトを生成し、データをセット
                HelloStrutsDTO dto = new HelloStrutsDTO();
                dto.setUserId(rs.getInt("user_id"));        // user_id列の値をDTOに設定
                dto.setUserName(rs.getString("user_name")); // user_name列の値をDTOに設定
                dto.setPassword(rs.getString("password"));  // password列の値をDTOに設定
                dto.setResult("MySQLと接続できます。");    // 接続成功メッセージを設定
                helloStrutsDTOList.add(dto);               // リストにDTOを追加
            }
        } catch (SQLException e) {
            // SQL例外が発生した場合、エラーメッセージを出力
            e.printStackTrace();
        } finally {
            // データベース接続を確実に閉じる処理
            try {
                if (con != null && !con.isClosed()) {
                    con.close();  // 接続が閉じられていない場合は閉じる
                }
            } catch (SQLException e) {
                // 接続を閉じる際の例外処理
                e.printStackTrace();
            }
        }

        // 取得したユーザー情報のリストを返す
        return helloStrutsDTOList;
    }
}


//全体の流れ
//1,select()メソッドが呼び出されると、データベース接続を確立し、SELECTクエリを実行
//2,クエリ結果をループで処理し、HelloStrutsDTOオブジェクトにユーザー情報を格納
//3,各DTOをリストに追加し、処理が終わったらデータベース接続を閉じる
//4,最後に、DTOオブジェクトのリストを返します