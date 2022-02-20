package gtp.arrays;

import static java.util.Objects.requireNonNull;

public class KataSelSort {
    public static int[] selSort(int[] src) {
        for (int i = 0; i < src.length; i++) {
            int minDx = findMinDex(src, i);
            swap(src, i, minDx);
        }
        return src;
    }

    public static int findMinDex(int[] arr, int pos) {
        requireNonNull(arr);
        int min = arr[pos];
        int minDx = pos;
        for (int i = pos; i < arr.length; i++) {
            if (min > arr[i]) {
                minDx = i;
                min = arr[i];
            }
        }
        return minDx;
    }

    public static int[] swap(int[] src, int pos, int minDex) {
        int tmp = src[pos];
        src[pos] = src[minDex];
        src[minDex] = tmp;
        return src;
    }
}
