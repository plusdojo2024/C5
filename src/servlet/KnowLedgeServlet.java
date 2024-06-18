package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/KnowLedgeServlet")
public class KnowLedgeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		String button1 = request.getParameter("1");
		String button2 = request.getParameter("2");
		String button3 = request.getParameter("3");

        if ("衣".equals(button1)) {
            request.setAttribute("title1", "Cloth1");
            request.setAttribute("title1", "Cloth2");
            request.setAttribute("title1", "Cloth3");

        } else if("食".equals(button2)) {
            request.setAttribute("title2", "Meal1");
            request.setAttribute("title2", "Meal2");
            request.setAttribute("title2", "Meal3");

        }else if ("住".equals(button3)) {
        	request.setAttribute("title3", "Living1");
        	request.setAttribute("title3", "Living2");
            request.setAttribute("title3", "Living3");
        }

		//フォワード先の指定
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/bookChoice.jsp");
		//フォワードの実行
		dispatcher.forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//フォワード
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Handbook/bookChoice.jsp");
				dispatcher.forward(request, response);
	}

}
