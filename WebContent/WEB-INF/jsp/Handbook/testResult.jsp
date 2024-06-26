<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



<!DOCTYPE html>
<html lang="ja" class="RecordBody">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/C5/CSS/testresult.css">

<title>テスト結果</title>
</head>
<header class="header">
	<h3>IKUMI</h3>
</header>
<body>

	<h1 class="test ct">衣食住テストの結果</h1>
	<h2 style="text-align: center">ハンドブックの理解度はどうだったかな？</h2>


	<p style="text-align: center">
		問1 ${game1.quiz}<br> 解答: ${問1}
	</p>
	<p style="text-align: center">
		問2 ${game2.quiz}<br> 解答: ${問2}
	</p>
	<p style="text-align: center">
		問3 ${game3.quiz}<br> 解答: ${問3}
	</p>
	<p style="text-align: center">
		問4 ${game4.quiz}<br> 解答: ${問4}
	</p>
	<p style="text-align: center">
		問5 ${game5.quiz}<br> 解答: ${問5}
	</p>

	<%--<p>問1  ${game1.quiz}<br> 解答:選択肢${answer1}     ${問1}</p>--%>

	<!--
<img src="/JavaProg/testResult.png" width="600" height="600">
-->

	<br>
	<br>
	<div class="ct mg">
		<p>${perfect}</p>
		<form method="get" action="/C5/HandbookServlet">
			<div>
				<input type="submit" value="ハンドブックを確認する" class="button">
			</div>
		</form>
	</div>

	<br>
	<br>
	<form method="get" action="/C5/TestServlet">
		<div class="ct mg">
			<p>もう一度テストする？</p>
			<div>
				<input type="submit" value="再テスト" class="button">
			</div>
		</div>
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<footer>
		<table align="center">
			<tr>
				<td><img src="/C5/images/icons/home.png" class="FixedBar"
					alt="ホーム"></a></td>
				<td><img src="/C5/images/icons/record.png" class="FixedBar"
					alt="記録書"></a></td>
				<td><img src="/C5/images/icons/handbook.png" class="FixedBar"
					alt="ハンドブック"></a></td>
				<td><img src="/C5/images/icons/consul.png" class="FixedBar"
					alt="相談所"></a></td>
			</tr>
			<tr>
				<td>
					<form method="get" action="/C5/HomeServlet">
						<input type="submit" id="" value="ホーム" class="button"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/RecordServlet">
						<input type="submit" id="" value="記録書" class="button"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/HandbookServlet">
						<input type="submit" id="" value="ハンドブック" class="button"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/ConsulServlet">
						<input type="submit" id="" value="相談所" class="button"></input>
					</form>
				</td>
			</tr>
		</table>
	</footer>
</body>

</html>