package mashservelet.logic;

import java.util.List;

import mashroom.bean.Mashroom;
import mashroom.dao.MashroomDao;

public class MashLogic {
	public static void InsertLogic(String name, String order, String family, String adnexed, String caulescent,String cortex,
			String density, String gill, String collar, String volva) {

		MashroomDao mashdao = new MashroomDao();
		int r = mashdao.InsertMash(name, order, family, adnexed, caulescent, cortex, density, gill, collar, volva);
		if(r==-1) {
			System.out.println("エラーが出ています。");
		}
	}

	public static List<Mashroom> SelectLogic(String userid, String adnexed, String caulescent,String cortex,
			String density, String gill, String collar, String volva) {
		MashroomDao mashdao = new MashroomDao();
		List<Mashroom> mashlist = mashdao.allselectFind(userid,adnexed, caulescent, cortex, density, gill, collar, volva);

		return mashlist;
	}

	public static List<Mashroom> SelectLogic(String name){
		MashroomDao mashdao = new MashroomDao();
		List<Mashroom> mashlist = mashdao.oneSelectFind(name);
		return mashlist;
	}
}
