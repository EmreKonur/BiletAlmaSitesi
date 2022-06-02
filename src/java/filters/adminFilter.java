package filters;

import entity.Users;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class adminFilter extends HttpFilter {
    
    @Override
    public void doFilter(ServletRequest sr, ServletResponse sr1, FilterChain fc) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) sr;
        HttpServletResponse response = (HttpServletResponse) sr1;
        
        String url = request.getRequestURI();
        
        HttpSession session = request.getSession();
        
        Users user = null;
        
        if (session != null) {
            user = (Users) session.getAttribute("users");
        }
        
        if (user == null) {
            if (url.contains("bus") || url.contains("plane")
                    || url.contains("Documents")
                    || url.contains("train") || url.contains("index")
                     || url.contains("traintravelroute") || url.contains("adminpage")
                    || url.contains("planetravelroute") || url.contains("bustravelroute")
                    || url.contains("busseats") || url.contains("planeseats")
                    || url.contains("trainseats")) {
                    
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
            
        } else {
            if (url.contains("users")) {
                response.sendRedirect(request.getContextPath() + "/");
            } else if (url.contains("logout")) {
                session.invalidate();
                response.sendRedirect(request.getContextPath() + "/login.xhtml");
            } else {
                fc.doFilter(sr, sr1);
            }
        }
    }
}
