package project;

public class BST<T> {
	BSTNode<T> root, current;

	/** Creates a new instance of BST */
	public BST() {
		root = current = null;
	}

	public boolean empty() {
		return root == null;
	}

	public boolean full() {
		return false;
	}

	public T retrieve() {
		return current.data;
	}

	public boolean findkey(String tkey) {
		BSTNode<T> p = root, q = root;

		if (empty())
			return false;

		while (p != null) {
			q = p;
			if (p.key .equals(tkey) ) {
				current = p;
				return true;
			} else if (tkey.charAt(0) < p.key.charAt(0))
				p = p.left;
			else
				p = p.right;
		}

		current = q;
		return false;
	}

	public boolean insert(String k, T val) {
		BSTNode<T> p, q = current;

		if (findkey(k)) {
			current = q;
			return false;
		}

		p = new BSTNode<T>(k, val);
		if (empty()) {
			root = current = p;
			return true;
		} else {

			if (k.charAt(0) < current.key.charAt(0))
				current.left = p;
			else
				current.right = p;
			current = p;
			return true;
		}
	}

}
