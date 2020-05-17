package com.assignment.six;

public class QuickSort {
    private int length;
    static int numberOfComparisons = 0;
    static int numberOfSwaps = 0;
    private HelperService helperService = new HelperService();


    public void sort(int[] inputArr) {
        if (inputArr == null || inputArr.length == 0) {
            return;
        }
        length = inputArr.length;
        quickSort(0, length - 1, inputArr);
        System.out.println("Sorted Result from Quick Sort:");
        helperService.printNumbers(inputArr);
        System.out.println("Number Of Comparisons in Quick Sort = " + numberOfComparisons);
        System.out.println("Number Of Swaps in Quick Sort = " + numberOfSwaps);
    }

    private void quickSort(int lowerIndex, int higherIndex, int [] array) {

        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (compareNumbers(pivot,array[i])) {//array[i] < pivot
                i++;
            }
            while (compareNumbers(array[j],pivot)) {//array[j] > pivot
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, array);
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);
        if (i < higherIndex)
            quickSort(i, higherIndex, array);
    }

    public boolean compareNumbers(int num1, int num2){
        numberOfComparisons++;
        boolean isGreater = false;
        if(num1 > num2){
            isGreater = true;
        }
        return isGreater;
    }

    private void exchangeNumbers(int i, int j, int [] array) {
        numberOfSwaps++;
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public int[] returnCompSwapCounts(){
        int [] returnVals = new int[2];
        returnVals[0] = numberOfComparisons;
        returnVals[1] = numberOfSwaps;
        return returnVals;
    }

    /*public static void main(String a[]){
        QuickSort sorter = new QuickSort();
        int[] input = {2,1,3,4,5,6,7,8,10,9};
        sorter.sort(input);
        System.out.println("numberOfComparisons = " + numberOfComparisons);
        System.out.println("numberOfSwaps = " + numberOfSwaps);
        for(int i:input){
            System.out.print(i);
            System.out.print(" ");
        }
    }*/
}
