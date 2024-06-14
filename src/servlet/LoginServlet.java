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
import model.Users;

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
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");

		// ログイン処理を行う。↓文字の型があっているかの確認
		UsersDAO iDao = new UsersDAO();
		if (iDao.isLoginOK(new Users(user_name, password))) {	// ログイン成功

			// セッションスコープにIDを格納する
			HttpSession session = request.getSession();
			session.setAttribute("id", new Users(id));

			// メニューサーブレットにリダイレクトする
			response.sendRedirect("/C5/HomeServlet");
		}
		else {
			// ログイン失敗したらJavaScriptで「user_nameまたはPWに間違いがあります。」と表示する。

			//スコープへ格納する情報
			  String message = "ユーザーネームまたはパスワードに間違いがあります。";

			  System.out.println("HttpServletRequestに"+ message + "を設定");

			//リクエストスコープへ格納
			  request.setAttribute("message", message);

			//ログインページへフォワード
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
			dispatcher.forward(request, response);
	}
}
