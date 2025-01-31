package com.jd.interviewprep.dsa.howtouse;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class QueueDemo {
    public static void main(String[] args) {
        // Create a Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        // Insert an element (Enqueue)
        int newValue = 60;
        queue.add(newValue);

        // Remove an element (Dequeue)
        int removedValue = queue.poll();

        // Sort the Queue
        Queue<Integer> sortedQueue = sortQueue(queue);

        // Search for an element
        int searchValue = 30;
        int foundIndex = searchQueue(sortedQueue, searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the Queue.");
        }

        // Update an element (Replace)
        int updateIndex = 1;
        int updatedValue = 25;
        queue.remove();
        queue.add(updatedValue);

        // Print the Queue
        System.out.println("Queue after all operations: " + queue);
    }

    // Sort the Queue using a temporary LinkedList
    public static Queue<Integer> sortQueue(Queue<Integer> queue) {
        LinkedList<Integer> tempList = new LinkedList<>(queue);
        Collections.sort(tempList);
        return tempList;
    }

    // Search for an element in the Queue
    public static int searchQueue(Queue<Integer> queue, int value) {
        int index = 0;
        for (int element : queue) {
            if (element == value) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
