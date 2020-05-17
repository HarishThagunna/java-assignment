package com.assignment.six;

import java.util.ArrayList;
import java.util.Random;
public class GenerateNumbers {

    public int[] generateRandom(int count, int bound){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        int [] returnValues = new int[count];
        Random random = new Random();
        do
        {
            int num = random.nextInt(bound);
            //to generate non-repeated list
            if(!numbers.contains(num)){
                //System.out.println("num = " + num);
                numbers.add(num);
            }
        } while (numbers.size() < count);

        for(int i=0;i<numbers.size();i++){
            returnValues[i] = numbers.get(i).intValue();
        }
        return returnValues;
    }

    public int[] generateReverse(int count, int bound){
        int [] returnValues = new int[count];
        for(int i=0;i<count;i++){
            returnValues[i] = bound;
            bound--;
        }
        return returnValues;
    }

    public int[] generateNormal(int count, int start){
        int [] returnValues = new int[count];
        for(int i=0;i<count;i++){
            returnValues[i] = start;
            start++;
        }
        return returnValues;
    }
    
    
    /*public static void main(String[] args) {
        GenerateNumbers generateRandom = new GenerateNumbers();
       int [] generatedNumbers = new int[10];
        //generatedNumbers = generateRandom.generateReverse(10, 10);
        generatedNumbers = generateRandom.generateNormal(100, 1);
        HelperService helperService = new HelperService();
        helperService.printNumbers(generatedNumbers);
        
    }*/
}
