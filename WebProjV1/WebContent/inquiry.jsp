<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> <!-- ページの文字エンコーディングをUTF-8に指定 -->
    <title>お問い合わせフォーム</title> <!-- ページのタイトルを設定 -->
</head>
<body>
    <!-- method="post" はフォーム送信時にPOSTメソッドを使用することを示します。 -->
    <!-- action="InquiryCompleteAction" はフォーム送信時に実行されるアクションを指定 -->
    <s:form method="post" action="InquiryCompleteAction">

        <!-- 名前入力フィールド。type="text" は通常のテキスト入力用 -->
        <!-- name="name"でサーバーに送信されるボタンのキーを「name」に指定 -->
        名前: <input type="text" name="name"/><br>

        <!-- 問い合わせの種類を選択するためのセレクトボックス -->
        お問い合わせの種類:<br>
        <select name="qtype">
            <option value="company">会社について</option>
            <option value="product">製品について</option>
            <option value="support">アフターサポートについて</option>
        </select>
        <br>

        <!-- お問い合わせ内容を記述するためのテキストエリア -->
        <!-- ユーザーが複数行のテキストを入力できるフォームフィールド -->
        お問い合わせ内容:<br>
        <s:textarea name="body"/>
        <br>

        <!-- フォームを送信するためのボタン -->
        <s:submit value="登録"/>
    </s:form>
</body>
</html>
