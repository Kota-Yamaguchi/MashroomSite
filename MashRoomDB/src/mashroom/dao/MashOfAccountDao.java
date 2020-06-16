package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.MashOfAccount;

public class MashOfAccountDao {
	private String userid;
	public MashOfAccountDao(String userid) {
		try {
			this.userid = userid;
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("ドライバが認識されてませんん");
		}
	}

	public int Insert(String mashname, Connection con) throws SQLException{
		String sql = "INSERT INTO "+userid+" VALUES (?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, userid);
		pstmt.setString(2, mashname);
		int rs = pstmt.executeUpdate();
		return rs;
	}

	public List<MashOfAccount> findAll(){
		Connection con = null;
		List<MashOfAccount> aclist = new ArrayList<>();
		String url ="jdbc:mysql://126.159.21.197:3306/Mashroom";
		try {
		con = DriverManager.getConnection(url,"AIBM","s1610615");
		String sql = "select * from "+this.userid+"";
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while(rs.next()) {
			MashOfAccount mashac = new MashOfAccount(rs.getString("id"), rs.getString("mashname"));
			aclist.add(mashac);
		}
		return aclist;

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


