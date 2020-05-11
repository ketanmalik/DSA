
public class Driver {

	public static void main(String args[]) {
		BST<Integer> bst = new BST<Integer>();

		bst.add(11);
		bst.add(6);
		bst.add(15);
		bst.add(3);
		bst.add(8);
		bst.add(13);
		bst.add(17);
		bst.add(1);
		bst.add(5);
		bst.add(12);
		bst.add(14);
		bst.add(19);

		bst.inorder();
		bst.preorder();
		bst.postorder();
		bst.levelorder();
	}
}
