package com.assignment.four;

import java.util.HashMap;

public class InputStorage {

    public int [] getNumberSets(int i){

        HashMap<Integer, int []> numbersSet = new HashMap<Integer, int []>();

        numbersSet.put(0, new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,-999});
        numbersSet.put(1, new int[]{3,1,5,-999});
        numbersSet.put(2, new int[]{-999});
        numbersSet.put(3, new int[]{2,-999});
        numbersSet.put(4, new int[]{11,25,75,12,37,60,90,8,15,32,45,50,67,97,95,-999});
        numbersSet.put(5, new int[]{50,40,60,30,70,20,80,10,90,-999});
        numbersSet.put(6, new int[]{30,40,20,10,50,-999});

        return numbersSet.get(i);
    }

    /*public static void main(String[] args) {
        InputStorage inputStorage = new InputStorage();
        inputStorage.getNumberSets(0);
    }*/
    

}
