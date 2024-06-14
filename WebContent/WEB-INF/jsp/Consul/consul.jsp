<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html lang="ja">
        <div class="content">
    <head>
        <meta charset="UTF-8">
        <title>サンプル</title>
        <link rel="stylesheet" href="Home.css">
    </head>
    <body>
        <h1>ひろしninaru</h1>
        <ul id="nav"></ul>
        <li><a href="/C5/ConsulChannelsServlet">衣</a></li>
        <li><a href="/C5/ConsulChannelsServlet">食</a></li>
        <li><a href="/C5/ConsulChannelsServlet">住</a></li>
        <li><a href="/C5/ConsulChannelsServlet">その他</a></li>
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
