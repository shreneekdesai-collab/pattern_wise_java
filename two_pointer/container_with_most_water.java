package two_pointer;

public class container_with_most_water {
    public static void main(String[] args) {

        // Question:
        // You are given an integer array height.
        // Find two lines that together with x-axis form a container
        // such that the container stores maximum water.

        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        int result = maxArea(height);

        System.out.println("Maximum Water Stored = " + result);
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxWater = 0;

        while (left < right) {

            int width = right - left;

            int minHeight = Math.min(height[left], height[right]);

            int area = width * minHeight;

            maxWater = Math.max(maxWater, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }
}
