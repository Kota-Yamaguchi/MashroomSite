package mashservelet.logic;

import java.util.List;

import mashroom.bean.MashOfAccount;
import mashroom.dao.MashOfAccountDao;

public class AccountLogic {
	public static List<MashOfAccount> accountMash(String userid) {
		MashOfAccountDao mashacdao = new MashOfAccountDao(userid);
		List<MashOfAccount> aclist = mashacdao.findAll();
		return aclist;
	}
}
