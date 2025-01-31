package com.jd.interviewprep.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class FailFastList {

	public static void main(String[] args) {

	/*	List<String> list = new ArrayList<>();
		list.add("a");
		list.add("b");

		// If we are using single threaded environment then iterator.remove() method
		// works perfectly fine for removing item from list.
		Iterator<String> iterator = list.iterator();

		while (iterator.hasNext()) {
			if (iterator.next() == "a")
				iterator.remove();
			System.out.println(iterator.next());

		} */
		
		// If we are using even single threaded environment then list.remove(obj) method
		// is not working
		// and throwing java.util.ConcurrentModificationException
		
/*		List<String> list1 = new ArrayList<>();
		list1.add("a");
		list1.add("b");

		Iterator<String> iterator1 = list1.iterator();

		while (iterator1.hasNext()) {
			list1.remove("b");

			System.out.println(iterator1.next());

		}
		*/

		// Problemm 1: Iterator and ListIterator both are throwing the
		// concurrentmodificationException while adding

		List<String> list2 = new ArrayList<>();
		list2.add("a");
		list2.add("b");
		
		Iterator<String> iterator2 = list2.iterator();

		while (iterator2.hasNext()) {
			String element = iterator2.next();
			System.out.println(element);
			list2.add("c");

		}
		

		List<String> list3 = new ArrayList<>();
		list3.add("a");
		list3.add("b");
		ListIterator<String> iterator3 = list3.listIterator();

		while (iterator3.hasNext()) {
			String element = iterator3.next();
			System.out.println(element);

			list3.add("c");

		}
		// --------------------------------------------------------------------
		/*
		 * System.out.println("CopyOnWriteArrayList"); List<String> list1 = new
		 * CopyOnWriteArrayList<>(); list1.add("a"); list1.add("b");
		 * 
		 * Iterator<String> iterator1 = list1.iterator();
		 * 
		 * while (iterator1.hasNext()) { String element = iterator1.next();
		 * list1.add("c"); System.out.println(element); } System.out.println(list1);
		 */
	}
}
