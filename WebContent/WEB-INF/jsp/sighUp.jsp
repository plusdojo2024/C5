<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html id="Login-Signup-Background">

<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/C5/CSS/sighup.css">

    <title>新規登録</title>
</head>

<body>
    <div class="WhiteBox">

        <h2 class="sinki">新規登録</h2>

        <form method="post" action="/C5/SignUpServlet">
            <p class="Guide">ユーザーID</p>
            <input type="text" class="userInfo" name="id" value="（自動採番）"readonly="readonly" placeholder="ID">
            <p class="Guide">ユーザーネーム</p>
                <input type="text" class="userInfo" name="user_name" placeholder="username">
            <p class="Guide">パスワード</p>
                <input type="password" class="userInfo" name="password" placeholder="password">
            <p class="Guide">お子さんの名前</p>
                <input type="text" class="userInfo" name="child_name" placeholder="childname">
            <p class="Guide">お子さんの誕生日</p>
                <input type="Date" class="userInfo" name="child_birthday" placeholder="birthday">

            <input type="submit" class="Register" name="login" value="登録">
        </form>

 		<form method="post" action="/C5/LoginServlet">
        	<input type="submit" name="back" value="戻る" class="back">
        </form>

    </div>
</body>

</html>





