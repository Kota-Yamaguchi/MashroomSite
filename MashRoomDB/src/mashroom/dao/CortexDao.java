package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Cortex;

public class CortexDao {
	public CortexDao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		// TODO 自動生成されたコンストラクター・スタブ
		}catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("ドライバがないです。");
		}
	}
	public Cortex find(String id, Connection con) throws SQLException{
		String sql = "select * from CORTEX where cortexId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Cortex co = null;
		if(rs.next()) {
			co = new Cortex(rs.getInt("cortexId"),rs.getString("cortex"),rs.getString("remarks"));
		}
		return co;

	}
	public List<Cortex> findAll() {
		Connection con = null;
		List<Cortex> colist = new ArrayList<Cortex>();
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url,"AIBM","s1610615");
			String sql = "select * from CORTEX";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Cortex co = new Cortex(rs.getInt("cortexId")
						,rs.getString("cortex"),rs.getString("remarks"));
				colist.add(co);
			}
			return colist;

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
