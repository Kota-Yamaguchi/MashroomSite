package mashservelet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login/admin/DeleteConfirm")
public class DeleteConfirm extends HttpServlet{
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		System.out.println("deleteまで");
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("delete");
		System.out.println(id);
		HttpSession session = request.getSession();
		session.setAttribute("id", id);
		RequestDispatcher rd = request.getRequestDispatcher("/delete.jsp");
		rd.forward(request, response);
	}

}
