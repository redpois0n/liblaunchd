package liblaunchd;

public class Key extends Entry {
	
	private String str;
	
	public Key(String str) {
		this.str = str;
	}

	@Override
	public String getData() {
		return str;
	}

	@Override
	public String toString() {
		return "key";
	}

}
