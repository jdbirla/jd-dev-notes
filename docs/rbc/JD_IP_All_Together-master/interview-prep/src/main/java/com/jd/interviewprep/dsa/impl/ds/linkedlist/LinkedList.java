package com.jd.interviewprep.dsa.impl.ds.linkedlist;

public class LinkedList {
	private Node head;
	private Node tail;
	private int length;

	class Node {
		int value;
		Node next;

		Node(int value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "Node{" + "value=" + value + ", next=" + next + '}';
		}
	}

	public LinkedList(int value) {
		Node newNode = new Node(value);
		head = newNode;
		tail = newNode;
		length = 1;
	}

	public void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.value + " -> ");
			temp = temp.next;
		}
	}

	public void getHead() {
		if (head == null) {
			System.out.println("Head: null");
		} else {
			System.out.println("Head: " + head.value);
		}
	}

	public void getTail() {
		if (head == null) {
			System.out.println("Tail: null");
		} else {
			System.out.println("Tail: " + tail.value);
		}
	}

	public void getLength() {
		System.out.println("Length: " + length);
	}

	public void append(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		length++;
	}

	public Node removeLast() {
		if (length == 0)
			return null;
		Node temp = head;
		Node pre = head;
		while (temp.next != null) {
			pre = temp;
			temp = temp.next;
		}
		tail = pre;
		tail.next = null;
		length--;
		if (length == 0) {
			head = null;
			tail = null;
		}
		return temp;
	}

	public void prepend(int value) {
		Node newNode = new Node(value);
		if (length == 0) {
			head = newNode;
			tail = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
		length++;
	}

	public Node removeFirst() {
		if (length == 0)
			return null;
		Node temp = head;
		head = head.next;
		temp.next = null;
		length--;
		if (length == 0) {
			tail = null;
		}
		return temp;
	}

	public Node get(int index) {
		if (index < 0 || index >= length)
			return null;
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}

	public boolean set(int index, int value) {
		Node temp = get(index);
		if (temp != null) {
			temp.value = value;
			return true;
		}
		return false;
	}

	public boolean insert(int index, int value) {
		if (index < 0 || index > length)
			return false;
		if (index == 0) {
			prepend(value);
			return true;
		}
		if (index == length) {
			append(value);
			return true;
		}
		Node newNode = new Node(value);
		Node temp = get(index - 1);
		newNode.next = temp.next;
		temp.next = newNode;
		length++;
		return true;
	}

	public Node remove(int index) {
		if (index < 0 || index >= length)
			return null;
		if (index == 0)
			return removeFirst();
		if (index == length - 1)
			return removeLast();

		Node prev = get(index - 1);
		Node temp = prev.next;

		prev.next = temp.next;
		temp.next = null;
		length--;
		return temp;
	}

	public void reverse() {
		Node temp = head;
		head = tail;
		tail = temp;
		Node after = temp.next;
		Node before = null;
		for (int i = 0; i < length; i++) {
			after = temp.next;
			temp.next = before;
			before = temp;
			temp = after;
		}
	}

	public Node findMiddleItem() {
		Node slowerPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.next != null) {
			fastPointer = fastPointer.next.next;
			slowerPointer = slowerPointer.next;
		}
		return slowerPointer;
	}

	public void findCycleinLinkedList() {
		Node slowerPointer = head;
		Node fastPointer = head;
		while (fastPointer != null && fastPointer.next != null && slowerPointer != null) {
			fastPointer = fastPointer.next.next;
			slowerPointer = slowerPointer.next;
			if (slowerPointer == fastPointer) {
				System.out.println("we have a loop here at node " + slowerPointer.value);
				break;
			}
		}

	}

	public static void main(String[] args) {
		/*
		 * New list test LinkedList myLinkedList = new LinkedList(1);
		 * myLinkedList.getHead(); myLinkedList.getTail(); myLinkedList.getLength();
		 * myLinkedList.printList();
		 */
		/*
		 * // Append method test LinkedList myLinkedList = new LinkedList(1);
		 * myLinkedList.append(20); myLinkedList.append(30); myLinkedList.getHead();
		 * myLinkedList.getTail(); myLinkedList.getLength(); myLinkedList.printList();
		 */

		/*
		 * // RemoveLast method test LinkedList myLinkedList = new LinkedList(1);
		 * myLinkedList.append(20); myLinkedList.append(30); myLinkedList.getHead();
		 * myLinkedList.getTail(); myLinkedList.getLength(); myLinkedList.printList();
		 * myLinkedList.removeLast(); myLinkedList.getHead(); myLinkedList.getTail();
		 * myLinkedList.getLength(); myLinkedList.printList();
		 */

		/*
		 * // prepend method test LinkedList myLinkedList = new LinkedList(1);
		 * myLinkedList.getHead(); myLinkedList.getTail(); myLinkedList.getLength();
		 * myLinkedList.printList(); myLinkedList.prepend(5); myLinkedList.getHead();
		 * myLinkedList.getTail(); myLinkedList.getLength(); myLinkedList.printList();
		 */

		/*
		 * // RemoveFirst method test LinkedList myLinkedList = new LinkedList(1);
		 * myLinkedList.append(5); myLinkedList.getHead(); myLinkedList.getTail();
		 * myLinkedList.getLength(); myLinkedList.printList();
		 * myLinkedList.removeFirst(); myLinkedList.getHead(); myLinkedList.getTail();
		 * myLinkedList.getLength(); myLinkedList.printList();
		 */

		/*
		 * // get method test LinkedList myLinkedList = new LinkedList(1);
		 * System.out.println(myLinkedList.get(0));
		 */

		/*
		 * // set method test LinkedList myLinkedList = new LinkedList(1);
		 * System.out.println(myLinkedList.set(1, 5)); myLinkedList.printList();
		 */

		/*
		 * //insert Method test LinkedList myLinkedList = new LinkedList(1);
		 * myLinkedList.append(5); myLinkedList.append(8);
		 * 
		 * myLinkedList.getHead(); myLinkedList.getTail(); myLinkedList.getLength();
		 * myLinkedList.printList(); myLinkedList.insert(1,10); myLinkedList.getHead();
		 * myLinkedList.getTail(); myLinkedList.getLength(); myLinkedList.printList();
		 */

		/*
		 * // remove method test LinkedList myLinkedList = new LinkedList(1);
		 * myLinkedList.append(5); myLinkedList.append(8);
		 * 
		 * myLinkedList.getHead(); myLinkedList.getTail(); myLinkedList.getLength();
		 * myLinkedList.printList(); myLinkedList.remove(1); myLinkedList.getHead();
		 * myLinkedList.getTail(); myLinkedList.getLength(); myLinkedList.printList();
		 */

		// Test reverse method
//        LinkedList myLinkedList = new LinkedList(1);
//        myLinkedList.append(5);
//        myLinkedList.append(8);
//        myLinkedList.reverse();
//        myLinkedList.printList();

		// find middle node
//		LinkedList myLinkedList = new LinkedList(10);
//		myLinkedList.append(20);
//		myLinkedList.append(30);
//		myLinkedList.append(40);
//		// myLinkedList.append(50);
//		// myLinkedList.printList();
//		Node findMiddleItem = myLinkedList.findMiddleItem();
//		System.out.println(findMiddleItem.value);

		// find cycle in linkedlist
		LinkedList myLinkedList = new LinkedList(10);
		myLinkedList.append(20);
		myLinkedList.append(30);
		myLinkedList.append(40);
		myLinkedList.append(50);

		myLinkedList.head.next.next.next = myLinkedList.head.next;
		myLinkedList.findCycleinLinkedList();

	}

}
