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

  <title>テスト結果</title>
</head>
<body>

<h1 style="text-align:center">衣食住テストの結果</h1>
<p style="text-align:center">ハンドブックの理解度はどうだったかな？</p>


<p>問1 問題文<br> 解答:選択肢1     ◎</p>
<p>問2 問題文<br> 解答:選択肢1     △</p>
<p>問3 問題文<br> 解答:選択肢1     ◎</p>
<p>問4 問題文<br> 解答:選択肢1     △</p>
<p>問5 問題文<br> 解答:選択肢1     ◎</p>

<!--
<img src="/JavaProg/testResult.png" width="600" height="600">
-->

<br>
<br>

<p style="text-align:center">ハンドブックをチェック！</p>
<form method="post" action="/C5/HandbookServlet">
	<input type="submit" value="ハンドブックを確認する" class="#HandBookCheck">
</form>

<br>
<br>
<form method="post" action="/C5/TestResultServlet">
	<p style="text-align:center">もう一度テストする？</p>
	<input type="submit" value="再テスト" class="testButton">
</form>
<br>
<br>
<br>

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
</body>

</html>