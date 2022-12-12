import java.util.*;

public class sjf_preemptive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs");
        int n = sc.nextInt();
        Job[] j = new Job[n];
        Job[] temp = new Job[n];

        int wt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        for (int i = 0; i < tat.length; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int tmp = i;
            j[i] = new Job(tmp, a, b);
            temp[i] = new Job(tmp, a, b);
        }

        sort(j);
        int c = 0, curr = 0;
        while (c < n) {
            for (int i = 0; i < tat.length; i++) {

                if (curr >= j[i].at && ct[j[i].pid] == 0) {
                    if (j[i].bt == 0) {
                        ct[j[i].pid] = curr;
                        // curr++;
                        c++;
                    } else {
                        curr++;
                        j[i].bt -= 1;
                    }
                    break;
                }

            }
            sort(j);

        }
        for (int i = 0; i < tat.length; i++) {
            tat[i] = ct[i] - temp[i].at;
            wt[i] = tat[i] - temp[i].bt;
        }
        for (int i = 0; i < tat.length; i++) {

            System.out.println("P" + i + "\t\t" + temp[i].at + "\t\t" + temp[i].bt + "\t\t" + ct[i] + "\t\t"
                    + tat[i] + "\t\t" + wt[i]);
        }
        sc.close();
    }

    private static void sort(Job[] j) {

        Arrays.sort(j, (Job j1, Job j2) -> {
            if (j1.bt == j2.bt) {
                if (j1.at == j2.at)
                    return j1.pid - j2.pid;
                return j1.at - j2.at;
            }

            return j1.bt - j2.bt;
        });
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
