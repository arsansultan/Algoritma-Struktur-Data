
import java.awt.event.ItemEvent;
import java.util.Iterator;
import java.util.NoSuchElementException;

class Bag<Item> implements Iterable<Item> {
    private Node first;
    private int size;

    private class Node {
        Item item;
        Node next;

    }

    public Bag() {
        first = null;
        size = 0;

    }

    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        size++;
    }

    public boolean Empty() { return first == null;}

    public int size() {return size;}

    public Iterator<Item> iterator() {return new ListIterator(); }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {return current != null; }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }




}

