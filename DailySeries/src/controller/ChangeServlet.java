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
import vo.MemberVo;

@WebServlet("/ChangeServlet")
public class ChangeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ChangeServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("========= ChangeServlet doget ���� ===============");
		 RequestDispatcher dispatcher = request.getRequestDispatcher("/Change.jsp");
		  dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 System.out.println("========= ChangeServlet dopost ���� ===============");
		 request.setCharacterEncoding("UTF-8");
		 HttpSession session = request.getSession();
		 
		 System.out.println(session.getAttribute("loginuser"));
		 
		 String newpassword = request.getParameter("newpassword");
		 String newaddr = request.getParameter("newaddr");
		 String newbirthyear = request.getParameter("newbirthyear");
		 
		 System.out.println("������ ��" + newpassword+newaddr+newbirthyear);
		 
		 MemberVo mVo = new MemberVo();
		 mVo.setUserid((String) session.getAttribute("loginuser"));
		 mVo.setPassword(newpassword);
		 mVo.setAddr(newaddr);
		 mVo.setBirthyear(newbirthyear);
		 MemberDao mDao = MemberDao.getInstance();
		 
		 int result = mDao.ChangeInfo(mVo);
		 if(result == 1) {
		      session.setAttribute("userid", mVo.getUserid());
		      request.setAttribute("changemessage", "ȸ�� ���� ���濡 ���� �߽��ϴ�.");
		      
		      RequestDispatcher dispatcher = request.getRequestDispatcher("/MypageServlet");
		        dispatcher.forward(request, response);
		     }else {
		      request.setAttribute("changemessage", "ȸ�� ���� ���濡 ���� �߽��ϴ�.");
		      RequestDispatcher dispatcher = request.getRequestDispatcher("/Change.jsp");
		        dispatcher.forward(request, response);
		     }
		    
		     
		        
		    }

		}