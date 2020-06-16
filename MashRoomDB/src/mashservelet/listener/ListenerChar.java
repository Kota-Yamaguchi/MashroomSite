package mashservelet.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import mashroom.bean.Adnexed;
import mashroom.bean.Caulescent;
import mashroom.bean.Collar;
import mashroom.bean.Cortex;
import mashroom.bean.Density;
import mashroom.bean.Family;
import mashroom.bean.Gill;
import mashroom.bean.Order;
import mashroom.bean.Volva;
import mashroom.dao.AdnexedDao;
import mashroom.dao.CollarDao;
import mashroom.dao.CortexDao;
import mashroom.dao.DensityDao;
import mashroom.dao.FamilyDao;
import mashroom.dao.GillDao;
import mashroom.dao.OrderDao;
import mashroom.dao.VolvaDao;
import mashroom.dao.caulescentDao;
@WebListener
public class ListenerChar implements ServletContextListener{
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext context = sce.getServletContext();
		OrderDao ordao = new OrderDao();
		List<Order> orlist = ordao.findAll();

		context.setAttribute("orlist", orlist);

		FamilyDao fam = new FamilyDao();
		List<Family> famlist = fam.findAll();
		context.setAttribute("famlist", famlist);

		AdnexedDao ad = new AdnexedDao();
		List<Adnexed> adlist = ad.findAll();
		context.setAttribute("adlist", adlist);

		caulescentDao ca = new caulescentDao();
		List<Caulescent> calist = ca.findAll();
		context.setAttribute("calist", calist);

		DensityDao da = new DensityDao();
		List<Density> delist = da.findAll();
		context.setAttribute("delist", delist);

		GillDao ga = new GillDao();
		List<Gill> gilist = ga.findAll();
		context.setAttribute("gilist", gilist);

		CortexDao cor = new CortexDao();
		List<Cortex> corlist = cor.findAll();
		context.setAttribute("corlist", corlist);

		CollarDao co = new CollarDao();
		List<Collar> colist = co.findAll();
		context.setAttribute("colist", colist);

		VolvaDao vo = new VolvaDao();
		List<Volva> volist = vo.findAll();
		context.setAttribute("volist", volist);
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO 自動生成されたメソッド・スタブ

	}
}
