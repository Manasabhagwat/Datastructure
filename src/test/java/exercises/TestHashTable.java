package exercises;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestHashTable {
    @Test
    public void testInsertIntoEmptyHashTable() {
        HashTable t = new HashTable();
        t.insert("SE", "Stockholm");
        String result = (String) t.get("SE");
        assertEquals("Stockholm", result);
    }

    @Test
    public void testInsertTwiceWithSameKeyIntoEmptyHashTable() {
        HashTable t = new HashTable();
        t.insert("SE", "Stockholm");
        // we just want to update the key-value mapping:
        t.insert("SE", "Gothenburg");
        // after 2nd insert, the "SE" key should still be
        // unique within the hash table!
        // all we are doing is update the mapping.
        String result = (String) t.get("SE");
        assertEquals("Gothenburg", result);
    }

    @Test
    public void testGetKeyFromEmptyHashTable() {
        HashTable t = new HashTable();
        Object result = t.get("SE");
        assertEquals(null, result);
    }
}
