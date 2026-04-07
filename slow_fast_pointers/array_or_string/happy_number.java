package slow_fast_pointers.array_or_string;

public class happy_number {
    public static void main(String[] args) {
        int n=19;
        
        System.out.println(find(n));
    }
    public static boolean find(int n){
        int slow=n;
        int fast=n;
        while (true) {
            slow=getsum(slow);
            fast=getsum(getsum(fast));
            if(slow==fast){
                break;

            }
        }

        return slow==1;

    }

    public static int getsum(int n){
        int sum=0;

        while (n>0) {
            int num=n%10;
            sum+=num*num;
            n=n/10;
        }
        return sum;
    }
}
