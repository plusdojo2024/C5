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
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">
<title>育児記録書</title>
</head>
<body class="RecordBody">
	<header>
		<h3>ひろしninaru</h3>
	</header>
	<h2 class="title">育児記録書</h2>
	<h3 class="calendar">
		<form action="/C5/RecordServlet" method="get">
			<input type="date" id="record_date" name="date">
		</form>
	</h3>
	<!--<a href="home.html"></a>-->
	<img src="ごはん中のしんのすけ.jpg" width="250" height="160">
	<div class="TimeRecord">
		<hr>
		<!--c:forEachで取得したデータを繰り返し表示-->
		<c:forEach var="e" items="${list}">
			<p class="RecordData">${e.timeFormat}${e.work}${e.milk_quantity}
				${e.comment}</p>
		</c:forEach>
		<!--
      <p class="RecordData">8:00 ミルク 50ml</p>
      <hr>
      <p class="RecordData">10:00 お昼寝</p>
      <hr>
      <p class="RecordData">12:00 ミルク 50ml</p>
      <hr>-->
	</div>
	<form>
		<textarea name="RecordComment" class="RecordComment"
			placeholder="コメントを入力してください"></textarea>
		<br>
		<button class="CommentButton">コメントする</button>
	</form>
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
</body>
</html>