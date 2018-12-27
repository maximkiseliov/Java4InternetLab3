package main;
import models.Answer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/res")
public class ResServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DBConnector database = new DBConnector();

		try {
			database.connect();
			database.load();
			ArrayList<Answer> answers = database.getAnswers();
			int accumPoints = 0;
			int accumPointsQuestionFive = 0;
			String message;
			String username = request.getParameter("username");
	        
	        for (int i=1; i<7; i++){
	        	if (i == 1){
    				String userAnswer = request.getParameter("question" + i);
	        		for (Answer answer : answers){
	        			if (answer.getQuestionNumb() == i && answer.checkCorrect().equals("Y") && (answer.getAnswerVariant().equals(userAnswer))){
	        					accumPoints++;
	        			}
	        		}
	        	}
	        	
	        	if (i == 2){
	        		String userAnswer = request.getParameter("question" + i);
	        		for (Answer answer : answers){
	        			if (answer.getQuestionNumb() == i && answer.getAnswerVariant().equals(userAnswer)){
	        					accumPoints++;
	        			}
	        		}
	        	}
	        	
	        	if (i == 3){
	        		String userAnswer = request.getParameter("question" + i);
	        		for (Answer answer : answers){
	        			if (answer.getQuestionNumb() == i && answer.checkCorrect().equals("Y") && answer.getAnswerVariant().equals(userAnswer)){
	        				accumPoints++;			
	        			}
	        		}
	        	}
	        	
	        	if (i == 4){
    				String userAnswer = request.getParameter("question" + i);
	        		for (Answer answer : answers){
	        			if (answer.getQuestionNumb() == i && answer.getAnswerVariant().equals(userAnswer)){
	        				accumPoints++;			
	        			}
	        		}
	        	}
	        	
	        	if (i == 5){
	        		String[] checkedValues = request.getParameterValues("question" + i);
	        		ArrayList<String> correctValues = new ArrayList<String>();
	        		
	        		for (Answer answer : answers){
	        			if (answer.getQuestionNumb() == i && answer.checkCorrect().equals("Y")){
	        				correctValues.add(answer.getAnswerVariant());
	        			}
	        		}
	        		
	        		for (String checkedValue:checkedValues){
	        			if (correctValues.contains(checkedValue)){
	        				accumPointsQuestionFive++;
	        			}
	        			else{
	        				accumPointsQuestionFive--;
	        			}
	        		}
	        		
	        		if (accumPointsQuestionFive == 3){
	        			accumPoints++;
	        		};
	        	}
	        	
	        	if (i == 6){
	        		String userAnswer = request.getParameter("question" + i);
	        		for (Answer answer : answers){
	        			if (answer.getQuestionNumb() == i && answer.checkCorrect().equals("Y") && answer.getAnswerVariant().equals(userAnswer)){
	        				accumPoints++;			
	        			}
	        		}
	        	}
	        	
	        }
	        
	        if (accumPoints == 6){
	        	message = "Well done! Looks like you are the real Boston Celtics Fan!";
	        }
	        else if (accumPoints == 4 || accumPoints == 5){
	        	message = "Almost there! Little push to prove that you are the real Boston Celtics Fan!";
	        }
	        
	        else if (accumPoints == 2 || accumPoints == 3){
	        	message = "Hmm... That's not enough to prove that you are the real Boston Celtincs Fan. Gain knowledge and come back!";
	        }
	        
	        else {
	        	message = "Most likely it was an accident and you do not know what you are doing here.";
	        }
	        
	        request.setAttribute("username", username);
            request.setAttribute("message", message);
            request.setAttribute("accumpoints", accumPoints);
            
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/quiz_results.jsp");
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