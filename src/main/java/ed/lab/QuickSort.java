package ed.lab;
import java.util.Random;


public interface QuickSort<T extends Comparable<T>> {

    void sort(T[] array);

}


class SortingAlgorithms {

    /* ================= HIGH PIVOT ================= */
    public static <T extends Comparable<T>> void highPivotQuickSort(T[] array) {
        quickSortHigh(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHigh(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionHigh(arr, low, high);
            quickSortHigh(arr, low, pi - 1);
            quickSortHigh(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionHigh(T[] arr, int low, int high) {
        T pivot = arr[high]; // último elemento como pivote
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    /* ================= LOW PIVOT ================= */
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[] array) {
        quickSortLow(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortLow(T[] arr, int low, int high) {
        if (low < high) {
            int pi = partitionLow(arr, low, high);
            quickSortLow(arr, low, pi - 1);
            quickSortLow(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partitionLow(T[] arr, int low, int high) {
        T pivot = arr[low]; // primer elemento como pivote
        int i = low + 1;

        for (int j = low + 1; j <= high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, low, i - 1);
        return i - 1;
    }

    /* ================= RANDOM PIVOT ================= */
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[] array) {
        quickSortRandom(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortRandom(T[] arr, int low, int high) {
        if (low < high) {
            int pi = randomPartition(arr, low, high);
            quickSortRandom(arr, low, pi - 1);
            quickSortRandom(arr, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int randomPartition(T[] arr, int low, int high) {
        Random rand = new Random();
        int pivotIndex = rand.nextInt(high - low + 1) + low;

        swap(arr, pivotIndex, high); // mover pivote al final
        return partitionHigh(arr, low, high);
    }

    /* ================= UTILIDAD ================= */
    private static <T> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}