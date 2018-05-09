package com.cuiwei.collection;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapTest {

	public static void main(String[] args) {
		SortedMap<Province,String> testMap = new TreeMap<Province,String>();
		testMap.put(new Province("四川省", 23), "四川省");
		testMap.put(new Province("云南省", 3), "云南省");
		testMap.put(new Province("湖南省", 2), "湖南省");
		testMap.put(new Province("陕西省", 123), "陕西省");
		testMap.put(new Province("山西省", 5), "山西省");
		testMap.put(new Province("浙江省", 65), "浙江省");
		testMap.put(new Province("新疆省", 34), "新疆省");
		
		Set<Entry<Province,String>> set = testMap.entrySet();
		Iterator<Entry<Province,String>> it = set.iterator();
		while(it.hasNext()){
			Entry<Province,String> entry = it.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
class Province implements Comparable<Province>{
	String name;
	int population;
	Province(String name,int population){
		this.name = name;
		this.population = population;
	}
	
	public String toString(){
		return name + ":" + population;
	}
	
	public int compareTo(Province other){
//		if(this.population > other.population){
//			return 1;
//		}else if(this.population < other.population){
//			return -1;
//		}else{
//			return 0;
//		}
		return this.population - other.population;
	}
}
