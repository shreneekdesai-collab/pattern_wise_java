package Heap;

// lc:692
// Given an array of strings words and an integer k, return the k most frequent strings.

// The answer should be sorted by:

// Frequency — highest to lowest.
// If two words have the same frequency, sort them in lexicographical order.

// Input:
// words = ["i","love","swati","i","love","coding"]
// k = 2

// Output:
// ["i","love"]

import java.util.*;

public class TopKFrequentWords {

    public static List<String> topKFrequent(String[] words, int k) {

        // Step 1: Count frequency of each word
        HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        // Step 2: Create PriorityQueue
        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {

            // Higher frequency comes first
            if (!map.get(a).equals(map.get(b))) {
                return map.get(b) - map.get(a);
            }

            // Same frequency -> lexicographical order
            return a.compareTo(b);
        });

        // Step 3: Add unique words to heap
        for (String word : map.keySet()) {
            heap.add(word);
        }

        // Step 4: Get top k words
        List<String> result = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            result.add(heap.poll());
        }

        return result;
    }

    public static void main(String[] args) {

        String[] words = {
            "i", "love", "leetcode",
            "i", "love", "coding"
        };

        int k = 2;

        List<String> result = topKFrequent(words, k);

        System.out.println(result);
    }
}
