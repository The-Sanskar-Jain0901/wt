import java.util.*;

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

public class RR1
{
    public static Queue<process> q=new LinkedList<>();

    public static void schedule(List<process> list)
    {
        

        int absTime=0;
        int TQ;
        Queue<process> readyq = new LinkedList<>();
        int c=0;
        int jobs=list.size();

        for(int i=0;i<list.size();i++)
        {
            if(list.get(i).at==absTime)
            {
                readyq.add(list.get(i));
                list.remove(i);
            }
        }
        while(true)
        {
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).at==absTime)
                {
                    readyq.add(list.get(i));
                    list.remove(i);
                }
            }
            if(c==jobs)break;
            TQ=2;
            if(!readyq.isEmpty()){
                process rp = readyq.poll();
                for(int j=0;j<TQ;j++)
                {
    
    
                    rp.tempbt-=1;
                    absTime+=1;
    
                    if(rp.tempbt==0)
                    {
                        q.add(rp);
                        c++;
                        
                        rp.tt = absTime-rp.at;
                        rp.wt = rp.tt-rp.bt;
    
                        break;
    
                    }
                    for(int i=0;i<list.size();i++)
                    {
                        if(list.get(i).at==absTime)
                        {
                            readyq.add(list.get(i));
                            list.remove(i);
                        }
                    }
    
    
                }
    
    
                if(rp.tempbt>0)
                {
                    System.out.println(absTime+"   "+rp.id);
                    readyq.add(rp);
                }
                else if(rp.tempbt==0)
                {
                    System.out.println(absTime+"   "+rp.id+"   finished");
                }
    
            }else absTime++;

            }
            
      

    }


    public static void main(String[] args)
    {
        List<process> list = new ArrayList<>();

        process p1 = new process("a",0,5);
        list.add(p1);
        process p2 = new process("b",1,4);
        list.add(p2);
        process p3 = new process("c",2,2);
        list.add(p3);
        process p4 = new process("d",3,1);
        list.add(p4);
        // process p5 = new process("e",8,2);
        // list.add(p5);
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

        while(!q.isEmpty()){
            process p=q.poll();
            System.out.println(p.id+","+p.wt+","+p.tt);
        }




    }
}
