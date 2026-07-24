public class MyHashSet {
    private boolean[] set;

    public MyHashSet() {
        // Create an array large enough to cover the max key range (0 to 1,000,000)
        set = new boolean[1000001];
    }
    
    public void add(int key) {
        // Mark the index as present
        set[key] = true;
    }
    
    public void remove(int key) {
        // Mark the index as absent
        set[key] = false;
    }
    
    public boolean contains(int key) {
        // Return whether the key exists at index
        return set[key];
    }
}

