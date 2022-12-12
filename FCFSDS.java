public class FCFSDS {
    public static void main(String[] args) {
        int req[] = { 176, 79, 34, 60,
            92, 11, 41, 114 };
        int head=50;
        int seek=seek(req,head);

        System.out.println("total seek ="+ ""+seek);
    }

    private static int seek(int[] req, int head) {
        int seek=0;

        for(int i=0;i<req.length;i++){
            seek+=Math.abs(head-req[i]);
            head=req[i];
        }

        return seek;
    }
    
}
