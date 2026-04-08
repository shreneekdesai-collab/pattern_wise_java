package slow_fast_pointers.array_or_string;

// Question:
// Given a circular integer array nums, return true if there is a cycle in the array.
// A cycle must:
// 1. Be in the same direction (all positive or all negative)
// 2. Have length > 1 (not a self-loop)

public class circularArrayLoop {

    public static void main(String[] args) {
        int[] nums = {2, -1, 1, 2, 2};

        boolean result = circularArrayLoop(nums);

        System.out.println("Cycle exists: " + result);
    }

    public static boolean circularArrayLoop(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = i;

            boolean isForward = nums[i] > 0;

            while (true) {
                slow = nextIdx(nums, isForward, slow);
                fast = nextIdx(nums, isForward, fast);

                if (fast != -1) {
                    fast = nextIdx(nums, isForward, fast);
                }

                if (slow == -1 || fast == -1) {
                    break;
                }

                if (slow == fast) {
                    // check for self-loop
                    if (slow == nextIdx(nums, isForward, slow)) {
                        break;
                    }
                    return true;
                }
            }
        }

        return false;
    }

    public static int nextIdx(int[] nums, boolean isForward, int current) {
        boolean direction = nums[current] > 0;

        // direction mismatch
        if (direction != isForward) return -1;

        int n = nums.length;
        int next = (current + nums[current]) % n;

        // handle negative index
        if (next < 0) next += n;

        return next;
    }
}