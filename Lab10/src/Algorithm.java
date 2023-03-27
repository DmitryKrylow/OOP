import java.util.Arrays;
import java.util.Objects;

public class Algorithm {
    private static String string = "";
    public static void quickSort(Integer[] array, int left, int right) {
        if (array.length == 0 || left >= right)
            return;

        int middle_index = left + (right - left) / 2;
        Integer border = array[middle_index];

        int i = left, j = right;

        while (i <= j) {
            while (array[i] < border) {
                i++;
            }
            while (array[j] > border) {
                j--;
            }
            if (i <= j) {
                int t = array[i];
                array[i] = array[j];
                array[j] = t;
                i++;
                j--;
                string += "Step: "+ Arrays.toString(array) + "\n";
            }
        }
        if (left < j) {
            quickSort(array, left, j);
        }
        if (right > i) {
            quickSort(array, i, right);
        }
    }
    public static void quickSort(String[] array, int left, int right) {
        if (array.length == 0 || left >= right)
            return;

        int middle_index = left + (right - left) / 2;
        String border = array[middle_index];

        int i = left, j = right;
        while (i <= j) {
            if ((array[i].compareTo(border)) < 0) {
                i++;
                continue;
            }
            if (array[j].compareTo(border) > 0) {
                j--;
                continue;
            }
            String t = array[i];
            array[i] = array[j];
            array[j] = t;
            i++;
            j--;
        }
        string += "Step: "+ Arrays.toString(array) + "\n";
        if (left < j) {
            quickSort(array, left, j);
        }
        if (right > i) {
            quickSort(array, i, right);
        }
    }
    public static String buildString(){
        String t = string;
        string = "";
        return t;
    }
}
