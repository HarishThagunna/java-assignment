package com.assignment.four;

import java.util.HashMap;

public class InputStorage {

    int [] numbers;
    HashMap<String, Integer> operations;

    public InputStorage getNumberSets(int i){

        InputStorage [] arrayInputs = new InputStorage[7];
        
        arrayInputs[0].numbers = new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,-999};
        arrayInputs[1].numbers = new int[]{3,1,5,-999};
        arrayInputs[2].numbers = new int[]{-999};
        arrayInputs[3].numbers = new int[]{2,-999};
        arrayInputs[4].numbers = new int[]{11,25,75,12,37,60,90,8,15,32,45,50,67,97,95,-999};
        arrayInputs[5].numbers = new int[]{50,40,60,30,70,20,80,10,90,-999};
        arrayInputs[6].numbers = new int[]{30,40,20,10,50,-999};


        arrayInputs[0].operations =  new HashMap<String, Integer>(){
            {
                put("insert1",21);
                put("delete1",1);
                put("insert2",0);
                put("delete2",10);
                put("delete3",11);
                put("delete4",5);
                put("delete5",2);
                put("insert6",10);
            }
        };


        /*Insert 21 Delete 1 Insert 0 Delete 10
                 Delete 11 Delete 5 Delete 2 Insert 10*/
        return arrayInputs[i];
    }
    

}
