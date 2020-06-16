package mashservelet.logic;

import mashroom.bean.Login;
import mashroom.dao.LoginDao;

public class LoginLogic {
	public static Login login(String id, String password) {
		LoginDao logdao = new LoginDao();
		Login login = logdao.find(id);
		if (login.getPassword().equals(password)) {
			System.out.println("ログインい成功しました。");
			return login;

		}else {
			System.out.println("ログインに失敗しました");
			return null;
		}
	}
	public static void resister(String id, String name, String password) {
		Login login = new Login(id, password, name);
		LoginDao logdao = new LoginDao();
		int rs = logdao.Insert(login);

		if(rs!=-1) {
			System.out.println("登録できました。");
		}
	}
}
