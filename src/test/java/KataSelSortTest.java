import gtp.arrays.KataSelSort;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static gtp.arrays.KataSelSort.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class KataSelSortTest {

    int[] src = {5,3,1,2};
    @Test
    public void testCreateKataSelSort(){

        assertNotNull(selSort(src));
        assertEquals(4, selSort(src).length);
        assertArrayEquals(new int[]{1,2,3,4,5,6}, selSort(new int[]{4,6,2,1,3,5}));
    }

    @Test
    public void testFindMinIndxThrowsExceptionWhenPassedNull(){
        assertThrows(NullPointerException.class, ()-> findMinDex(null,0));
        assertThrows(ArrayIndexOutOfBoundsException.class, ()-> findMinDex(new int[]{},-1));
    }

    @Test
    public void testFindMinIndxReturnsIndexOfMinimumValInArray(){
        assertEquals(2 , findMinDex(src,0));
    }

    @ParameterizedTest
    @MethodSource("srcArr_Pos_Expected")
    public void testSwapPlaces(int[] src, int pos, int[] expected){
        assertArrayEquals(expected, swap(src,pos, findMinDex(src,pos)));
    }

    public static Stream<Arguments> srcArr_Pos_Expected(){
        return Stream.of(
          arguments(new int[]{5,3,1,2}, 0, new int[]{1, 3, 5, 2}),
          arguments(new int[]{1, 3, 5, 2}, 1, new int[]{1, 2, 5, 3}),
          arguments(new int[]{1, 2, 5, 3}, 2, new int[]{1, 2, 3, 5})
        );
    }

}
