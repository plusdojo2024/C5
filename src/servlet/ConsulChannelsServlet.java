package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ConsulsDAO;
import model.Consuls;

@WebServlet("/ConsulChannelsServlet")
public class ConsulChannelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索処理を行う
				ConsulsDAO bDao = new ConsulsDAO();
				// ここを改造しました
				List<Consuls> cardList = bDao.select(new Consuls());

				// 検索結果をリクエストスコープに格納する
				request.setAttribute("cardList", cardList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Consul/consulChannels.jsp");
		dispatcher.forward(request, response);
	}




	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッションスコープからユーザーID（user_id）を取得
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        String user_id = (String) session.getAttribute("user_id");

        System.out.println("ユーザーID（user_id）を取得" + user_id);


 		//チャンネルID（channel_id）画面でどのボタンを押したかによってチャンネル番号を判断＆取得する。
        //衣→１、食→２、住→３，その他→４

        int channel_id = 0; // 仮の初期化

        String button1 = request.getParameter("1");
        String button2 = request.getParameter("2");
        String button3 = request.getParameter("3");
        String button4 = request.getParameter("4");

        if ("衣".equals(button1)) {
            channel_id = 1;
        } else if ("食".equals(button2)) {
            channel_id = 2;
        } else if ("住".equals(button3)) {
            channel_id = 3;
        } else if ("その他".equals(button4)) {
            channel_id = 4;
        }

        //チャンネル名の表示をこれで行う
        String channelName = "";

        if ("衣".equals(button1)) {
            request.setAttribute("channel_id", "衣");
        } else if("食".equals(button2)) {
            request.setAttribute("channel_id", "食");
        }else if ("住".equals(button3)) {
            request.setAttribute("channel_id", "住");
        }else if ("その他".equals(button4)) {
            request.setAttribute("channel_id", "その他");
        }

        request.setAttribute("channel_id", channelName);

        System.out.println("チャンネル名を取得");


        //投稿ID（post_id）投稿した質問につく番号。他の質問との区別を行う。
 		//データベースから生成する。自分でつける。
 		//consulsテーブルを検索して、投稿IDのMax値を検索して、その値に+1をする。

        ConsulsDAO cDao = new ConsulsDAO();
        int maxPost_Id = cDao.getMaxPostId();
        int post_id = maxPost_Id + 1;

        request.setAttribute("post_id", post_id);

        System.out.println("投稿ID（post_id）を取得");


 		//投稿NO（post_number）質問と返信を区別する。
 		//固定値1か2を設定する。１が質問、2が返信。

        int post_number = 0;

        String question = request.getParameter("1");
        String reply = request.getParameter("2");

        if ("Question".equals(question)) {
        	post_number = 1;
        } else if ("Reply".equals(reply)) {
        	post_number = 2;
        }

        System.out.println("投稿NO（post_number）を取得");

 		//投稿内容（post_content）
 		String post_content = request.getParameter("inputText");

 		//DAOを経由して、データベースに格納する。
 		Consuls consuls = new Consuls();
 		consuls.setId(0);
 		consuls.setPost_content(post_content);

 		ConsulsDAO consulsDao = new ConsulsDAO();
 		consulsDao.insertAndGetGeneratedPostId(consuls);

        // 投稿IDを生成してセットする
		/*        ConsulsDAO consulsDao = new ConsulsDAO();
		Consuls c = new Consuls();

		c.setUser_id(0);
		    	c.setChannel_id(0);
		    	c.setPost_id(0);
		    	c.setPost_number(0);
		    	c.setPost_content("");

		    	if (consulsDao.insertAndGetGeneratedPostId(c) == 1) {
		    		//if (cDao.insert(new Consuls(0,user_id,channel_id,0,0,post_content,0))) {// 登録成功時の処理
		    request.setAttribute("result", "投稿完了");
		} else {
		    // 登録失敗時の処理
		    request.setAttribute("result", "投稿に失敗しました");
		}*/

		 //---------ここからデータ表示に移る↓------------

		 //DAOを経由して、データベースの値を取得する。
		 // 投稿内容をリクエストに保存


      //フォワード
  		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Consul/consulChannels.jsp");
  		dispatcher.forward(request, response);

    }
}
