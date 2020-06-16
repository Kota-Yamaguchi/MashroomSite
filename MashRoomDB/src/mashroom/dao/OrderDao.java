package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Order;

public class OrderDao {
	String url ="jdbc:mysql://126.159.21.197:3306/Mashroom";
	public OrderDao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	}


	public void InsertOrder(Order or) {
		Connection con = null;
		try {

			con = DriverManager.getConnection(url,"AIBM","s1610615");
			String sql = "INSERT INTO orders VALUES (?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, or.getId());
			pstmt.setString(2, or.getName());

			int rs = pstmt.executeUpdate();
			con.commit();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}
	public Order find(String id, Connection con) throws SQLException{
		String sql = "select * from orders where orderId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Order or = null;
		if(rs.next()) {
			or = new Order(rs.getInt("orderId"),rs.getString("orders"));
		}
		return or;
	}

	public List<Order> findAll(){
		Connection con = null;
		List<Order> orlist = new ArrayList<Order>();
		try {

			con = DriverManager.getConnection(url,"AIBM","s1610615");

			String sql = "SELECT * from orders";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Order or = new Order(rs.getInt("orderId"),rs.getString("orders"));
				orlist.add(or);
			}
			return orlist;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

}
