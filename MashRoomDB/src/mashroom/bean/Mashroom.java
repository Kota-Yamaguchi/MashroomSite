package mashroom.bean;

public class Mashroom {

	String name;
	Order order;
	Family family;
	Adnexed adnexed;
	Caulescent caulescent;
	Density density;
	Gill gill;
	Cortex cortex;
	Collar collar;
	Volva volva;
	String path;
	public Mashroom(String name, Order order, Family family) {
		super();
		this.name = name;
		this.order = order;
		this.family = family;
	}
	public Mashroom(String name, Order order, Family family, Adnexed adnexed, Caulescent caulescent, Density density,
			Gill gill, Cortex cortex, Collar collar, Volva volva) {
		super();
		this.name = name;
		this.order = order;
		this.family = family;
		this.adnexed = adnexed;
		this.caulescent = caulescent;
		this.density = density;
		this.gill = gill;
		this.cortex = cortex;
		this.collar = collar;
		this.volva = volva;
	}
	public Mashroom(String name, Order order, Family family, Adnexed adnexed, Caulescent caulescent, Density density,
			Gill gill, Cortex cortex, Collar collar, Volva volva, String path) {
		super();
		this.name = name;
		this.order = order;
		this.family = family;
		this.adnexed = adnexed;
		this.caulescent = caulescent;
		this.density = density;
		this.gill = gill;
		this.cortex = cortex;
		this.collar = collar;
		this.volva = volva;
		this.path = path;
	}

	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	@Override
	public String toString() {
		return "Mashroom [name=" + name + ", order=" + order + ", family=" + family + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Family getFamily() {
		return family;
	}
	public void setFamily(Family family) {
		this.family = family;
	}
	public Adnexed getAdnexed() {
		return adnexed;
	}
	public void setAdnexed(Adnexed adnexed) {
		this.adnexed = adnexed;
	}
	public Caulescent getCaulescent() {
		return caulescent;
	}
	public void setCaulescent(Caulescent caulescent) {
		this.caulescent = caulescent;
	}
	public Density getDensity() {
		return density;
	}
	public void setDensity(Density density) {
		this.density = density;
	}
	public Gill getGill() {
		return gill;
	}
	public void setGill(Gill gill) {
		this.gill = gill;
	}
	public Cortex getCortex() {
		return cortex;
	}
	public void setCortex(Cortex cortex) {
		this.cortex = cortex;
	}
	public Collar getCollar() {
		return collar;
	}
	public void setCollar(Collar collar) {
		this.collar = collar;
	}
	public Volva getVolva() {
		return volva;
	}
	public void setVolva(Volva volva) {
		this.volva = volva;
	}




}
