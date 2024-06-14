package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/testStart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		String ID = request.getParameter("ID");
		String qize = request.getParameter("qize");
		String choice_1 = request.getParameter("choice_1");
		String choice_2 = request.getParameter("choice_2");
		String choice_3 = request.getParameter("choice_3");
		String choice_4 = request.getParameter("choice_4");
		String correct = request.getParameter("correct");
		String score = request.getParameter("score");

<<<<<<< HEAD
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
		dispatcher.forward(request, response);
=======
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//		// リクエストパラメータを取得する
//		request.setCharacterEncoding("UTF-8");
//		String id = request.getParameter("id");
//		String pw = request.getParameter("pw");
//
//
////		セッションスコープにIDを格納する
//				HttpSession session = request.getSession();
//				session.setAttribute("id", new LoginUser(id));

		//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/test.jsp");
				dispatcher.forward(request, response);


>>>>>>> 878316429725137be2049f13669b88259d827419
	}

}
