package main;
import models.Answer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/index")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public IndexServlet(){
		
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//ServletOutputStream out = response.getOutputStream();
		DBConnector database = new DBConnector();
		
	try {
		database.connect();
		database.load();
		ArrayList<Answer> answers = database.getAnswers();
		
		 // Сохранить данные в атрибут 'answers' в request.
		request.setAttribute("answers", answers);
		
        // Создать объект RequestDispatcher
        // чтобыForward (перенаправить) запрос к main_quiz_file.jsp
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/main_quiz_file.jsp");
		
		// Forward (перенаправить) запрос, чтобы отобразить данные на странице JSP.
		dispatcher.forward(request, response);

	} catch (SQLException e) {
		e.printStackTrace();
		response.sendError(500);
	} finally {
		database.disconnect();
	}
}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}
}