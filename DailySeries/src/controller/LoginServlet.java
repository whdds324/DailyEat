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


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
    
    public LoginServlet() {
        super();
       
    }

 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  System.out.println("========= LoginServlet doget 도착 ===============");
  
  RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
  dispatcher.forward(request, response);
 }

 
 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
  System.out.println("========= LoginServlet dopost 도착 ===============");
  
  request.setCharacterEncoding("UTF-8");
  
  String userid = request.getParameter("userid");
  String password = request.getParameter("password");

  
    MemberDao mDao = MemberDao.getInstance();
  
   
  int result = mDao.userCheck(userid, password);
  
  
  if(result == 1) {
	MemberVo mVo = mDao.getInfo(userid);
		   String name = mVo.getName();
		   String addr = mVo.getAddr();
		   String birthyear = mVo.getBirthyear();
		   String signdate = mVo.getSigndate();
		   
   HttpSession session = request.getSession();
   
	   session.setAttribute("session",mVo);
	   session.setAttribute("loginuser",userid);
	   session.setAttribute("username",name);
	   session.setAttribute("password",password );
	   session.setAttribute("addr",addr);
	   session.setAttribute("birthyear",birthyear );
	   session.setAttribute("signdate",signdate );
	   
   request.setAttribute("message", "로그인에 성공 했습니다.");
   System.out.println(name);
   System.out.println("========= 로그인에 성공 했습니다. ===============");
   
      RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
       dispatcher.forward(request, response);
       
  }else if(result == 0 || result == -1) {
   request.setAttribute("message", "로그인에 실패했습니다.");
   System.out.println("========= 로그인에 실패 했습니다. ===============");
   
      RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
       dispatcher.forward(request, response);  
  }
  
 }
 

}