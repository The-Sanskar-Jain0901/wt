import java.util.*;

public class Priority {
    private static void print(int n, int[] prio, int[] at, int[] bt, int[] wt, int[] tt, int[] ct, Queue<Integer> seq) {
        int i;
        System.out.println("Sr.\t\tat\t\tbt\t\twt\t\ttt\t\tabst\n");
        while (!seq.isEmpty()) {
            i = seq.poll();
            System.out.println(i + "\t\t" + at[i] + "\t\t" + bt[i] + "\t\t" + wt[i] + "\t\t" + tt[i] + "\t\t" + ct[i]);
        }

    }

    private static void schedule(int n, int[] prio, int[] at, int[] bt, int[] wt, int[] tt, int[] ct,
            Queue<Integer> seq) {
        int TJF = 0;
        int totalTime = 0;
        int minIndex = 0;
        boolean FJ[] = new boolean[n];
        int minPrio = Integer.MAX_VALUE;
        while (true) {
            minPrio = Integer.MAX_VALUE;
            if (n == TJF)
                break;

            for (int i = 0; i < n; i++) {
                if (totalTime > at[i] && minPrio > prio[i] && !FJ[i]) {

                    minPrio = prio[i];
                    minIndex = i;
                }
            }
            totalTime += bt[minIndex];
            wt[minIndex] = totalTime - bt[minIndex] - at[minIndex];
            tt[minIndex] = bt[minIndex] + wt[minIndex];
            ct[minIndex] = totalTime;

            FJ[minIndex] = true;
            seq.add(minIndex);
            TJF++;

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
        int prio[] = new int[n];
        Queue<Integer> seq = new LinkedList<>();

        System.out.println("Enter arrival time of each process except 1st(assumed to be 0): \n");
        for (int i = 1; i < n; i++) {
            at[i] = sc.nextInt();
        }

        System.out.println("Enter burst time of each process: ");
        for (int i = 0; i < n; i++) {
            bt[i] = sc.nextInt();
        }

        System.out.println("Enter Priority of each process: ");
        for (int i = 0; i < n; i++) {
            prio[i] = sc.nextInt();
        }

        schedule(n, prio, at, bt, wt, tt, abst, seq);
        print(n, prio, at, bt, wt, tt, abst, seq);
        sc.close();

    }

}
