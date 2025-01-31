package com.jd.interviewprep.java8;

import java.util.HashMap;
import java.util.Map;

public class AlphanumericFilterExample {
	public static void main(String[] args) {
		Map<String,String> map =new HashMap<>();
		String e1 = new String("AJAY");
		String e2 = new String("AJAY");
		String e3 = new String("AJAY");
		
		System.out.println(e1.hashCode()+" : "+e2.hashCode()+" : "+e3.hashCode());
		System.out.println(e1==e2);

		map.put(e1,"I");
		map.put(e2,"M2");
		System.out.println(map.get(e1));
		System.out.println(map.get(e2));
}
}
