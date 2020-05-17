package com.assignment.six;


public class ThreeSortingAlgorithms {
    public void bubbleSort(int [] arr){
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble_sort(arr);
    }

    public void quickSort(int [] arr){
        QuickSort quickSort = new QuickSort();
        quickSort.sort(arr);
    }

    public void heapSort(int [] arr){
        HeapSort heapSort = new HeapSort();
        heapSort.sort(arr);
    }
}
