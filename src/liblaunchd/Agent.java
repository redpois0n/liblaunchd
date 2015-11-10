package liblaunchd;

import java.util.ArrayList;
import java.util.List;

public class Agent {
	
	private List<Entry> list = new ArrayList<Entry>(); 
	private Dict root = new Dict();
	
	private String label;
	
	public Agent(String label) {
		this.label = label;
		init();
	}
	
	/**
	 * Add label key directly (required)
	 */
	private final void init() {
		list.add(root);
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
}
