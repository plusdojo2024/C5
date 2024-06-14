<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">

<div id="content">
  <head>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="../css/style.css">

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
      	<input type ="button" id="" value="体温を測る"></input>
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
            <td><input type ="button" id="" value="排泄"></input></td>
            <td><input type ="button" id="" value="睡眠"></input></td>
            <td><input type ="button" id="" value="ごはん"></input></td>
            <td><input type ="button" id="" value="写真"></input></td>
          </tr>

       </table>
       	<br>

       <input type ="button" id="shareQR" value="パートナーにシェア"></input>

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

                    </div>
                </div>-->

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
            /*document.addEventListener('DOMContentLoaded',(event)=> {
                const modal = document.getElementById("popup");
                    const btl1 = document.getElementById("openPopupBtn1");
                    const btl2 = document.getElementById("openPopupBtn2");

                    const span = document.getElementsByClassName("close")[0];
                    const submitBtn = document.getElementById("submitBtn");
                    const userInput = document.getElementById("userInput");
                    const toggleswich = document.getElementById("toggleSwich");

                function openModal() {
                    modal.style.display = "block";
                        setTimeout(()=>) {
                            modal.classList.add("open");
                        },10);
                    }
                    function closeModal(){
                        modal.classList.remove("open");
                            setTimeout(() => {
                                modal.style.display ="none";
                            },300);
                    }

                    btl1.onclick = function (){
                        openModal();
                    }
                    btl2.onclick = function (){
                        openModal();
                    }
                    submitBtn.onclick = function(){
                        alert("入力されたテキスト:"+ userInput.value);
                        closeModal();
                    }
                    toggleswich.onchange = function() {
                        if (toggleswich.checked){
                            console.log("ON");
                        } else {
                            console.log("OFF");
                        }
                    }
                    window.onclick = function(event) {
                        if (event.terget == modal){
                            closeModal();
                        }
                    }
                });*/


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