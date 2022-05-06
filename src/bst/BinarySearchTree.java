package bst;

import java.util.Stack;

public class BinarySearchTree<T extends Comparable<T>> {

	private static class BSTNode<T extends Comparable<T>> {
		private T data;
		private BSTNode<T> leftChild;
		private BSTNode<T> rightChild;

		public BSTNode(T data) {
			this.data = data;
		}

		@Override
		public String toString() {
			return this.data.toString();
		}
	}

	private BSTNode<T> root;

	public void insert(T data) {
		this.root = this.recursiveInsert(this.root, data);
	}

	private BSTNode<T> recursiveInsert(BSTNode<T> node, T data) {
		if (node == null) {
			return new BSTNode<T>(data);
		}
		if (data.compareTo(node.data) < 0) {
			node.leftChild = this.recursiveInsert(node.leftChild, data);
		} else if (data.compareTo(node.data) > 0) {
			node.rightChild = this.recursiveInsert(node.rightChild, data);
		}
		return node;
	}

	public void delete(T data) {
		this.root = this.recursiveDelete(this.root, data);
	}

	private BSTNode<T> recursiveDelete(BSTNode<T> node, T data) {
		if (node == null) {
			return node;
		}
		if (data.compareTo(node.data) < 0) {
			node.leftChild = this.recursiveDelete(node.leftChild, data);
		} else if (data.compareTo(node.data) > 0) {
			node.rightChild = this.recursiveDelete(node.rightChild, data);
		} else {// we found the node to delete
			if (node.leftChild == null && node.rightChild == null) {
				return null;
			} else if (node.leftChild == null) {
				return node.rightChild;
			} else if (node.rightChild == null) {
				return node.leftChild;
			} else {// Still need to handle the case with two children
				BSTNode<T> predecessor = this.getMax(node.leftChild);
				T d = predecessor.data;
				node.data = d;// update data at node
				// remove predecessor node
				node.leftChild = this.recursiveDelete(node.leftChild, d);
			}
		}
		return node;
	}

	// assumes root is not null
	public BSTNode<T> getMax(BSTNode<T> node) {
		while (node.rightChild != null) {
			node = node.rightChild;
		}
		return node;
	}

	// assumes root is not null
	public BSTNode<T> getMin(BSTNode<T> node) {
		while (node.leftChild != null) {
			node = node.leftChild;
		}
		return node;
	}

	public boolean contains(T data) {
		return this.find(data) != null;
	}

	public BSTNode<T> find(T key) {
		return this.recursiveFind(this.root, key);
	}

	private BSTNode<T> recursiveFind(BSTNode<T> node, T key) {
		// base case, made it to the end or I found it
		if (node == null || key.equals(node.data)) {
			return node;
		}
		if (key.compareTo(node.data) < 0) {
			return this.recursiveFind(node.leftChild, key);
		}
		return this.recursiveFind(node.rightChild, key);

	}

	// Traverse the tree in an preorder fashion
	// Print the current node first and then recurse on the children
	public void preOrder() {
<<<<<<< HEAD
		System.out.println("PreOrder test commit");
		preOrderRecurse(root); 
=======
		this.preOrderRecurse(this.root);
>>>>>>> 5cdaac2 (updated traversal code)
	}

	private void preOrderRecurse(BSTNode<T> node) {
<<<<<<< HEAD
		if(node == null) return;
		System.out.println(node.data);
		preOrderRecurse(node.leftChild);
		preOrderRecurse(node.rightChild);
=======

>>>>>>> 5cdaac2 (updated traversal code)
	}

	// Traverse the tree in an preorder fashion but using a stack
	// Print the current node first and then recurse on the children
	public void preOrderStack() {
		Stack<BSTNode<T>> pre = new Stack<BSTNode<T>>();
<<<<<<< HEAD
		if(root == null) {
			return;
		}
		pre.add(root);
		while(!pre.isEmpty()) {
			BSTNode<T> node = pre.pop();
			if(node == null) {
				continue;
			}
			System.out.println(node.data);
			if(node.rightChild != null) {
				pre.add(node.rightChild);
			}
			if(node.leftChild != null) {
				pre.add(node.leftChild);
			}
		}
	}	
=======

	}
>>>>>>> 8389ce33cd9c02f91f98f6897f986335d31c63f4

	// Traverse the tree in an inorder fashion
	// Recursively print the left side of the current node, then the current node,
	// then recursively print the right side of current node
	// For a bst this will print the values in sorted order from smallest to largest
	public void inOrder() {
		this.inOrderRecurse(this.root);
	}

	public void inOrderRecurse(BSTNode<T> node) {

	}

	// Traverse the tree in an inorder fashion but using a stack
	public void inOrderStack() {
		Stack<BSTNode<T>> in = new Stack<BSTNode<T>>();

	}

	// Traverse the tree in an postorder fashion
	// Recurse on the children and then print the value in the current node
	public void postOrder() {
		this.postOrderRecurse(this.root);
		System.out.println("PostOrder test commit");
	}

	public void postOrderRecurse(BSTNode<T> node) {

	}

	// Traverse the tree in an postorder fashion uses Stacks.
	// This is more difficult than the other traversals using a Stack
	// I suggest using two stacks. Think about the order you want the elements
	// to appear on the stack you will print.
	public void postOrderStack() {
		Stack<BSTNode<T>> post = new Stack<>();
		Stack<BSTNode<T>> postHelper = new Stack<>();
		if (this.root != null) {
			postHelper.push(this.root);
			while (!postHelper.isEmpty()) {
				// how should post and postHelper be updated?
			}

			while (!post.isEmpty()) {
				BSTNode<T> node = post.pop();
				System.out.print(node + " ");
			}
		}

	}

	@Override
	public String toString() {
		return this.recursiveToString(this.root, "");
	}

	private String recursiveToString(BSTNode<T> node, String indent) {

		if (node == null) {
			return "";
		}
		return this.recursiveToString(node.rightChild, indent + "    ") + "\n" + indent + node.data
				+ this.recursiveToString(node.leftChild, indent + "    ");
	}

	public static void main(String[] args) {
		// Test Tree
		BinarySearchTree<Integer> bst = new BinarySearchTree<>();
		bst.insert(9);
		bst.insert(7);
		bst.insert(11);
		bst.insert(2);
		bst.insert(8);
		bst.insert(15);
		bst.insert(10);
		bst.insert(3);
		System.out.println(bst);

		System.out.println("In Order Traversals");
		bst.inOrder();
		System.out.println();
		bst.inOrderStack();
		System.out.println();
		System.out.println("Pre Order Traversals");
		bst.preOrder();
		System.out.println();
		bst.preOrderStack();
		System.out.println();
		System.out.println("Post Order Traversals");
		bst.postOrder();
		System.out.println();
		bst.postOrderStack();

	}

}
