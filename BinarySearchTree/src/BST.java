import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * This code contains basic functions for a Binary Search Tree. Along with this, it has has 
 * following traversals: inorder, preorder, postorder, level order
 * */

public class BST<T extends Comparable<T>> {

	// Inner Node class
	private class Node<T> {
		T value;
		Node<T> left, right;

		Node(T value) {
			this.value = value;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return this.value.toString();
		}
	}

	// This is the root of the tree
	private Node<T> root;
	private Node<T> parent;

	BST() {
		root = null;
		parent = null;
	}

	// Helper function to compare two comparable values
	private boolean less(T val1, T val2) {
		return val1.compareTo(val2) <= 0;
	}

	// Helper function to see if tree is empty
	public boolean isEmpty() {
		return this.root == null;
	}

	// Adding a new node in the tree
	public void add(T value) {
		addRec(root, value);
	}

	// Finding the correct place to add the new node, Avg: O(log(n)), Worst:
	// O(log(n))
	private void addRec(Node<T> root, T value) {
		if (root == null) {
			Node<T> node = new Node<T>(value);
			this.root = node;
			return;
		}
		if (less(value, root.value)) {
			if (root.left == null) {
				Node<T> node = new Node<T>(value);
				root.left = node;
			} else {
				addRec(root.left, value);
			}
		} else {
			if (root.right == null) {
				Node<T> node = new Node<T>(value);
				root.right = node;
			} else {
				addRec(root.right, value);
			}
		}
	}

	// Removing a particular node in the tree
	public void remove(T value) {
		if (value == null) {
			System.out.println("Please enter a valid value to delete");
			return;
		}
		Node<T> node = find(root, value, root);
		if (node == null) {
			System.out.println("Node " + value + " is not present in the tree");
			return;
		}
		removeRec(node);
	}

	// Finding the element to be removed, O(n)
	public Node<T> find(Node<T> root, T value, Node<T> parent) {
		Node<T> found = null;
		if (root != null) {
			if (root.value == value) {
				found = root;
				if (this.parent == null)
					this.parent = parent;
			} else {
				if (less(value, root.value)) {
					found = find(root.left, value, root);
				} else {
					found = find(root.right, value, root);
				}
			}
		}
		return found;
	}

	// Removing the found element
	public void removeRec(Node<T> node) {

		// Case 1: Node is a leaf node
		if (node.left == null && node.right == null) {
			node.value = null;

			if (this.parent.left == node) {
				this.parent.left = null;
			} else if (this.parent.right == node) {
				this.parent.right = null;
			}
		}

		// Case 2: Node has left child but no right child
		else if (node.left != null && node.right == null) {
			node.value = null;
			if (this.parent.left == node) {
				this.parent.left = node.left;
			} else if (this.parent.right == node) {
				this.parent.right = node.left;
			}
		}

		// Case 3: Node has right child but no left child
		else if (node.right != null && node.left == null) {
			node.value = null;
			if (this.parent.left == node) {
				this.parent.left = node.right;
			} else if (this.parent.right == node) {
				this.parent.right = node.right;
			}
		}

		// Case 4: Node has both right & left child
		else if (node.left != null && node.right != null) {
			Node<T> leftSuccessor = node.left;
			Node<T> leftSuccessorParent = node;
			while (true) {
				if (leftSuccessor.right != null) {
					leftSuccessorParent = leftSuccessor;
					leftSuccessor = leftSuccessor.right;
				} else
					break;
			}
			node.value = leftSuccessor.value;
			leftSuccessor.value = null;
			leftSuccessorParent.right = null;
		}
		this.parent = null;
	}

	// Inorder traversal
	public void inorder() {
		if (isEmpty())
			return;
		System.out.println("Inorder traversal of the tree:");
		inorderRec(root);
		System.out.println();
		System.out.println();
	}

	// Inorder traversal function, O(n) where n = number of nodes in the tree
	private void inorderRec(Node<T> root) {
		if (root == null)
			return;
		inorderRec(root.left);
		System.out.print(root.value + " ");
		inorderRec(root.right);
	}

	// Preorder traversal
	public void preorder() {
		if (isEmpty())
			return;
		System.out.println("Preorder traversal of the tree:");
		preorderRec(root);
		System.out.println();
		System.out.println();
	}

	// Preorder traversal function, O(n) where n = number of nodes in the tree
	private void preorderRec(Node<T> root) {
		if (root == null)
			return;
		System.out.print(root.value + " ");
		preorderRec(root.left);
		preorderRec(root.right);
	}

	// Postorder traversal
	public void postorder() {
		if (isEmpty())
			return;
		System.out.println("Postorder traversal of the tree:");
		postorderRec(root);
		System.out.println();
		System.out.println();
	}

	// Preorder traversal function, O(n) where n = number of nodes in the tree
	private void postorderRec(Node<T> root) {
		if (root == null)
			return;
		postorderRec(root.left);
		postorderRec(root.right);
		System.out.print(root.value + " ");
	}

	// Levelorder traversal
	public void levelorder() {
		if (isEmpty())
			return;
		Queue<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		System.out.println("Levelorder traversal of the tree:");
		levelorderRec(this.root, queue);
		System.out.println();
		System.out.println();
	}

	// Levelorder traversal function, O(n) where n = number of nodes in the tree
	private void levelorderRec(Node<T> root, Queue<Node<T>> queue) {
		if (root == null)
			return;
		if (root.left != null)
			queue.add(root.left);
		if (root.right != null)
			queue.add(root.right);
		System.out.print(queue.peek() + " ");
		queue.poll();
//		System.out.println(queue.peek().left);
		levelorderRec(queue.peek(), queue);
	}
	
}