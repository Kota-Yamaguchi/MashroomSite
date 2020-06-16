package mashservelet.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mashroom.bean.Mashroom;
import mashservelet.logic.MashLogic;

@WebServlet("/Login/detail")
public class DetailMashroom extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		request.setCharacterEncoding("UTF-8");
		String mashname = request.getParameter("detail");
		List<Mashroom> mashlist = MashLogic.SelectLogic(mashname);
		Mashroom mash = mashlist.get(0);
		request.setAttribute("mash", mash);
		RequestDispatcher rd = request.getRequestDispatcher("/detail.jsp");

		rd.forward(request, response);


	}

}
