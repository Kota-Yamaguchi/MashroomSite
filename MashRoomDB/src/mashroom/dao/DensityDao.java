package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Density;

public class DensityDao {
	public DensityDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		// TODO 自動生成されたコンストラクター・スタブ
		}catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("ドライバがないです。");
		}
	}
	public Density find(String id, Connection con) throws SQLException{
		String sql = "select * from DENSITY where densityId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Density de = null;
		if(rs.next()) {
			de = new Density(rs.getInt("densityId"),rs.getString("density"),rs.getString("remarks"));
		}
		return de;

	}
	public List<Density> findAll() {
		Connection con = null;
		List<Density> delist = new ArrayList<Density>();
		try {
			String url ="jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url, "AIBM","s1610615");
			String sql = "select * from DENSITY";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Density dense = new Density(rs.getInt("densityId"), rs.getString("density"),
						rs.getString("remarks"));
				delist.add(dense);
			}
			return delist;
		}catch(SQLException e) {
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
}
