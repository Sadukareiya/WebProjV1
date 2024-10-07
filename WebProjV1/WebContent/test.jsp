<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8"> <!-- 文字エンコーディングを指定し、ページがUTF-８で表示される -->
    <link rel="stylesheet" type="text/css" href="./css/style.css">
    <title>TEST</title>
</head>
<body>
    <br>
    <h1>以下の新規ユーザーが登録されました。</h1>
    <br>
    <table>
        <thead>
            <tr>
                <th>USERNAME</th>
                <th>PASSWORD</th>
            </tr>
        </thead>
        <tbody>
            <!-- セッションからユーザーリストを取得して表示 -->
            <s:iterator value="#session.loginDTOList">
            <!-- value=session.loginDTOList"は、セッションスコープに格納されているloginDTOListを参照して、
            	そのリストの要素を一つずつ取り出して表示 -->
                <tr>
                    <td><s:property value="username"/></td> <!-- s:propertyは、そのオブジェクトのプロパティを表示するために使います -->
                    <td><s:property value="password"/></td> <!-- value="username"でLoginDTOオブジェクトのusernameフィールドを表示 -->   <!-- value="password"でLoginDTOオブジェクトのpasswordフィールドを表示 -->
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>

<!-- 全体の流れ -->
	<!--  このJSPページは、ユーザー登録が完了した後に表示され、新しく登録されたユーザー情報（usernameとpassword）をセッションから取得して、テーブルに表示
	TestActionクラスで処理されたユーザー情報が、セッションに保存され、それをこのページで(s:iterator)を使って繰り返し処理している形になります-->