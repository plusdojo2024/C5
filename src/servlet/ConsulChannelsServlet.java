package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ConsulChannelsServlet")
public class ConsulChannelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Consul/consulChannels.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータからテキストを取得
     		request.setCharacterEncoding("UTF-8");
     		String inputText = request.getParameter("inputText");

    	// doPostメソッド内で登録処理の後に以下のようにセッションに情報を保存する
     		request.getSession().setAttribute("question",inputText);

      //フォワード
      		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Consul/consulChannels.jsp");
      		dispatcher.forward(request, response);

    }
}
