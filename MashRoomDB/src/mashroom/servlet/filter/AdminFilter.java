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
@WebFilter("/Login/admin/*")
public class AdminFilter implements Filter {

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession();
		Login account = (Login) session.getAttribute("account");
		if (account.getId().equals("admin") && account.getName().equals("admin")) {
			System.out.println("あなたは管理者ですね");
		}else {
			System.out.println("フィルターに引っ掛かりました");
			((HttpServletResponse) response).sendRedirect("/MashRoomDB");
		}

		chain.doFilter(request, response);
		// TODO 自動生成されたメソッド・スタブ

	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ

	}


}
