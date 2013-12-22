package smallc.parser.ast;
import java.util.*;

public class Shared {
	public int base = 0;
	public boolean isGlobal = true;
	public int lastRet = 0;
	public int labelMark = 0;
	public int structMark = 0;
	
	public HashMap<String, Boolean> isLocalVariable;
	//public HashMap<String, Boolean> isArray;
	public HashMap<String, Integer> arraySize;
	
	public HashMap<String, Integer> markReps;
	
	public HashMap<String, Integer> structSize;
	
	public HashMap<String, Integer> subnameTable;
	
	public HashMap<String, String> structVars;
	
	public String buffer;
	
	public void println(String newstring)
	{
		buffer = buffer + newstring + "\n";
	}
	
	public void print(String newstring)
	{
		buffer = buffer + newstring + "";
	}
	
	public boolean queryLocal(String qs)
	{
		if(this.isLocalVariable.containsKey(qs)) {
			if(this.isLocalVariable.get(qs).equals(true)) return true; else return false;
		}
		return false;
	}
	
	public void addLocal(String qs)
	{
		this.isLocalVariable.put(qs, true);
	}
	
	public void addArray(String qs, Integer size) {
		//this.isArray.put(qs, true);
		this.arraySize.put(qs, size);
	}
	
	public boolean isArray(String qs) {
		return this.arraySize.containsKey(qs);
	}
	
	public int aSize(String qs) {
		if(this.isArray(qs)) {
			return this.arraySize.get(qs);
		}
		return -1;
	}
	
	public String newMarker() {
		return "_MARKER" + (++this.labelMark) + "MARKER_";
	}
	
	public String newStruct() {
		return "_STRUCT" + (++this.structMark) + "STRUCT_";
	}
	
	public void addStructSubname(String name, String subname) {
		if(!this.structSize.containsKey(name)) {
			this.structSize.put(name, 0);
		}
		int oldSize = this.structSize.get(name);
		this.subnameTable.put(name + "." + subname, oldSize);
		this.structSize.put(name, oldSize + 1);
	}
	
	public int queryStructSize(String name) {
		if(!this.structSize.containsKey(name)) return 0;
		return this.structSize.get(name);
	}
	
	public int querySubname(String subname) {
		if(!this.subnameTable.containsKey(subname)) return 0;
		return this.subnameTable.get(subname);
	}
	
	public void declareAsStruct(String var, String name) {
		this.structVars.put(var, name);
	}
	
	public String whichStruct(String var) {
		if(!this.structVars.containsKey(var)) {
			System.out.println("NO MATCHING STRUCT!!!");
			return "";
		}
		return this.structVars.get(var);
	}
	
	public void markerReplace(String marker, Integer i) {
		this.markReps.put(marker, i);
	}
	
	public void pleaseReplace() {
		Set<String> keys = this.markReps.keySet();
		
		Iterator<String> iter = keys.iterator();
		while(iter.hasNext()) {
			String me = iter.next();
			//System.out.println(me);
			//System.out.println(this.markReps.get(me).toString());
			this.buffer = this.buffer.replaceAll(me, this.markReps.get(me).toString());
		}
	}
	
	public Shared() {
		this.isLocalVariable = new HashMap<String, Boolean>();
		//this.isArray = new HashMap<String, Boolean>();
		this.arraySize = new HashMap<String, Integer>();
		this.markReps = new HashMap<String, Integer>();
		this.structSize = new HashMap<String, Integer>();
		this.subnameTable = new HashMap<String, Integer>();
		this.structVars = new HashMap<String, String>();
		
		this.buffer = "";
		
	}
}
