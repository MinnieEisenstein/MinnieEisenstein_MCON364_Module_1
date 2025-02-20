package binarySearchTrees;

import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
    private BNode<T> root;
    public BNode<T> getRoot() {
		return root;
	}

	public void setRoot(BNode<T> root) {
		this.root = root;
	}

	private boolean found; // used by remove methods

    public BinaryTree() {
       root = null; // empty tree
       found = false; 
        
    }

    public boolean insert(T data) {
        BNode<T> curr = root;
        BNode<T> parent = root;
        BNode<T> newNode;
        // iterative approach to inserting data
        if (root == null) {
            // nothing in tree yet
            root = new BNode<T>(data);
        } else {
            while (curr != null) {
                if (data.compareTo(curr.getData()) < 0) {
                    // data is less than data in current Node
                    // go down left branch
                    parent = curr;
                    curr = curr.getLC();
                } else if (data.compareTo(curr.getData()) > 0) {
                    // data is greater than data in current Node
                    // go down right branch
                    parent = curr;
                    curr = curr.getRC();
                } else {
                    return false; // duplicate value
                }
            }
            // found the right place
            newNode = new BNode<T>(data);
            // should it be a left child or a right child?
            if (newNode.compareTo(parent) < 0) {
                parent.setLC(newNode);
            } else {
                parent.setRC(newNode);
            }
        }
        return true;
    }

    // Recursive in-order traversal method
    public void inOrderTraversal() {
        inOrderTraversal(root);
    }

    private void inOrderTraversal(BNode<T> node) {
        if (node != null) {
            inOrderTraversal(node.getLC()); // Traverse left subtree
            System.out.print(node.getData() + " "); // Visit node
            inOrderTraversal(node.getRC()); // Traverse right subtree
        }
    }
    
    public void InOrderTraverseIterative(){
		//using iterative approach
		//iterative inOrder traversal of the BST   notice how much more complicated it is
		//we maintain our own Stack in order to be able to retrace our steps
		Stack<BNode<T>> stack = new Stack<BNode<T>>();
		BNode<T> tree;   //sub tree of the binary tree
		if (root == null) System.out.println("\n tree is empty");
       tree = root;
		stack.push(tree);   //put root on the stack
		 //System.out.println( "\npushing " + tree.getData() + "onto the stack");
		while (tree!=null)
			{ //go down the left branch,push the node on to the stack to be revisited
			  tree = tree.getLC();
			  while  (tree != null){
			      stack.push(tree);
				  //System.out.println( "\npushing " + tree.getData() + "onto the stack");
				  tree = tree.getLC();
			  	  }
			  //made it all the way down the leftmost branch
			  //pop the last node off the stack
			  if (!stack.empty()){
			   tree = stack.pop();
		       //System.out.println("\npopped " + tree.getData() + "off the stack");
		       System.out.println(    tree.getData());   //display the value at the current node
			  
			  }
			 
			  tree = tree.getRC();  //now start down the right branch of that node
			  if (tree != null) stack.push(tree);  //has a right branch so push it on the stack
			  else {     //we are done processing this node, took care of left and right branches
				  while (!stack.empty() && tree == null) {
				     	 tree = stack.pop();  //get next node to complete processing
			             System.out.println(tree.getData());   //complete left branch, now write out the data
					     //System.out.println( "\npopped " + tree.getData() + "off the stack");
					     tree = tree.getRC();  //visit the right branch of this node
					   
				  }
				  if (tree != null) stack.push(tree);   //push the right branch node onto the stack
			  }
			 
			    
			} //end outer while   
		}

    // Find method
    public boolean find(T data) {
        BNode<T> curNode = root;
        boolean found = false;
        if (root == null) {
            return false;
        }
        while (!found && curNode != null) {
            if (data.compareTo(curNode.getData()) < 0) {
                curNode = curNode.getLC();
            } else if (data.compareTo(curNode.getData()) > 0) {
                curNode = curNode.getRC();
            } else {
                return true;
            }
        }
        return false;
    }

    
 // Recursive find method
    public boolean findRecur(T data) {
        return findRecur(data, root);
    }


    private boolean findRecur(T data, BNode<T> curNode) {
        // anchor case 1: curNode is null
        if (curNode == null) {
            return false; // you did not find the node
        }


        // anchor case 2: you found the data
        if (curNode.getData().compareTo(data) == 0) {
            return true;
        }


        // otherwise, continue searching
        if (curNode.getData().compareTo(data) < 0) {
            return findRecur(data, curNode.getRC());
        } else {
            return findRecur(data, curNode.getLC());
        }
    }

    public boolean removeVal(T value) { // 1
        // to remove a value must start searching for it at the root
        root = removeNode(value, root); // 2
        return found; // return value in instance variable set by private method // 3
    } // 4

    private BNode<T> removeNode(T value, BNode<T> tree) { // 5
        // looks for value in the subtree
        if (tree == null) // 6
            found = false; // 7
        else if (value.compareTo(tree.getData()) < 0) // 8
            // recursive call further down the left side of tree
            // might have to reset links if a node further down
            // is set to null
            tree.setLC(removeNode(value, tree.getLC())); // 9
        else if (value.compareTo(tree.getData()) > 0) // 10
            // recursive call further down the right side of the tree
            // might have to reset links if a node further down
            // is set to null
            tree.setRC(removeNode(value, tree.getRC())); // 11
        else { // found the value, now remove that data from
            // the tree
            tree = removeData(tree); // 12
            found = true; // 13
        } // 14
        return tree; // 15
    } // 16

    private BNode<T> removeData(BNode<T> tree) { // 17
        // case 1 and 2: subtree just has one child branch so return that
        // branch and link that branch to previous
        // part of tree, basically eliminating the BNode
        // in which the data was found
        if (tree.getLC() == null) // 18
            return tree.getRC(); // 19
        else if (tree.getRC() == null) // 20
            return tree.getLC(); // 21
        else { // data is in a BNode that has two children.
            // It is too complicated to remove this type of Node
            // Instead do the following:
            // a. Replace the data in that BNode with data that
            // logically precedes that data - this data will be found in
            // a leaf BNode
            // b. eliminate the leaf BNode by reinvoking the
            // removeNode() method
            T data = findPredecessor(tree.getLC()); // 22
            tree.setData(data); // 23
            tree.setLC(removeNode(data, tree.getLC())); // 24
            return tree; // 25
        } // 26
    } // 27

    private T findPredecessor(BNode<T> tree) { // 28
        // the Node that contains data that precedes a Node
        // can be found by going down till one hits the right most leaf
        // of its left branch
        while (tree.getRC() != null) { // 29
            tree = tree.getRC(); // 30
        } // 31
        return tree.getData(); // 32
    } // 33
    
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.insert(100);
        tree.insert(50);
        tree.insert(500);
        tree.insert(25);
        tree.insert(80);
        tree.insert(40);
        tree.insert(70);
        tree.insert(250);
        tree.insert(700);
        tree.insert(600);

        System.out.println("In-order traversal:");
        tree.inOrderTraversal();
        tree.InOrderTraverseIterative();
        System.out.println("\nFind 70: " + tree.findRecur(100)); // Should return true
        System.out.println("Find 90: " + tree.findRecur(90)); // Should return false
        System.out.println("Remove 500: Expect TRUE :  " + tree.removeVal(600));
        System.out.println("Remove 800: EXPECT FALSE : " + tree.removeVal(800));
    
    }
}

