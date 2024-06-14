<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>テスト結果</title>
<!--
<link rel="stylesheet" type="text/css" href="style.css">
-->
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

<input type="button" value="ハンドブックを確認する" class="#HandBookCheck">

<br>
<br>
<p style="text-align:center">もう一度テストする？</p>
<input type="button" value="再テスト" class="testButton">

<br>
<br>
<br>

    <footer>
        <table align="center">
            <tr>
                <td>
                	<form method="get" action="/C5/HomeServlet">
                    <img src="../images/icons/home.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
                <td>
                    <form method="get" action="/C5/RecordServlet">
                    <img src="../images/icons/record.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
                <td>
                    <form method="get" action="/C5/HandbookServlet">
                    <img src="../images/icons/handbook.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
                <td>
                    <form method="get" action="/C5/ConsulServlet">
                    <img src="../images/icons/consul.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
            </tr>

            <tr>
                <td><input type ="submit" id="" value="ホーム"></input></td>
                <td><input type ="submit" id="" value="記録書"></input></td>
                <td><input type ="submit" id="" value="ハンドブック"></input></td>
                <td><input type ="submit" id="" value="相談所"></input></td>
            </tr>
        </table>
    </footer>

</body>

</html>