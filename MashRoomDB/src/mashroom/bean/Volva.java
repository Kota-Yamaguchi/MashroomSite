package mashroom.bean;

public class Volva {
	private int volvaId;
	private Existence exist;
	private String remarks;
	public Volva(int volvaId, Existence exist, String remarks) {
		super();
		this.volvaId = volvaId;
		this.exist = exist;
		this.remarks = remarks;
	}
	public int getVolvaId() {
		return volvaId;
	}
	public void setVolvaId(int volvaId) {
		this.volvaId = volvaId;
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
		return "Volva [volvaId=" + volvaId + ", exist=" + exist + ", remarks=" + remarks + "]";
	}


}
