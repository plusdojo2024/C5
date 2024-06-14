<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/C5/CSS/style.css">

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


            <input type="submit" name="cloth" value="衣">
            <br>
            <input type="submit" name="meal" value="食">
            <br>
            <input type="submit" name="shelter" value="住">
            <br>

            </form>

            <form method="get" action="/C5/TestServlet">
            	<input type="submit" name="test" value="テスト">
			</form>

            <br>

      </div>

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
      </html>