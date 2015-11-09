package liblaunchd;

public class Agent {
	
	private String label;
	private String[] programArguments;
	private Env[] envs;
	
	public Agent(String label) {
		this.label = label;
	}
	
	public String build() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("<plist version=\"1.0\">\n");
		sb.append("	<dict>\n");
		
		sb.append("		<key>Label</key>\n");
		sb.append("		<string>" + label + "</string>\n");
		
		if (programArguments.length <= 1) {
			sb.append("		<key>Program</key>\n");
			sb.append("		<string>" + programArguments[0] + "</string>\n");
		} else {
			sb.append("		<key>ProgramArguments</key>\n");
			sb.append("		<array>\n");

			for (String arg : programArguments) {
				sb.append("			<string>" + arg + "</string>\n");
			}
			
			sb.append("		</array>\n");
		}
		
		if (envs != null && envs.length > 0) {
			sb.append("		<key>EnvironmentVariables</key>\n");
			sb.append("		<dict>\n");
			
			for (Env e : envs) {
				sb.append("			<key>" + e.getKey() + "</key>\n");
				sb.append("			<string>" + e.getValue() + "</string>\n");
			}
			
			sb.append("		</dict>\n");
		}
		
		sb.append("		<key>RunAtLoad</key>\n");
		sb.append("		<true/>\n");
		sb.append("	</dict>\n");
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
