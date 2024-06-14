<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!doctype html>
    <html>
    <head>
    <meta charset="UTF-8">
    <title>ハンドブック</title>

    </head>
    <header style="text-align: center;">
        ひろしninaru
    </header>

    <body style="text-align: center;">

        <h1>ハンドブック</h1>

        <div>
            <img src="ハンドブックTOP画像.png" alt="">

            <p>ハンドブックを選ぶ↓</p>
      <!--  <form method="post" action="/simpleBC/LoginServlet"> -->


            <input type="button" name="cloth" value="衣">
            <br>
            <input type="button" name="meal" value="食">
            <br>
            <input type="button" name="shelter" value="住">
            <br>
            <br>
            <input type="button" name="test" value="テスト">



      </div>

          <footer>
        <table align="center">
            <tr>
                <td>
                	<form method="get" action="/C5/HomeServlet">
                    <img src="../images/icons/home.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
                <td>
                    <form method="get" action="/C5/RecordServlet">
                    <img src="../images/icons/record.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
                <td>
                    <form method="get" action="/C5/HandbookServlet">
                    <img src="../images/icons/handbook.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
                <td>
                    <form method="get" action="/C5/ConsulServlet">
                    <img src="../images/icons/consul.png" id="fixedBar" alt=""></a>
                    </form>
                </td>
            </tr>

            <tr>
                <td><input type ="submit" id="" value="ホーム"></input></td>
                <td><input type ="submit" id="" value="記録書"></input></td>
                <td><input type ="submit" id="" value="ハンドブック"></input></td>
                <td><input type ="submit" id="" value="相談所"></input></td>
            </tr>
        </table>
    </footer>

      </body>
      </html>