import java.util.*;

public class nru {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2));
        int n = 15;
        int m = 3;
        // ArrayList<Integer> pages = new ArrayList<>();
        HashMap<Integer, Integer> pages = new HashMap<>(m);
        int c = 0;
        int i = 0;
        while (c < m) {
            if (!pages.containsKey(arr.get(i))) {
                pages.put(arr.get(i), 1);
                c++;
            } else
                pages.put(arr.get(i), pages.get(arr.get(i)) + 1);
            i++;
        }
        for (int key : pages.keySet()) {
            // if (pages.get(key) < min) {
            // min = pages.get(key);
            // ind = key;
            // }
            System.out.println("KEY" + key + "VALUE" + pages.get(key));
        }
        for (; i < n; i++) {
            if (pages.containsKey(arr.get(i))) {
                pages.put(arr.get(i), pages.get(arr.get(i)) + 1);
                continue;
            }
            // pageFault
            int min = Integer.MAX_VALUE;
            int ind = 0;
            for (int key : pages.keySet()) {
                if (pages.get(key) < min) {
                    min = pages.get(key);
                    ind = key;
                }
            }
            System.out.println(ind);
            pages.remove(ind);
            pages.put(arr.get(i), 1);
            c++;

        }
        System.out.println(c);
    }
}
