package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Family;

public class FamilyDao {
	public FamilyDao(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			System.out.println("ドライバが見つかりません");
		}
	}

	public void insertFamily(Family fam) {
		Connection con = null;
		try {
			try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url,"AIBM","s1610615");
			}catch(SQLException e) {
				System.out.println("DBへ接続できません");
			}
			PreparedStatement pstmt = null;
			try {
			String sql = "INSERT INTO family VALUES (?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, fam.getId());
			pstmt.setString(2, fam.getName());
			int rs = pstmt.executeUpdate();
			}catch(SQLException e) {
				System.out.println("sqlでエラーがてます");
			}


			con.commit();
//			System.out.println("Insertに成功しました"+rs+"行だけ書き加えました");

		}catch(SQLException e) {
			System.out.println("SQL実行中か、それまでにエラーが発生しました。");
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
	public Family find(String id, Connection con) throws SQLException{
		String sql = "select * from family where familyId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, Integer.parseInt(id));
		ResultSet rs = pstmt.executeQuery();
		Family fam = null;
		if(rs.next()) {
			fam = new Family(rs.getInt("familyId"),rs.getString("family"));
		}
		return fam;

	}
	public List<Family> findAll() {
		List<Family> familist = new ArrayList<Family>();
		Connection con = null;
		ResultSet rs=null;
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url,"AIBM","s1610615");
			String sql = "SELECT * from family";
			PreparedStatement pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				Family f = new Family(Integer.parseInt(rs.getString("familyId")), rs.getString("family"));
				familist.add(f);
			}

		}catch(SQLException e) {
			System.out.println("SQL実行中か、それまでにエラーが発生しました。");
			e.printStackTrace();

		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		return familist;
	}
	public int delete(String id) {
		Connection con = null;
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url, "AIBM", "s1610615");
			String sql = "DELETE FROM family WHERE familyId = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(id));
			int rs = ps.executeUpdate();
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return -10;
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
