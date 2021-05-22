package com.samples;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

	public static boolean checkBST(Node node) {
		boolean isBTS = check(node);

		if (isBTS) {
			System.out.println("YES");
		}

		return isBTS;
	}

	public static boolean check(Node node) {
		List<Integer> items = new ArrayList<Integer>();

		return check(node, items);
	}

	private static boolean check(Node node, List<Integer> items) {
		if ((node.left != null) && !check(node.left, items)) {
			return false;
		}

		int size = items.size();
		if (size > 0 && items.get(size - 1) > node.data) {
			return false;
		}

		items.add(node.data);

		if ((node.right != null) && !check(node.right, items)) {
			return false;
		}

		return true;
	}



	public static boolean checkBST2(Node root) {
        return checkBST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
	public static boolean checkBST2(Node node, int min, int max) {
        if (node == null) return true;
        return  min < node.data && node.data < max &&
            checkBST2(node.left, min, node.data) &&
            checkBST2(node.right, node.data, max);
    }
}
