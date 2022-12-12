import java.util.*;;

public class round_robin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs");
        int n = sc.nextInt();
        System.out.println("Enter Time Quantum");
        int Time = sc.nextInt();
        Job[] j = new Job[n];
        Job[] t = new Job[n];

        int wt[] = new int[n];
        int ct[] = new int[n];
        int tat[] = new int[n];
        // int[] p = new int[n];
        for (int i = 0; i < tat.length; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            // int pi = sc.nextInt();
            int tmp = i;
            j[i] = new Job(tmp, a, b);
            t[i] = new Job(tmp, a, b);
        }
        Arrays.sort(j, (Job j1, Job j2) -> {
            if (j1.at == j2.at)
                return j1.pid - j2.pid;
            return j1.at - j2.at;
        });

        int c = 0;
        int curr = 0;
        boolean[] flag = new boolean[n];
        Queue<Job> ready = new LinkedList<>();
        for (int i = 0; i < tat.length; i++) {
            if (j[i].at <= curr) {
                flag[i] = true;
                ready.add(j[i]);
            }

        }

        while (c < n) {

            Job readyJob = ready.poll();
            int act_time = Math.min(Time, readyJob.bt);
            curr += act_time;
            readyJob.bt -= act_time;
            for (int i = 0; i < tat.length; i++) {
                if (j[i].at <= curr && flag[i] == false) {
                    ready.add(j[i]);
                    flag[i] = true;
                }
            }
            if (readyJob.bt == 0) {
                c++;
                ct[readyJob.pid] = curr;
            } else {
                ready.add(readyJob);
            }

        }
        for (int i = 0; i < tat.length; i++) {
            tat[i] = ct[i] - t[i].at;
            wt[i] = tat[i] - t[i].bt;
        }
        for (int i = 0; i < tat.length; i++) {

            System.out.println("P" + i + "\t\t" + t[i].at + "\t\t" + t[i].bt + "\t\t" +
                    ct[i] + "\t\t"
                    + tat[i] + "\t\t" + wt[i]);
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