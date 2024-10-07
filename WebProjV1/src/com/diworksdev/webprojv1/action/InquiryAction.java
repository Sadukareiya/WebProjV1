package com.diworksdev.webprojv1.action;

import com.opensymphony.xwork2.ActionSupport;

/**
 * InquiryActionクラスは問い合わせ処理を行うアクションです。
 * executeメソッドが呼び出され、処理が成功した場合にSUCCESSを返します。
 */
public class InquiryAction extends ActionSupport {

    /**
     * このメソッドがStruts2フレームワークから呼び出されます。
     * 正常に処理が完了するとSUCCESSが返され、対応するJSPページが表示されます。
     */
    public String execute() {
        return SUCCESS;
    }
}
