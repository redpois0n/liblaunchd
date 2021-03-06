package liblaunchd;

import java.util.ArrayList;
import java.util.List;

public class Dict extends Entry {
	
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
		return "dict";
	}
	
	@Override
	public boolean newLine() {
		return true;
	}
	
	
	public void add(Entry e) {
		entries.add(e);
	}
	
	public void add(String s) {
		entries.add(new StringEntry(s));
	}

}
