package daleHmwk;

import java.util.Stack;

public class LeafCountProgram {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.insert(10);
		tree.insert(23);
		tree.insert(11);
		tree.insert(43);
		tree.insert(65);
		tree.insert(21);
		tree.insert(86);
		tree.insert(87);
		tree.insert(50);
		tree.insert(25);
		
		System.out.println("This tree has "+ leafCount1(tree)+ " leaves.");
		System.out.println("This tree has "+ leafCount2(tree)+ " leaves.");

	}

	public static <T> int leafCount1(BinaryTree tree) {
		//iteratively find the number of leaves
		if (tree == null) {
	        return 0; // no leaves if the tree is empty
	    }

	    int leaves = 0;
	    Stack<BNode> stack = new Stack<>();
	    stack.push(tree.getRoot()); // start with the root node

	    while (!stack.isEmpty()) {
	        BNode node = stack.pop(); // pop the top node

	        // if the node is a leaf, add one to count
	        if (node.getLC() == null && node.getRC() == null) {
	            leaves++;
	        }

	        // push children onto stack
	        if (node.getRC() != null) {
	            stack.push(node.getRC());
	        }
	        if (node.getLC() != null) {
	            stack.push(node.getLC());
	        }
	    }

	    return leaves;
	}
	
	public static int leafCount2(BinaryTree tree) {
		//recursive approach
	    if (tree == null || tree.getRoot() == null) {
	        return 0; // no leaves if the tree is empty
	    }
	    return leafCountRec(tree.getRoot()); // call the recursive method
	}

	private static int leafCountRec(BNode node) {
		//getsd a node and returns 1 if 1 if it's a leaf- gets added once  all the recusive calls are done
	    if (node == null) {
	        return 0;//base case
	    }
	    if (node.getLC() == null && node.getRC() == null) {
	        return 1; // current node is a leaf
	    }
	    return leafCountRec(node.getLC()) + leafCountRec(node.getRC()); // sum of leaf counts in both subtrees
	}

}
