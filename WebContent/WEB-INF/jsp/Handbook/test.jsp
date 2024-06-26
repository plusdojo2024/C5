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
<link rel="stylesheet" type="text/css" href="/C5/CSS/test.css">

<title>テスト</title>
</head>

<header class="header">
	<h3>IKUMI</h3>
</header>
<body>

	<h1 class="test ct">衣食住テスト</h1>
	<c:if test="${i == 0 }">
		<p style="text-align: center">問1</p>
	</c:if>

	<c:if test="${i == 1 }">
		<p style="text-align: center">問2</p>
	</c:if>

	<c:if test="${i == 2}">
		<p style="text-align: center">問3</p>
	</c:if>

	<c:if test="${i == 3 }">
		<p style="text-align: center">問4</p>
	</c:if>

	<c:if test="${i == 4 }">
		<p style="text-align: center">問5</p>
	</c:if>

	<form method="post" action="/C5/TestServlet">
		<div style="text-align: center">

			<c:if test="${i ==0 }">
				<p>${game1.quiz}</p>

				<table class="ct mg">
					<tr>
						<th><p>${game1.choice_1}</p></th>
						<th><p>${game1.choice_2}</p></th>
						<th><p>${game1.choice_3}</p></th>
						<th><p>${game1.choice_4}</p></th>
					</tr>
					<tr>
						<c:if test="${i == 0}">
							<th><input type="radio" name="answer" value="1"></th>
							<th><input type="radio" name="answer" value="2"></th>
							<th><input type="radio" name="answer" value="3"></th>
							<th><input type="radio" name="answer" value="4"></th>
						</c:if>
					</tr>
				</table>
			</c:if>

			<c:if test="${i ==1 }">
				<p>${game2.quiz}</p>
				<table class="ct mg">
					<tr>
						<th><p>${game2.choice_1}</p></th>
						<th><p>${game2.choice_2}</p></th>
						<th><p>${game2.choice_3}</p></th>
						<th><p>${game2.choice_4}</p></th>
					</tr>
					<tr>
						<c:if test="${i == 1}">
							<th><input type="radio" id="#" name="answer" value="1"></th>
							<th><input type="radio" id="#" name="answer" value="2"></th>
							<th><input type="radio" id="#" name="answer" value="3"></th>
							<th><input type="radio" id="#" name="answer" value="4"></th>
						</c:if>
					</tr>
				</table>
			</c:if>

			<c:if test="${i ==2 }">
				<p>${game3.quiz}</p>
				<table class="ct mg">
					<tr>
						<th><p>${game3.choice_1}</p></th>
						<th><p>${game3.choice_2}</p></th>
						<th><p>${game3.choice_3}</p></th>
						<th><p>${game3.choice_4}</p></th>
					</tr>
					<tr>
						<c:if test="${i == 2}">
							<th><input type="radio" id="#" name="answer" value="1"></th>
							<th><input type="radio" id="#" name="answer" value="2"></th>
							<th><input type="radio" id="#" name="answer" value="3"></th>
							<th><input type="radio" id="#" name="answer" value="4"></th>
						</c:if>
					</tr>
				</table>
			</c:if>

			<c:if test="${i ==3 }">
				<p>${game4.quiz}</p>

				<table class="ct mg">
					<tr>
						<th><p>${game4.choice_1}</p></th>
						<th><p>${game4.choice_2}</p></th>
						<th><p>${game4.choice_3}</p></th>
						<th><p>${game4.choice_4}</p></th>
					</tr>
					<tr>
						<c:if test="${i == 3}">
							<th><input type="radio" id="#" name="answer" value="1"></th>
							<th><input type="radio" id="#" name="answer" value="2"></th>
							<th><input type="radio" id="#" name="answer" value="3"></th>
							<th><input type="radio" id="#" name="answer" value="4"></th>
						</c:if>
					</tr>
				</table>
			</c:if>

			<c:if test="${i ==4 }">
				<p>${game5.quiz}</p>

				<table class="ct mg">
					<tr>
						<th><p>${game5.choice_1}</p></th>
						<th><p>${game5.choice_2}</p></th>
						<th><p>${game5.choice_3}</p></th>
						<th><p>${game5.choice_4}</p></th>
					</tr>
					<tr>
						<c:if test="${i == 4}">
							<th><input type="radio" id="#" name="answer" value="1"></th>
							<th><input type="radio" id="#" name="answer" value="2"></th>
							<th><input type="radio" id="#" name="answer" value="3"></th>
							<th><input type="radio" id="#" name="answer" value="4"></th>
						</c:if>
					</tr>
				</table>
			</c:if>
		</div>
		<br>
		<div style="text-align: center">
			<c:if test="${i < 4 }">
				<input type="submit" value="次へ" class="button">
			</c:if>

			<c:if test="${i == 4 }">
				<input type="submit" value="終了" class="button">
			</c:if>
		</div>
	</form>
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







