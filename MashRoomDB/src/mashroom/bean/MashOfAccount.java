package mashroom.bean;

public class MashOfAccount {
	private String id;
	private String mashname;
	public MashOfAccount(String id, String mashname) {
		super();
		this.id = id;
		this.mashname = mashname;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMashname() {
		return mashname;
	}
	public void setMashname(String mashname) {
		this.mashname = mashname;
	}
}
