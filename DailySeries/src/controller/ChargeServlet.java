package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

/**
 * Servlet implementation class ChargeServlet
 */
@WebServlet("/ChargeServlet")
public class ChargeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ChargeServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		System.out.println("========= chargeServlet doget µµÂø ===============");
		MemberDao dao = MemberDao.getInstance();
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("loginuser");
		dao.DeleteShoppingBag(userid);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/shoppingbag.jsp");
		  dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
