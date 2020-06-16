package mashroom.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mashroom.bean.Login;
@WebFilter("/Login/*")
public class LoginFilter implements Filter{
	public void init(FilterConfig fConfig) throws ServletException{
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Login account = (Login) session.getAttribute("account");
		System.out.println("firuta- ");
		System.out.println(account);if (account==null) {
			System.out.println("ko");
			((HttpServletResponse) response).sendRedirect("/MashRoomDB");
		}
		chain.doFilter(request, response);

		// TODO 自動生成されたメソッド・スタブ

	}

	public void destroy() {

	}


}
