public class BSTTest {
    public static void main(String[] args) {
        BST<Integer, String> bst = new BST<>();

        // Menambahkan elemen ke BST
        bst.put(5, "Lima");
        bst.put(3, "Tiga");
        bst.put(7, "Tujuh");
        bst.put(2, "Dua");
        bst.put(4, "Empat");
        bst.put(6, "Enam");
        bst.put(8, "Delapan");

        // Menampilkan elemen BST secara inorder
        System.out.print("Inorder Traversal: ");
        bst.inorderTraversal();

        // Mengambil nilai dari key tertentu
        System.out.println("Nilai dari key 5: " + bst.get(5));
        System.out.println("Nilai dari key 3: " + bst.get(3));
        System.out.println("Nilai dari key 7: " + bst.get(7));

        // Mengambil nilai minimum
        System.out.println("Nilai minimum: " + bst.min());

        // Menghapus elemen
        bst.delete(3);
        System.out.println("Setelah menghapus key 3, Inorder Traversal: ");
        bst.inorderTraversal();
    }
}
