package liblaunchd;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	
	private List<Entry> list = new ArrayList<Entry>(); 
	private Dict root = new Dict();
	
	private String label;
	private String[] programArguments;
	private Env[] envs;
	
	public Agent(String label) {
		this.label = label;
		init();
	}
	
	private final void init() {
		root.getEntries().add(new Key("Label"));
		root.getEntries().add(new String0(label));
	}
	
	public Dict getRoot() {
		return root;
	}
	
	public String build() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<plist version=\"1.0\">\n");

		for (Entry e : list) {
			sb.append("<" + e.toString() + ">");
			if (e.newLine()) {
				sb.append("\n");
			}
			sb.append(e.getData());
			sb.append("</" + e.toString() + ">\n");
		}
		
		sb.append("</plist>\n");
	
		return sb.toString();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getProgram() {
		return programArguments.length == 0 ? null : programArguments[0];
	}
	
	public void setProgram(String program) {
		this.programArguments = new String[1];
		this.programArguments[0] = program;
	}

	public String[] getProgramArguments() {
		return programArguments;
	}

	public void setProgramArguments(String[] program) {
		this.programArguments = program;
	}

	public Env[] getEnvironmentVariables() {
		return envs;
	}

	public void setEnvironmentVariables(Env[] env) {
		this.envs = env;
	}

}
