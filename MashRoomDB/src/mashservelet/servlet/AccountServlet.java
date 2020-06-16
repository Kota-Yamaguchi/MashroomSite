package mashservelet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mashroom.bean.Login;
import mashroom.bean.MashOfAccount;
import mashservelet.logic.AccountLogic;
@WebServlet("/Login/account")
public class AccountServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

		HttpSession session = request.getSession();
		Login account= (Login) session.getAttribute("account");
		System.out.println(session.getId());
		System.out.println(account);
		List<MashOfAccount> list = AccountLogic.accountMash(account.getId());
		request.setAttribute("list", list);

		RequestDispatcher rd = request.getRequestDispatcher("/account.jsp");
		rd.forward(request, response);

	}

}
