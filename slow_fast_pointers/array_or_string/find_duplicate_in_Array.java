package slow_fast_pointers.array_or_string;

public class find_duplicate_in_Array {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,3};
        System.out.println(find_dup(arr));
    }
    public static int find_dup(int []arr){

        int slow=arr[0];
        int fast=arr[0];

        //cycle detection
        while (true) {
            slow=arr[slow];
            fast=arr[arr[fast]];

            if(slow==fast){
                break;
            }
        }

        //finding dup
        slow=arr[0];
        while (slow!=fast) {
            slow=arr[slow];
            fast=arr[fast];while (true) {
            slow=arr[slow];
            fast=arr[arr[fast]];

            if(slow==fast){
                break;
            }
        }
        }
        

        return slow;

    }
}
