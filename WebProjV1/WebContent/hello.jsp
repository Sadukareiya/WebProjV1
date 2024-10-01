<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- ページ全体の設定 -->
<%@ taglib prefix="s" uri="/struts-tags"%>
<!-- Struts2タグライブラリを使用するための宣言 Strutsタグを使用する際は、「prefix="s"」を使用 -->
<!DOCTYPE html>
<html>
<head>
    <!-- ページの文字エンコーディングを指定 -->
    <meta charset="utf-8">
    <!-- 外部のCSSファイルを読み込む href="./css/style.css"はファイルへのパス -->
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <!-- ページタイトル -->
    <title>HelloStruts</title>
</head>
<body>
    <!-- ページの見出し -->
    <h1>HelloStruts2!</h1>
    <br>

    <!-- データをテーブル形式で表示 -->
    <table>
        <tbody>
            <!-- テーブルのヘッダー -->
            <tr>
                <th>USERID</th> <!-- テーブルのヘッダーセルで「USERID」という見出しが表示 -->
                <th>USERNAME</th> <!-- : 「USERNAME」という見出しを表示 -->
                <th>PASSWORD</th><!--  「PASSWORD」という見出しを表示 -->
                <th>RESULT</th><!-- 「RESULT」という見出しを表示します。この列には、処理の結果が表示 -->
            </tr>
            <!-- セッションからデータリストを取得して繰り返し表示(helloStrutsDTOListの内容を繰り返し処理) -->
            <s:iterator value="#session.helloStrutsDTOList">
                <tr>
                    <!-- データの各プロパティを表示
                    リスト項目（helloStrutsDTO）からuserId・userNameなどのプロパティを取得し、テーブルセル内に表示 -->
                    <td><s:property value="userId"/></td>
                    <td><s:property value="userName"/></td>
                    <td><s:property value="password"/></td>
                    <td><s:property value="result"/></td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>
