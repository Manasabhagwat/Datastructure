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

// TODO This class should be documented!
public class HashTable {

    public HashTable() {
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
            // not enough to go to last Entry object!!
            // (because we may have to update an existing Entry object
            // with a new value! see test.)
            while (tmp.next != null && tmp.key != key) {
                tmp = tmp.next;
            }
            if (tmp.key == key) {
                // this is the case where the value needs to be updated!
                tmp.value = value;
            } else {
                // tmp.next == null
                // this means: tmp is the very last Entry node!! :-)
                Entry ourNewEntry = new Entry(key, value, null);
                tmp.next = ourNewEntry;
            }
        }
    }

    /**
     * Looks up the value corresponding to the given key.
     * @param key the key whose mapped value should be returned.
     * @return the value that the given key maps to.
     */
    public Object get(Object key) {
        // we want to return the value that the given key maps to!

        // as before
        int hc = key.hashCode();
        int index = hc % SIZE;

        // either entry is null or the first object in the chain:
        Entry entry = storage[index]; // normal array lookup!

        if (entry == null) {
            return null;
        }

        // Still one issue here:
        // If we have a chain, but the key is not in it,
        // then at some point, tmp will be null and
        // tmp.key will throw a NPE.
        Entry tmp = entry;
        boolean found = false;
        while (!found) {
            if (tmp.key == key) {
                found = true;
            } else {
                tmp = tmp.next; // can be null!
            }
        }
        return tmp.value;
    }
}
