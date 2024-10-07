<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <!-- ページの文字エンコーディングとスタイルシートの指定 -->
    <meta charset="UTF-8"> <!-- 文字エンコーディングをUTF-8に設定します -->
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>お問い合わせ 受付完了</title>
</head>
<body>

    <!-- 問い合わせの内容を表示するテーブル -->
    <table>
        <thead>
            <tr>
                <th>名前</th>
                <th>お問い合わせの種類</th>
                <th>お問い合わせ内容</th>
            </tr>
        </thead>
        <tbody>
            <!-- セッションに保存されている inquiryDTOList を繰り返し処理 -->
            <s:iterator value="#session.inquiryDTOList">
            <!-- #session.inquiryDTOListでセッションに格納されたリストを参照している -->
                <tr>
                    <!-- 名前を表示 -->
                    <td><s:property value="name" /></td>

                    <!-- お問い合わせの種類を条件に応じて表示 -->
                    <td>
                        <s:if test='qtype == "company"'>
                            会社について
                        </s:if>
                        <s:if test='qtype == "product"'>
                            製品について
                        </s:if>
                        <s:if test='qtype == "support"'>
                            アフターサポートについて
                        </s:if>
                    </td>

                    <!-- お問い合わせ内容を表示 -->
                    <td><s:property value="body" /></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>

</body>
</html>
