package com.diworksdev.webprojv1.action;

// Struts2のActionSupportクラスをインポートします。
import com.opensymphony.xwork2.ActionSupport;

// WelcomeActionクラスはActionSupportクラスを継承(extends)しています。
public class WelcomeAction extends ActionSupport {

    // executeメソッドはStruts2のアクションメソッドです。
    // アクションが成功したときに呼ばれます。
    public String execute() {
        // このメソッドが成功した場合、"success"という結果を返します。
        return SUCCESS;
    }
}

/**全体の流れ
 *１，WelcomeActionクラスの定義：WelcomeAction というクラスが定義され、このクラスは、Struts2の ActionSupport クラスを継承してる
 *２，execute()メソッドの定義：リクエストが送られた際にアクションとして実行されるメソッド
 *※このメソッドは、通常、リクエストを処理し、その結果としてページの遷移を決定
 *３，SUCCESSの返却：execute() メソッドの中では、何らかの処理を行った後、SUCCESS という結果を返しています
 *SUCCESSが返されると、この結果に対応するページ（通常はJSP）が表示されます。
 *※Struts2の設定ファイル（struts.xml）で、success の結果に対してどのJSPページに遷移するかが指定されている
 *（welcome.jsp）
 */