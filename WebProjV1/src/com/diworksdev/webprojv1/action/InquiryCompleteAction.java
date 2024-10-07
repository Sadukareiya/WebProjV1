package com.diworksdev.webprojv1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.webprojv1.dao.InquiryCompleteDAO;
import com.diworksdev.webprojv1.dto.InquiryDTO;
import com.opensymphony.xwork2.ActionSupport;

// InquiryCompleteAction クラスは、お問い合わせのデータを処理し、完了画面に遷移するためのアクションです
public class InquiryCompleteAction extends ActionSupport implements SessionAware {
	/*ActionSupprotはStruts2の標準的なアクションをサポートするためのクラス
	 *ActionSupprotはSUCCESSやERRORといった結果を返す便利なメソッド
	 *SessionAwareを実装することでセッションオブジェクトを操作することができます。
	 */

    // フォームから受け取るパラメータ
    private String name;  // 名前
    private String qtype; // 問い合わせの種類
    private String body;  // 問い合わせ内容

    // 問い合わせデータを格納するリスト
    List<InquiryDTO> inquiryDTOList = new ArrayList<InquiryDTO>();

    // セッションオブジェクト（ユーザーのセッション情報を管理する）
    private Map<String, Object> session;

    // execute メソッドは、フォーム送信時に実行される
    public String execute() {
        String ret = ERROR; // 初期状態はエラーとして定義

        // DAO（データベースアクセスオブジェクト）を作成
        InquiryCompleteDAO dao = new InquiryCompleteDAO();

        // データベースに問い合わせデータを挿入
        int count = dao.insert(name, qtype, body);

        // データベースに1件以上登録できたら処理を成功とする
        if (count > 0) {
            // 登録されたデータを取得してリストに格納
            inquiryDTOList = dao.select();

            // 取得したデータをセッションに格納
            session.put("inquiryDTOList", inquiryDTOList);

            // 成功として結果を返す
            ret = SUCCESS;
        }
        return ret; // 成功かエラーかの結果を返す
    }

    // 以下はフォームから渡される値を取得および設定するためのメソッド

    public String getName() {
        return name; // 名前を取得
    }

    public void setName(String name) {
        this.name = name; // 名前をセット
    }

    public String getQtype() {
        return qtype; // 問い合わせ種類を取得
    }

    public void setQtype(String qtype) {
        this.qtype = qtype; // 問い合わせ種類をセット
    }

    public String getBody() {
        return body; // 問い合わせ内容を取得
    }

    public void setBody(String body) {
        this.body = body; // 問い合わせ内容をセット
    }

    // セッションの取得
    public Map<String, Object> getSession() {
        return session;
    }

    // セッションのセット
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}

/**全体の流れ
 * １，ユーザーが問い合わせフォームを送信すると、このアクションが呼び出されます
 * ２，フォームの内容を（name,qtype,body）をデータベースに挿入します
 * ３，データベースに保存できたら、そのデータを取得しセッションに保存します。
 * ４，処理が成功したらSUCCESSを返し、完了画面へ・失敗したらERRORを返します
 */
