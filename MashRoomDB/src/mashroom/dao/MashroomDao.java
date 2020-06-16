package mashroom.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mashroom.bean.Adnexed;
import mashroom.bean.Caulescent;
import mashroom.bean.Collar;
import mashroom.bean.Cortex;
import mashroom.bean.Density;
import mashroom.bean.Family;
import mashroom.bean.Gill;
import mashroom.bean.Mashroom;
import mashroom.bean.Order;
import mashroom.bean.Volva;

public class MashroomDao {
	public MashroomDao(){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	public List<Mashroom> oneSelectFind(String name) {
		String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
		Connection con = null;
		List<Mashroom> mashlist = new ArrayList<Mashroom>();
		try {
			con = DriverManager.getConnection(url,"AIBM", "s1610615");
			String sql = "select * from mashroom where name = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderDao ordao = new OrderDao();
				FamilyDao famdao = new FamilyDao();
				AdnexedDao addao = new AdnexedDao();
				caulescentDao cadao = new caulescentDao();
				CollarDao coldao = new CollarDao();
				CortexDao cordao = new CortexDao();
				DensityDao dendao = new DensityDao();
				GillDao gidao = new GillDao();
				VolvaDao vodao = new VolvaDao();

				Order ordto = ordao.find(rs.getString("orderId"), con);
				Family famdto = famdao.find(rs.getString("familyId"), con);
				Adnexed addto = addao.find(rs.getString("adnexedId"), con);
				Caulescent cadto = cadao.find(rs.getString("caulescentId"), con);
				Density dendto = dendao.find(rs.getString("densityId"), con);
				Collar coldto = coldao.find(rs.getString("collarId"), con);
				Cortex cordto = cordao.find(rs.getString("cortexId"), con);
				Gill gidto = gidao.find(rs.getString("gillId"), con);
				Volva vodto = vodao.find(rs.getString("volvaId"), con);

				Mashroom mash = new Mashroom(rs.getString("name"), ordto, famdto, addto, cadto,
						dendto, gidto, cordto, coldto, vodto, rs.getString("PICTUREPATH"));

				mashlist.add(mash);

			}
			return mashlist;

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con!=null);
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}
	}
	public List<Mashroom> allselectFind(String userid, String adnexed, String caulescent,String cortex,
			String density, String gill, String collar, String volva) {
		String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
		Connection con = null;
		List<Mashroom> mashlist = new ArrayList<Mashroom>();
		try {
			con = DriverManager.getConnection(url,"AIBM", "s1610615");
			String sql = "select name , orderId, familyId from mashroom where gillId=? AND densityId=? AND caulescentId=? AND cortexId=? "
					+ "AND adnexedId=? AND volvaId=? AND collarId=?";

			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Integer.parseInt(gill));
			pstmt.setInt(2, Integer.parseInt(density));
			pstmt.setInt(3, Integer.parseInt(caulescent));
			pstmt.setInt(4, Integer.parseInt(cortex));
			pstmt.setInt(5, Integer.parseInt(adnexed));
			pstmt.setInt(6, Integer.parseInt(volva));
			pstmt.setInt(7, Integer.parseInt(collar));


			AdnexedDao addao = new AdnexedDao();
			caulescentDao cadao = new caulescentDao();
			CollarDao coldao = new CollarDao();
			CortexDao cordao = new CortexDao();
			DensityDao dendao = new DensityDao();
			GillDao gidao = new GillDao();
			VolvaDao vodao = new VolvaDao();


			Adnexed addto = addao.find(adnexed, con);
			Caulescent cadto = cadao.find(caulescent, con);
			Density dendto = dendao.find(density, con);
			Collar coldto = coldao.find(collar, con);
			Cortex cordto = cordao.find(cortex, con);
			Gill gidto = gidao.find(gill, con);
			Volva vodto = vodao.find(volva, con);

			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				OrderDao ordao = new OrderDao();
				FamilyDao famdao = new FamilyDao();
				Order ordto = ordao.find(rs.getString("orderId"), con);
				Family famdto = famdao.find(rs.getString("familyId"), con);


				Mashroom mash = new Mashroom(rs.getString("name"), ordto, famdto, addto, cadto,
						dendto, gidto, cordto, coldto, vodto);
				mashlist.add(mash);
				MashOfAccountDao acountdao = new MashOfAccountDao(userid);
				acountdao.Insert(rs.getString("name"), con);
			}
			return mashlist;

		}catch(SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			if(con!=null);
				try {
					con.close();
				} catch (SQLException e) {
					// TODO 自動生成された catch ブロック
					e.printStackTrace();
				}
		}
	}

	public int InsertMash(String name, String order, String family, String adnexed, String caulescent, String cortex,
			String density, String gill, String collar, String volva) {
		Connection con = null;
		try {
			String url = "jdbc:mysql://126.159.21.197:3306/Mashroom";
			con = DriverManager.getConnection(url,"AIBM","s1610615");


			OrderDao ordao = new OrderDao();
			FamilyDao famdao = new FamilyDao();
			AdnexedDao addao = new AdnexedDao();
			caulescentDao cadao = new caulescentDao();
			CollarDao coldao = new CollarDao();
			CortexDao cordao = new CortexDao();
			DensityDao dendao = new DensityDao();
			GillDao gidao = new GillDao();
			VolvaDao vodao = new VolvaDao();

			Order ordto = ordao.find(order, con);
			Family famdto = famdao.find(family, con);
			Adnexed addto = addao.find(adnexed, con);
			Caulescent cadto = cadao.find(caulescent, con);
			Density dendto = dendao.find(density, con);
			Collar coldto = coldao.find(collar, con);
			Cortex cordto = cordao.find(cortex, con);
			System.out.println(gill);
			Gill gidto = gidao.find(gill, con);
			Volva vodto = vodao.find(volva, con);

			Mashroom mash = new Mashroom(name, ordto, famdto, addto, cadto, dendto, gidto, cordto, coldto, vodto);

			String sql = "INSERT INTO mashroom VALUES (?,?,?,?,?,?,?,?,?,?) ";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setInt(2, ordto.getId());
			pstmt.setInt(3, famdto.getId());
			pstmt.setInt(4, gidto.getGillId());
			pstmt.setInt(5, dendto.getDensityId());
			pstmt.setInt(6, cadto.getCaulescentId());
			pstmt.setInt(7, cordto.getCortexId());
			pstmt.setInt(8, addto.getAdnexedId());
			pstmt.setInt(9, vodto.getVolvaId());
			pstmt.setInt(10, coldto.getCollarId());

			int rs = pstmt.executeUpdate();

			System.out.println(rs+"行の挿入に成功");
			return rs;
		}catch(SQLException e) {
			e.printStackTrace();
			return -1;
		}finally {
			try {
				if (con!=null) {
					con.close();
				}
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
	}

}
