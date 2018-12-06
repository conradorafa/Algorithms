import java.util.Arrays;
//Top-down mergesort
public class MergeSort  {
    private static int[] aux; // auxiliary array for merges
    public static void sort(int[] a)
    {
        aux = new int[a.length]; // Allocate space just once.
        sort(a, 0, a.length - 1);
    }
    private static void sort(int[] a, int lo, int hi)
    { // Sort a[lo..hi].
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(a, lo, mid); // Sort left half.
        sort(a, mid+1, hi); // Sort right half.
        merge(a, lo, mid, hi); // Merge results (code on page 271).
    }
    public static void merge(int[] a, int lo, int mid, int hi)
    { // Merge a[lo..mid] with a[mid+1..hi].
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) // Copy a[lo..hi] to aux[lo..hi].
            aux[k] = a[k];
        for (int k = lo; k <= hi; k++) // Merge back to a[lo..hi].
            if (i > mid) a[k] = aux[j++];
            else if (j > hi ) a[k] = aux[i++];
            else if (aux[j] <= aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
    }

    public static void main (String[] args) {
        int[] array = {5,3,4, 3, 100, 2, 9, 18, 25, 33, 66,7,2,1,188,22,45,56,32,21,28,19,16,40,10000,345};
        //int[] array = {5,3,4, 1};
        MergeSort sortingAlgorithms = new MergeSort();
        sortingAlgorithms.sort(array);
        System.out.println("MergeSort = "+ Arrays.toString(array));


    }

}
