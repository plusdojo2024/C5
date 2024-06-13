<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>ログイン</title>

    </head>

    <body style="text-align: center;">

      <h1>
        ひろしninaru
      </h1>

    <div>
    <!--  <form method="post" action="/simpleBC/LoginServlet"> -->
<form method="get" action="/C5/HomeServlet">
              <br>
              <input type="text" name="username" placeholder="username">
              <br>
              <input type="password" name="password" placeholder="password">
              <br>
              <input type="submit" name="submit" value="ログイン"><br>
              </form>
              <form action="/C5/"></form>
              <input type="reset" name="reset" value="新規登録">
    <!--          <span id="error_message"></span> -->


    </div>
    </body>
    </html>