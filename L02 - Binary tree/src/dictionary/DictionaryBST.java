package dictionary;

public class DictionaryBST<K extends Comparable<K>, V> implements
Dictionary<K, V> {

	private Node root;

	public DictionaryBST() {
		root = null;
	}

	/**
	 * Returner værdien hørende til nøglen k. Returner null, hvis nøglen k ikke er i dictionary.
	 *            noeglen elementet skal findes til
	 */
	@Override
	public V get(K key) {
		Node current = root;
		while (current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				return current.value;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		return null;
	}

	private Node find(K key) {
		Node current = root;
		boolean found = false;
		while (!found && current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				found = true;
			} else if (d > 0) {
				current = current.left;
			} else {
				current = current.right;
			}
		}
		if (found) {
			return current;
		} else {
			return null;
		}

	}

	@Override
	public boolean isEmpty() {
		if (root == null) {
			return true;
		}
		return false;
	}

	/**
	 * Indsættet parret (nøgle, værdi) i dictionary med k som nøgle og v som
	 * værdi.
	 * Returner den gamle værdi, hvis nøglen k i forvejen var i dictionary.
	 * Hvis ikke, returneres null.
	 * Hverken nøglen k eller værdien v kan være null.
	 *            noeglen objektet skal indsaettes med
	 *            objektet der skal indsaettes
	 */
	@Override
	public V put(K key, V value) {
		if (root == null) {
			root = new Node(key, value);
			return null;
		}

		Node current = root;
		Node parent = null;

		while (current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				V old = current.value;
				current.value = value;
				return old;
            } else if (d < 0) {
				parent = current;
				current = current.left;
			} else if (d > 0) {
				parent = current;
				current = current.right;
			}

			Node newNode = new Node(key, value);
			if (key.compareTo(parent.key) < 0) {
				parent.left = newNode;
			} else {
				parent.right = newNode;
			}
		}
		return null;
	}

	/**
	 * Fjerner (nøgle, værdi)-parret med nøgle k fra dictionary.
	 * Returnerer værdien hørende til nøglen, hvis nøglen var I dictionary.
	 * Hvis ikke returneres null.
	 *            noeglen der med tilhoerende objekt skal fjernes
	 *            (tror ikke den er rigtig)
	 */
	@Override
	public V remove(K key) {
		if (root == null) {
			return null;
		}

		Node current = root;
		Node parent = null;

		while (current != null) {
			int d = current.key.compareTo(key);
			if (d == 0) {
				V old = current.value;
				current.value = null;
				return old;
			} else if (d < 0) {
				parent = current;
				current = current.left;
			} else if (d > 0) {
				parent = current;
				current = current.right;
			}


			if (key.compareTo(parent.key) < 0) {
				parent.left = null;
			} else {
				parent.right = null;
			}
		}
		return null;
	}

	/**
	 * Returnerer antallet af (nøgle,værdi)-par.
	 *
	 */
	@Override
	public int size() {
		return size(root);
	}

	private int size(Node current) {
		if (root == null) {
			return 0;
		} else {
			return size(root.left) + 1 + size(root.right);
		}
	}

	private class Node {
		private K key;
		private V value;
		private Node left;
		private Node right;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}


	}

}
