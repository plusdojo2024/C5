<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!doctype html>
<html id="Login-Signup-Background">

<head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">

    <title>ログイン</title>
</head>

<body>
    <div class="WhiteBox">

      <h1>
        ひろしninaru
      </h1>

        <div>
        	 <%-- エラーメッセージが設定されている場合に表示する --%>
				<% if (request.getAttribute("errorMessage") != null) { %>
    			<p style="color: red;"><%= request.getAttribute("errorMessage") %></p>
				<% } %>

        	<form method="post" action="/C5/LoginServlet">

                <br>
                <input type="text" class="userInfo" name="user_name" placeholder="user_name" required>
                <br>
                <input type="password" class="userInfo" name="password" placeholder="password" required>
                <br>
                <input type="submit" class="Login" name="submit" value="ログイン">
                <br>

            </form>

			<form method="post" action="/C5/SignUpServlet">
              <input type="reset" class="SignUp" name="reset" value="新規登録">
            </form>


        </div>
    </div>
</body>

</html>