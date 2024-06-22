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

import dao.ConsulsDAO;
import model.Comments;
import model.Consul_comment;
import model.Consuls;


@WebServlet("/ConsulChannelsServlet")
public class ConsulChannelsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//フォワード
        request.setCharacterEncoding("UTF-8");

 		//チャンネルID（channel_id）画面でどのボタンを押したかによってチャンネル番号を判断＆取得する。
        //衣→１、食→２、住→３，その他→４

		int channel_id = Integer.parseInt(request.getParameter("channel_id"));
		request.setAttribute("channel_id", channel_id);
		// 検索処理を行う
		ConsulsDAO bDao = new ConsulsDAO();
		// ここを改造しました
		List<Consul_comment> cardList = bDao.select(channel_id);

		request.setAttribute("cardList",cardList);

      //フォワード
  		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Consul/consulChannels.jsp");
  		dispatcher.forward(request, response);

    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String touko = request.getParameter("touko");
		String koment = request.getParameter("koment");
		int channel_id = Integer.parseInt(request.getParameter("channel_id"));
		if(touko != null) {
			String consulText = request.getParameter("consulText");
			int users_id = (int) session.getAttribute("user_id");

			Consuls consul = new Consuls();
			consul.setId(0);
			consul.setUser_id(users_id);
			consul.setChannel_id(channel_id);
			consul.setConsul_content(consulText);

			ConsulsDAO conD = new ConsulsDAO();
			conD.insert1(consul);
		}else if(koment != null) {
			int consul_id = Integer.parseInt(request.getParameter("consul_id"));
			String commentText = request.getParameter("commentText");
			int users_id = (int) session.getAttribute("user_id");

			Comments comment = new Comments();
			comment.setId(0);
			comment.setUser_id(users_id);
			comment.setConsul_id(consul_id);
			comment.setComment_content(commentText);

			ConsulsDAO conD = new ConsulsDAO();
			conD.insert2(comment);
		}
		request.setAttribute("channel_id", channel_id);
		doGet(request, response);
	}

}
