import java.util.*;

public class CSCAN {
    static int DS = 200;

    public static void main(String[] args) {
        int arr[] = { 176, 79, 34, 60,
                92, 11, 41, 114 };
        int head = 50;

        SCAN(arr, head);
    }

    private static void SCAN(int[] arr, int head) {
        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();
        ArrayList<Integer> seq = new ArrayList<>();
        right.add(DS - 1);
        left.add(0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > head)
                right.add(arr[i]);
            else if (arr[i] < head)
                left.add(arr[i]);
        }

        Collections.sort(left);
        Collections.sort(right);

        int seek = 0;

        for (int i = 0; i < right.size(); i++) {
            seq.add(right.get(i));
            seek += Math.abs(right.get(i) - head);
            head = right.get(i);

        }
        head=0;
        seek+=Math.abs(DS-1);

        for (int i = 0; i < left.size(); i++) {
            seq.add(left.get(i));
            seek += Math.abs(left.get(i) - head);
            head = left.get(i);
        }

       

        System.out.println("Seek =" + seek);
        for (int i = 0; i < seq.size(); i++) {
            System.out.println(seq.get(i));
        }
    }

}
