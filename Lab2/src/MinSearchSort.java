/**
 * Created by Alexey_O on 14.03.2017.
 */
public class MinSearchSort {
    private static double dTemp;
    private static double dMin;
    private static long lTemp;
    private static long lMin;
    private static int time;

    public static int sort(double[] array) {
        if (array == null || array.length == 0) {
            System.out.println("ERROR! Array is null!");
            return -1;
        }
        time = 0;

        //TODO: init timer...

        //TODO: start timer...
        calc(array);
        //TODO: end timer...

        return time;
    }

    public static int sort(long[] array) {
        if (array == null || array.length == 0) {
            System.out.println("ERROR! Array is null!");
            return -1;
        }
        time = 0;

        //TODO: init timer...

        //TODO: start timer...
        calc(array);
        //TODO: end timer...

        return time;
    }

    private static double[] calc(double[] array) {
        for (int i = 0; i < array.length; i++) {
            dMin = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] <= dMin) {
                    dTemp = array[j];
                    array[j] = array[i];
                    array[i] = dTemp;
                    dMin = dTemp;
                }
            }
        }
        return array;
    }

    private static long[] calc(long[] array) {
        for (int i = 0; i < array.length; i++) {
            dMin = array[i];
            for (int j = i; j < array.length; j++) {
                if (array[j] <= lMin) {
                    lTemp = array[j];
                    array[j] = array[i];
                    array[i] = lTemp;
                    lMin = lTemp;
                }
            }
        }
        return array;
    }
}
