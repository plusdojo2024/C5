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
<link rel="stylesheet" type="text/css" href="/C5/CSS/record.css">
<title>育児記録書</title>
</head>
<body class="RecordBody">
	<header class="header">
		<h3>IKUMI</h3>
	</header>
	<h1 class="kiroku ct">育児記録書</h1>
	<h3 class="ct">
		<form action="/C5/RecordServlet" method="get">
			<input type="date" id="hiduke" name="date"> <input
				type="submit" value="日付送信" class="button">
		</form>
	</h3>
	<!--<a href="home.html"></a>-->
	<hr />
	<div class="ct">

		<c:forEach var="p" items="${photo }">

			<div class="slide"><img src=/C5/upload/${p.imgPath1} width=300 height=200></div>
			<div class="slide"><img src=/C5/upload/${p.imgPath2} width=200 height=200></div>
			<div class="slide"><img src=/C5/upload/${p.imgPath3} width=200 height=200></div>
			<div class="slide"><img src=/C5/upload/${p.imgPath4} width=200 height=200></div>
			<div class="slide"><img src=/C5/upload/${p.imgPath5} width=200 height=200></div>
		</c:forEach>
		<a class="prev" onclick="plusSlides(-1)">&#10094;</a>
    	<a class="next" onclick="plusSlides(1)">&#10095;</a>
	</div>

	<p class="ct">体温：37.0℃</p>

	<hr />

	<div class="TimeRecord">
		<hr>
		<p class="ct">記録</p>
		<hr>
		<!--c:forEachで取得したデータを繰り返し表示-->
		<c:forEach var="e" items="${list}">
			<h3  class="RecordData">${e.timeFormat} &emsp; ${e.work} &emsp; ${e.milk_quantity} &emsp; ${e.comment}</h3 >
			<hr>
		</c:forEach>

		<p class="ct">コメント欄</p>
		<hr>
		<c:forEach var="c" items="${comments}">
			<h3 class="RecordData">${c.comment}</h3>
			<hr>
		</c:forEach>
	</div>
	<div class="ct">
	<form action="/C5/RecordServlet" method="post">
		<textarea name="RecordComment" class="RecordComment"
			placeholder="コメントを入力してください"></textarea>
		<br> <input type="submit" name="koment" value="コメントする"
			class="button">
	</form>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	</div>
	<footer>
		<table class="ct mg">
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
	<script>
		let slideIndex = 1;
		showSlides(slideIndex);

		// 前後のスライドを切り替える関数
		function plusSlides(n) {
	  		showSlides(slideIndex += n);
		}

		// 現在のスライドを表示する関数
		function showSlides(n) {
	  		let slides = document.getElementsByClassName("slide");

	  		// 最後のスライドの場合、最初のスライドに戻る
	  		if (n > slides.length) { slideIndex = 1 }
	  		// 最初のスライドの場合、最後のスライドに戻る
	  		if (n < 1) { slideIndex = slides.length }

	  		// すべてのスライドを非表示にする
	  		for (let i = 0; i < slides.length; i++) {
	      		slides[i].style.display = "none";
	  		}

	  		// 指定されたスライドを表示する
	  		slides[slideIndex - 1].style.display = "block";
		}

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