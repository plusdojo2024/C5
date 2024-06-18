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
		request.setAttribute("game", game);

		//gameList = [Games, Games, Games, Games, Games]
		HttpSession session = request.getSession();
		session.setAttribute("gameList", gameList);

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
		String answer = request.getParameter("1");

		//		セッションスコープからgameListを取り出す
		HttpSession session = request.getSession();
		List<Games> gameList = (List<Games>) session.getAttribute("gameList");
		//		型 名前 = (型) session.getAttribute("属性名");

		//int i をセッションスコープから取り出す
		HttpSession session1 = request.getSession();
		int i = (int) session1.getAttribute("i");

		if (i == 0) {
			i += 1;
			session.setAttribute("i", i);

			Games game = gameList.get(1);
			request.setAttribute("game", game);

		} else if (i == 1) {
			i += 1;
			Games game = gameList.get(2);
			session.setAttribute("i", i);

			request.setAttribute("game", game);

		} else if (i == 2) {
			i += 1;
			Games game = gameList.get(3);
			session.setAttribute("i", i);

			request.setAttribute("game", game);

		} else if (i == 3) {
			i += 1;
			Games game = gameList.get(4);
			session.setAttribute("i", i);

			request.setAttribute("game", game);

		} else {

		}
		//gameをセッションスコープに格納する→格納することでjspで利用可能になる
		//request.setAttribute("game", game);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
		dispatcher.forward(request, response);

	}
}
