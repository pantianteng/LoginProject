package controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import vo.User;

/**
 * Servlet implementation class ServletTest1
 */
@WebServlet(urlPatterns="/login.do")
public class ServletTest1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String vcode = request.getParameter("userCode");
		
		HttpSession session = request.getSession();
		String saveVcode = (String) session.getAttribute("vCode");
		String forwardPath = "";
		
		if(!vcode.equalsIgnoreCase(saveVcode)) {
			request.setAttribute("info","验证码不正确！" );
			forwardPath = "/error.jsp";
		}else {
			UserDao userDao = new UserDao();
			User user = null;
			try {
				user = userDao.getUserByUserName(userName);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(user == null) {
				request.setAttribute("info","您输入的用户名不存在！");
				forwardPath = "/error.jsp";
			}else {
				if(!user.getPassword().equals(password)) {
					request.setAttribute("info", "您输入的密码不正确！");
					forwardPath = "/error.jsp";
				}else {
					session.setAttribute("currentUser", user);
					forwardPath = "/main.jsp";
				}
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(forwardPath);
		rd.forward(request, response);
	}

}
