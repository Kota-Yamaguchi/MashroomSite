package mashroom.bean;

public class Cortex {
	private int cortexId;
	private String cortex;
	private String remarks;
	public Cortex(int cortexId, String cortex, String remarks) {
		super();
		this.cortexId = cortexId;
		this.cortex = cortex;
		this.remarks = remarks;
	}
	public int getCortexId() {
		return cortexId;
	}
	public void setCortexId(int cortexId) {
		this.cortexId = cortexId;
	}
	public String getCortex() {
		return cortex;
	}
	public void setCortex(String cortex) {
		this.cortex = cortex;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}



}
