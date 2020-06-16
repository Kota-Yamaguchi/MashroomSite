package mashroom.bean;

public class Existence {
	private int id;
	private String existense;

	public Existence(int id, String existense) {
		super();
		this.id = id;
		this.existense = existense;
	}

	@Override
	public String toString() {
		return this.existense;
	}



}
