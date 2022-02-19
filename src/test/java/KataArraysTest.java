import gtp.arrays.KataArrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static gtp.arrays.KataArrays.findArrays;

class KataArraysTest {

    @Test
    public void testFindSubArrays(){

        int nums[] = new int[]{10};
        assertNotNull( findArrays(nums,10));
        assertTrue(findArrays(nums,10).length == 1);
        assertArrayEquals(new int[][]{{10}}, findArrays(nums,10));

        int nums2[] = new int[]{4};
        assertArrayEquals(new int[][]{}, findArrays(nums2,10));

        int nums3[] = new int[]{10,10};
        assertArrayEquals(new int[][]{{10},{10}}, findArrays(nums3,10));

        int nums4[] = new int[]{6,4};
        assertArrayEquals(new int[][]{{6,4}}, findArrays(nums4,10));

        int nums5[] = new int[]{6,4,3,7};
        assertArrayEquals(new int[][]{{6,4},{3,7}}, findArrays(nums5,10));

        int nums6[] = new int[]{10,0};
        assertEquals(2, findArrays(nums6,10).length);

    }

    @Test
    public void testArrayMash(){
        int arr1[] = {1,2,3};
        int arr2[] = {4,5,6};

        assertArrayEquals(new int[]{1,2,3,4,5,6}, KataArrays.mash(arr1,arr2));
//        assertArrayEquals(new int[]{1,2,3,4,5,6}, KataArrays.mash(null,arr2));

    }






}