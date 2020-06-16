package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Adnexed;

public class AdnexedDao{
	public AdnexedDao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
	}
	public Adnexed find(String id, Connection con) throws SQLException{
		String sql = "select * from ADNEXED where adnexedId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Adnexed ad=null;
		if(rs.next()) {
			ad = new Adnexed(rs.getInt("adnexedId"), rs.getString("adnexed"), rs.getString("remarks"));
		}
		return ad;
	}

	public List<Adnexed> findAll() {
		Connection con= null;
		List<Adnexed> adlist = new ArrayList<Adnexed>();
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url,"AIBM","s1610615");
			String sql = "select * from ADNEXED";
			PreparedStatement pstmt = con.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();

			while(rs.next()) {
				Adnexed ad = new Adnexed(rs.getInt("adnexedId"),
						rs.getString("adnexed"),rs.getString("remarks"));
				adlist.add(ad);
			}
			return adlist;

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
