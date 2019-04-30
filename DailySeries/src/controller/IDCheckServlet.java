package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;


@WebServlet("/idCheck.do")
public class IDCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public IDCheckServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("IDCheck¼­ºí¸´ µµÂø~~~~~~~~~~~~~``");
		String userid = request.getParameter("userid");
		MemberDao Dao = MemberDao.getInstance();
		int result = Dao.confirmID(userid);
		
		request.setAttribute("userid", userid);
		request.setAttribute("result", result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/idcheck.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
