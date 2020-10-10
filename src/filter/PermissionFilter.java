package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "PermissionFilter")
public class PermissionFilter implements Filter {
    private  String notCheckPath;
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        String path = request.getServletPath();
        System.out.println("请求地址url-pattern:" + path);
        if (notCheckPath.indexOf(path) == -1) {
            HttpSession session = request.getSession();
            if (session.getAttribute("currentUser") == null) {
                request.setAttribute("info", "没有权限访问");
                request.getRequestDispatcher("/error.jsp").forward(request, resp);
            } else {
                chain.doFilter(req, resp);
            }
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        notCheckPath = config.getInitParameter("notCheckPath");
    }
}