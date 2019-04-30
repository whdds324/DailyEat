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
import vo.MenuVo;
import vo.orderlistVo;


@WebServlet("/deleteServlet")
public class deleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public deleteServlet() {
        super();
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");  
		System.out.println("========= deleteServlet doget 도착 ===============");
		
		 String orderid = request.getParameter("orderid");
			System.out.println(orderid);
			
			MemberDao dao = MemberDao.getInstance();
			int result = dao.DeleteOrderList(orderid);
			
			if(result == 1) {
				HttpSession session = request.getSession();
				String userid = (String)session.getAttribute("loginuser");
				
				List<orderlistVo> orderlist = dao.getorderlist(userid);
				
				 String totalprice = dao.GettotalPrice(userid);
				 request.setAttribute("totalprice", totalprice);
				 
				request.setAttribute("orderlist", orderlist);
				 RequestDispatcher dispatcher = request.getRequestDispatcher("/shoppingbag.jsp");
				  dispatcher.forward(request, response);
				  
				
			}
			
		
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========= deleteServlet dopost 도착 ==============="); 
		
		String userid = request.getParameter("userid");
		String password = request.getParameter("password");
		 
		 System.out.println(password);
		 
		 MemberDao dao = MemberDao.getInstance();
		 int result =dao.deletemember(userid, password);
		
		 if(result == 1) {
			 request.setAttribute("message", "회원 탈퇴에 성공 했습니다.");
			 HttpSession session = request.getSession();
			 session.invalidate();
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
		
			 dispatcher.forward(request, response);
		 }
		 else {
			 request.setAttribute("message", "아이디 비밀번호를 확인해주세요."); 
			 RequestDispatcher dispatcher = request.getRequestDispatcher("/delete.jsp");
			
			 dispatcher.forward(request, response);
		 }
		 
	}

}
