<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ja" class="RecordBody">

<head>
<script
	src="https://cdn.rawgit.com/davidshimjs/qrcodejs/gh-pages/qrcode.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/qrcode-generator/qrcode.js"></script>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="/C5/CSS/home.css">
<title>ホーム</title>
</head>

<body>
	<div class="Content">
		<header class="header">
			<div class="headerBox">
				<div class="headerItem1">
					<form method="get" action="/C5/LogoutServlet">
						<input class="logoutButton" type="submit" value="ログアウト">
					</form>
				</div>
				<div class="headerItem2">
					<h3 class="AppLogo">IKUMI</h3>
				</div>
			</div>
		</header>

		<c:choose>
			<c:when test="${sum <= 20 or sum == null}">
				<p>
					<img src="/C5/images/icons/a_1920.png" width="70px" height="90px"
						id="ml">
				</p>
			</c:when>
			<c:when test="${sum <= 40}">
				<p>
					<img src="/C5/images/icons/c_1920.png" width="70px" height="90px">
				</p>
			</c:when>
			<c:when test="${sum <= 60}">
				<p>
					<img src="/C5/images/icons/d_1920.png" width="70px" height="90px">
				</p>
			</c:when>
			<c:when test="${sum <= 80}">
				<p>
					<img src="/C5/images/icons/b_1920.png" width="70px" height="90px">
				</p>
			</c:when>
			<c:when test="${sum <= 99}">
				<p>
					<img src="/C5/images/icons/e_1920.png" width="70px" height="90px">
				</p>
			</c:when>
			<c:otherwise>
				<p>
					<img src="/C5/images/icons/f_1920.png" width="70px" height="90px"
						id="ml">
				</p>
			</c:otherwise>
		</c:choose>


		<div class="Content">
			<!-- ↓今日の日付-->
			<div class="hidukeBox">
				<div class="hidukeItem1">
					<form id=hiduke></form>
					<a id="hiduke">生年月日:${child_birthday}</a>
				</div>
				<p></p>
				<form id="birthdateForm"></form>
				<label for="birthdate"></label>
			</div>
			<%-- <input type="date" id="birthdate"
				name="birthdate" value="${child_birthday}"> --%>

			<!--↓生年月日を表示する-->
			<p id="result"></p>

			<img src="/C5/images/IKUMI.png" class="homeIkumi"> <br>
			<button id="click-btn">体温を測る</button>
			<div id="popup-wrapper">
				<div id="popup-inside">
					<div id="close">x</div>
					<div id="message">
						<p>体温検査</p>
						<form action="/C5/RecordServlet" method="post">
							<table>
								<tr>
									<th><input type="date" name="date"></th>
								</tr>
								<tr>
									<th class="ct"><input type="text" name="temperature">℃</th>
								</tr>
								<tr>
									<th><input type="submit" value="記録する" name="taion"
										class="button"></th>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
			<h2>記録する</h2>
			<table align="center">
				<tr>
					<td><img src="/C5/images/icons/poop.png" class="RecordIcon"
						alt="排泄"></td>
					<td><img src="/C5/images/icons/sleep.png" class="RecordIcon"
						alt="睡眠"></td>
					<td><img src="/C5/images/icons/milk.png" class="RecordIcon"
						alt="ごはん"></td>
					<td><img src="/C5/images/icons/photos.png" class="RecordIcon"
						alt="写真"></td>
				</tr>

				<tr>
					<td><button id="click-btn1">排泄</button>
						<div id="popup-wrapper1">
							<div id="popup-inside1">
								<div id="close1">x</div>
								<div id="message1">
									<p>排泄記録</p>
									<form action="/C5/RecordServlet" method="post">
										<table align="center">
											<tr>
												<th>おしっこ<input type="checkbox"
													name="excretion_checkbox" value="pee"></th>
											</tr>
											<tr>
												<th>うんち<input type="checkbox" name="excretion_checkbox"
													value="poop"></th>
											</tr>
											<tr>
												<th>時間</th>
											</tr>
											<tr>
												<th><input type="time" name="excretion_time"></th>
											</tr>
											<tr>
												<th>備考</th>
											</tr>
											<tr>
												<th><textarea rows="10" cols="40"
														name="excretion_comment"></textarea></th>
											</tr>
											<tr>
												<th><input type="submit" value="記録する" name="haisetu"
													class="button"></th>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div></td>

					<td><button id="click-btn2">睡眠</button>
						<div id="popup-wrapper2">
							<div id="popup-inside2">
								<div id="close2">x</div>
								<div id="message2">
									<p>睡眠記録</p>
									<form action="/C5/RecordServlet" method="post">
										<table>
											<tr>
												<th>時間</th>
											</tr>
											<tr>
												<th><input type="time" name="sleep_time"></th>
											</tr>
											<tr>
												<th>備考</th>
											</tr>
											<tr>
												<th><textarea rows="10" cols="40" name="sleep_comment"></textarea></th>
											</tr>
											<tr>
												<th><input type="submit" value="記録する" name="suimin"
													class="button"></th>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div></td>

					<td><button id="click-btn3">ごはん</button>
						<div id="popup-wrapper3">
							<div id="popup-inside3">
								<div id="close3">x</div>
								<div id="message3">
									<p>ごはん記録</p>
									<form action="/C5/RecordServlet" method="post">
										<table>
											<tr>
												<th>ミルク<input type="checkbox" name="meal_checkbox"
													value="milk"></th>
											</tr>
											<tr>
												<th>離乳食<input type="checkbox" name="meal_checkbox"
													value="milk_quantity"></th>
											</tr>
											<tr>
												<th>時間</th>
											</tr>
											<tr>
												<th><input type="time" name="meal_time"></th>
											</tr>
											<tr>
												<th>ミルク量<input type="text" name="milk_quantity">ml
												</th>
											</tr>
											<tr>
												<th>備考</th>
											</tr>
											<tr>
												<th><textarea rows="10" cols="40" name="meal_comment"></textarea></th>
											</tr>
											<tr>
												<th><input type="submit" value="記録する" name="gohan"
													class="button"></th>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div></td>

					<td><button id="click-btn4">写真</button>
						<div id="popup-wrapper4">
							<div id="popup-inside4">
								<div id="close4">x</div>
								<div id="message4">
									<p>写真の追加</p>
									<form action="/C5/RecordServlet" method="post"
										enctype="multipart/form-data">
										<table>
											<tr>
												<th class="ct"><input type="file" name="img" id="files"
													multiple></th>
											</tr>
											<tr>
												<th><input type="submit" value="保存する" name="syasin"
													class="button"></th>
											</tr>
										</table>
									</form>
								</div>
							</div>
						</div></td>
				</tr>
			</table>



			<button id="click-btn5">${child_name}の記録をシェアしよう</button>
			<br>
			<div id="popup-wrapper5">
				<div id="popup-inside5">
					<div id="close5">x</div>
					<button id="generate">共有QRコードを作成</button>
					<div id="qrcode" class="ct"></div>
				</div>
			</div>
			<br> <br> <br> <br>
			<!--ポップアップダイアログ
                <div id="popup" class="modal">
                    <div class="modal-content">
                        <span class="close">&times;</span>
                             <p>テキストを入力してください:</p>
                                <label class="toggle-swich"></label>
                                <input type="checkbox" id="toggle-swich">
                                <span class="toggle-slibe"></span></label>
                                <input type="text" id="userInput" placeholder="ここに入力">
                                <button id="submitBtn">登録</button>
=======
                <!--ポップアップダイアログ-->
			<!-- 		<div id="popup" class="modal" style="display: none;">
			<div class="modal-content">
				<span class="close">&times;</span>
				<p>テキストを入力してください:</p>
				<input type="text" id="userInput" placeholder="ここに入力">
				<button id="submitBtn">登録</button>
				トグルスイッチ
				<label class="toggle-switch"> <input type="checkbox"
					id="toggleSwitch"> <span class="toggle-slider round"></span></label>
			</div>
		</div> -->
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
			<script>
        //体温ポップアップ
        const clickBtn = document.getElementById('click-btn');
        const popupWrapper = document.getElementById('popup-wrapper');
        const close = document.getElementById('close');

        // ボタンをクリックしたときにポップアップを表示させる
        clickBtn.addEventListener('click', () => {
            popupWrapper.style.display = "block";
        });

        // ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
        popupWrapper.addEventListener('click', e => {
            if (e.target.id === popupWrapper.id || e.target.id === close.id) {
                popupWrapper.style.display = 'none';
            }
        });


        //排泄ポップアップ
        const clickBtn1 = document.getElementById('click-btn1');
        const popupWrapper1 = document.getElementById('popup-wrapper1');
        const close1 = document.getElementById('close1');

        // ボタンをクリックしたときにポップアップを表示させる
        clickBtn1.addEventListener('click', () => {
            popupWrapper1.style.display = "block";
        });

        // ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
        popupWrapper1.addEventListener('click', e => {
            if (e.target.id === popupWrapper1.id || e.target.id === close1.id) {
                popupWrapper1.style.display = 'none';
            }
        });

        //睡眠ポップアップ
        const clickBtn2 = document.getElementById('click-btn2');
        const popupWrapper2 = document.getElementById('popup-wrapper2');
        const close2 = document.getElementById('close2');

        // ボタンをクリックしたときにポップアップを表示させる
        clickBtn2.addEventListener('click', () => {
            popupWrapper2.style.display = "block";
        });

        // ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
        popupWrapper2.addEventListener('click', e => {
            if (e.target.id === popupWrapper2.id || e.target.id === close2.id) {
                popupWrapper2.style.display = 'none';
            }
        });

        //ごはんポップアップ
        const clickBtn3 = document.getElementById('click-btn3');
        const popupWrapper3 = document.getElementById('popup-wrapper3');
        const close3 = document.getElementById('close3');

        // ボタンをクリックしたときにポップアップを表示させる
        clickBtn3.addEventListener('click', () => {
            popupWrapper3.style.display = "block";
        });

        // ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
        popupWrapper3.addEventListener('click', e => {
            if (e.target.id === popupWrapper3.id || e.target.id === close3.id) {
                popupWrapper3.style.display = 'none';
            }
        });

        //写真ポップアップ
        const clickBtn4 = document.getElementById('click-btn4');
        const popupWrapper4 = document.getElementById('popup-wrapper4');
        const close4 = document.getElementById('close4');

        // ボタンをクリックしたときにポップアップを表示させる
        clickBtn4.addEventListener('click', () => {
            popupWrapper4.style.display = "block";
        });

        // ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
        popupWrapper4.addEventListener('click', e => {
            if (e.target.id === popupWrapper4.id || e.target.id === close4.id) {
                popupWrapper4.style.display = 'none';
            }
        });

        //パートナーにシェアQRコード

    	 const clickBtn5 = document.getElementById('click-btn5');
         const popupWrapper5 = document.getElementById('popup-wrapper5');
         const close5 = document.getElementById('close5');

         // ボタンをクリックしたときにポップアップを表示させる
         clickBtn5.addEventListener('click', () => {
             popupWrapper5.style.display = "block";
         });


         	document.addEventListener('DOMContentLoaded', function() {
     			var generateButton = document.getElementById('generate');

     			generateButton.addEventListener('click', function() {
     				var url = "http://localhost:8080/C5/LoginServlet";

     				var qrcode = new QRCode(document.getElementById('qrcode'), {
     	            	text: url,

     	            	width: 100,
     	            	height: 100
     	       	 	});


    			 });
 			});




         // ポップアップの外側又は「x」のマークをクリックしたときポップアップを閉じる
         popupWrapper5.addEventListener('click', e => {
             if (e.target.id === popupWrapper5.id || e.target.id === close5.id) {
                 popupWrapper5.style.display = 'none';
             }
         });

        //カレンダー
        document.addEventListener('DOMContentLoaded',function(){
            const birthdateInput = document.getElementById('birthdate');
            birthdateInput.addEventListener('input',calculateAge);
        });
        function calculateAge(){
            //生年月日入力フィールドを取得
            const birthdateInput = document.getElementById('birthdate').value;
            //生年月日が未入力の場合、エラーメッセージが表示して処理終了
            if (!birthdateInput){
                document.getElementById('result').textContent = "生年月日を入力してください。";
                    return;
            }
            //生年月日をDateオブジェクトに変換
            const birthdate = new Date(birthdateInput);
            const today = new Date();
            //年齢の計算
            let years = today.getFullYear() - birthdate.getFullYear();
            let months = today.getMonth() - birthdate.getMonth();
            let days = today.getDate() - birthdate.getDate();
            //日数がマイナスの場合、月数を補正
            if (days < 0 ){
                months -= 1;
                const previousMonth = new Date(today.getFullYear(),today.getMonth(),0);
                days += previousMonth.getDate();
            }
            //月数がマイナスの場合、年数を補正
            if (months < 0){
                years -= 1;
                months += 12;
            }
            //結果を表示
            let result = `生後`;
            if (years > 0) {
                result += `${years}年`;
            }
            if (months > 0 || years > 0) {
                result += `${months}ヵ月`;
            }
            result += `${days}日です`;
                document.getElementById('result').textContent = result;
        }

        //曜日を配列として定義
		const daysOFWeek = ["日","月","火","水","木","金","土",]

        //今日の日付を取得
        const today = new Date();

        //年、月、日、曜日を取得
        const year = today.getFullYear();
        const month = today.getMonth()+1;
        const date = today.getDate();
        const day = daysOFWeek[today.getDay()];

        //日付（曜日）を文字列として整形
       	document.getElementById("hiduke").textContent ="日付:" + month + "月" + date + "日" + "("+ day +")";
        </script>
		</div>
</body>
</html>