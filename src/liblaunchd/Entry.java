package liblaunchd;

public abstract class Entry {
	
	public abstract String getData();
	
	public abstract String toString();

	public boolean newLine() {
		return false;
	}

}
