package liblaunchd;

public class StringEntry extends Entry {
	
	private String str;
	
	public StringEntry(String str) {
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
