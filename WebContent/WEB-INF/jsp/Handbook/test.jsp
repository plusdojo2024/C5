<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />


<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">

<title>テスト</title>
</head>

<header>
	<h1>ひろしninaru</h1>
</header>
<body>

	<h1 style="text-align: center">衣食住テスト</h1>
	<c:if test="${i == 0 }">
		<p style="text-align: left">問1</p>
	</c:if>

	<c:if test="${i == 1 }">
		<p style="text-align: left">問2</p>
	</c:if>

	<c:if test="${i == 2}">
		<p style="text-align: left">問3</p>
	</c:if>

	<c:if test="${i == 3 }">
		<p style="text-align: left">問4</p>
	</c:if>

	<c:if test="${i == 4 }">
		<p style="text-align: left">問5</p>
	</c:if>
	<form method="post" action="/C5/TestServlet">


		<c:if test="${i ==0 }">
			<p>${game1.quiz}</p>

			<table>
				<tr>
					<th><p>${game1.choice_1}</p></th>
					<th><p>${game1.choice_2}</p></th>
					<th><p>${game1.choice_3}</p></th>
					<th><p>${game1.choice_4}</p></th>
				</tr>
				</c:if>

				<c:if test="${i ==1 }">
					<p>${game2.quiz}</p>

					<table>
						<tr>
							<th><p>${game2.choice_1}</p></th>
							<th><p>${game2.choice_2}</p></th>
							<th><p>${game2.choice_3}</p></th>
							<th><p>${game2.choice_4}</p></th>
						</tr>
				</c:if>

				<c:if test="${i ==2 }">
					<p>${game3.quiz}</p>

					<table>
						<tr>
							<th><p>${game3.choice_1}</p></th>
							<th><p>${game3.choice_2}</p></th>
							<th><p>${game3.choice_3}</p></th>
							<th><p>${game3.choice_4}</p></th>
						</tr>
						</c:if>

						<c:if test="${i ==3 }">
							<p>${game4.quiz}</p>

							<table>
								<tr>
									<th><p>${game4.choice_1}</p></th>
									<th><p>${game4.choice_2}</p></th>
									<th><p>${game4.choice_3}</p></th>
									<th><p>${game4.choice_4}</p></th>
								</tr>
								</c:if>

								<c:if test="${i ==4 }">
									<p>${game5.quiz}</p>

									<table>
										<tr>
											<th><p>${game5.choice_1}</p></th>
											<th><p>${game5.choice_2}</p></th>
											<th><p>${game5.choice_3}</p></th>
											<th><p>${game5.choice_4}</p></th>
										</tr>
										</c:if>

									</table>


										<c:if test="${i == 0}">
											<th><input type="radio" name="answer1" value="あめりか"></th>
											<th><input type="radio" name="answer1" value="あめりか"></th>
											<th><input type="radio" name="answer1" value="あめりか"></th>
											<th><input type="radio" name="answer1" value="あめりか"></th>
										</c:if>

										<c:if test="${i == 1}">
											<th><input type="radio" id="#" name="answer2" value="1"></th>
											<th><input type="radio" id="#" name="answer2" value="2"></th>
											<th><input type="radio" id="#" name="answer2" value="3"></th>
											<th><input type="radio" id="#" name="answer2" value="4"></th>
										</c:if>

										<c:if test="${i == 2}">
											<th><input type="radio" id="#" name="answer3" value="1"></th>
											<th><input type="radio" id="#" name="answer3" value="2"></th>
											<th><input type="radio" id="#" name="answer3" value="3"></th>
											<th><input type="radio" id="#" name="answer3" value="4"></th>
										</c:if>

										<c:if test="${i == 3}">
											<th><input type="radio" id="#" name="answer4" value="1"></th>
											<th><input type="radio" id="#" name="answer4" value="2"></th>
											<th><input type="radio" id="#" name="answer4" value="3"></th>
											<th><input type="radio" id="#" name="answer4" value="4"></th>
										</c:if>

										<c:if test="${i == 4}">
											<th><input type="radio" id="#" name="answer5" value="1"></th>
											<th><input type="radio" id="#" name="answer5" value="2"></th>
											<th><input type="radio" id="#" name="answer5" value="3"></th>
											<th><input type="radio" id="#" name="answer5" value="4"></th>
										</c:if>


							</table>


							<c:if test="${i < 4 }">
								<input type="submit" value="次へ" class="next">
							</c:if>
	</form>
	<form method="post" action="/C5/TestServlet">
		<c:if test="${i == 4 }">
			<input type="submit" value="終了" class="next">
		</c:if>
	</form>







	<!-- <input type="radio"  id="#" name="1">選択肢1<br><br>
<input type="radio"  id="#"  name="2">選択肢2<br><br>
<input type="radio"  id="#" name="3">選択肢3<br><br>
<input type="radio"  id="#" name="4">選択肢4<br> -->
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<form method="post" action="/C5/TestResultServlet">



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
					<input type="submit" id="" value="ホーム"></input>
				</form>
			</td>
			<td>
				<form method="get" action="/C5/RecordServlet">
					<input type="submit" id="" value="記録書"></input>
				</form>
			</td>
			<td>
				<form method="get" action="/C5/HandbookServlet">
					<input type="submit" id="" value="ハンドブック"></input>
				</form>
			</td>
			<td>
				<form method="get" action="/C5/ConsulServlet">
					<input type="submit" id="" value="相談所"></input>
				</form>
			</td>
		</tr>
	</table>
</footer>
</html>