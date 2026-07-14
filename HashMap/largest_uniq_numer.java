package HashMap;

import java.util.HashMap;

public class largest_uniq_numer {
    public static void main(String[] args) {
        int[] arr={2,5,6,5,6,7,8,7};
        System.out.println(thatsit(arr));
    }
    static int thatsit (int[] arr){

        HashMap<Integer,Integer> map=new HashMap<>();
        int max=0;
        for(int i=0;i<arr.length;i++){
            int num=arr[i];
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else{
                map.put(num,1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (map.get(arr[i])==1) {
                int n=arr[i];
                if(max<n){
                    max=n;
                }
            }
        }

        return max;

    }
}
