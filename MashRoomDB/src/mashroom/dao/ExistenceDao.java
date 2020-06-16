package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import mashroom.bean.Existence;

public class ExistenceDao {
	public ExistenceDao() {
		// TODO 自動生成されたコンストラクター・スタブ
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			throw new IllegalArgumentException("ドライバが参照できません");
			}
	}

	public Existence find(int id) throws SQLException{

		String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
		Connection con = DriverManager.getConnection(url,"AIBM","s1610615");

		String sql = "select * from EXISTENCE WHERE existenceId = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);

		pstmt.setInt(1, id);
		ResultSet rst = pstmt.executeQuery();

		Existence existence = null;

		if(rst.next()) {
		String exist = rst.getString("existence");
		existence = new Existence(id, exist);

		}

		return existence;


	}

	public Existence find(int id,Connection con) throws SQLException{
			String sql = "select * from EXISTENCE WHERE existenceId = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rst = pstmt.executeQuery();
			Existence existence = null;
			if(rst.next()) {
			String exist = rst.getString("existence");
			existence = new Existence(id, exist);
			}else {
				return null;
			}
			return existence;


		}
	}

