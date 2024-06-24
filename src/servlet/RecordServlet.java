package servlet;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.Record_commentsDAO;
import dao.RecordsDAO;
import model.RecordTime;
import model.Record_excretions;
import model.Record_meals;
import model.Record_sleeps;
import model.Records;
import model.UploadFile;
import model.record_comments;

/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/RecordServlet")
@MultipartConfig

public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userInputDate = request.getParameter("date");
		List<RecordTime> list = null;
		List<record_comments> comments = null;

		if (userInputDate != null) {
			HttpSession session = request.getSession();
			RecordsDAO dao = new RecordsDAO();
			list = dao.select(java.sql.Date.valueOf(userInputDate), (int) session.getAttribute("user_id"));
			Collections.sort(list, new Comparator<RecordTime>() {
				@Override
				public int compare(RecordTime o1, RecordTime o2) {
					return o1.getTime().compareTo(o2.getTime());
				}
			});
			Record_commentsDAO rcDao = new Record_commentsDAO();
			comments = rcDao.select(java.sql.Date.valueOf(userInputDate), (int) session.getAttribute("user_id"));
			Collections.sort(comments, new Comparator<record_comments>() {
				@Override
				public int compare(record_comments o1, record_comments o2) {
					return o1.getComment_timestamp().compareTo(o2.getComment_timestamp());
				}
			});
		}
		//リクエストスコープに格納
		request.setAttribute("list", list);
		request.setAttribute("comments", comments);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Record/record.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		int users_id = (int) session.getAttribute("user_id");
		//		int record_id = (int)session.getAttribute("id");
		String taion = request.getParameter("taion");
		String haisetu = request.getParameter("haisetu");
		String suimin = request.getParameter("suimin");
		String gohan = request.getParameter("gohan");
		String syasin = request.getParameter("syasin");
		String koment = request.getParameter("koment");

		if (taion != null) {
			//体温記録
			String date = request.getParameter("date");
			String temperature = request.getParameter("temperature");
			Records input = new Records();

			input.setId(0);
			input.setUser_id(users_id);
			input.setDate(java.sql.Date.valueOf(date));
			input.setTemperature(temperature);

			RecordsDAO rDao = new RecordsDAO();
			rDao.insert(input);

		} else if (haisetu != null) {
			//排泄記録
			String[] excretion_checkbox = request.getParameterValues("excretion_checkbox");
			String excretion_time = request.getParameter("excretion_time");
			String excretion_comment = request.getParameter("excretion_comment");

			Record_excretions input1 = new Record_excretions();
			input1.setExcretion_id(0);
			input1.setUser_id(users_id);
			input1.setExcretionCheckBox(excretion_checkbox);
			input1.setExcretion_time(java.sql.Time.valueOf(excretion_time + ":00"));
			input1.setExcretion_comment(excretion_comment);

			RecordsDAO rDao = new RecordsDAO();
			rDao.insert1(input1);

		} else if (gohan != null) {
			//食事記録
			String[] meal_checkbox = request.getParameterValues("meal_checkbox");
			String meal_time = request.getParameter("meal_time");
			String milk_quantity = request.getParameter("milk_quantity");
			String meal_comment = request.getParameter("meal_comment");

			Record_meals input2 = new Record_meals();
			input2.setMeal_id(0);
			input2.setUser_id(users_id);
			input2.setExcretionCheckBox(meal_checkbox);
			input2.setMeal_time(java.sql.Time.valueOf(meal_time + ":00"));
			input2.setMilk_quantity(milk_quantity);
			input2.setMeal_comment(meal_comment);

			RecordsDAO rDao = new RecordsDAO();
			rDao.insert2(input2);

		} else if (suimin != null) {
			//睡眠記録
			String sleep_time = request.getParameter("sleep_time");
			String sleep_comment = request.getParameter("sleep_comment");

			Record_sleeps input3 = new Record_sleeps();
			input3.setSleep_id(0);
			input3.setUser_id(users_id);
			input3.setSleep_time(java.sql.Time.valueOf(sleep_time + ":00"));
			input3.setSleep_comment(sleep_comment);
			RecordsDAO rDao = new RecordsDAO();
			rDao.insert3(input3);
		} else if (syasin != null) {

			request.setCharacterEncoding("UTF-8");

			Collection<Part> parts = request.getParts();
			Part[] images = parts.toArray(new Part[parts.size()]);

			//images = [ Part, Part, Part, Part, Part ];

			UploadFile upload = new UploadFile();
			if (images.length < 7) {

				upload.setId(0);
				upload.setUser_id(users_id);
				upload.setImgPath1(images[0].getSubmittedFileName());
				upload.setImgPath2(images[1].getSubmittedFileName());
				upload.setImgPath3(images[2].getSubmittedFileName());
				upload.setImgPath4(images[3].getSubmittedFileName());
				upload.setImgPath5(images[4].getSubmittedFileName());

			} else {
				// アップロード失敗時の処理
				String errorMessage = "画像は5枚までです。";
				request.setAttribute("errorMessage", errorMessage);
			}

			RecordsDAO uDao = new RecordsDAO();
			uDao.insert4(upload);

			List<Part> fileParts = request.getParts().stream()
					.filter(part -> "img".equals(part.getName()) && part.getSize() > 0)
					.collect(Collectors.toList());

			for (int i = 0; i < fileParts.size(); i++) {

				Part part = fileParts.get(i);
				String submittedFileName = getSubmittedFileName(part);
				String fileName = new String(submittedFileName.getBytes("UTF-8"), "UTF-8");
				String filePath = "/images/icons/" + fileName;

				// ここでファイルを保存する処理を追加
				part.write(getServletContext().getRealPath(filePath));

				// imgPath1 〜 imgPath5 の適切なフィールドにファイルパスを設定する
				switch (i) {
				case 0:
					upload.setImgPath1(filePath);
					break;
				case 1:
					upload.setImgPath2(filePath);
					break;
				case 2:
					upload.setImgPath3(filePath);
					break;
				case 3:
					upload.setImgPath4(filePath);
					break;
				case 4:
					upload.setImgPath5(filePath);
					break;
				default:
					break;
				}
			}
			request.setAttribute("upload", upload);
		} else if (koment != null) {
			//コメント
			String RecordComment = request.getParameter("RecordComment");

			record_comments input4 = new record_comments();
			input4.setComment_id(0);
			input4.setUser_id(users_id);
			input4.setComment(RecordComment);
			Record_commentsDAO rcDao = new Record_commentsDAO();
			rcDao.insert(input4);
			doGet(request, response);
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);

	}

	private String getSubmittedFileName(Part part) {

		for (String cd : part.getHeader("content-disposition").split(";")) {

			if (cd.trim().startsWith("filename")) {

				String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
				return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
			}
		}
		return null;
	}

}
