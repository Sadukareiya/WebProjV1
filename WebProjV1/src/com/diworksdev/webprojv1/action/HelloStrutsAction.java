package com.diworksdev.webprojv1.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.diworksdev.webprojv1.dao.HelloStrutsDAO;
import com.diworksdev.webprojv1.dto.HelloStrutsDTO;
import com.opensymphony.xwork2.ActionSupport;
/**
 * package宣言：このクラスはcom.diworksdev.webproj5.action パッケージに所属
 * インポート文：必要なクラスやインターフェースをインポート
 * SessionAware はセッションの管理
 * HelloStrutsDAO と HelloStrutsDTO はデータベースアクセスとデータの保存に関するクラス
 * ActionSupport は Struts2 フレームワークの基本クラス
 */

/**
 * HelloStrutsActionクラスは、Struts2のアクションクラス
 * このクラスは、ユーザーのデータを取得し、セッションに保存する
 * セッションはウェブサイトでユーザーの情報を一時的に保存するための仕組み
 * ActionSupport クラスの継承: Struts2 でアクションを定義する際の基本クラス
 * SessionAware の実装: セッションの管理を行うために SessionAware インターフェースを実装
 */
public class HelloStrutsAction extends ActionSupport implements SessionAware {

    // HelloStrutsDTOのリストを保持するためのフィールド（フィールド：helloStrutsDTOList）
    private List<HelloStrutsDTO> helloStrutsDTOList = new ArrayList<HelloStrutsDTO>();

    // セッションを管理するためのマップ（session フィールド）
    private Map<String, Object> session;

    /**
     * アクションのメインメソッドです。
     * ユーザーのデータを取得して、セッションに保存します。
     * ret 変数: 初期状態では ERROR として設定し、成功した場合に SUCCESS に変更
     */
    public String execute() {
        String ret = ERROR;

        /** HelloStrutsDAOのインスタンスを作成し、データを取得
         * DAO インスタンス生成: HelloStrutsDAO クラスをインスタンス化
         * select メソッドでデータベースからユーザー情報を取得
         * DTOリスト更新: 取得した HelloStrutsDTO オブジェクトをリストに保存
         */
        HelloStrutsDAO dao = new HelloStrutsDAO();
        helloStrutsDTOList = dao.select();

        /** データが取得できた場合
         *  リストにデータがある場合は、セッションにリストを保存し、ret を SUCCESS に変更
         *  データがない場合は ERROR を返す
         */
        if (helloStrutsDTOList.size() > 0) {
            // セッションにデータを保存
            session.put("helloStrutsDTOList", helloStrutsDTOList);
            ret = SUCCESS; // 成功結果を設定
        } else {
            // データがない場合はエラー
            ret = ERROR;
        }

        return ret; // 結果を返す retの返却：処理結果を返す
    }

    /**
     * getSession メソッド: セッションを取得するためのメソッドです。
     */
    public Map<String, Object> getSession() {
        return session;
    }

    /**
     * setSession メソッド: セッションを設定するためのメソッドです。
     *
     * @param session セッションのマップ
     */
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
  /**全体の流れ
   *１，HelloStrutsAction クラスの定義: Struts2 アクションとしてユーザーの情報を管理
   *２，execute メソッド: データベースからユーザー情報を取得し、セッションに保存
   *    成功すれば、SUCCESS を返し、失敗すれば ERROR を返します。
   *３，セッション管理: ユーザーの情報をセッションに保存し、セッションにアクセスするためのメソッドが用意
   */