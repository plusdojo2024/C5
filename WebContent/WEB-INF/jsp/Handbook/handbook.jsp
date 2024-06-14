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
      		<form method="get" action="/C5/BookChoiceServlet">


            <input type="button" name="cloth" value="衣">
            <br>
            <input type="button" name="meal" value="食">
            <br>
            <input type="button" name="shelter" value="住">
            <br>
            <br>
            <input type="button" name="test" value="テスト">

			</form>

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

      </body>
      </html>