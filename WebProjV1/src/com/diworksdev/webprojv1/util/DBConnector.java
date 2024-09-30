package com.diworksdev.webprojv1.util;
//package com.diworksdev.webproj5.util;
//上記クラスがcom.diworksdev.webproj5.utilというパッケージに所属していることを示す

//JDBCのConnectionクラスをインポート＝データベース接続を表すオブジェクトを確立
import java.sql.Connection;
//DriverManagerクラスをインポート＝これを使ってデータベース接続を確立
import java.sql.DriverManager;
//SQLExceptionクラスをインポート＝SQL実行時に発生する例外を処理するために使用
import java.sql.SQLException;

//public class DEConnector:データベース接続を管理するためのDBConnectrクラスを定義（public＝ほかのクラスにもアクセス可能）
public class DBConnector {

    /**
     * JDBC ドライバー名
     */
    private static String driverName = "com.mysql.jdbc.Driver";
    // MySQLデータベースを操作するためのJDBCドライバーのクラス名
    //staticで定義されているためこのクラスがインスタンス化しないでもアクセス可能

    /**
     * データベース接続 URL
     */
    private static String url = "jdbc:mysql://localhost/testdb";
    // MySQLデータベースの接続URL。'localhost'はローカルマシン上のMySQLサーバを指し、'testdb'は接続するデータベース名

    /**
     * データベース接続ユーザ名
     */
    private static String user = "root";
    // データベースに接続するためのユーザ名。通常、MySQLのデフォルトユーザは'root'

    /**
     * データベース接続パスワード
     */
    private static String password = "mysql";
    // データベース接続に必要なパスワード。この例では"mysql"がパスワードとして指定されている

    /**
     * データベース接続を取得するメソッド
     */
    public Connection getConnection() {
    //	public Connection getConnection():データベースへの接続を取得するメソッドを定義

    	//Connectionオブジェクトを初期化（この変数にデータベース接続が格納され、後で返される）
        Connection con = null;

        //接続処理で発生する例外をキャッチするために使用
        try {
            // JDBC ドライバーのロード
            Class.forName(driverName);
            // 指定されたJDBCドライバーをロード。これによってJDBCがMySQLに接続できるようになる

            // データベースへの接続
            con = DriverManager.getConnection(url, user, password);
            // DriverManagerのgetConnectionメソッドを使って、データベースに接続しConnectionオブジェクトを取得

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            // JDBCドライバーが見つからなかった場合のエラーハンドリング
        } catch (SQLException e) {
            e.printStackTrace();
            // SQLエラーが発生した場合のエラーハンドリング
        }
        return con;
        // Connectionオブジェクトを返す。接続が成功していればデータベースと通信可能になる
    }
}

//全体の流れ
//1,JDBCドライバをロード
//2,DriverManager.getConnectionを使ってデータベースに接続。
//3,例外処理（ClassNotFoundExceptionとSQLException）を行い、エラーが発生した場合はスタックトレースを出力
//例外処理（ClassNotFoundExceptionとSQLException）を行い、エラーが発生した場合はスタックトレースを出力
