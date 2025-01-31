package com.jd.interviewprep.dsa.impl.ds.binarysearchtree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(45);
        bst.insert(20);
        bst.insert(10);
        bst.insert(21);
        bst.insert(50);
        bst.insert(49);
        System.out.println(bst.root);
        System.out.println(bst.root.left.value);
        System.out.println(bst.root.left.right.value);

        System.out.println(bst.contains(10));
        System.out.println(bst.contains(22));

    }
}
