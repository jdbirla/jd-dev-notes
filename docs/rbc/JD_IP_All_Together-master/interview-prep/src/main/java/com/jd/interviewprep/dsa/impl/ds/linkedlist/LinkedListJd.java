package com.jd.interviewprep.dsa.impl.ds.linkedlist;

public class LinkedListJd {
	 class Node {
	        int value;
	        Node next;

	        Node(int value) {
	            this.value = value;
	        }

	        @Override
	        public String toString() {
	            return "Node{" +
	                    "value=" + value +
	                    ", next=" + next +
	                    '}';
	        }
	    }

	    Node head;
	    Node tail;
	    int length;

	    public LinkedListJd(int value) {
	        Node newNode = new Node(value);
	        head = newNode;
	        tail = newNode;
	        length = 1;
	    }

	    public void printLinkedList() {
	        Node temp = head;
	        System.out.println("\n");
	        while (temp != null) {
	            System.out.print(temp.value + "->");
	            temp = temp.next;
	        }
	        System.out.println("\n");
	    }

	    public void printLinkedList(Node head) {
	        Node temp = head;
	        System.out.println("\n");
	        while (temp != null) {
	            System.out.print(temp.value + "->");
	            temp = temp.next;
	        }
	        System.out.println("\n");
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
	        if (length == 0) return null;
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
	        if (length == 0) return null;
	        Node temp = head;
	        head = head.next;
	        temp.next = null;
	        length--;
	        if (length == 0) {
	            head = null;
	            tail = null;
	        }
	        return temp;

	    }

	    // Find nth element from end of linked list
	    public Node get(int index) {
	        Node temp = head;
	        if (index < 0 || index >= length) return null;
	        for (int i = 0; i < index; i++) {
	            temp = temp.next;
	        }

	        return temp;
	    }

	    public boolean set(int index, int value) {
	        Node node = get(index);
	        if (node != null) {
	            node.value = value;
	            return true;
	        }
	        return false;
	    }

	    public Node remove(int index) {
	        if (index < 0 || index >= length) return null;

	        if (index == 0) {
	            return removeFirst();
	        }
	        if (index == length - 1) {
	            return removeLast();
	        }

	        Node pre = get(index - 1);
	        Node temp = pre.next;
	        pre.next = temp.next;
	        temp.next = null;
	        length--;
	        return temp;
	    }

	    public boolean insert(int index, int value) {
	        if (index < 0 || index > length) return false;

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

	    // How to reverse linked list in java.
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

	    //How to find middle element of linked list.
	    public Node getMiddleNode() {
	        Node slowPointer, fastPointer;
	        slowPointer = fastPointer = head;
	        while (fastPointer != null) {
	            fastPointer = fastPointer.next;
	            if (fastPointer != null && fastPointer.next != null) {
	                slowPointer = slowPointer.next;
	                fastPointer = fastPointer.next;
	            }
	        }
	        return slowPointer;
	    }

	    //Java program to reverse linked list in pairs
	//Lets understand with the help of simple example:
//	    Lets say linkedlist is 5-> 6 -> 7 -> 1
//	    If you look closely, below steps are just reversing link to  6->5->7->1 in first iteration (Swapping node 6 and 5) and then advance to next pair (Node 7 and 1)
	    public Node reverseLinkedListInPairItr() {

	        Node current = head;
	        Node temp = null;
	        Node newHead = null;
	        while (current != null && current.next != null) {

	            if (temp != null) {
	                // This is important step
	                temp.next.next = current.next;
	            }
	            temp = current.next;
	            current.next = temp.next;
	            temp.next = current;

	            if (newHead == null)
	                newHead = temp;
	            current = current.next;

	        }
	        return newHead;
	    }

	    public static void main(String[] args) {
	        LinkedListJd ll = new LinkedListJd(5);
	        ll.append(10);
	        ll.append(15);
	        ll.append(20);
	        ll.printLinkedList();
	        Node result = ll.reverseLinkedListInPairItr();
	        System.out.println("After reversing in pair");
	        ll.printLinkedList(result);

	    }
}
