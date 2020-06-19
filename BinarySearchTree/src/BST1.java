class BST1<T extends Comparable<T>> {
	private class Node<T> {
		Node<T> left, right;
		T value;

		Node(T value) {
			this.value = value;
			left = null;
			right = null;
		}

		@Override
		public String toString() {
			return this.value.toString();
		}
	}

	private Node<T> root;
	private Node<T> parent;
	private int size;

	BST1() {
		this.root = null;
		this.parent = null;
		this.size = 0;
	}

	public void add(T value) {
		if (value == null)
			throw new IllegalArgumentException();
		Node<T> node = new Node<>(value);
		if (root == null) {
			root = node;
			return;
		}
		addRec(this.root, node);
		this.size += 1;
	}

	private void addRec(Node<T> parent, Node<T> node) {
		int diff = compare(node.value, parent.value);
		if (diff > 0) {
			if (parent.right == null) {
				parent.right = node;
				return;
			}
			parent = parent.right;
			addRec(parent, node);
		} else if (diff < 0) {
			if (parent.left == null) {
				parent.left = node;
				return;
			}
			parent = parent.left;
			addRec(parent, node);
		} else {

		}

	}

	private int compare(T val1, T val2) {
		return val1.compareTo(val2);
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public Node<T> findNode(Node<T> parent, T value) {
		if (parent == null) {
			System.out.println("Node does not exist");
			return null;
		}
		if (parent.left != null) {
			if (compare(value, parent.left.value) == 0)
				return parent.left;
		}

		return parent.right;
	}

	public Node<T> findParent(T value) {
		return findParentRec(root, value);
	}

	private Node<T> findParentRec(Node<T> root, T value) {
		if (root == null) {
			System.out.println("Node does not exist");
			return null;
		}

		parent = root;
		if (parent.right != null) {
			if (compare(parent.right.value, value) == 0)
				return parent;
		}
		if (parent.left != null) {
			if (compare(parent.left.value, value) == 0)
				return parent;
		}

		int diff = compare(value, parent.value);
		if (diff > 0) {
			parent = parent.right;
			findParentRec(parent, value);
		} else if (diff < 0) {
			parent = parent.left;
			findParentRec(parent, value);
		} else {

		}

		return parent;
	}

	private Node<T> findSuccessor(Node<T> node) {
		if (node == null)
			return null;
		Node<T> successor = node;
		while (true) {
			node = node.right;
			if (node == null)
				break;
			successor = node;
		}
		return successor;
	}

	public void remove(T value) {
		if (value == null)
			throw new NullPointerException();
		parent = findParent(value);
		if (parent == null)
			return;
		Node<T> node = findNode(parent, value);
		if (node == null)
			return;
		removeNode(parent, node);
		this.size -= 1;
	}

	private void removeNode(Node<T> parent, Node<T> node) {
		int leftDiff = -1;
		if (parent.left != null) {
			leftDiff = compare(node.value, parent.left.value);
		}
		int rightDiff = -1;
		if (parent.right != null) {
			rightDiff = compare(node.value, parent.right.value);
		}
		// Leaf Node
		if (node.left == null && node.right == null) {
			node.value = null;
			node = null;
			if (leftDiff == 0)
				parent.left = null;

			else
				parent.right = null;
		}

		// Only left node present
		else if (node.left != null && node.right == null) {
			if (leftDiff == 0) {
				parent.left = node.left;
			} else if (rightDiff == 0) {
				parent.right = node.left;
			}
			node.value = null;
			node.left = null;
			node = null;
		}

		// Only right node present
		else if (node.left == null && node.right != null) {
			if (leftDiff == 0) {
				parent.left = node.right;
			} else if (rightDiff == 0) {
				parent.right = node.right;
			}
			node.value = null;
			node.left = null;
			node = null;
		}

		// Both left and right node present
		else {
			Node<T> successor = findSuccessor(node.left);
			Node<T> p = findParent(successor.value);
			node.value = successor.value;
			removeNode(p, successor);

		}
		System.out.println();
	}

	public int size() {
		return this.size;
	}

}