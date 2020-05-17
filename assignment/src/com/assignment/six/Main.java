package com.assignment.six;


import java.util.HashMap;

public class Main {
    private ThreeSortingAlgorithms threeSortingAlgorithms = new ThreeSortingAlgorithms();
    private GenerateNumbers generateNumbers = new GenerateNumbers();
    private HelperService helperService = new HelperService();
    private BubbleSort bubbleSort = new BubbleSort();
    private QuickSort quickSort = new QuickSort();
    private HeapSort heapSort = new HeapSort();
    private Comparator comparator = new Comparator();

    public void readAGroupOfNumbers(){

        HashMap<Integer,String> headingsMap = new HashMap<Integer, String>();
        HashMap<String, int [] > numbersMap = new HashMap<String, int []>();

        headingsMap.put(1,"10 numbers in almost sorted order (two or three numbers interchanged)");
        headingsMap.put(2,"10 numbers in random order");
        headingsMap.put(3,"10 numbers in reverse order");
        headingsMap.put(4,"50 numbers in almost sorted order (a few out of order)");
        headingsMap.put(5,"50 numbers in random order");
        headingsMap.put(6,"50 numbers in reverse order");
        headingsMap.put(7,"100 numbers in almost sorted order (a few out of order)");
        headingsMap.put(8,"100 numbers in random order");
        headingsMap.put(9,"100 numbers in reverse order");

        numbersMap.put("10 numbers in almost sorted order (two or three numbers interchanged)", new int []{2,1,3,4,5,6,7,8,10,9});
        numbersMap.put("10 numbers in random order",generateNumbers.generateRandom(10,10));
        numbersMap.put("10 numbers in reverse order",generateNumbers.generateReverse(10,20));

        numbersMap.put("50 numbers in almost sorted order (a few out of order)",
                new int []{1, 2, 3, 4, 5, 6, 7, 9, 8, 10, 11, 12, 13, 14, 15, 16, 17, 18, 25, 20, 21, 22, 23, 24, 19, 26, 27, 28, 29, 30,
                        31, 32, 33, 34, 35, 36, 37, 38, 39, 41, 40, 42, 43, 44, 45, 46, 47, 48, 49, 50});
        numbersMap.put("50 numbers in random order",generateNumbers.generateRandom(50,50));
        numbersMap.put("50 numbers in reverse order",generateNumbers.generateReverse(50,60));

        numbersMap.put("100 numbers in almost sorted order (a few out of order)", new int []{1, 2, 3, 5, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14,
                15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 38, 37, 39, 40, 41, 42, 43, 44, 45,
                46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 70, 68, 69, 67, 71, 72, 73, 74, 75, 76,
                77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 98, 97, 99, 100});
        numbersMap.put("100 numbers in random order",generateNumbers.generateRandom(100,100));
        numbersMap.put("100 numbers in reverse order",generateNumbers.generateReverse(100,120));

        String heading = null;
        int [] originalArr = {};
        int [] bubbleReturns = {};
        int [] quickReturns = {};
        int [] heapReturns = {};


        for(int i=1;i <= numbersMap.size();i++){
            heading = headingsMap.get(i);
            System.out.println("Heading "+i+" : " + headingsMap.get(i));
            System.out.println("-----XXX------XXX-----XXX------");
            System.out.println("Original Group of Numbers:");
            originalArr = numbersMap.get(heading);
            helperService.printNumbers(originalArr);
            System.out.println("-----XXX------XXX-----XXX------");
            //1. bubble sort
            threeSortingAlgorithms.bubbleSort(originalArr.clone());
            bubbleReturns = bubbleSort.returnCompSwapCounts();
            helperService.printNumbers(bubbleReturns);
            System.out.println("-----XXX------XXX-----XXX------");
            //2. quick sort
            threeSortingAlgorithms.quickSort(originalArr.clone());
            quickReturns = quickSort.returnCompSwapCounts();
            helperService.printNumbers(quickReturns);
            System.out.println("-----XXX------XXX-----XXX------");
            //3. Heap Sort
            threeSortingAlgorithms.heapSort(originalArr.clone());
            heapReturns = heapSort.returnCompSwapCounts();
            helperService.printNumbers(heapReturns);
            System.out.println("-----XXX------XXX-----XXX------");
            comparator.compareSorts(bubbleReturns,quickReturns,heapReturns);
            System.out.println("-----XXX------END of "+i+" -----XXX------");
        }
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.readAGroupOfNumbers();
    }
}
