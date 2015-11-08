package liblaunchd;

public class Agent {
	
	private String label;
	
	public Agent(String label) {
		this.setLabel(label);
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
