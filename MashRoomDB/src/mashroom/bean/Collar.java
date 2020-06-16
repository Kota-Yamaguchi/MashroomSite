package mashroom.bean;

public class Collar {
	private int collarId;
	private Existence exist;
	private String remarks;

	public Collar(int collarId, Existence exist, String remarks) {
		super();
		this.collarId = collarId;
		this.exist = exist;
		this.remarks = remarks;
	}
	public int getCollarId() {
		return collarId;
	}
	public void setCollarId(int collarId) {
		this.collarId = collarId;
	}
	public Existence getExist() {
		return exist;
	}
	public void setExist(Existence exist) {
		this.exist = exist;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "Collar [collarId=" + collarId + ", exist=" + exist + ", remarks=" + remarks + "]";
	}




}
