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
		HttpSession session1 = request.getSession();
		session1.setAttribute("i", i);

		// 検索処理を行う
		GamesDAO gDao = new GamesDAO();
		// ここを改造しました
		List<Games> gameList = gDao.selectAll();
		//初期値を設定
		Games game = gameList.get(0);

		//		セッションスコープに格納
		HttpSession session = request.getSession();
		session.setAttribute("game1", game);

		//gameList = [Game, Game, Game, Game, Game]
		HttpSession session2 = request.getSession();
		session2.setAttribute("gameList", gameList);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
		dispatcher.forward(request, response);

		//		//フォワード
		//				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/testStart.jsp");
		//				dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		String answer4 = request.getParameter("answer4");
		String answer5 = request.getParameter("answer5");

		//		回答をセッションスコープに格納する
		HttpSession session = request.getSession();
		session.setAttribute("answer1", answer1);
		session.setAttribute("answer2", answer2);
		session.setAttribute("answer3", answer3);
		session.setAttribute("answer4", answer4);
		session.setAttribute("answer5", answer5);

		if (answer1 == "あめりか") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/knowledge.jsp");
			dispatcher.forward(request, response);
		} else {
		//		セッションスコープからgameListを取り出す
		HttpSession session2 = request.getSession();
		List<Games> gameList = (List<Games>) session2.getAttribute("gameList");
		//		型 名前 = (型) session.getAttribute("属性名");

		//int i をセッションスコープから取り出す
		HttpSession session1 = request.getSession();
		int i = (int) session1.getAttribute("i");

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

		} else if (answer1 == "あめりか") {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/knowledge.jsp");
			dispatcher.forward(request, response);
		} else if (i == 4) {

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/testResult.jsp");
			dispatcher.forward(request, response);

		}
		//gameをセッションスコープに格納する→格納することでjspで利用可能になる
		//request.setAttribute("game", game);

		//		フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
		dispatcher.forward(request, response);
		//
	}
}
}
