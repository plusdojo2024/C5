<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html lang="ja" class="Content">

<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/C5/CSS/consulchannel.css">
<title>相談所${message}チャンネル</title>
</head>

<body>
	<header>
		<h3 class="h">IKUMI</h3>
	</header>

	<c:choose>
		<c:when test="${channel_id == 1 }">
			<h1 class="consul">衣類の相談所</h1>
		</c:when>
		<c:when test="${channel_id == 2 }">
			<h1 class="consul">食事の相談所</h1>
		</c:when>
		<c:when test="${channel_id == 3 }">
			<h1 class="consul">住居の相談所</h1>
		</c:when>
		<c:otherwise>
			<h1 class="consul">その他の相談所</h1>
		</c:otherwise>
	</c:choose>

	<c:set var="c" value="0"></c:set>

	<c:forEach var="e" items="${cardList}">
		<c:if test="${c != e.consul_id or e.consul_id == 0}">
			<c:set var="c" value="${e.consul_id }"></c:set>
			<h6>
				${e.consul_name}
				<fmt:formatDate value="${e.consul_time}" type="DATE"
					pattern="MM月dd日（E） kk時mm分" />
			</h6>
			<h3>${e.consul_content}</h3>
			<c:if test="${c != 0 }">
				<c:forEach var="a" items="${cardList}">
					<c:if test="${c == a.id}">
						<h6>
							${a.comment_name}
							<fmt:formatDate value="${a.comment_time}" type="DATE"
								pattern="MM月dd日（E） kk時mm分" />
						</h6>
						<p>${a.comment_content}</p>
					</c:if>
				</c:forEach>
			</c:if>
			<!-- 				<button id="click-btn5">コメント</button>
				<div id="popup-wrapper5">
					<div id="popup-inside5">
						<div id="close5">x</div>
						<div id="message5">
							<p>コメント欄</p> -->
			<form method="post" action="/C5/ConsulChannelsServlet">
				<table align="center">
					<tr>
						<th><input type="text" name="commentText"
							placeholder="コメント入力欄"></th>
					</tr>
					<tr>
						<th><input type="submit" name="koment" value="コメント送信"
							class="button"> <input type="hidden" name="channel_id"
							value="${channel_id }"> <input type="hidden"
							name="consul_id" value="${e.id}"></th>
					</tr>
				</table>
			</form>
			<!-- 						</div>
					</div>
				</div> -->
			<script>

			const clickBtn5 = document.getElementById('click-btn5');
        const popupWrapper5 = document.getElementById('popup-wrapper5');
        const close5 = document.getElementById('close5');

        // ボタンをクリックしたときにポップアップを表示させる
        clickBtn5.addEventListener('click', () => {
            popupWrapper5.style.display = "block";
        });

        // ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
        popupWrapper5.addEventListener('click', e => {
            if (e.target.id === popupWrapper5.id || e.target.id === close5.id) {
                popupWrapper5.style.display = 'none';
            }
        });

    </script>
			<hr>
		</c:if>
	</c:forEach>
	<hr>
	<form method="post" action="/C5/ConsulChannelsServlet">
		<input type=text name="consulText" placeholder="質問内容を入力してください。"><br>
		<input type="submit" name="touko" value="投稿送信" class="button"><br>
		<input type="hidden" name="channel_id" value="${channel_id}">
	</form>

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
	<!--ポップアップダイアログ-->
	<div id="popup" class="modal" style="display: none;">
		<div class="modal-content">
			<span class="close">&times;</span>
			<p>テキストを入力してください:</p>
			<label class="toggle-swich"></label> <input type="checkbox"
				id="toggle-swich"> <span class="toggle-slibe"></span></label> <input
				type="text" id="userInput" placeholder="ここに入力">
			<button id="submitBtn">登録</button>
		</div>
	</div>
	<!-- このボタンはなんのため？ <input type="submit" id="open" value="相談する">-->
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
						<input type="submit" class="button" value="ホーム"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/RecordServlet">
						<input type="submit" class="button" value="記録書"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/HandbookServlet">
						<input type="submit" class="button" value="ハンドブック"></input>
					</form>
				</td>
				<td>
					<form method="get" action="/C5/ConsulServlet">
						<input type="submit" class="button" value="相談所"></input>
					</form>
				</td>
			</tr>
		</table>
	</footer>
</body>
</html>