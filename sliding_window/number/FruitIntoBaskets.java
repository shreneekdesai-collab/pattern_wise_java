package sliding_window.number;

import java.util.HashMap;

public class FruitIntoBaskets {

    public static void main(String[] args) {

        int[] fruits = {1,1,1,2,1,5,2};

        FruitIntoBaskets obj = new FruitIntoBaskets();

        int result = obj.totalFruit(fruits);

        System.out.println("Maximum fruits collected: " + result);
    }

    public int totalFruit(int[] f) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int low = 0;
        int res = 0;

        for (int high = 0; high < f.length; high++) {

            map.put(f[high], map.getOrDefault(f[high], 0) + 1);

            while (map.size() > 2) {

                map.put(f[low], map.get(f[low]) - 1);

                if (map.get(f[low]) == 0) {
                    map.remove(f[low]);
                }

                low++;
            }

            res = Math.max(res, high - low + 1);
        }

        return res;
    }
}
