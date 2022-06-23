package chap09.exam04.hashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Test {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("kim", 23);
		map.put("lee", 26);
		map.put("park", 26);
		map.put("kim", 30);
		
		Set<String> keySet = map.keySet();
		Iterator<String> iter = keySet.iterator();
		while(iter.hasNext()) {
		String key	= iter.next();
		int value = map.get(key);
		System.out.println(key + ":" + value);
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> entry = entrySet.iterator();
		while (entry.hasNext()) {
		Entry<String, Integer> item	= entry.next();
		String key = item.getKey();
		int value = item.getValue();
		System.out.println(key + ":" + value);
		}
		
		for (String key : map.keySet()) {
			System.out.println(key + ":" + map.get(key));
		}
	}

}
