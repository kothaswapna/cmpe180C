import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortMultiThread<T extends Comparable<T>> extends RecursiveAction {
    static final int threshold = 100;
    private T[] arr;
    private int begin;
    private int end;
    static long executionTime = 0;

    MergeSortMultiThread(T[] arr) {
        this.arr = arr;
        
    }
    MergeSortMultiThread(T[] arr, int begin, int end) {
        this.arr = arr;
        this.begin = begin;
        this.end = end;   
    }
    
    @Override
    protected void compute() {
        mergeSort(arr, begin, end);
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
            int half = (begin + end)/2;
            MergeSortMultiThread<T> T1 = new MergeSortMultiThread<T>(arr, begin, half);
            MergeSortMultiThread<T> T2 = new MergeSortMultiThread<T>(arr, half+1, end);
            T1.fork();
            T2.fork();
            T1.join();
            T2.join();

            merge(arr, begin, half, end);
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