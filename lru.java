import java.util.ArrayList;
import java.util.Arrays;

public class lru {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(
                Arrays.asList(7, 0, 1, 2, 0, 3, 0, 4, 2, 3, 0, 3, 2, 1, 2, 0, 1, 7, 0, 1));
        int n = 20;
        int m = 4;
        ArrayList<Integer> pages = new ArrayList<>();
        int i = 0;
        int c = 0;
        while (c < m) {
            if (!pages.contains(arr.get(i))) {
                pages.add(arr.get(i));
                c++;
            }
            i++;
        }
        int[] flag = new int[m];
        for (; i < n; i++) {
            int f = 0;
            for (int j = 0; j < m; j++) {
                if (arr.get(i) == pages.get(j)) {
                    f = 1;
                    break;
                }
            }
            if (f == 1)
                continue;
            // page fault
            for (int j3 = 0; j3 < flag.length; j3++) {
                flag[j3] = -1;
            }

            for (int j = 0; j < m; j++) {
                for (int j2 = i; j2 >= 0; j2--) {
                    if (arr.get(j2) == pages.get(j) && flag[j] == -1)
                        flag[j] = j2;
                }
            }

            int min = i;
            int index = 0;
            for (int k = 0; k < m; k++) {
                if (flag[k] == -1) {
                    index = k;
                    break;
                }
                if (min > flag[k]) {
                    index = k;
                    min = flag[k];

                }
            }

            System.out.println("Removed-->" + pages.get(index));
            pages.remove(pages.get(index));
            pages.add(arr.get(i));
            System.out.println("Added" + arr.get(i));
            c++;
        }
        System.out.println(c);
    }

}
