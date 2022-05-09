import java.util.Random;

public class Main {
    public static void main(String[] args){
        Integer[] x = randomArray(10);
        Integer[] y = x.clone();

        MergeSortMultiThread<Integer> X = new MergeSortMultiThread<>(x);
        MergeSortSingleThread<Integer> Y = new MergeSortSingleThread<>(y);
        
        X.sort();
        Y.sort();
        System.out.println("Execution Time for Multi Thread MergeSort for 10 element array:"+X.getExecutionTime());
        System.out.println("Execution Time for Single Thread MergeSort for 10 element array:"+Y.getExecutionTime());
        
        x = randomArray(100);
        y = x.clone();
        X = new MergeSortMultiThread<>(x);
        Y = new MergeSortSingleThread<>(y);

        X.sort();
        Y.sort();
        System.out.println("Execution Time for Multi Thread MergeSort for 100 element array:"+X.getExecutionTime());
        System.out.println("Execution Time for Single Thread MergeSort for 100 element array :"+Y.getExecutionTime());

        x = randomArray(1000);
        y = x.clone();
        X = new MergeSortMultiThread<>(x);
        Y = new MergeSortSingleThread<>(y);

        X.sort();
        Y.sort();
        System.out.println("Execution Time for Multi Thread MergeSort for 1000 element array:"+X.getExecutionTime());
        System.out.println("Execution Time for Single Thread MergeSort for 1000 element array:"+Y.getExecutionTime());

        x = randomArray(10000);
        y = x.clone();
        X = new MergeSortMultiThread<>(x);
        Y = new MergeSortSingleThread<>(y);

        X.sort();
        Y.sort();
        System.out.println("Execution Time for Multi Thread MergeSort for 10000 element array:"+X.getExecutionTime());
        System.out.println("Execution Time for Single Thread MergeSort for 10000 element array:"+Y.getExecutionTime());

        x = randomArray(100000);
        y = x.clone();
        X = new MergeSortMultiThread<>(x);
        Y = new MergeSortSingleThread<>(y);

        X.sort();
        Y.sort();
        System.out.println("Execution Time for Multi Thread MergeSort for 100000 element array :"+X.getExecutionTime());
        System.out.println("Execution Time for Single Thread MergeSort for 100000 element array:"+Y.getExecutionTime());
    }
    
    public static Integer[] randomArray(int size){
        Integer[] temp = new Integer[size];
        Random random = new Random();

        for(int i=0;i<size;i++){
            temp[i] =random.nextInt(10000);
        }
        return temp;
    }
}
