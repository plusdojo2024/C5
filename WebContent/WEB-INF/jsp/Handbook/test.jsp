<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">

  <title>テスト</title>
</head>

<header>
    <h1>ひろしninaru</h1>
</header>

<body>
<h1 style="text-align:center">衣食住テスト</h1>
<p style="text-align:left">問1</p>

<p>ランダムで問題文表示</p>

<input type="radio"  id="#">選択肢1<br><br>
<input type="radio"  id="#">選択肢2<br><br>
<input type="radio"  id="#">選択肢3<br><br>
<input type="radio"  id="#">選択肢4<br>

<br>
<br>

<form method="post" action="/C5/TestResultServlet">
	<input type="submit" value="次へ" class="next">
</form>

<!--
問2以降は戻るボタンも
<input type="button" value="戻る" class="back">
-->

<!--
問5は終了ボタンも
<input type="button" value="終了" class="finish">
-->

<br>

</body>

    <footer>
        <table align="center">
            <tr>
                <td>

                    <img src="../images/icons/home.png" id="fixedBar" alt="ホーム"></a>

                </td>
                <td>

                    <img src="../images/icons/record.png" id="fixedBar" alt="記録書"></a>

                </td>
                <td>

                    <img src="../images/icons/handbook.png" id="fixedBar" alt="ハンドブック"></a>

                </td>
                <td>

                    <img src="../images/icons/consul.png" id="fixedBar" alt="相談所"></a>

                </td>
            </tr>

            <tr>
                <td>
                	<form method="get" action="/C5/HomeServlet">
                	<input type ="submit" id="" value="ホーム"></input>
                	</form>
                </td>
                <td>
                	<form method="get" action="/C5/RecordServlet">
                	<input type ="submit" id="" value="記録書"></input>
                	</form>
                </td>
                <td>
                	<form method="get" action="/C5/HandbookServlet">
                	<input type ="submit" id="" value="ハンドブック"></input>
                	</form>
                </td>
                <td>
                	<form method="get" action="/C5/ConsulServlet">
                	<input type ="submit" id="" value="相談所"></input>
                	</form>
                </td>
            </tr>
        </table>
    </footer>

</html>