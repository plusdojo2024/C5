<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html id="Login-Signup-Background">

<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="style.css">

    <title>ログイン</title>
</head>

<body>
    <div class="WhiteBox">

      <h1>
        ひろしninaru
      </h1>

        <div>
        	<form method="post" action="/C5/LoginServlet">
                <br>
                <input type="text" class="userInfo" name="username" placeholder="username">
                <br>
                <input type="password" class="userInfo" name="password" placeholder="password">
                <br>
                <input type="submit" class="Login" name="submit" value="ログイン">
                <br>

              <input type="reset" class="SignUp" name="reset" value="新規登録">
            </form>
            <!-- <span id="error_message"></span> -->
        </div>
    </div>
</body>

</html>