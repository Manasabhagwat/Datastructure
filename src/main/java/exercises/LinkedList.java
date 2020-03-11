package exercises;

// This class is used for each "box".
class Node {
    int elem;
    Node next;
    // so we can do new Node(5, null) etc.
    Node(int elem, Node next) {
        this.elem = elem;
        this.next = next;
    }
}

public class LinkedList {
    private Node first = null;
    private Node last = null;

    /** Adds an integer element to the end of the
     * linked list.
     * @param elem The element to add.
     */
    public void add(int elem) {
        // 1. case: list is empty
        if (first == null) {
            first = new Node(elem, null);
            last = first;
        } else { // 2. case: list is non-empty
            // at least one node already exists!
            // this means, the `first` field is not null.

            Node nodeForElem = new Node(elem, null);
            // node that used to be last needs to be
            // connected to our new node!

            last.next = nodeForElem;
            last = nodeForElem;
        }
    }

    // get method
    public int get(int index) {
        // what we have:
        // field `first` referring to the first Node object
        // `first.next`
        Node tmp = first;
        int counter = 0;
        while (counter < index && tmp.next != null) {
            tmp = tmp.next;
            counter++;
        }
        // what we know: either counter < index is false
        // or tmp.next == null (Alarm bell!)
        if (counter == index) {
            return tmp.elem;
        } else {
            // list is too short!
            throw new IndexOutOfBoundsException();
        }

        /* NullPointerExceptions always occur:
         * (1) null.field
         * (2) null.method(arg1, arg2)
         */
    }

    public int size() {
        int counter = 0;
        Node tmp = first;
        while (tmp != null) {
            tmp = tmp.next;
            counter++;
        }
        // at this point we know: tmp == null
        return counter;
    }
}
