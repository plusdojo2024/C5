<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <!--<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>-->
<!DOCTYPE html>
<html lang="ja">
<div class="content">

    <head>
        <meta charset="UTF-8">
        <title>サンプル</title>
        <link rel="stylesheet" href="consulChannels.css">
    </head>

    <body>

        <header>
            <h3>ひろしninaru</h3>
        </header>
        <input type="button" name="cloth" value="衣について">
        <br>
        <textarea class="ta"></textarea> <br>
        <input type="submit" value="コメント"><br>
        <textarea class="ta"></textarea> <br>
        <textarea class="ta"></textarea> <br>
        <textarea class="ta"></textarea> <br>


        <!--<input type ="submit" id="" value="衣について"></input>
        <input type ="submit" id="" value="食について"></input>
        <input type ="submit" id="" value="住について"></input>
        <input type ="submit" id="" value="その他"></input><br>-->
        <!--ポップアップダイアログ
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
            </div>-->
        <!-- <input type="submit" id="open" value="相談する"> -->

        <footer>
            <textarea class="ta1" id="myTextareaChange"></textarea><br>
            <ul id="nav">
                <li><a href="Home.html">ホーム</a></li>
                <li><a href="record.html">記録書</a></li>
                <li><a href="ConsulTop.html">相談所</a></li>
                <li><a href="HandBook.html">Handbook</a></li>
            </ul>
        </footer>
    </body>
    </biv>
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