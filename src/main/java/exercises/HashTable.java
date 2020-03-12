package exercises;

class Entry {
    Object key;
    Object value;
    Entry next;
    Entry(Object key, Object value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}

public class HashTable {

    public HashTable() {
        // initialize fields...
    }

    private int SIZE = 1024; // 2^10
    private Entry[] storage = new Entry[SIZE];  // this would require the key
    // to have type int
    // solution:
    // compute the hash code of each key, which is an int! :-)

    /**
     * Insert a key-value mapping into the hash table.
     * @param key the key to insert.
     * @param value the value to insert.
     */
    public void insert(Object key, Object value) {
        if (key == null)
            throw new IllegalArgumentException("null keys are not allowed");
        // ...
        // have to store key-value mapping somewhere!

        // Step 1: convert key object to an int value:
        int hc = key.hashCode();

        // Problem: `hc` could be super small (-2 billion)
        // or super large (2 billion) or anything in-between.

        // storage[abs(hc)] = value;

        // Step 2
        // What we need: an index between 0 and SIZE-1!
        // Modulo computes the remainder of the integer division by SIZE.
        // This means the remainder is between 0 and SIZE-1!
        int index = hc % SIZE;

        // Now we need to solve the collision issue!
        // get to first entry of chain:
        Entry entry = storage[index]; // normal array lookup!

        if (entry == null) {
            Entry e = new Entry(key, value, null);
            storage[index] = e;
        } else {
            // entry != null
            Entry tmp = entry;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            // after the loop: tmp.next == null
            // this means: tmp is the very last Entry node!! :-)
            Entry ourNewEntry = new Entry(key, value, null);
            tmp.next = ourNewEntry;
        }
    }

    /**
     * Looks up the value corresponding to the given key.
     * @param key the key whose mapped value should be returned.
     * @return the value that the given key maps to.
     */
    public Object get(Object key) {
        return null; // not implemented yet
    }
}
