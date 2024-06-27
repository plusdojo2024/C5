<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja" class="a">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap"
	rel="stylesheet">

<link rel="stylesheet" type="text/css" href="/C5/CSS/consul.css">

<title>相談所</title>
</head>
<header class="header">
	<h3>IKUMI</h3>
</header>
<h1 class="soudan ct">相談所</h1>
<body>
	<div class="ct mg">
		<img src="/C5/images/IKUMI.png" width="200px" height="200px">
	</div>
	<nav class="Menu">
		<ul class="Menu-Group">
			<li class="Menu-Group-Item"><a class="Menu-Group-Item-Link"
				href="/C5/ConsulChannelsServlet?channel_id=1">衣類の相談所</a></li>
			<li class="Menu-Group-Item"><a class="Menu-Group-Item-Link"
				href="/C5/ConsulChannelsServlet?channel_id=2">食事の相談所</a></li>
			<li class="Menu-Group-Item"><a class="Menu-Group-Item-Link"
				href="/C5/ConsulChannelsServlet?channel_id=3">住居の相談所</a></li>
			<li class="Menu-Group-Item"><a class="Menu-Group-Item-Link"
				href="/C5/ConsulChannelsServlet?channel_id=4">その他相談所</a></li>
		</ul>
	</nav>
<br>
<br>

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
</body>
</html>