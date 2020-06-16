package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import mashroom.bean.Login;

public class LoginDao {
	public LoginDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("ドライバが認識されてませんん");
		}
	}

	public Login find(String id) {
		Connection con = null;
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url, "AIBM", "s1610615");
			String sql="select * from LOGIN WHERE id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			Login login =null;
			if(rs.next()) {
				login = new Login(rs.getString("id"), rs.getString("password"), rs.getString("name"));
			}
			return login;

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}
	}

	public int Insert(Login login) {
		Connection con = null;
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url, "AIBM", "s1610615");
			String sql = "INSERT INTO LOGIN VALUES (?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, login.getId());
			pstmt.setString(2, login.getName());
			pstmt.setString(3, login.getPassword());
			int rs = pstmt.executeUpdate();
			String sqlTable = "CREATE TABLE "+login.getId()+" (id VARCHAR(10), mashname VARCHAR(20))";

			Statement createTable = con.createStatement();
			createTable.executeUpdate(sqlTable);

			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
			}
		}


	}
}

