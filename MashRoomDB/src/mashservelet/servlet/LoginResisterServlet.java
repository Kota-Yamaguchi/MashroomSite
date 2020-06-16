package mashservelet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mashservelet.logic.LoginLogic;
@WebServlet("/resister")
public class LoginResisterServlet extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		RequestDispatcher rd = request.getRequestDispatcher("/resister.jsp");
		rd.forward(request, response);

	}

	public void doPost(HttpServletRequest request , HttpServletResponse response) throws IOException, ServletException{
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");

		LoginLogic.resister(id, name, password);

		RequestDispatcher rd = request.getRequestDispatcher("/resisterFinish.jsp");
		rd.forward(request, response);

	}

}
