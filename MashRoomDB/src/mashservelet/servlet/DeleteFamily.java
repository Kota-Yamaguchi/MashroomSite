package mashservelet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mashservelet.logic.FamilyLogic;

@WebServlet("/Login/admin/DeleteFamily")
public class DeleteFamily extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");
		String which = request.getParameter("which");
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		if (Integer.parseInt(which)==0) {
			FamilyLogic.deleteLogic(id);
		}
		session.removeAttribute("id");

		response.sendRedirect("/Login/admin/InsertFamily");
	}

}
