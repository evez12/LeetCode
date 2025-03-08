package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class InsertDeleteGedRandom_380 {


    public static void main(String[] args) {
//        int index = 6;
//        System.out.println((int) (Math.random() * (index+1)));
//        System.out.println((int) (Math.random() * (index+1)));
//        System.out.println((int) (Math.random() * (index+1)));
//        System.out.println((int) (Math.random() * (index+1)));

        test();


    }


    private static void test() {
        RandomizedSet obj = new RandomizedSet();
//        System.out.println(obj.insert(2)); // true
        System.out.println(obj.insert(2)); // false
        System.out.println(obj.insert(3)); // ture
        System.out.println(obj.insert(4)); // true
//        System.out.println(obj.remove(3)); // true
//        System.out.println(obj.remove(3)); // false
//        System.out.println(obj.insert(3)); // true
//        System.out.println(obj.insert(5)); // true
//        System.out.println(obj.insert(6)); // true
//        System.out.println(obj.insert(7)); // true
//        System.out.println(obj.insert(7)); // false

        System.out.println();
        System.out.println();

        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
        System.out.println(obj.getRandom());
    }
}

class RandomizedSet {
    private Map<Integer, Integer> mapKeyValue; // Element -> İndeks
    private Map<Integer, Integer> mapKeyIndex; // İndeks -> Element
    private int size;
    private Random random;

    public RandomizedSet() {
        mapKeyValue = new HashMap<>();
        mapKeyIndex = new HashMap<>();
        size = 0;
        random = new Random();
    }

    public boolean insert(int val) {
        if (mapKeyValue.containsKey(val)) {
            return false;
        }
        mapKeyValue.put(val, size);
        mapKeyIndex.put(size, val);
        size++;
        return true;
    }

    public boolean remove(int val) {
        if (!mapKeyValue.containsKey(val)) {
            return false;
        }

        int indexToRemove = mapKeyValue.get(val);
        int lastElement = mapKeyIndex.get(size - 1);

        //Replace the last element with deleted element
        mapKeyIndex.put(indexToRemove, lastElement);
        mapKeyValue.put(lastElement, indexToRemove);

        // delete old value
        mapKeyValue.remove(val);
        mapKeyIndex.remove(size - 1);

        size--; // Ölçünü azalt
        return true;
    }

    public int getRandom() {
        if (size == 0) {
            return -1;
        }
        int randomIndex = random.nextInt(size);
        return mapKeyIndex.get(randomIndex);
    }
}
