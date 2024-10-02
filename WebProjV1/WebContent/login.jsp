<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- Struts2のタグライブラリを使用するための設定 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!-- Struts2のタグライブラリを使用するために、sというプレフィックスを定義(例：s:property) -->
<!DOCTYPE html>
<html>
<head>
    <!-- ページの文字エンコーディングをUTF-8に設定 -->
    <meta charset="UTF-8">
    <!-- 外部のCSSファイルを読み込む -->
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <!-- ページのタイトル -->
    <title>LOGIN</title>
</head>
<body>

    <!-- ログイン成功時のメッセージを表示 -->
    <!-- セッションから取得したユーザー名を表示 -->
    <s:property value="#session.loginDTOList.get(0).username"/>さん、ようこそ！
    <br>

    <!-- ユーザー名とパスワードのリストを表示するテーブル -->
    <table>
        <tbody>
            <tr>
                <!-- テーブルのヘッダー（列名） -->
                <th>USERNAME</th>
                <th>PASSWORD</th>
            </tr>

            <!-- セッションに保存されたユーザー情報を繰り返し表示 -->
            <s:iterator value="#session.loginDTOList">
                <tr>
                    <!-- 各ユーザーのユーザー名を表示 -->
                    <td><s:property value="username"/></td>
                    <!-- 各ユーザーのパスワードを表示 -->
                    <td><s:property value="password"/></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>

</body>
</html>
