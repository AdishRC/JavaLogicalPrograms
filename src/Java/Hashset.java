package Java;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

	public static void main(String[] args) {
		
		//HashSet treeset, LinkedHashSet implements set interface
		//does not accept duplicate values
		//There is no guarantee elements stored in sequential order ...... random order
	HashSet hs = new HashSet();
	hs.add("USA");
	hs.add("UK");
	hs.add("AUS");
	hs.add("AUS");
	
	System.out.println(hs.contains("AUS"));
	System.out.println(hs.containsAll(hs));
//	System.out.println(hs.remove("USA"));
	System.out.println(hs);
	System.out.println(hs.size());

	Iterator<String> i = hs.iterator();
	System.out.println(i.next());
	System.out.println(i.next());
	}
}

