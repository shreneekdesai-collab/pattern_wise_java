package Stack;



import java.util.Stack;

public class previous_smaller {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int[] result = check(arr);

        for (int x : result) {
            System.out.print(x + " ");
        }
    }

    public static int[] check(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                res[i] = -1;
            } else {
                res[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return res;
    }
}
