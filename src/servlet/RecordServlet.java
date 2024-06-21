package servlet;

import java.io.IOException;
import java.util.List;
<<<<<<< HEAD
=======
import java.util.stream.Collectors;
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.RecordsDAO;
import model.RecordTime;
import model.Record_excretions;
import model.Record_meals;
import model.Record_sleeps;
import model.Records;
import model.UploadFile;

import dao.RecordsDAO;
import model.RecordTime;
/**
 * Servlet implementation class RecordServlet
 */
@WebServlet("/RecordServlet")
@MultipartConfig

public class RecordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//データを取得する
		//RecordsDAO dao = new RecordsDAO();
		//List<RecordTime> cardList = dao.select(new RecordTime());
		//リクエストスコープに格納
		//request.setAttribute("cardList", cardList);
		//リクエストから日付を取得
		String userInputDate = request.getParameter("date");
		//DAOに日付を渡すための処理
		//RecordTime input = new RecordTime();
		//Date.valueOf(sample_date)
		//input.setSampleDate(java.sql.Date.valueOf(userInputDate));
		RecordsDAO dao = new RecordsDAO();
		List<RecordTime> list = dao.select(java.sql.Date.valueOf(userInputDate));
		//
		//		RecordTime time1 = list.get(0);
		//リクエストスコープに格納
		request.setAttribute("list", list);
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


		}else if(syasin != null) {

	    	String imgPath1=request.getPart("img").getSubmittedFileName();
	    	String imgPath2=request.getPart("img").getSubmittedFileName();
	    	String imgPath3=request.getPart("img").getSubmittedFileName();
	    	String imgPath4=request.getPart("img").getSubmittedFileName();
	    	String imgPath5=request.getPart("img").getSubmittedFileName();

	    	UploadFile upload = new UploadFile();

	    	upload.setUser_id(users_id);
	    	upload.setImgPath1(imgPath1);
	    	upload.setImgPath2(imgPath2);
	    	upload.setImgPath3(imgPath3);
	    	upload.setImgPath4(imgPath4);
	    	upload.setImgPath5(imgPath5);

	 		RecordsDAO uDao = new RecordsDAO();
	 		uDao.insert(upload);

	        List<Part> fileParts = request.getParts().stream()
	                .filter(part -> "img".equals(part.getName()) && part.getSize() > 0)
	                .collect(Collectors.toList());

	        	for (int i = 0; i < fileParts.size(); i++) {

	        		Part part = fileParts.get(i);
	        		String submittedFileName = getSubmittedFileName(part);
	        		String fileName = new String(submittedFileName.getBytes("UTF-8"), "UTF-8");
	        		String filePath = "/upload/" + fileName;

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
		}
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/home.jsp");
		dispatcher.forward(request, response);
	}

<<<<<<< HEAD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

=======

	    private String getSubmittedFileName(Part part) {

	    	for (String cd : part.getHeader("content-disposition").split(";")) {

	    		if (cd.trim().startsWith("filename")) {

	    			String fileName = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
	    			return fileName.substring(fileName.lastIndexOf('/') + 1).substring(fileName.lastIndexOf('\\') + 1);
	    		}
	    	}
	    return null;
	    }
>>>>>>> 096450f686fb3ac6feeb1c2e4ff4cb790c82599b


	//データを取得する
	RecordsDAO dao = new RecordsDAO();
	List<RecordTime> cardList = dao.select(new RecordTime());

	//リクエストスコープに格納
	request.setAttribute("cardList", cardList);

	//フォワード
	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Record/record.jsp");
	dispatcher.forward(request, response);
	}
}
