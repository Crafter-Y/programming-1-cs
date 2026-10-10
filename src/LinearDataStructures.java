import java.util.*;

public class LinearDataStructures {
    public static void main() {
        // primitive arrays
        int[] ints = {10, 20, 30, 40};
        String[] strings = {"Foo", "Bar", "Baz"};

        int n = ints.length; // 4

        // initialize empty with a fixes size:
        int[] fixedArray = new int[23];

        // access through the [] syntax
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i] + " ");
        }

        // access through the iterator approach
        for (int el : ints) {
            System.out.println(el + " ");
        }

        // since primitive arrays are hard to work with, java provides newer apis through the {Collection} APIs
        // Lists are the equivalent to primitive arrays, but require the wrapper types
        // Possible list implementations are: ArrayList, LinkedList
        List<String> stringList = new ArrayList<>();
        // .add(String element), get(int index), remove(int index), remove(String element) ...

        // Sets hold a unique set of entries. adding an entry twice won't do anything
        // Implementations are: HashSet, LinkedHashSet, TreeSet
        Set<String> stringSet = new HashSet<>();
        // add, remove, contains ...

        // Queues are similar to arrays but use the FIFO principle
        // Implementations: TODO
        Queue<String> stringQueue = new ArrayDeque<>();
        // add, poll ...

        // Stack, LIFO principle
        Stack<String> stringStack = new Stack<>();
        // push, pop, peek

        // Maps are dictionaries with unique keys.
        // implementations are HashMap, LinkedHashMap, TreeMap
        Map<String, String> stringMap = new HashMap<>();


    }
}
