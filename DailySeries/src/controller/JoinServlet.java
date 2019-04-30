
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


@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;
       
   
    public JoinServlet() {
        super();
    }

 
 protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    
	 System.out.println( "===============JoinServlet doget 수행================");
	 
  RequestDispatcher dispatcher = request.getRequestDispatcher("/Join.jsp");
  dispatcher.forward(request, response);
 
 }

 
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
     request.setCharacterEncoding("UTF-8");
     
     String userid = request.getParameter("userid");
     String name = request.getParameter("name");
     String password = request.getParameter("password");
     String birthyear = request.getParameter("birthyear");
     String addr = request.getParameter("addr");
     
     System.out.println( userid + name  +password+ birthyear + addr);
     
     MemberVo mVo = new MemberVo();
     mVo.setUserid(userid);
     mVo.setName(name);
     mVo.setPassword(password);
     mVo.setBirthyear(birthyear);
     mVo.setAddr(addr);

     MemberDao mDao = MemberDao.getInstance();
     
     int result = mDao.insertMember(mVo);
     
     HttpSession session = request.getSession();
     
     if(result == 1) {
      session.setAttribute("userid", mVo.getUserid());
      request.setAttribute("message", "회원 가입에 성공 했습니다.");
     }else {
      request.setAttribute("message", "회원 가입에 실패 했습니다.");
     }
    
     RequestDispatcher dispatcher = request.getRequestDispatcher("/Join.jsp");
        dispatcher.forward(request, response);
        
    }

}