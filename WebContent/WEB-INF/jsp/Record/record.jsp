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
		<h3>IKUMI</h3>
	</header>
	<h2 class="title">育児記録書</h2>
	<h3 class="calendar">
		<form action="/C5/RecordServlet" method="get">
			<input type="date" id="hiduke" name="date"> <input
				type="submit" value="日付送信">
		</form>
	</h3>
	<!--<a href="home.html"></a>-->
	<hr />
	<div class="upload">
		<p>アップロードファイル：画像</p>
		<c:forEach var="p" items="${photo }">
		<P>${p.img_timestamp }</P>
			<img src="${p.imgPath1}" width=200 height=200>
			<img src="${p.imgPath2}" width=200 height=200>
			<img src="${p.imgPath3}" width=200 height=200>
			<img src="${p.imgPath4}" width=200 height=200>
			<img src="${p.imgPath5}" width=200 height=200>
		</c:forEach>
	</div>
	<hr />

	<div class="TimeRecord">
		<hr>
		<p>記録</p>
		<hr>
		<!--c:forEachで取得したデータを繰り返し表示-->
		<c:forEach var="e" items="${list}">
			<p class="RecordData">${e.timeFormat} &emsp; ${e.work} &emsp; ${e.milk_quantity} &emsp; ${e.comment}</p>
			<hr>
		</c:forEach>

		<p>コメント欄</p>
		<hr>
		<c:forEach var="c" items="${comments}">
			<p class="RecordData">${c.comment}</p>
			<hr>
		</c:forEach>
	</div>
	<form action="/C5/RecordServlet" method="post">
		<textarea name="RecordComment" class="RecordComment"
			placeholder="コメントを入力してください"></textarea>
		<br> <input type="submit" name="koment" value="コメントする"
			class="CommentButton">
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
	<script>
		//曜日を配列として定義
		const daysOFWeek = [ "日", "月", "火", "水", "木", "金", "土", ]

		//今日の日付を取得
		const today = new Date();

		//年、月、日、曜日を取得
		const year = today.getFullYear();
		const month = today.getMonth() + 1;
		const date = today.getDate();
		const day = daysOFWeek[today.getDay()];

		//日付（曜日）を文字列として整形
		document.getElementById("hiduke").Date = year + month + +date;
	</script>
</body>
</html>