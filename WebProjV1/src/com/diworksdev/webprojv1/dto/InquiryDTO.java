package com.diworksdev.webprojv1.dto;

// InquiryDTO クラスは、お問い合わせフォームのデータを格納するためのクラスです
public class InquiryDTO {

    // 名前を保存するためのフィールド
    private String name;

    // お問い合わせの種類を保存するためのフィールド
    private String qtype;

    // お問い合わせ内容を保存するためのフィールド
    private String body;

    // 名前を取得するためのメソッド
    public String getName() {
        return name;
    }

    // 名前を設定するためのメソッド
    public void setName(String name) {
        this.name = name;
    }

    // お問い合わせの種類を取得するためのメソッド
    public String getQtype() {
        return qtype;
    }

    // お問い合わせの種類を設定するためのメソッド
    public void setQtype(String qtype) {
        this.qtype = qtype;
    }

    // お問い合わせ内容を取得するためのメソッド
    public String getBody() {
        return body;
    }

    // お問い合わせ内容を設定するためのメソッド
    public void setBody(String body) {
        this.body = body;
    }
}
