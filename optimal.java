import java.util.*;

public class optimal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();
        System.out.println("Enter number of pages");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        System.out.println("Enter Frames");
        int m = sc.nextInt();
        ArrayList<Integer> pages = new ArrayList<Integer>(m);
        int c = 0;
        for (int i = 0; i < m; i++) {
            pages.add(arr.get(i));
            c += 1;
        }
        int flag[] = new int[m];

        // no page fault
        // page fault and -1
        // pf and last first occurence
        for (int i = m; i < n; i++) {
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
                for (int j2 = i + 1; j2 < n; j2++) {
                    if (arr.get(j2) == pages.get(j) && flag[j] == -1)
                        flag[j] = j2;
                }
            }
            // System.out.println(flag[0] + " " + flag[1] + " " + flag[2] + " " + flag[3]);
            int max = -1;
            int index = 0;
            for (int k = 0; k < m; k++) {
                if (flag[k] == -1) {
                    index = k;
                    break;
                }
                if (max < flag[k]) {
                    index = k;
                    max = flag[k];

                }
            }

            System.out.println("Removed-->" + pages.get(index));
            pages.remove(pages.get(index));
            pages.add(arr.get(i));
            System.out.println("Added" + arr.get(i));
            c++;
        }
        System.out.println(c);
        sc.close();
    }
}