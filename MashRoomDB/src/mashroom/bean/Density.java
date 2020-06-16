package mashroom.bean;

public class Density {
	private int densityId;
	private String density;
	private String remarks;
	public Density(int densityId, String density, String remarks) {
		super();
		this.densityId = densityId;
		this.density = density;
		this.remarks = remarks;
	}
	public int getDensityId() {
		return densityId;
	}
	public void setDensityId(int densityId) {
		this.densityId = densityId;
	}
	public String getDensity() {
		return density;
	}
	public void setDensity(String density) {
		this.density = density;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


}
