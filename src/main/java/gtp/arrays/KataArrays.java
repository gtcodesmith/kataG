package gtp.arrays;

import java.util.ArrayList;
import java.util.Stack;

public class KataArrays {

    public static int[][] findArrays(int[] nums, int sum) {

        Stack<int[]> subArrays = new Stack<>();
        Stack<int[]> zeroArrays = new Stack<>();

        ArrayList<Integer> accum = new ArrayList<>();

        if (nums.length > 0) {
            int tot=0;
            for (int num : nums) {

                accum.add(num);
                tot += num;

                if (tot == sum || tot == 0) {
                    int[] arr = accum.stream().mapToInt(Integer::intValue).toArray();
                    if (tot == 0) {
                        zeroArrays.push(arr);
                        if (subArrays.size() > 0) {
                            int[] pre = subArrays.peek();
                            int[] smash = mash(pre, arr);
                            subArrays.push(smash);
                        }

                    } else {
                        if (zeroArrays.size() > 0) {
                            for (int[] zarr : zeroArrays) {
                                int[] smash = mash(zarr, arr);
                                subArrays.push(smash);
                            }
                            zeroArrays.clear();
                        }
                        subArrays.add(arr);
                    }

                    accum.clear();
                    tot = 0;
                }
            }
            return subArrays.toArray(new int[][]{});
        } else
            return new int[][]{};
    }

    public static int[] mash(int[] arr1, int[] arr2) {
        int[] mashed = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mashed, 0, arr1.length);
        System.arraycopy(arr2, 0, mashed, arr1.length, arr2.length);
        return mashed;
    }
}
