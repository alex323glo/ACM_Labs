/**
 * Created by Alexey_O on 14.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        double[] arr0 = null;
        double[] arr1 = {};
        double[] arr2 = {-1.2, 34.11, 11, 0, 11, -245, 0.1, -0.1};
        double[] arr3 = {111.11, -1, 1, 1, -1, 12.34, 5.67, -1000.1, 444444};
        double[] arr4 = {0.1, 0.11, 0.101, -1.111, -0.1, -0.01};
        double[] arr5 = {-99999, 9.99999, 13.124, 4.6546, -23.0004, -11111.32235, 14324, -131.5, 23432.1, -12314, -11};
        long[] arr6 = null;
        long[] arr7 = {};
        long[] arr8 = {1111, -1232, -12431, 57567, 11111111, -1111111, 34234};
        long[] arr9 = {45435,-43534, 67984, -4363, 2355, -4543463};
        long[] arr10 = {0,1,0,1,2,-5,6, 6, -5, 10,436546, -435, 545, -2432, 545, 0, 0};
        long[] arr11 = {1, 2, 6, 1, -5, 4, 200, 100};
        printArr(arr0);
        printArr(arr1);
        printArr(arr2);
        printArr(arr3);
        printArr(arr4);
        printArr(arr5);
        printArr(arr6);
        printArr(arr7);
        printArr(arr8);
        printArr(arr9);
        printArr(arr10);
        printArr(arr11);
    }

    static String doubleToString(double[] dArr) {
        if (dArr == null) return "";
        String str = "";
        for (double d: dArr) {
            str += ("" + d + " ");
        }
        return str;
    }
    static String doubleToString(long[] dArr) {
        if (dArr == null) return "";
        String str = "";
        for (double d: dArr) {
            str += ("" + d + " ");
        }
        return str;
    }

    static void printArr(double[] arr) {
        System.out.println("Array before: " + doubleToString(arr));
        MinSearchSort.sort(arr);
        System.out.println("Array after : " + doubleToString(arr));
        System.out.println("--------------------------------------------------------");
    }
    static void printArr(long[] arr) {
        System.out.println("Array before: " + doubleToString(arr));
        MinSearchSort.sort(arr);
        System.out.println("Array after : " + doubleToString(arr));
        System.out.println("--------------------------------------------------------");
    }
}
