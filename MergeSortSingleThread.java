import java.util.Arrays;

public class MergeSortSingleThread<T extends Comparable<T>>  {
    static final int threshold = 100;
    private T[] arr;
    static long executionTime = 0;

    MergeSortSingleThread(T[] arr) {
        this.arr = arr;
    }
    
    public void sort() {
        long startTime = System.currentTimeMillis();
        int begin = 0;
        int end = arr.length - 1;
        if((begin + end) < threshold) {
            for(int i=begin; i<=end; i++) {
                for(int j=i+1; j<=end; j++) {
                    if(arr[j].compareTo(arr[i]) < 0) {
                        T temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        else {
            mergeSort(arr, begin, end);
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }
    
    public static <T extends Comparable<T>> void mergeSort(T[] arr, int begin, int end) {
        if(begin < end) {
            int half = (begin+end)/2;
            mergeSort(arr, begin, half);
            mergeSort(arr, half+1, end);
            merge(arr, begin, half, end);
        }
    }

    public static <T extends Comparable<T>> void merge(T[] arr, int begin, int half, int end) {
        int begin2 = half+1, i = begin;
        T[] temp = Arrays.copyOf(arr,arr.length);
        while((begin <= half) && (begin2 <= end)) {
            if(temp[begin].compareTo(temp[begin2]) < 0) {
                arr[i] = temp[begin];
                begin++;
            }
            else {
                arr[i] = temp[begin2];
                begin2++;
            }
            i++;
        }

        while(begin<=half) {
            arr[i] = temp[begin];
            i++;
            begin++;
        }

        while(begin2<=end) {
            arr[i] = temp[begin2];
            i++;
            begin2++;
        }

    }
    public long getExecutionTime() {
        return executionTime;
    }
}
