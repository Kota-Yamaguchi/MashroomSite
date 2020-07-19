package mashservelet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mashroom.bean.Family;
import mashroom.dao.FamilyDao;

@WebServlet("/Login/admin/InsertFamily")
public class InsertFamily extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/InsertFamily.jsp");
			rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws IOException, ServletException{

		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");

		Family family =new Family(id, name);
		FamilyDao f = new FamilyDao();
		f.insertFamily(family);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/InsertFamily.jsp");
		rd.forward(request, response);



	}
}
