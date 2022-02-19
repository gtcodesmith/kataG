package gtp.arrays;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class KataArrays {

    public static int[][] findArrays(int[] nums, int sum) {

        ArrayList<int[]> lst = new ArrayList<>();

        ArrayList<Integer> tmp = new ArrayList<>();

        if (nums.length > 0) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == sum) {
                    lst.add(new int[]{nums[i]});
                }
                if(nums[i]<sum){
                    tmp.add(nums[i]);
                    int tot = sumTmp(tmp);

                    if(tot==sum || tot==0){
                        lst.add(tmp.stream().mapToInt(Integer::intValue).toArray());
                        tmp.clear();
                    }
                }
            }

            return lst.toArray(new int[][]{});
        }
        else
            return new int[][]{};
    }

    private static int sumTmp(ArrayList<Integer> tmp) {
        return tmp.stream().reduce(0, Integer::sum);
    }

    public static int[] mash(int[] arr1, int[] arr2) {
        int mashed[] = new int[arr1.length+arr2.length];
        System.arraycopy(arr1,0,mashed,0,arr1.length);
        System.arraycopy(arr2,0,mashed,arr1.length,arr2.length);
        return mashed;
    }
}
