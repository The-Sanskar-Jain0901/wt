import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class SCAN {
    static int DS=200;
    public static void main(String[] args) {
        int arr[] = { 176, 79, 34, 60,
                92, 11, 41, 114 };
        int head = 50;
        String direction = "left";

        SCAN(arr, head, direction);
    }

    private static void SCAN(int[] arr, int head, String direction) {
        ArrayList<Integer> left=new ArrayList<>();
        ArrayList<Integer> right =new ArrayList<>();
        ArrayList<Integer> seq=new ArrayList<>();
        if(direction.equals("right"))right.add(DS-1);
        else left.add(0);
        for(int i=0;i<arr.length;i++){
            if(arr[i]>head)right.add(arr[i]);
            else if(arr[i]<head)left.add(arr[i]);
        }

        Collections.sort(left);
        Collections.sort(right);

        int w=2;
        int seek=0;
        while(w>0){
            w--;
            if(direction=="left"){
                direction="right";

                for(int i=left.size()-1;i>=0;i--){
                    seq.add(left.get(i));
                    seek+=Math.abs(left.get(i)-head);
                    head=left.get(i);
                }
                
            }
            else{
                direction="left";
                for(int i=0;i<right.size();i++){
                    seq.add(right.get(i));
                    seek+=Math.abs(right.get(i)-head);
                    head=right.get(i);

                }
            }

        }

        System.out.println("Seek ="+seek);
        for(int i=0;i<seq.size();i++){
            System.out.println(seq.get(i));
        }
    }

}
