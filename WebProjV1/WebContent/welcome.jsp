<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>WELCOME</title>
</head>
<body>
    <!-- ユーザーに名前とパスワードを入力してもらうフォームです -->
    名前とパスワードを入力してください。

    <!-- Struts2のフォームタグを使用してログインフォームを作成 -->
    <s:form action="LoginAction">
        <!-- ユーザー名を入力するためのテキストフィールド -->
        <s:textfield name="username" label="ユーザー名" />

        <!-- パスワードを入力するためのパスワードフィールド -->
        <s:password name="password" label="パスワード" />

        <!-- フォームを送信するためのボタン -->
        <s:submit value="送信"/>
    </s:form>
</body>
</html>
