package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;
import vo.orderlistVo;


@WebServlet("/BagServlet")
public class BagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public BagServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		System.out.println("========= BagServlet doget µµÂø ===============");
		HttpSession session = request.getSession();
		String userid = (String)session.getAttribute("loginuser");
		
		String key = request.getParameter("key");
		
		 System.out.println(key);
		 
		 
		 MemberDao mdao = MemberDao.getInstance();
		
		 List<orderlistVo> orderlist = mdao.insertshoppingbag(key,userid);
		 String totalprice = mdao.GettotalPrice(userid);
		 request.setAttribute("orderlist", orderlist);
		 request.setAttribute("totalprice", totalprice);
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/shoppingbag.jsp");
		        dispatcher.forward(request, response);
		        
		    
	}
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		System.out.println("========= BagServlet dopost µµÂø ===============");
		
		
	}

}
