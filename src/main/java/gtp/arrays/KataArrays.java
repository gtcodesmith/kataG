package gtp.arrays;

import java.util.ArrayList;
import java.util.Stack;

import static java.util.Optional.of;

public class KataArrays {

    public static int[][] findArrays(int[] nums, int sum) {

        if (nums.length == 0) {
            return new int[][]{};
        }

        Stack<int[]> subArrays = new Stack<>();
        Stack<int[]> zeroArrays = new Stack<>();
        ArrayList<Integer> accum = new ArrayList<>();

        int tot = 0;
        for (int num : nums) {

            accum.add(num);
            tot += num;

            if (tot == sum || tot == 0) {
                int[] arr = accum.stream().mapToInt(Integer::intValue).toArray();
                if (tot == 0) {
                    zeroArrays.push(arr);
                    of(subArrays)
                            .filter(sa -> !sa.isEmpty())
                            .map(Stack::peek)
                            .map(prevArr -> mash(prevArr, arr))
                            .ifPresent(subArrays::push);

                } else {
                    zeroArrays
                            .stream()
                            .map(zarr -> mash(zarr, arr))
                            .forEach(subArrays::push);

                    zeroArrays.clear();
                    subArrays.add(arr);
                }

                accum.clear();
                tot = 0;
            }
        }

        return subArrays.toArray(new int[][]{});
    }

    public static int[] mash(int[] arr1, int[] arr2) {
        int[] mashed = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mashed, 0, arr1.length);
        System.arraycopy(arr2, 0, mashed, arr1.length, arr2.length);
        return mashed;
    }
}
