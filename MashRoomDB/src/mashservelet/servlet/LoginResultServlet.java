package mashservelet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mashroom.bean.Login;
import mashservelet.logic.LoginLogic;

@WebServlet("/LoginResult")
public class LoginResultServlet extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		HttpSession session = request.getSession();

		Login login = LoginLogic.login(id, password);
		session.setAttribute("account", login);
		System.out.println("1");
		System.out.println(login);
		Login account = (Login) session.getAttribute("account");
		System.out.println(account);
		System.out.println(session.getId());
		if (login==null) {
			response.sendRedirect("/");
		}else {
			response.sendRedirect("/Login/SelectMash");

		}



	}

}
