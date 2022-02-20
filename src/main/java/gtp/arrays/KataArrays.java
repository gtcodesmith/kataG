package gtp.arrays;

import java.util.ArrayList;
import java.util.Stack;

public class KataArrays {

    public static int[][] findArrays(int[] nums, int sum) {

        Stack<int[]> subArrays = new Stack<>();
        Stack<int[]> zeroArrays = new Stack<>();

        ArrayList<Integer> accum = new ArrayList<>();

        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == sum) {
                    int arr[] = new int[]{nums[i]};
                    processZeroArrays(subArrays, zeroArrays, arr);
                    subArrays.push(arr);
                }
                if (nums[i] < sum) {
                    accum.add(nums[i]);
                    int tot = sumTmp(accum);

                    if (tot == sum || tot == 0) {
                        int arr[] = accum.stream().mapToInt(Integer::intValue).toArray();
                        if (tot == 0) {
                            if (subArrays.size() > 0) {
                                int pre[] = subArrays.peek();
                                int smash[] = mash(pre, arr);
                                subArrays.push(smash);
                            }
                            zeroArrays.push(arr);

                        } else {
                            processZeroArrays(subArrays, zeroArrays, arr);
                            subArrays.add(arr);

                        }
                        accum.clear();
                    }
                }
            }

            return subArrays.toArray(new int[][]{});
        } else
            return new int[][]{};
    }

    private static void processZeroArrays(Stack<int[]> subArrays, Stack<int[]> zeroArrays, int[] arr) {
        if (zeroArrays.size() > 0) {

            for (int[] zarr : zeroArrays) {
                int smash[] = mash(zarr, arr);
                subArrays.push(smash);
            }
            zeroArrays.clear();

        }
    }

    private static int sumTmp(ArrayList<Integer> tmp) {
        return tmp.stream().reduce(0, Integer::sum);
    }

    public static int[] mash(int[] arr1, int[] arr2) {
        int mashed[] = new int[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, mashed, 0, arr1.length);
        System.arraycopy(arr2, 0, mashed, arr1.length, arr2.length);
        return mashed;
    }
}
