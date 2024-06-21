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

import dao.GamesDAO;
import model.Games;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//		int i をセッションスコープに入れる
		int i = 0;
		HttpSession session = request.getSession();
		session.setAttribute("i", i);

		// 検索処理を行う
		GamesDAO gDao = new GamesDAO();
		// ここを改造しました
		List<Games> gameList = gDao.selectAll();

		//問１を定義する
		Games game1 = gameList.get(0);
		//セッションスコープに格納
		session.setAttribute("game1", game1);


		session.setAttribute("gameList", gameList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String answer = request.getParameter("answer");

		//int i をセッションスコープから取り出す
		HttpSession session = request.getSession();
		int i = (int) session.getAttribute("i");

		//		回答をセッションスコープに格納する
		if (i == 0) {
			session.setAttribute("answer1", answer);
		} else if (i == 1) {
			session.setAttribute("answer2", answer);
		} else if (i == 2) {
			session.setAttribute("answer3", answer);
		} else if (i == 3) {
			session.setAttribute("answer4", answer);
		} else if (i == 4) {
			session.setAttribute("answer5", answer);
		}

		//		セッションスコープからgameListを取り出す
		List<Games> gameList = (List<Games>) session.getAttribute("gameList");
		//		型 名前 = (型) session.getAttribute("属性名");


		if (i == 0) {
			i += 1;
			session.setAttribute("i", i);

			Games game = gameList.get(1);
			session.setAttribute("game2", game);

		} else if (i == 1) {
			i += 1;
			Games game = gameList.get(2);
			session.setAttribute("i", i);

			session.setAttribute("game3", game);

		} else if (i == 2) {
			i += 1;
			Games game = gameList.get(3);
			session.setAttribute("i", i);

			session.setAttribute("game4", game);

		} else if (i == 3) {
			i += 1;
			Games game = gameList.get(4);
			session.setAttribute("i", i);

			session.setAttribute("game5", game);

			//i==4は実質機能していない
		} else if (i == 4) {

			// パパの回答を取得
			String userAnswer1 = (String) session.getAttribute("answer1");
			String userAnswer2 = (String) session.getAttribute("answer2");
			String userAnswer3 = (String) session.getAttribute("answer3");
			String userAnswer4 = (String) session.getAttribute("answer4");
			String userAnswer5 = (String) session.getAttribute("answer5");

			// 正解を取得
			String correctAnswer1 = gameList.get(0).getCorrect();
			String correctAnswer2 = gameList.get(1).getCorrect();
			String correctAnswer3 = gameList.get(2).getCorrect();
			String correctAnswer4 = gameList.get(3).getCorrect();
			String correctAnswer5 = gameList.get(4).getCorrect();

			int sum =0;
			session.setAttribute("sum", sum);
			//問１の答え合わせ
			if (userAnswer1.equals(correctAnswer1)) {

				String Cheack1 = "◎";
				session.setAttribute("問1", Cheack1);
//				List<Games> gameList = (List<Games>) session.getAttribute("gameList");
				sum+=1;
				session.setAttribute("sum", sum);
			} else {
				String Cheack1 = "✖";
				session.setAttribute("問1", Cheack1);
			}

			//問２の答え合わせ
			if (userAnswer2.equals(correctAnswer2)) {

				String Cheack2 = "◎";
				session.setAttribute("問2", Cheack2);

				sum+=1;
				session.setAttribute("sum", sum);
			} else {
				String Cheack2 = "✖";
				session.setAttribute("問2", Cheack2);
			}

			//問３の答え合わせ
			if (userAnswer3.equals(correctAnswer3)) {

				String Cheack3 = "◎";
				session.setAttribute("問3", Cheack3);

				sum+=1;
				session.setAttribute("sum", sum);
			} else {
				String Cheack3 = "✖";
				session.setAttribute("問3", Cheack3);
			}

			//問４の答え合わせ
			if (userAnswer4.equals(correctAnswer4)) {

				String Cheack4 = "◎";
				session.setAttribute("問4", Cheack4);

				sum+=1;
				session.setAttribute("sum", sum);
			} else {
				String Cheack4 = "✖";
				session.setAttribute("問4", Cheack4);
			}

			//問５の答え合わせ
			if (userAnswer5.equals(correctAnswer5)) {

				String Cheack5 = "◎";
				session.setAttribute("問5", Cheack5);

				sum+=1;
				session.setAttribute("sum", sum);
			} else {
				String Cheack5 = "✖";
				session.setAttribute("問5", Cheack5);
			}

			if(sum == 5) {
				String Perfect = "全問正解！！！！！おめでとう～🎉";
				session.setAttribute("perfect", Perfect);
			}else if(sum==4) {
				String Perfect = "惜しい！！";
				session.setAttribute("perfect", Perfect);
			}else if(sum==0) {
				String Perfect = "え、１問も正解できなかったの、、";
				session.setAttribute("perfect", Perfect);
			}	else {
				String Perfect = "まだまだ勉強不足！間違えた箇所はハンドブックをチェックしよう";
				session.setAttribute("perfect", Perfect);
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/testResult.jsp");
			dispatcher.forward(request, response);

		}
		//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
		dispatcher.forward(request, response);

	}
}