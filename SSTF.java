import java.util.ArrayList;

class node {
    int dist = 0;
    boolean acc = false;

}

public class SSTF {
    public static void main(String[] args) {
        int arr[] = { 176, 79, 34, 60, 92, 11, 41, 114 };
        shortestSeekTimeFirst(arr, 50);
    }

    static int minindex(node[] diff) {
        int index = -1, mindiff = Integer.MAX_VALUE;
        for (int i = 0; i < diff.length; i++) {
            if (diff[i].dist < mindiff && !diff[i].acc) {
                mindiff = diff[i].dist;
                index = i;

            }
        }
        return index;

    }

    static void SSTF(int[] arr, node[] diff, int head) {
        for (int i = 0; i < diff.length; i++)
            diff[i].dist = Math.abs(arr[i] - head);

    }

    static void shortestSeekTimeFirst(int[] arr, int head) {
        int seek = 0;
        node[] diff = new node[arr.length];
        for (int i = 0; i < diff.length; i++)
            diff[i] = new node();
        ArrayList<Integer> l = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            l.add(head);
            SSTF(arr, diff, head);
            int j = minindex(diff);
            seek += diff[j].dist;
            diff[j].acc = true;
            head = arr[j];

        }
        l.add(head);

        System.out.println("seek = "+seek);
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }

    }

}
