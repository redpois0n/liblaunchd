package liblaunchd;

public class String0 extends Entry {
	
	private String str;
	
	public String0(String str) {
		this.str = str;
	}

	@Override
	public String getData() {
		return str;
	}

	@Override
	public String toString() {
		return "string";
	}

}
