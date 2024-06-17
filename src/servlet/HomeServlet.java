package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import dao.ChildDAO;
import model.Childinfo;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	// リクエストパラメータを取得する
    	request.setCharacterEncoding("UTF-8");
    	HttpSession session = request.getSession();
        int userId = (int) session.getAttribute("id");

        try (Connection con = dataSource.getConnection()) {

        	ChildDAO childDAO = new ChildDAO(con);
            List<Childinfo> children = childDAO.getChildrenByUserId(userId);

            // 子供の情報をリクエストスコープにセットする
            request.setAttribute("children", children);

            // ホーム画面にフォワードする
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
            dispatcher.forward(request, response);

        } catch (SQLException e) {
            // 例外処理
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // フォームからのデータ処理をここに実装する


        // フォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
        dispatcher.forward(request, response);
    }

