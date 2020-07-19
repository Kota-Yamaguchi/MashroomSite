package mashservelet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mashservelet.logic.MashLogic;
@WebServlet("/Login/admin/InsertMash")
public class InsertMashroom extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/InsertMashroom.jsp");
		rd.forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException{
			request.setCharacterEncoding("UTF-8");

			request.setCharacterEncoding("UTF-8");
			String name = request.getParameter("name");
			String order = request.getParameter("order");
			String family = request.getParameter("family");
			String adnexed = request.getParameter("adnexed");
			String caulescent = request.getParameter("caulescent");
			String cortex = request.getParameter("cortex");
			String density = request.getParameter("density");
			String gill = request.getParameter("gill");
			String collar = request.getParameter("collar");
			String volva = request.getParameter("volva");
			MashLogic.InsertLogic(name, order, family, adnexed, caulescent, cortex, density, gill, collar, volva);

			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/result.jsp");
			rd.forward(request, response);

	}
}
