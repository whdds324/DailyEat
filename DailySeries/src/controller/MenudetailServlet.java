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

@WebServlet("/MenudetailServlet")
public class MenudetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MenudetailServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			request.setCharacterEncoding("utf-8"); 
			System.out.println("========= Menudetail doget µµÂø ===============");
			HttpSession session = request.getSession();
			String addr = request.getParameter("addr");
			if(addr !=null) {
				
				System.out.println(addr+"213213213123123");
				MemberDao mdao = MemberDao.getInstance();
				MenuVo vo = new MenuVo();
				List<MenuVo> menu= mdao.getRecommend(addr);
				
				request.setAttribute("menulist", menu);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Menu.jsp");
				dispatcher.forward(request, response);
			}
			
			
			else if(request.getParameter("code") != null) {
					doPost(request, response);
				}
				
				else {
					String type = request.getParameter("type");
					System.out.println(type);
					MemberDao mdao = MemberDao.getInstance();
					MenuVo Vo = new MenuVo();
		
					List<MenuVo> menu= mdao.getMenu(type);
						for(int cnt = 0;cnt<menu.size();cnt++) {
							System.out.println(menu.get(cnt).getType());
			
						}
	
					request.setAttribute("menulist", menu);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/Menu.jsp");
					dispatcher.forward(request, response);
				}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8"); 
		System.out.println("========= Menudetail dopost µµÂø ===============");
		 HttpSession session = request.getSession();
		 
		 String code = request.getParameter("code");
		 System.out.println(code);
		 	
		 MemberDao mdao = MemberDao.getInstance();
		 MenuVo Vo = new MenuVo();
		 
		 List<MenuVo> detail = mdao.getMenudetail(code);
		 
		 request.setAttribute("menudetail", detail);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Menudetail.jsp");
			dispatcher.forward(request, response);
	}

}
