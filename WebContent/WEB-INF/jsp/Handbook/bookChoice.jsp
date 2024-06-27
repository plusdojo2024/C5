<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang class = "Content"="ja">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />

  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+JP:wght@100..900&display=swap" rel="stylesheet">
  <link rel="stylesheet" type="text/css" href="/C5/CSS/bookchoice.css">

  <title>ハンドブック</title>
</head>
<header style="text-align: center;">
    <h3 class="AppLogo">IKUMI</h3>
</header>

<body style="text-align: center;">
    <h1 class="book">Handbook</h1>

    <img src="/C5/images/meal.png" class="meal" width="300px" height="200px"> <br>

<!--データベースからとってくる-->

	<form method="post" action="/C5/BookChoiceServlet">
<input type="submit" value="ハンドブックへ" class="next">
    </form>

<form method="post" action="/C5/HandbookServlet">
<input type="submit" value="テストへ" class="test">
    </form>

<!--ここまでデータベースからとってくる-->


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
                	<input type ="submit" id="" value="ホーム" class="button"></input>
                	</form>
                </td>
                <td>
                	<form method="get" action="/C5/RecordServlet">
                	<input type ="submit" id="" value="記録書" class="button"></input>
                	</form>
                </td>
                <td>
                	<form method="get" action="/C5/HandbookServlet">
                	<input type ="submit" id="" value="ハンドブック" class="button"></input>
                	</form>
                </td>
                <td>
                	<form method="get" action="/C5/ConsulServlet">
                	<input type ="submit" id="" value="相談所" class="button"></input>
                	</form>
                </td>
            </tr>
        </table>
    </footer>
</div>
 </body>
      </html>