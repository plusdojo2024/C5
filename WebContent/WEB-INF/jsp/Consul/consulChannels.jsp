<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja">
<<<<<<< HEAD

<div class="content">

<head>
  	<meta charset="UTF-8" />
  	<meta http-equiv="X-UA-Compatible" content="IE=edge" />
  	<meta name="viewport" content="width=device-width, initial-scale=1.0" />

  	<link rel="preconnect" href="https://fonts.googleapis.com">
  	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
  	<link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">

    <title>相談所${message}チャンネル</title>
</head>

	<body>

        <header>
            <h3>ひろしninaru</h3>
        </header>

        	<p>${post_content}</p>
        	<p>${result}</p>

        <br>
<c:forEach var="e" items="${cardList}">
				<form method="get" action="/simpleBC/ConsulChannelsServlet">


					<p>${e.post_content}</p>
					<br>


				</form>
				<hr>
			</div>

		</c:forEach>
        <form method=post action=/C5/ConsulChannelsServlet>
			<input type=text name="inputText" placeholder="質問内容を入力してください。"><br>

        	<input type="submit"  value="送信"><br>
        	<input type="hidden" name="channel_id" value="${channel_id}">

        </form>

        <form method="get" action="/C5/ConsulChannelsServlet">
            <input type="submit" name="1" value="衣">
            <br>
            <input type="submit" name="2" value="食">
            <br>
            <input type="submit" name="3" value="住">
            <br>
            <input type="submit" name="4" value="その他">
        </form>

    <!--ポップアップダイアログ-->

         <div id="popup" class="modal" style="display: none;">
         <div class="modal-content">
           <span class="close">&times;</span>
               <p>テキストを入力してください:</p>
                   <label class="toggle-swich"></label>
                       <input type="checkbox" id="toggle-swich">
                       <span class="toggle-slibe"></span></label>
                       <input type="text" id="userInput" placeholder="ここに入力">
                       <button id="submitBtn">登録</button>
                </div>
            </div>

       <!-- このボタンはなんのため？ <input type="submit" id="open" value="相談する">-->

    <footer>
        <table align="center">
            <tr>
                <td>

                    <img src="/C5/images/icons/home.png" class="FixedBar" alt="ホーム"></a>

                </td>
                <td>

                    <img src="/C5/images/icons/record.png" class="FixedBar" alt="記録書"></a>

                </td>
                <td>

                    <img src="/C5/images/icons/handbook.png" class="FixedBar" alt="ハンドブック"></a>

                </td>
                <td>

                    <img src="/C5/images/icons/consul.png" class="FixedBar" alt="相談所"></a>

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
</div>
    <script>
        /*document.addEventListener('DOMContentLoaded'),function() {
            const modal = document.getElementById("popup");
        }*/
        const myTextareaChange = document.getElementById("myTextareaChange");
        const resultChange = document.getElementById("resultChange");
        myTextareaChange.addEventListener("change", (e) => {
            resultChange.innerHTML = e.target.value;
        });
    </script>

=======

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
<title>相談所${message}チャンネル</title>
</head>

<body>
	<div class="content">
		<header>
			<h3>ひろしninaru</h3>
		</header>
		<p>${post_content}</p>
		<p>${result}</p>
		<br>
		<c:forEach var="e" items="${cardList}">
			<p>${e.post_content}</p>
			<button id="click-btn5">コメント</button>
			<div id="popup-wrapper5">
				<div id="popup-inside5">
					<div id="close5">x</div>
					<div id="message5">
						<p>コメント欄</p>
						<form method="get" action="/C5/ConsulChannelsServlet">
							<table align="center">
								<tr>
									<th><input type="text" name="inputText"></th>
								</tr>
								<tr>
									<th><input type="submit" name="toko" value="送信"></th>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
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
		</c:forEach>
		<hr>
		<form method="get" action="/C5/ConsulChannelsServlet">
			<input type=text name="inputText" placeholder="質問内容を入力してください。"><br>
			<input type="submit" name="touko" value="送信"><br> <input
				type="hidden" name="channel_id" value="${channel_id}">
		</form>
		<form method="get" action="/C5/ConsulChannelsServlet">
			<input type="submit" name="1" value="衣"> <br> <input
				type="submit" name="2" value="食"> <br> <input
				type="submit" name="3" value="住"> <br> <input
				type="submit" name="4" value="その他">
		</form>
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
	</div>
</body>
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b
</html>