package com.assignment.six;

public class HelperService {
    public void printNumbers(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if(i == input.length-1) System.out.print(input[i]);
            else System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
}
