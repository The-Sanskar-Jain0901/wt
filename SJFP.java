import java.util.ArrayList;
import java.util.List;

class process
{
    String  id;
    int at;
    int bt;
    int tempbt;
    int wt;
    int tt;

    public process(String id, int at, int bt) {
        this.id = id;
        this.at = at;
        this.bt = bt;
        this.tempbt = bt;
    }
}
//
//class process
//{
//    String  id;
//    int at;
//    int bt;
//    int tempbt;
//    int wt;
//    int tt;
//
//    public process(String id, int at, int bt) {
//        this.id = id;
//        this.at = at;
//        this.bt = bt;
//        this.tempbt = bt;
//    }
//}

public class SJFP
{


    public static process findShortestJob(List<process> waitingList)
    {
        int min=0;
        for(int j=0;j<waitingList.size();j++)
        {
            if(waitingList.get(min).tempbt>waitingList.get(j).tempbt)
            {
                min = j;
            }
        }
        process sj = waitingList.get(min);
        waitingList.remove(min);
        return sj;
    }

    public static void schedule(List<process> list)
    {
        int absTime=0;
        int TQ=2;
        List<process> waitingList = new ArrayList<>();

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).at==absTime)
            {
                waitingList.add(list.get(i));
            }
        }

        process sj;
//        sj = findShortestJob();


        while(!waitingList.isEmpty())
        {
            sj = findShortestJob(waitingList);
            for(int j=0;j<TQ;j++)
            {

                sj.tempbt-=1;
                absTime+=1;

                if(sj.tempbt==0)
                {
                    sj.tt = absTime-sj.at;
                    sj.wt = sj.tt-sj.bt;

                    break;

                }
                for(int i=0;i<list.size();i++)
                {
                    if(list.get(i).at==absTime)
                    {
                        waitingList.add(list.get(i));
                        list.remove(i);
                    }
                }


            }


            if(sj.tempbt>0)
            {
                System.out.println(absTime+"   "+sj.id);
                waitingList.add(sj);
            }
            else if(sj.tempbt==0)
            {
                System.out.println(absTime+"   "+sj.id+"   finished");
            }

        }


    }

    public static void main(String[] args)
    {
        // int n,at,bt;
        // String id;
        List<process> list = new ArrayList<>();

        process p1 = new process("a",0,3);
        list.add(p1);
        process p2 = new process("b",2,6);
        list.add(p2);
        process p3 = new process("c",4,4);
        list.add(p3);
        process p4 = new process("d",6,5);
        list.add(p4);
        process p5 = new process("e",8,2);
        list.add(p5);
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter number of processes: \n");
//
//        n = sc.nextInt();
//
//        System.out.println("Enter info of each process sequentially(put arrival time of 1st process =0): \n");
//        for(int i=0;i<n;i++)
//        {
//            System.out.print("\nEnter id of process "+i+": ");
//            id = sc.next();
//            System.out.print("\nEnter at of process "+i+": ");
//            at = sc.nextInt();
//            System.out.print("\nEnter bt of process "+i+": ");
//            bt = sc.nextInt();
//            process p = new process(id,at,bt);
//            list.add(p);
//        }

        schedule(list);



    }
}
