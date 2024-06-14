<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ja">
    <head>
      <meta charset="UTF-8" />
      <meta http-equiv="X-UA-Compatible" content="IE=edge" />
      <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>育児記録書</title>
    
    <link rel="stylesheet" type="text/css" href="RecordStyle.css">
    
    </head>
    
    <body class="RecordBody">
      <header>
        
        <h3>ひろしninaru</h3>
    
      </header>
    
    <h2 class="title">育児記録書</h2>
    <h3 class="calendar">カレンダー</h3>
    
    <!--<a href="home.html"></a>-->
      <img src="ごはん中のしんのすけ.jpg" width="250" height="160">
     
    <div class="TimeRecord">
      <hr>
    
      <!--c:forEachで取得したデータを繰り返し表示-->
      <p class="RecordData">8:00 ミルク 50ml</p>
      <hr>
     
      <p class="RecordData">10:00 お昼寝</p>
      <hr>
      
      <p class="RecordData">12:00 ミルク 50ml</p>
      <hr>
    </div>
    
    <form>
      <textarea name="RecordComment" class="RecordComment" placeholder="コメントを入力してください"></textarea>
      <br>
      <button class="CommentButton">コメントする</button>
    </form>
    
    <br>
    
    <ul id="nav">
        <li><a href="">ホーム</a></li>
        <li><a href="">記録書</a></li>
        <li><a href="">相談所</a></li>
        <li><a href="">ハンドブック</a></li>
      </ul>
    
    </body>
    
    </html>