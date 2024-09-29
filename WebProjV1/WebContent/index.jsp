<!-- ・language="java=このJSPページがJavaを使って書かれていることを指定
	 ・contentType="text/html; charset=UTF-8=このページがHTML形式で文字エンコーディングがUTF-８と指定
	 ・pageEncoding="UTF-8"=このJSPファイル自体のエンコーディングがUTF-８であることを指定 -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- 以下行はJSPページでStrutsのタグライブラリを使用するための宣言
	 ・prefix="s"=Strutsタグを使用するときに「s:」というプレフィックスを付けて使用することを指定（例：s:formなど）
	 ・uri="/struts-tags"=StrutsのタグライブラリのURLを指定 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<!-- 文書がUTF-8エンコードされていることを示す -->
    <meta charset="utf-8">
    <!-- HTMLページのタイトル -->
    <title>INDEX</title>
</head>
<body>
	<!-- Sturtsフレームワークのフォームタグ  Strutsのアクションを使ってサーバー側で処理を行う -->
	<!-- action="HelloStrutsAction"=このフォームのデータが送信される先を指定 -->
    <s:form action="HelloStrutsAction">
    	<!-- Sturtsのサブミットボタン（送信ボタン）フォームのデータをサーバーに送信します -->
    	<!-- value="HelloStruts"ボタンに表示されるテキストを指定 -->
        <s:submit value="HelloStruts" />

       <!-- action="WelcomeAction"=新しいフォームを開始し、WelcomeActionというアクションにデータを送信 -->
    </s:form>
    <s:form action="WelcomeAction">
        <!-- ボタンを押すと、WelcomeActionが実行されます -->
        <s:submit value="Welcome"/>
    </s:form>

    <!-- action="InquiryAction"=さらに新しいStrutsのフォームを開始し、InquiryActionというアクションにデータを送信 -->
    <s:form action="InquiryAction">
        <!-- ボタンを押すと、InquiryActionが実行されます -->
        <s:submit value="問い合わせ"/>
    </s:form>

    <!-- 新規ユーザー登録フォーム -->
    <!-- <h3>タグで「新規ユーザー登録」という見出しを作成 -->
	<br>
	<h3>新規ユーザー登録</h3>

	<!-- GET 通信を使用したフォーム -->
	<!-- method="get"=フォームのデータをURLのクエリストリング（文字列）として送信することを指定 -->
	<!-- action="TestAction"=このフォームが送信される先のアクション名 -->
	<h4>GET 通信</h4>
	<s:form method="get" action="TestAction">

		<!-- name="username"=フィールドの名前を指定し、サーバーでサクセスするためのキー -->
		<!-- label="ユーザー名"=フィールドに関連するラベルテキストを指定 -->
    	<s:textfield name="username" label="ユーザー名" />

    	<!-- name="password"=フィールドの名前を指定 -->
    	<!-- label="パスワード"=フィールドに関連するラベルテキストを指定 -->
    	<s:password name="password" label="パスワード" />

    	<!-- value="送信"=ボタンに表示されるテキスト。フォームが送信される -->
    	<s:submit value="送信" />
	</s:form>

	<!-- POST 通信を使用したフォーム(POSTメゾットを使用したフォーム) -->
	<!-- method="post"=フォームのデータをHTTPリクエストボディとして送信することを指定 -->
	<h4>POST 通信</h4>
	<s:form method="post" action="TestAction">

		<!-- ユーザー名を入力するためのテキストフィールドを定義 -->
    	<s:textfield name="username" label="ユーザー名" />

    	<!-- パスワードを入力するためのパスワードフィールドを定義 -->
    	<s:password name="password" label="パスワード" />

    	<!-- 送信ボタンを定義 -->
    	<s:submit value="送信" />
	</s:form>

</body>
</html>


<!-- 全体の流れ
	 １，Jspページの設定：最初にページの言語やエンコーディング、使用するタグライブラリを定義
	 ２，HTML構造：HTMLの標準的な構造
	 ３，Strutsフォーム：Strutsフォームとボタンを使用し、フォームデータをサーバーに処理
	 ４，各アクションに対するフォームを提供し、異なる方法（GETとPOST）でデータを送信できるようにした -->