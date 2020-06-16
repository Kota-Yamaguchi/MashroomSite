package mashroom.bean;

public class Caulescent {
	private int caulescentId;
	private String caulescent;
	private String remarks;
	public Caulescent(int caulescentId, String caulescent, String remarks) {
		super();
		this.caulescentId = caulescentId;
		this.caulescent = caulescent;
		this.remarks = remarks;
	}
	public int getCaulescentId() {
		return caulescentId;
	}
	public void setCaulescentId(int caulescentId) {
		this.caulescentId = caulescentId;
	}
	public String getCaulescent() {
		return caulescent;
	}
	public void setCaulescent(String caulescent) {
		this.caulescent = caulescent;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



}
