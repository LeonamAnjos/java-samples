package com.samples;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

	@Test
	void checkBST_whenCase1() {
		Node root = buildTree(new int[] { 1, 2, 3, 4, 5, 6, 7 });
		boolean check = BinarySearchTree.checkBST(root);
		assertTrue(check);
	}

	@Test
	void checkBST_whenCase2() {
		Node root = buildTree(new int[] { 1, 2, 4, 3, 5, 6, 7 });
		boolean check = BinarySearchTree.checkBST(root);
		assertFalse(check);
	}

	@Test
	void checkBST_whenCase3() {
		Node root = buildTree(new int[] { 3, 5, 7, 9, 11, 13, 15 });
		boolean check = BinarySearchTree.checkBST(root);
		assertTrue(check);
	}

	private Node buildTree(int[] items) {
		if (items.length != 7)
			throw new RuntimeException("Only arrays with 7 positions are allowed to build a Tree");

		Node root = new Node(items[3]);
		root.left = new Node(items[1]);
		root.left.left  = new Node(items[0]);
		root.left.right = new Node(items[2]);

		root.right = new Node(items[5]);
		root.right.left = new Node(items[4]);
		root.right.right= new Node(items[6]);

		return root;
	}

}
