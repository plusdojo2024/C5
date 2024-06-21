package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsersDAO;
import model.Users;

@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/sighUp.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//リクエストスコープからデータを取得する。
		request.setCharacterEncoding("UTF-8");
		String user_name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String child_name = request.getParameter("child_name");
		String child_birthday = request.getParameter("child_birthday");

		//DAOに渡すためのBcSampleオブジェクトの準備（初期化）
		Users input = new Users();
		input.setId(0);
		input.setUser_name(user_name);
		input.setPassword(password);
		input.setChild_name(child_name);
		input.setChild_birthday(java.sql.Date.valueOf(child_birthday));

		//DAOの準備
		UsersDAO uDao = new UsersDAO();
		//DAOにBcSampleのオブジェクトを渡して、bc_sampleテーブルへ追加する処理
		uDao.insert(input);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
		dispatcher.forward(request, response);
	}

}
