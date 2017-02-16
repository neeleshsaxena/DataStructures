
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class SortingAHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map = new HashMap<>();
		
		Map<String,Integer> intMap = new HashMap<>();
		
		map.put("JDK 1.1.4", "Sparkler"); 
		map.put("J2SE 1.2", "Playground");
		map.put("J2SE 1.3", "Kestrel");
		map.put("J2SE 1.4", "Merlin"); 
		map.put("J2SE 5.0", "Tiger");
		map.put("Java SE 6", "Mustang"); 
		map.put("Java SE 7", "Dolphin");
		
		/*map.put("s", "Sparkler"); 
		map.put("t", "Playground");
		map.put("p", "Kestrel");
		map.put("g", "Merlin"); 
		map.put("h", "Tiger");
		map.put("w", "Mustang"); 
		map.put("a", "Dolphin");*/

		intMap.put("JDK 1.1.4", 129); 
		intMap.put("J2SE 1.2", 876);
		intMap.put("J2SE 1.3", 98676);
		intMap.put("J2SE 1.4", 23); 
		intMap.put("J2SE 5.0", 1213);
		intMap.put("Java SE 6", 57567); 
		intMap.put("Java SE 7", 22);
		
		//Sorting based on the keys
		//just insert the hashmap into a treemap
		//tree map will sort the objects based on the keys
		Map<String,String> treeMap = new TreeMap<>(map);
		System.out.println("Sorted according to the keys");
		for(String key: treeMap.keySet()){
			System.out.println(key + " ==> "+ treeMap.get(key));
		}
		
		
		//for integer map
		Map<String,Integer> intTreeMap = new TreeMap<>(intMap);
		System.out.println("Integer map Sorted according to the keys");
		for(String key: intTreeMap.keySet()){
			System.out.println(key + " ==> "+ intTreeMap.get(key));
		}
		
		System.out.println("*********************************************");
		
		//sorting based on the values
		//design your comparator
		//if you want to put the values back into a map, then use a linkedHashMap, as 
		//it will maintain the order in which the entries are added
		
		List<Map.Entry<String,String>> list = new ArrayList<>(map.entrySet());
		
		List<Map.Entry<String,Integer>> intList = new ArrayList<>(intMap.entrySet());
		
		Comparator<Map.Entry<String,String>> comp = new Comparator<Map.Entry<String,String>>() {

			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// TODO Auto-generated method stub
				String s1 = o1.getValue();
				String s2 = o2.getValue();
				
				int val = s1.compareTo(s2);
				
				return val;
			}
		};
		Comparator<Map.Entry<String, Integer>> compInt = new Comparator<Map.Entry<String,Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
				Integer v1 = o1.getValue();
				Integer v2 = o2.getValue();
				int val = v1.compareTo(v2);
				
				return val;
			}
			
		};
		
		
		
		Collections.sort(list, comp);
		Collections.sort(intList, compInt);
		
		//now insert the list in a linkedHashMap
		
		Map<String,String> linkedHashMap = new LinkedHashMap<>();
		
		for(Map.Entry<String, String> entry: list){
			linkedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		//for integers
		Map<String,Integer> intLinkedHashMap = new LinkedHashMap<>();
		
		for(Map.Entry<String, Integer> entry: intList){
			intLinkedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		
		//iterate on the linkedHashMap
		
		System.out.println("Sorted according to the values");
		for(String key: linkedHashMap.keySet()){
			System.out.println(key + " ==> "+ linkedHashMap.get(key));
		}
		
		System.out.println("Integer map Sorted according to the values");
		for(String key: intLinkedHashMap.keySet()){
			System.out.println(key + " ==> "+ intLinkedHashMap.get(key));
		}
		
	}

}
