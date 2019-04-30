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
import vo.SayingVo;

@WebServlet("/MainServlet")
public class MainServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MainServelet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServelt µµÂø~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MainServlet dopost µµÂø");
		request.setCharacterEncoding("UTF-8");
		MemberDao mDao = MemberDao.getInstance();
		
		SayingVo sv = mDao.getSaying();
		
		HttpSession session = request.getSession();
		String kortxt = sv.getKortxt();
		String engtxt = sv.getEngtxt();
		String speaker = sv.getSpeaker();
		
		session.setAttribute("kortxt", kortxt);
		session.setAttribute("engtxt",engtxt);
		session.setAttribute("speaker",speaker);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Main.jsp");
        dispatcher.forward(request, response);
		
	}

}
