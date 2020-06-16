package mashroom.bean;

public class Gill {
	private int gillId;
	private String gill;
	private String remarks;
	public Gill(int gillId, String gill, String remarks) {
		super();
		this.gillId = gillId;
		this.gill = gill;
		this.remarks = remarks;
	}
	public int getGillId() {
		return gillId;
	}
	public void setGillId(int gillId) {
		this.gillId = gillId;
	}
	public String getGill() {
		return gill;
	}
	public void setGill(String gill) {
		this.gill = gill;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



}
