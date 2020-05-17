package com.assignment.six;

public class HeapSort
{
    static int numberOfComparisons = 0;
    static int numberOfSwaps = 0;
    private HelperService helperService = new HelperService();
    public void sort(int array[])
    {
        int n = array.length;

        // Build heap (rearrayange arrayay)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(array, n, i);

        // One by one extract an element from heap
        for (int i=n-1; i>=0; i--)
        {
            exchangeNumbers(0,i,array);

            // call max heapify on the reduced heap
            heapify(array, i, 0);
        }
        System.out.println("Sorted Result from Heap Sort:");
        helperService.printNumbers(array);
        System.out.println("Number Of Comparisons in Heap Sort = " + numberOfComparisons);
        System.out.println("Number Of Swaps in Heap Sort = " + numberOfSwaps);
    }

    void heapify(int array[], int n, int i)
    {
        int largest = i;  // Initialize largest as root
        int l = 2*i + 1;  // left = 2*i + 1
        int r = 2*i + 2;  // right = 2*i + 2

        // If left child is larger than root
        if (l < n && compareNumbers(array[l],array[largest]))//array[l] > array[largest]
            largest = l;

        // If right child is larger than largest so far
        if (r < n && compareNumbers(array[r],array[largest]))//array[r] > array[largest]
            largest = r;

        // If largest is not root
        if (largest != i)
        {
            exchangeNumbers(i,largest,array);

            // Recursively heapify the affected sub-tree
            heapify(array, n, largest);
        }
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

    /*public static void main(String args[])
    {
        int array[] = {2,1,3,4,5,6,7,8,10,9};
        int n = array.length;

        HeapSort ob = new HeapSort();
        ob.sort(array);
    }*/
}
