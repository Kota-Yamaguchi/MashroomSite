package mashservelet.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mashroom.bean.Order;
import mashroom.dao.OrderDao;

@WebServlet("Login/admin/InsertOrder")
public class InsertOrder extends HttpServlet{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws IOException,ServletException{
		RequestDispatcher rd = request.getRequestDispatcher("/InsertOrder.jsp");
		rd.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
	throws IOException,ServletException{
		request.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(request.getParameter("id"));;
		String name = request.getParameter("name");

		try {
		Order or = new Order(id, name);
		OrderDao ordao = new OrderDao();
		ordao.InsertOrder(or);

		RequestDispatcher rd = request.getRequestDispatcher("/InsertOrder.jsp");
		rd.forward(request, response);
		}catch(IllegalArgumentException e) {
			Order or = null;
			request.setAttribute("order", or);
			RequestDispatcher rd = request.getRequestDispatcher("/InsertOrder.jsp");
			rd.forward(request, response);

		}


	}


}
