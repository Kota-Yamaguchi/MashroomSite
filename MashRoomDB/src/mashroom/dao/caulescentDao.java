package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Caulescent;

public class caulescentDao {
	public caulescentDao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		// TODO 自動生成されたコンストラクター・スタブ
		}catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("ドライバがないです。");
		}
	}
	public Caulescent find(String id, Connection con) throws SQLException{
		String sql = "select * from CAULESCENT where caulescentId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Caulescent ca = null;
		if(rs.next()) {
			ca = new Caulescent(rs.getInt("caulescentId"),rs.getString("caulescent"),rs.getString("remarks"));
		}
		return ca;

	}

	public List<Caulescent> findAll() {
		Connection con = null;
		List<Caulescent> calist = new ArrayList<Caulescent>();
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url,"AIBM","s1610615");
			String sql = "select * from CAULESCENT";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Caulescent ca = new Caulescent(rs.getInt("caulescentId")
						,rs.getString("caulescent"),rs.getString("remarks"));
				calist.add(ca);
			}
			return calist;

		}catch(SQLException e) {
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
