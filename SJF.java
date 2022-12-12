import java.util.*;

public class SJF {
    public static void schedule(int n, int at[], int bt[], int wt[], int tt[], int abst[], Queue<Integer> seq) {
        int count = 0;
        boolean finished[] = new boolean[n];
        int time = 0;
        int min = 0;
        int sj = Integer.MAX_VALUE;

        while (true) {
            sj = Integer.MAX_VALUE;
            if (count == n) {
                break;
            }

            for (int i = 0; i < n; i++) {
                if (at[i] <= time && sj > bt[i] && !finished[i]) {
                    sj = bt[i];
                    min = i;
                }
            }

            
            time = time + bt[min];
            wt[min] = time - at[min]-bt[min];
            seq.add(min);
            tt[min] = bt[min] + wt[min];
            abst[min] = time;
            count++;
            finished[min] = true;

        }
    }

    public static void print(int n, int[] at, int[] bt, int[] wt, int[] tt, int[] abst, Queue<Integer> seq) {
        System.out.println("Sr.\t\tat\t\tbt\t\twt\t\ttt\t\tabst\n");
        int i;
        for (int k = 0; k < n; k++) {
            i = seq.poll();
            System.out.println(i + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tt[i] + "\t\t" + abst[i]);
        }
    }

    public static void main(String[] args) {
        int n;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: \n");

        n = sc.nextInt();

        int at[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int tt[] = new int[n];
        int abst[] = new int[n];
        Queue<Integer> seq = new LinkedList<>();

        System.out.println("Enter arrival time of each process except 1st(assumed to be 0): \n");
        for (int i = 1; i < n; i++) {
            at[i] = sc.nextInt();
        }

        System.out.println("Enter burst time of each process: ");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        schedule(n, at, bt, wt, tt, abst, seq);
        print(n, at, bt, wt, tt, abst, seq);
        sc.close();

    }
}
