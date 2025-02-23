import java.util.NoSuchElementException;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;

    private class Node {
        private Key key;
        private Value value;
        private Node left, right;
        private int size;

        public Node(Key key, Value value, int size) {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    // Mengembalikan jumlah node dalam subtree
    public int size() {
        return size(root);
    }

    private int size(Node x) {
        if (x == null) return 0;
        return x.size;
    }

    // Mengecek apakah BST kosong
    public boolean isEmpty() {
        return size() == 0;
    }

    // Memasukkan (key, value) ke dalam BST
    public void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("Key tidak boleh null");
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) return new Node(key, value, 1);
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = put(x.left, key, value);
        else if (cmp > 0) x.right = put(x.right, key, value);
        else x.value = value;
        x.size = 1 + size(x.left) + size(x.right);
        return x;
    }

    // Mengambil nilai berdasarkan key
    public Value get(Key key) {
        if (key == null) throw new IllegalArgumentException("Key tidak boleh null");
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else return x.value;
    }

    // Menampilkan elemen dalam BST secara inorder (terurut)
    public void inorderTraversal() {
        inorderTraversal(root);
        System.out.println();
    }

    private void inorderTraversal(Node x) {
        if (x == null) return;
        inorderTraversal(x.left);
        System.out.print(x.key + " ");
        inorderTraversal(x.right);
    }

    // Mencari key minimum
    public Key min() {
        if (isEmpty()) throw new NoSuchElementException("BST kosong");
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) return x;
        return min(x.left);
    }

    // Menghapus key dari BST
    public void delete(Key key) {
        if (key == null) throw new IllegalArgumentException("Key tidak boleh null");
        root = delete(root, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0) x.left = delete(x.left, key);
        else if (cmp > 0) x.right = delete(x.right, key);
        else {
            if (x.right == null) return x.left;
            if (x.left == null) return x.right;
            Node t = x;
            x = min(t.right);
            x.right = deleteMin(t.right);
            x.left = t.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    // Menghapus node dengan key minimum
    public void deleteMin() {
        if (isEmpty()) throw new NoSuchElementException("BST kosong");
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }
}
