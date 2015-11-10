package liblaunchd;

import java.util.ArrayList;
import java.util.List;

public class Array extends Entry {
	
	private List<Entry> entries = new ArrayList<Entry>();
	
	public List<Entry> getEntries() {
		return entries;
	}

	@Override
	public String getData() {
		StringBuilder sb = new StringBuilder();
		

		for (Entry e : entries) {
			sb.append("<" + e.toString() + ">");
			if (e.newLine()) {
				sb.append("\n");
			}
			sb.append(e.getData());
			sb.append("</" + e.toString() + ">\n");
		}
		
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return "array";
	}
	
	@Override
	public boolean newLine() {
		return true;
	}

}
