import java.util.*;

public class priority {
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
        boolean temp_AT[] = new boolean[n];
        int temp_CT = Integer.MAX_VALUE;
        int c = 0;
        int tmp_i = 0;
        for (int i = 0; i < n; i++) {
            if (temp_CT > j[i].at) {
                temp_CT = j[i].at;
                tmp_i = i;
            }
        }
        ct[j[tmp_i].pid] = temp_CT + j[tmp_i].bt;
        temp_AT[tmp_i] = true;
        System.out.println(ct[j[tmp_i].pid]);
        int prv_ct = ct[j[tmp_i].pid];
        while (c < n - 1) {
            // int temp = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (prv_ct >= j[i].at && temp_AT[i] != true) {
                    // temp = j[i].at;
                    tmp_i = i;
                    break;
                }
            }
            // temp_CT = temp;
            ct[j[tmp_i].pid] = prv_ct + j[tmp_i].bt + Math.max(j[tmp_i].at - prv_ct, 0);
            prv_ct = ct[j[tmp_i].pid];
            temp_AT[tmp_i] = true;
            c++;
        }
        for (int i = 0; i < tat.length; i++) {
            tat[i] = ct[i] - t[i].at;
            wt[i] = tat[i] - t[i].bt;
        }
        for (int i = 0; i < tat.length; i++) {

            System.out.println("P" + i + "\t\t" + t[i].at + "\t\t" + t[i].bt + "\t\t" + ct[i] + "\t\t"
                    + tat[i] + "\t\t" + wt[i]);
        }
        sc.close();

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
