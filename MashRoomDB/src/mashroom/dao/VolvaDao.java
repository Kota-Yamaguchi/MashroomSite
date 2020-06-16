package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Existence;
import mashroom.bean.Volva;

public class VolvaDao {
	String url ="jdbc:mysql://126.159.21.197:3306/Mashroom";
	public VolvaDao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	public Volva find(String id, Connection con) throws SQLException{
		String sql = "select * from VOLVA where volvaId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Volva vo = null;
		if(rs.next()) {
			int volvaId = rs.getInt("volvaId");
			String remarks = rs.getString("remarks");
			int existenceId = rs.getInt("existenceId");
			ExistenceDao edao = new ExistenceDao();
			Existence exist = edao.find(existenceId, con);
			vo = new Volva(volvaId, exist, remarks);
		}
		return vo;

	}

	public List<Volva> findAll() {
		Connection con = null;
		List<Volva> volist = new ArrayList<Volva>();

		try {
		con = DriverManager.getConnection(url,"AIBM","s1610615");
		String sql = "select * from VOLVA";

		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();

		while(rs.next()) {

			int volvaId = rs.getInt("volvaId");

			String remarks = rs.getString("remarks");

			int existenceId = rs.getInt("existenceId");

			ExistenceDao edao = new ExistenceDao();
			Existence exist = edao.find(existenceId, con);

			Volva vol = new Volva(volvaId, exist, remarks);

			volist.add(vol);
		}

		return volist;
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
