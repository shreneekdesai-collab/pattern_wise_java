package Heap;
// lc:215

import java.util.Collections;
import java.util.PriorityQueue;

public class kth_largets_element {
        public static void main(String[] args) {
            int [] a={3,2,4,1,6};
            int k=2;
            System.out.println(smallest(a,k));

        }
        static int smallest(int[] a,int k){
            PriorityQueue <Integer> heap=new PriorityQueue<>(Collections.reverseOrder());
            for (int i = 0; i < a.length; i++) {
                    heap.add(a[i]);
            }
            for (int i = 0; i < k-1; i++) {
                heap.poll();
            }
            return heap.peek();

        }
}
