package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Collar;
import mashroom.bean.Existence;

public class CollarDao {
	public CollarDao() {
		// TODO 自動生成されたコンストラクター・スタブ
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	}catch(ClassNotFoundException e) {
		throw new IllegalArgumentException("ドライバが参照できません");
		}
	}

	public Collar find(String id, Connection con) throws SQLException{
		String sql = "select * from COLLAR where collarId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Collar co = null;
		if(rs.next()) {
			ExistenceDao edao = new ExistenceDao();
			int collarId = rs.getInt("collarId");
			int existenceId = rs.getInt("existenceId");
			String remarks = rs.getString("remarks");
			Existence exist = edao.find(existenceId,con);
			co = new Collar(collarId, exist, remarks);
		}
		return co;

	}
	public List<Collar> findAll() {

		Connection con = null;
		List<Collar> clist = new ArrayList<Collar>();
		try {
		String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
		con = DriverManager.getConnection(url,"AIBM","s1610615");
		String sql = "select * from COLLAR";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while(rs.next()) {
			ExistenceDao edao = new ExistenceDao();
			int collarId = rs.getInt("collarId");
			int existenceId = rs.getInt("existenceId");
			String remarks = rs.getString("remarks");
			Existence exist = edao.find(existenceId,con);

			Collar collar = new Collar(collarId, exist, remarks);

			clist.add(collar);
		}
		return clist;
		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally{
			if (con!=null) {
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
