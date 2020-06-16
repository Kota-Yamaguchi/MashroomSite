package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Gill;

public class GillDao {
	public GillDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		}
	}
	public Gill find(String id, Connection con) throws SQLException{
		String sql = "select * from GILL where gillId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		System.out.println(sql);
		ResultSet rs = pstmt.executeQuery();
		Gill gi = null;
		if(rs.next()) {
			gi = new Gill(rs.getInt("gillId"),rs.getString("gill"),rs.getString("remarks"));
		}
		return gi;

	}
	public List<Gill> findAll(){
		Connection con = null;
		List<Gill> gilist = new ArrayList<Gill>();
		try {
			String url ="jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url, "AIBM","s1610615");
			String sql = "select * from GILL";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Gill gil = new Gill(rs.getInt("gillId"),rs.getString("gill"),
						rs.getString("remarks"));
				gilist.add(gil);
			}
			return gilist;

		}catch(SQLException e) {
			return null;

		}finally{
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
