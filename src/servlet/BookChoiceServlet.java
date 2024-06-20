package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/BookChoiceServlet")
public class BookChoiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String button1 = request.getParameter("1");
		String button2 = request.getParameter("2");
		String button3 = request.getParameter("3");

        if ("衣".equals(button1)) {
            request.setAttribute("message", "衣");
        } else if("食".equals(button2)) {
            request.setAttribute("message", "食");
        }else if ("住".equals(button3)) {
            request.setAttribute("message", "住");
        }

        if ("衣".equals(button1)) {
            request.setAttribute("title1", "おむつの替え方");
            request.setAttribute("title2", "洗濯時の注意");
            request.setAttribute("title3", "外出時の持ち物");

        } else if("食".equals(button2)) {
            request.setAttribute("message", "食");
            request.setAttribute("message", "衣");
            request.setAttribute("message", "衣");

        }else if ("住".equals(button3)) {
            request.setAttribute("message", "住");
            request.setAttribute("message", "衣");
            request.setAttribute("message", "衣");
        }

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/bookChoice.jsp");
			dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/bookChoice.jsp");
				dispatcher.forward(request, response);
	}

}
