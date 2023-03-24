import org.testng.annotations.Test;

import java.util.Arrays;

public class sortArray {
    @Test
    public void testSortArray() {
        int[] array =  {1,5,4,3,2};
        int swap = 0;
        for (int i = 0;i<array.length;i++) {
            for (int j = 0;j<array.length;j++) {
                if (array[i]>array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                     swap++;
                }
            }

        }
        System.out.println(Arrays.asList(array));
        System.out.println(swap);
    }

}
