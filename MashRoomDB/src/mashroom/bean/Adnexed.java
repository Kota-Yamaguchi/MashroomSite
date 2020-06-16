package mashroom.bean;

public class Adnexed {
	private int adnexedId;
	private String adnexed;
	private String remarks;
	public Adnexed(int adnexedId, String adnexed, String remarks) {
		super();
		this.adnexedId = adnexedId;
		this.adnexed = adnexed;
		this.remarks = remarks;
	}
	public int getAdnexedId() {
		return adnexedId;
	}
	public void setAdnexedId(int adnexedId) {
		this.adnexedId = adnexedId;
	}
	public String getAdnexed() {
		return adnexed;
	}
	public void setAdnexed(String adnexed) {
		this.adnexed = adnexed;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
