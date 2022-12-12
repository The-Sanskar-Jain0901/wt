import java.util.Scanner;

public class FCFS
{

    public static void calculateWt(int n, int[] at, int[] bt, int[] wt,int[] abst)
    {
        wt[0] = 0;
        abst[0] = bt[0];
        for(int j=1;j<n;j++)
        {
            if(abst[j-1]<at[j])
            {
                wt[j] = 0;
                abst[j] = at[j] + bt[j];
            }
            else
            {
                wt[j] = abst[j-1] - at[j] ;
                abst[j] = abst[j-1] + bt[j];
            }

        }
    }

    public static void calculateTt(int n, int[] bt, int[] wt,int[] tt)
    {
        for(int j=0;j<n;j++)
        {
            tt[j] = wt[j] + bt[j];
        }
    }

    public static void print(int n, int[] at, int[] bt, int[] wt, int[] tt, int[] abst)
    {
        System.out.println("Sr.\tat\tbt\twt\ttt\tabst\n");

        for(int k=0;k<n;k++)
        {
            System.out.println(k+"\t"+at[k]+"\t"+bt[k]+"\t"+wt[k]+"\t"+tt[k]+"\t"+abst[k]);
        }
    }
    public static void main(String[] args)
    {
        int n;

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of processes: \n");

        n = sc.nextInt();

        int at[] = new int[n];
        int bt[] = new int[n];
        int wt[] = new int[n];
        int tt[] = new int[n];
        int abst[] = new int[n];
        System.out.println("Enter arrival time of each process except 1st(assumed to be 0): \n");
        for(int i=1;i<n;i++)
        {
            at[i] = sc.nextInt();
        }

        System.out.println("Enter burst time of each process: ");
        for(int i=0;i<n;i++)
        {
            bt[i] = sc.nextInt();
        }

        calculateWt(n,at,bt,wt,abst);
        calculateTt(n,bt,wt,tt);
        print(n,at,bt,wt,tt,abst);

       sc.close();
    }

}
