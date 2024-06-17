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


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/testStart.jsp");
				dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 検索処理を行う
		GamesDAO gDao = new GamesDAO();
		// ここを改造しました
		List<Games> gameList = gDao.selectAll();

	    HttpSession session = request.getSession();
	    session.setAttribute("gameList", gameList);


		// 検索結果をリクエストスコープに格納する
		/*request.setAttribute("gameList", gameList);*/

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
		dispatcher.forward(request, response);


}
}


//		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//
//
////		セッションスコープにIDを格納する
//				HttpSession session = request.getSession();
//				session.setAttribute("id", new LoginUser(id));

