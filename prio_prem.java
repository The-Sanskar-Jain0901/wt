import java.util.*;

public class prio_prem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs");
        int n = sc.nextInt();
        Job[] j = new Job[n];
        Job[] t = new Job[n];

        int wt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        // int[] p = new int[n];
        for (int i = 0; i < tat.length; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int pi = sc.nextInt();
            int tmp = i;
            j[i] = new Job(tmp, a, b, pi);
            t[i] = new Job(tmp, a, b, pi);
        }
        Arrays.sort(j, (Job j1, Job j2) -> {
            if (j1.p == j2.p) {
                if (j1.bt == j2.bt) {
                    if (j1.at == j2.at)
                        return j1.pid - j2.pid;
                    return j1.at - j2.at;
                }
                return j1.bt - j2.bt;
            }
            return j1.p - j2.p;
        });
        int c = 0;
        int curr = 0;
        while (c < n) {
            for (int i = 0; i < n; i++) {
                if (j[i].at <= curr && ct[j[i].pid] == 0) {

                    curr++;
                    j[i].bt--;

                    if (j[i].bt == 0 && ct[j[i].pid] == 0) {
                        ct[j[i].pid] = curr;
                        c++;
                    }
                    break;
                }
            }
        }
        for (int i = 0; i < tat.length; i++) {
            tat[i] = ct[i] - t[i].at;
            wt[i] = tat[i] - t[i].bt;
        }
        for (int i = 0; i < tat.length; i++) {

            System.out.println("P" + i + "\t\t" + t[i].at + "\t\t" + t[i].bt + "\t\t" + ct[i] + "\t\t"
                    + tat[i] + "\t\t" + wt[i]);
        }
    }
}

class Job {
    int at;
    int bt;
    int pid;
    int p;

    Job(int i, int a, int b, int p) {
        this.pid = i;
        this.at = a;
        this.bt = b;
        this.p = p;

    }

}
