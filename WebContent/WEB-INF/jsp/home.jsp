<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<div id="content">
  <head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">

    <title>ホーム</title>
  </head>

	<body>
      <header>
        <h3 id="AppLogo">ひろしninaru</h3>
      </header>

      <form id="birthdateForm">
         <label for="birthdate">生年月日を選択してください:</label>
         <input type ="date" id="birthdate" name = "birthdate">
      </form>

      <!--↓生年月日を表示する-->
      <p id="result"></p>

      <img src="../images/Home-Hiroshi.png">

      <br>

      <form>
      	<input type ="submit" class="openPopupBtn" value="体温を測る"></input>
	  </form>

      <h2>記録する</h2>
      <table align="center">
         <tr>
           <td>
              <img src="../images/icons/poop.jpeg" id="recordIcon" alt="排泄">
           </td>
           <td>
              <img src="../images/icons/sleepingHima.png" id="recordIcon" alt="睡眠">
           </td>
           <td>
              <img src="../images/icons/milk.jpeg" id="recordIcon" alt="ごはん">
           </td>
           <td>
              <img src="../images/icons/photos.jpeg" id="recordIcon" alt="写真">
           </td>
          </tr>

          <tr>
            <td><input type ="submit" class="openPopupBtn" value="排泄"></input></td>
            <td><input type ="submit" class="openPopupBtn" value="睡眠"></input></td>
            <td><input type ="submit" class="openPopupBtn" value="ごはん"></input></td>
            <td><input type ="submit" class="openPopupBtn" value="写真"></input></td>
          </tr>

       </table>
       	<br>

       <input type ="submit" class="shareQR" value="パートナーにシェア"></input>

<<<<<<< HEAD


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
            <div id="popup" class="modal" style="display: none;">
            <div class="modal-content">
                <span class="close">&times;</span>
                <p>テキストを入力してください:</p>
                <input type="text" id="userInput" placeholder="ここに入力">
                <button id="submitBtn">登録</button>
                <!-- トグルスイッチ -->
                    <label class="toggle-switch">
                    <input type="checkbox" id="toggleSwitch">
                    <span class="toggle-slider round"></span></label>
>>>>>>> d22bbd540094533443c3e979f0e5af4b54edddf6


            </div>
    </div>

    <footer>
        <table align="center">
            <tr>
                <td>

                    <img src="../images/icons/home.png" id="fixedBar" alt="ホーム"></a>

                </td>
                <td>

                    <img src="../images/icons/record.png" id="fixedBar" alt="記録書"></a>

                </td>
                <td>

                    <img src="../images/icons/handbook.png" id="fixedBar" alt="ハンドブック"></a>

                </td>
                <td>

                    <img src="../images/icons/consul.png" id="fixedBar" alt="相談所"></a>

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
        <script>
      //ポップアップ、トグルスイッチ
        document.addEventListener('DOMContentLoaded',function (){
            //モーダル要素を取得
            const modal = document.getElementById("popup");

            //ポップアップ表示ボタンを取得
                const openPopupBtns = document.querySelectorAll(".openPopupBtn");

                //const btn2 = document.getElementById("openPopupBtn2");

                //閉じるボタン要素を取得
                const closeBtn = document.querySelector(".close");

                //OKボタン要素を取得
                const submitBtn = document.getElementById("submitBtn");

                //ユーザー入力フィールドを取得
                const userInput = document.getElementById("userInput");
                //const toggleSwich = document.getElementById("toggleSwich");

                //モーダルを開く関数
            function openModal() {
                modal.style.display = "block";
                    setTimeout(() =>  {

                        //微小な遅延を設けてクラスを追加
                        modal.classList.add("open");
                    }, 10 );
                }

                //モーダルを閉じる関数
                function closeModal(){
                    modal.classList.remove("open");
                        setTimeout(() => {

                            //アニメーションの時間に合わせる
                            modal.style.display ="none";
                        },300);
                }

                openPopupBtns.forEach(btn => {
                    btn.addEventListener('click',function(event) {
                        event.preventDefault();
                        openModal();
                    });
                });

                closeBtn.addEventListener('click',function() {
                    closeModal();
               });

                submitBtn.addEventListener ('click',function(){
                    alert("入力されたテキスト:"+ userInput.value);
                    closeModal();
                });

               /*window.addEventListener('click',function (event) {
                    if (event.target == modal) {
                        closeModal();
                    }
                });*/

               toggleSwich.addEventListener('chage', function() {
                    if (toggleSwich.cheaked) {
                        console.log("ON");
                    } else {
                        console.log('OFF');
                    }
                });
       });


            //カレンダー
            document.addEventListener('DOMContentLoaded',function(){
                const birthdateInput = document.getElementById('birthdate');

                birthdateInput.addEventListener('input',calculateAge);
            });

            function calculateAge(){
                const birthdateInput = document.getElementById('birthdate').value;
                if (!birthdateInput){
                    document.getElementById('result').textContent = "生年月日を入力してください。";
                        return;
                }
                const birthdate = new Date(birthdateInput);
                const today = new Date();

                let years = today.getFullYear() - birthdate.getFullYear();
                let months = today.getMonth() - birthdate.getMonth();
                let days = today.getDate() - birthdate.getDate();


                if (days < 0 ){
                    months -= 1;
                    const previousMonth = new Date(today.getFullYear(),today.getMonth(),0);
                    days += previousMonth.getDate();
                }

                if (months < 0){
                    years -= 1;
                    months += 12;
                }

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
        </script>

    </div>
</body>
</html>