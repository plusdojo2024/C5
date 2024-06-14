<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html id="Login-Signup-Background">

<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">

    <title>新規登録</title>
</head>

<body>
    <div class="WhiteBox">

        <h1>新規登録</h1>

        <form>
        <form method="post" action="/5C/SignUpServlet">
            <p class="Guide">ユーザーネーム</p>
                <input type="text" class="userInfo" name="username" placeholder="username">
            <p class="Guide">パスワード</p>
                <input type="password" class="userInfo" name="password" placeholder="password">
            <p class="Guide">お子さんの名前</p>
                <input type="text" class="userInfo" name="childname" placeholder="childname">
            <p class="Guide">お子さんの誕生日</p>
                <input type="text" class="userInfo" name="birthday" placeholder="birthday">

            <input type="submit" class="Register" name="login" value="登録">
        </form>

 		<form method="post" action="/5C/LoginServlet">
        	<input type="submit" name="back" value="戻る">
        </form>

    </div>
</body>

</html>




    <!DOCTYPE html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>新規登録</title>
    <!--<link rel="stylesheet" href="/simpleBC/css/style.css">-->

    </head>

    <body style="text-align: center;">

    <h1>新規登録</h1>

    <!--<p>※ID, パスワード, ユーザ名を入力して下さい。-->


    <div>
    <!--<form method="post" action="/simpleBC/NewAccountServlet">-->
    ユーザーネーム<br>
    <input type="text" name="username" placeholder="username"><br>
    パスワード<br>
    <input type="password" name="password" placeholder="password"><br>
    お子さんの名前<br>
    <input type="text" name="childname" placeholder="childname"><br>
    お子さんの誕生日<br>
    <input type="text" name="birthday" placeholder="birthday"><br>

    <input type="submit" name="login" value="登録">
    </form>


    <!--<form method="get"action="/simpleBC/LoginServlet">
    <input type="submit" name="back" value="戻る">
    </form>--->

    </div>
    </body>

    </html>





