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
<<<<<<< HEAD
=======

import dao.ConsulsDAO;
import model.Consuls;
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b

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
		  // セッションスコープからユーザーID（user_id）を取得
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
        int users_id = (int) session.getAttribute("user_id");
        String inputText = request.getParameter("inputText");

 		//チャンネルID（channel_id）画面でどのボタンを押したかによってチャンネル番号を判断＆取得する。
        //衣→１、食→２、住→３，その他→４

		/*        int channel_id = 0; // 仮の初期化

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

		System.out.println("チャンネル名を取得");*/


<<<<<<< HEAD


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // セッションスコープからユーザーID（user_id）を取得
        HttpSession session = request.getSession();
        request.setCharacterEncoding("UTF-8");
<<<<<<< HEAD
        String user_id = (String) session.getAttribute("user_id");
=======
>>>>>>> eaf24b5303bca1ec7d0bd3d6a149b30b5ceb9c51
=======
        //投稿ID（post_id）投稿した質問につく番号。他の質問との区別を行う。
 		//データベースから生成する。自分でつける。
 		//consulsテーブルを検索して、投稿IDのMax値を検索して、その値に+1をする。
		/*       String touko = request.getParameter("touko");
		String koment = request.getParameter("koment");
		ConsulsDAO cDao = new ConsulsDAO();
		int maxPost_Id = cDao.getMaxPostId();
		if(touko != null) {
			int post_id = 1;
			request.setAttribute("post_id", post_id);
		}else if(koment != null){
			int post_id = maxPost_Id + 1;
			request.setAttribute("post_id", post_id);
		}*/




//        System.out.println("投稿ID（post_id）を取得");


 		//投稿NO（post_number）質問と返信を区別する。
 		//固定値1か2を設定する。１が質問、2が返信。

		/*        int post_number = 0;

		String question = request.getParameter("1");
		String reply = request.getParameter("2");

		if ("Question".equals(question)) {
			post_number = 1;
		} else if ("Reply".equals(reply)) {
			post_number = 2;
		}

		System.out.println("投稿NO（post_number）を取得");

		 		//投稿内容（post_content）
		 		String post_content = request.getParameter("inputText");*/

 		//DAOを経由して、データベースに格納する。
 		Consuls consuls = new Consuls();
 		consuls.setId(0);
 		consuls.setUser_id(users_id);
 		consuls.setPost_content(inputText);

 		ConsulsDAO consulsDao = new ConsulsDAO();
 		consulsDao.insertAndGetGeneratedPostId(consuls);

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
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b
<<<<<<< HEAD

        System.out.println("ユーザーID（user_id）を取得" + user_id);

=======
>>>>>>> eaf24b5303bca1ec7d0bd3d6a149b30b5ceb9c51

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
        String touko = request.getParameter("touko");
        String koment = request.getParameter("koment");
        ConsulsDAO cDao = new ConsulsDAO();
        int maxPost_Id = cDao.getMaxPostId();
        if(touko != null) {
        	int post_id = 1;
        	request.setAttribute("post_id", post_id);
        }else if(koment != null){
        	int post_id = maxPost_Id + 1;
        	request.setAttribute("post_id", post_id);
        }




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
}
