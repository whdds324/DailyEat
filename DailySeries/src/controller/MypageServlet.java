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


@WebServlet("/MypageServlet")
public class MypageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MypageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========= MypageServlet doget ���� ===============");
		  
		  RequestDispatcher dispatcher = request.getRequestDispatcher("/Mypage.jsp");
		  dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("========= MypageServlet dopost ���� ===============");
		request.setCharacterEncoding("UTF-8");
		MemberDao mDao = MemberDao.getInstance();
		HttpSession session = request.getSession();
		  MemberVo mVo = mDao.getInfo((String) session.getAttribute("loginuser"));
		   String name = mVo.getName();
		   String addr = mVo.getAddr();
		   String birthyear = mVo.getBirthyear();
		   String signdate = mVo.getSigndate();
		   String password = mVo.getPassword();
		   
		   session.setAttribute("loginuser",session.getAttribute("loginuser"));
		   session.setAttribute("username",name);
		   session.setAttribute("password",password);
		   session.setAttribute("addr",addr);
		   session.setAttribute("birthyear",birthyear );
		   session.setAttribute("signdate",signdate );
		   
		   RequestDispatcher dispatcher = request.getRequestDispatcher("/Mypage.jsp");
			  dispatcher.forward(request, response);
		  
		
	}

}
