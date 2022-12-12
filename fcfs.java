import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class fcfs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs");
        int n = sc.nextInt();
        Job[] j = new Job[n];

        int wt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        for (int i = 0; i < tat.length; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int tmp = i;
            j[i] = new Job(tmp, a, b);
        }

        Arrays.sort(j, (Job j1, Job j2) -> {
            if (j1.at == j2.at)
                return j1.pid - j2.pid;
            return j1.at - j2.at;
        });

        ct[0] = j[0].bt + j[0].at;
        for (int i = 1; i < tat.length; i++) {
            ct[i] = j[i].bt + ct[i - 1] + Math.max(j[i].at - ct[i - 1], 0);
            // System.out.println(ct[i]);
        }
        for (int i = 0; i < tat.length; i++) {
            tat[i] = ct[i] - j[i].at;
            wt[i] = tat[i] - j[i].bt;
        }
        for (int i = 0; i < tat.length; i++) {
            System.out
                    .println("P" + j[i].pid + " " + j[i].at + " " + j[i].bt + " " + ct[i] + " " +
                            tat[i] + " " + wt[i]);
        }

        sc.close();
    }
}

class Job {
    int at;
    int bt;
    int pid;

    Job(int i, int a, int b) {
        this.pid = i;
        this.at = a;
        this.bt = b;

    }

}
