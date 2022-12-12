public class fifo {
    public static void main(String[] args) {
        int[] given = { 7, 1, 0, 3, 2, 0, 1, 5, 7, 4, 2, 0, 3, 4, 1, 6 };
        int[] arr = { -1, -1, -1, -1 };
        int count = 0, fc = 0, m = arr.length;
        for (int i = 0; i < given.length; i++) {
            int j;
            boolean isminus = false, ispresent = false;
            for (j = 0; j < m; j++) {
                if (arr[j] == -1) {
                    isminus = true;
                    break;
                }

                if (given[i] == arr[j]) {
                    ispresent = true;
                }

            }

            if (isminus == true) {
                arr[j] = given[i];
                // isminus = false;
                fc++;
            }

            else if (ispresent == false) {
                arr[count % m] = given[i];
                count++;
                fc++;
            }

        }

        System.out.println("Total number of page faults occured are: " + fc);
        for (int a = 0; a < m; a++) {
            // System.out.println("-------------------------------------------------------------------------");
            System.out.println(arr[a]);
        }
    }
}