<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html id="Login-Signup-Background">

<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">

    <title>ログアウト</title>
</head>
<body>
    <div class="WhiteBox">
        <p>ログアウトしますか？</p>
        <form method="post" action="/C5/LoginServlet">
            <input type="submit" class="Logout" name="logout" value="ログアウト">
        </form>

        <form method="post" action="/C5/LogoutServlet">
            <input type="submit" class="Cancel" name="cancel" value="キャンセル">
        </form>
    </div>

</body>
</html>