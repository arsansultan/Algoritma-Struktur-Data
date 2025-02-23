public class BagTest {
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();
        bag.add("Apple");
        bag.add("Banana");
        bag.add("Cherry");

        System.out.println("Isi Bag");
        for (String item : bag) {
            System.out.println(item);
        }

        System.out.println(("Jumlah item dalam bag: " + bag.size()));
    }
}
