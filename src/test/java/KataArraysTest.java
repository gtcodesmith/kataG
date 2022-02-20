import gtp.arrays.KataArrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static gtp.arrays.KataArrays.findArrays;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class KataArraysTest {

    @Test
    public void testFindSubArrays() {
        int nums[] = new int[]{10};
        assertNotNull(findArrays(nums, 10));
        System.out.println(Arrays.deepToString(findArrays(nums, 10)));
        assertTrue(findArrays(nums, 10).length == 1);
    }

    @Test
    public void testArrayMash() {
        int arr1[] = {1, 2, 3};
        int arr2[] = {4, 5, 6};

        assertArrayEquals(new int[]{1, 2, 3, 4, 5, 6}, KataArrays.mash(arr1, arr2));
    }

    @ParameterizedTest
    @MethodSource("srcArr_Sum_ExpectedArr")
    void testParameterizedFindArrays(int src[], int sum, int expected[][]) {
        int actual[][]=findArrays(src, sum);
        System.out.println(Arrays.deepToString(expected)+"\n"+Arrays.deepToString(actual)+"\n----------------");
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> srcArr_Sum_ExpectedArr() {
        //3 params 1- src Array  2- Sum  3-expected Array of sub Arrays
        return Stream.of(
                arguments(
                        new int[]{10}, 10,
                        new int[][]{{10}}
                ),
                arguments(
                        new int[]{4}, 10,
                        new int[][]{}
                ),
                arguments(
                        new int[]{10, 10}, 10,
                        new int[][]{{10}, {10}}
                ),
                arguments(
                        new int[]{6, 4, 3, 7}, 10,
                        new int[][]{{6, 4}, {3, 7}}
                ),
                arguments(
                        new int[]{10, 0}, 10,
                        new int[][]{{10}, {10, 0}}
                ),
                arguments(
                        new int[]{10, 0, 10}, 10,
                        new int[][]{{10}, {10, 0}, {0, 10}, {10}}
                        ),
                arguments(
                        new int[]{10, 0, 10, 0}, 10,
                        new int[][]{{10}, {10, 0}, {0, 10}, {10}, {10,0}}
                ),
                arguments(
                        new int[]{5, -5, 10}, 10,
                        new int[][]{{5, -5, 10}, {10}}
                ),
                arguments(
                        new int[]{20, -10, 10}, 10,
                        new int[][]{{20, -10}, {10}}
                )
        );
    }


}