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
import mashroom.bean.Mashroom;
import mashservelet.logic.MashLogic;

@WebServlet("/Login/SelectMash")
public class SelectMashroom extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		System.out.println("koko");
		RequestDispatcher rd = request.getRequestDispatcher("/SelectMashroom.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request,HttpServletResponse response)
		throws IOException, ServletException{
		String adnexed = request.getParameter("adnexed");
		String caulescent = request.getParameter("caulescent");
		String cortex = request.getParameter("cortex");
		String density = request.getParameter("density");
		String gill = request.getParameter("gill");
		String collar = request.getParameter("collar");
		String volva = request.getParameter("volva");
		HttpSession session = request.getSession();
		Login account = (Login) session.getAttribute("account");
		System.out.println(account);
		List<Mashroom> mashlist = MashLogic.SelectLogic(account.getId(), adnexed, caulescent, cortex, density, gill, collar, volva);
		request.setAttribute("mashlist", mashlist);
		RequestDispatcher rd = request.getRequestDispatcher("/SelectResult.jsp");
		rd.forward(request, response);
	}
}
