import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {
    private ArrayList<Integer> list;
    private HashMap<Integer, Integer> map;
    private Random rand;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false; // Value already exists in the set
        }

        // Add the value to the end of the ArrayList
        list.add(val);

        // Update the mapping in the HashMap
        map.put(val, list.size() - 1);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false; // Value does not exist in the set
        }

        // Get the index of the value to be removed
        int indexToRemove = map.get(val);

        // Swap the value to be removed with the last element in the ArrayList
        int lastVal = list.get(list.size() - 1);
        list.set(indexToRemove, lastVal);
        map.put(lastVal, indexToRemove);

        // Remove the last element from the ArrayList
        list.remove(list.size() - 1);

        // Remove the value from the HashMap
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}
