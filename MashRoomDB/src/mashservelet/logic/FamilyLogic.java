package mashservelet.logic;

import mashroom.dao.FamilyDao;

public class FamilyLogic {
	public static void deleteLogic(String id) {
		FamilyDao famdao = new FamilyDao();
		int rs =famdao.delete(id);
		System.out.println(rs);
	}

}
