package Heap;

import java.util.PriorityQueue;

/**
 * IPO
 * LeetCode 502 — IPO
Problem Statement

You have n projects. Each project has a profit and a required capital.

Initially, you have w capital and can complete at most k projects.

A project can be selected only if:

capital[i] <= w

After completing it:

w = w + profits[i]

Find the maximum possible final capital.

Example
k = 2
w = 0

profits = [1, 2, 3]
capital = [0, 1, 1]

Output: 4
 */
public class IPO {

    public static void main(String[] args) {
        int k = 2;
         int w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.print(find(k,w,profits,capital));
    }

    static int find(int k,int w,int[] profits,int[] capital){
        PriorityQueue<Integer>minheap=new PriorityQueue<>((a,b)->(capital[a]-capital[b]));
        PriorityQueue<Integer>maxheap=new PriorityQueue<>((a,b)->(profits[b]-profits[a]));

        for (int i = 0; i < profits.length; i++) {
            minheap.add(i);
        }

        for (int i = 0; i < k; i++) {
            while (!minheap.isEmpty() && capital[minheap.peek()]<=w) {
                maxheap.offer(minheap.poll());
            }
            if(maxheap.isEmpty()){
                break;
            }

            int project=maxheap.poll();
            w+=profits[project];
        }



        return w;

    }
}
