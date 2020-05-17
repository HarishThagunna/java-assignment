package com.assignment.six;

public class BubbleSort {
    static int numberOfComparisons = 0;
    static int numberOfSwaps = 0;
    private HelperService helperService = new HelperService();

    public void bubble_sort(int[] array)
    {
        int n = array.length;
        int temp = 0;
        for(int i=0; i < n; i++) // Looping through the array length
        {
            for(int j=1; j < (n-i); j++)
            {
                if(compareNumbers(array[j-1],array[j]) == true)//array[j-1] > array[j]
                {

                    swapNumbers(j-1,j,array);
                }

            }
        }
        System.out.println("Sorted Result from Bubble Sort:");
        helperService.printNumbers(array);
        System.out.println("Number Of Comparisons in Bubble Sort = " + numberOfComparisons);
        System.out.println("Number Of Swaps in Bubble Sort = " + numberOfSwaps);
    }

    private static void swapNumbers(int i, int j, int[] array) {
        numberOfSwaps++;
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static boolean compareNumbers(int num1, int num2){
        numberOfComparisons++;
        boolean isGreater = false;
        if(num1 > num2){
            isGreater = true;
        }
        return isGreater;
    }

    public int[] returnCompSwapCounts(){
        int [] returnVals = new int[2];
        returnVals[0] = numberOfComparisons;
        returnVals[1] = numberOfSwaps;
        return returnVals;
    }

    /*public static void main(String[] args) {
        int[] input = { 2,1,3,4,5,6,7,8,10,9};
        BubbleSort bubbleSort = new BubbleSort();
        //bubbleSort.bubble_sort(input);
        bubbleSort.bubble_sort(input);
        System.out.println("numberOfComparisons = " + numberOfComparisons);
        System.out.println("numberOfSwaps = " + numberOfSwaps);

    }*/
}
