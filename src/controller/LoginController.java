package controller;

import dao.UserDao;
import vo.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/LoginController")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/jsp;charset=utf-8");


        String userVCode = request.getParameter("userCode");

        HttpSession session = request.getSession();
        String vCode = (String) session.getAttribute("vCode");

        String info = "";
        User user = null;

        if(!vCode.equalsIgnoreCase(userVCode)){
            info = "抱歉，您所输入的验证码错误！";
        }else{
            String userName = request.getParameter("userName");
            String password = request.getParameter("password");
            UserDao userDao = new UserDao();
            try {
                if(userDao.getUserByUserName(userName)==null){
                    info = "抱歉，您所输入的用户名不存在！";
                }else{
                    user = userDao.getUserByUserName(userName);
                    if(!user.getPassword().equals(password)){
                        info = "抱歉，您所输入的密码不正确！";
                    }else{

                        info = null;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        /**
         * 不可以在代码中间进行转发或者重定向
         */

        if(info != null){
            request.setAttribute("errorInfo",info);
            RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
            dispatcher.forward(request,response);
        }else{
            session.setAttribute("User",user);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
            requestDispatcher.forward(request,response);
        }
    }



/*if(!errorInfo.equals("")){
    request.setAttribute("errorInfo",errorInfo);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("error.jsp");
                requestDispatcher.forward(request,response);
                }else{  //允许登录
                //response.addHeader("Set-Cookie","cookie中的内容");
                Cookie cookieUserName = new Cookie("userName", user.getUserName());
                Cookie cookiePassword = new Cookie("password", user.getPassWord());
                if("on".equals(checkBox)) {  //是否勾选“一周免登陆”
                cookieUserName.setMaxAge(60 * 60 * 24 * 7);
                cookiePassword.setMaxAge(60 * 60 * 24 * 7);
                }
                else
                {  //会话结束就销毁
                cookieUserName.setMaxAge(0);
                cookiePassword.setMaxAge(0);
                }
                response.addCookie(cookieUserName);
                response.addCookie(cookiePassword);

                RequestDispatcher requestDispatcher = request.getRequestDispatcher("main.jsp");
                requestDispatcher.forward(request,response);
                }
                }
*/
}
