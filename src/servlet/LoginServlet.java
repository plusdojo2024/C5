package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsersDAO;
import model.Userpw;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//ログインページにフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータを取得する
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");

		// ログイン処理を行う。↓文字の型があっているかの確認
		UsersDAO iDao = new UsersDAO();
		System.out.println("ユーザー名: " + user_name + ", パスワード: " + password);

		if (iDao.isLoginOK(new Userpw(user_name, password))) {    // ログイン成功

		    // セッションスコープにIDを格納する
		    HttpSession session = request.getSession();
		    session.setAttribute("user_name", user_name);

		    // メニューサーブレットにリダイレクトする
		    response.sendRedirect("/C5/HomeServlet");
		} else {
		    // ログイン失敗時の処理
		    String errorMessage = "ユーザー名またはパスワードに間違いがあります。";
		    request.setAttribute("errorMessage", errorMessage);

		    // ログインページへフォワード
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		    dispatcher.forward(request, response);
		}
	}
}
