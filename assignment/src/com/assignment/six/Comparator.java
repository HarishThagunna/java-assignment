package com.assignment.six;

public class Comparator {
    public void compareSorts(int [] bubble, int [] quick, int [] heap){
        System.out.println("Number Of Comparisons Wise:");
        if(bubble[0]>quick[0] && bubble[0]>heap[0]){
            if(quick[0]>heap[0]){
                System.out.println("Bubble (" + bubble[0]+")"+" > "+"Quick ("+quick[0]+")"+" > "+"Heap ("+heap[0]+")");
            }else{
                System.out.println("Bubble (" + bubble[0]+")"+" > "+"Heap ("+heap[0]+")"+" > "+"Quick ("+quick[0]+")");
            }
        }else if(quick[0]>bubble[0] && quick[0]>heap[0]) {
            if (bubble[0] > heap[0]) {
                System.out.println("Quick (" + quick[0] + ")" + " > " + "Bubble (" + bubble[0] + ")" + " > " + "Heap (" + heap[0] + ")");
            } else {
                System.out.println("Quick (" + quick[0] + ")" + " > " + "Heap (" + heap[0] + ")" + " > " + "Bubble (" + bubble[0] + ")");
            }
        } else{
            if(bubble[0]>quick[0]){
                System.out.println("Heap (" + heap[0]+")"+" > "+"Bubble ("+bubble[0]+")"+" > "+"Quick ("+quick[0]+")");
            }else{
                System.out.println("Heap (" + heap[0]+")"+" > "+"Quick ("+quick[0]+")"+" > "+"Bubble ("+bubble[0]+")");
            }
        }

        System.out.println("-----XXX------XXX-----XXX------");
        System.out.println("Number Of Interchanges Wise:");

        if(bubble[1]>quick[1] && bubble[1]>heap[1]){
            if(quick[1]>heap[1]){
                System.out.println("Bubble (" + bubble[1]+")"+" > "+"Quick ("+quick[1]+")"+" > "+"Heap ("+heap[1]+")");
            }else{
                System.out.println("Bubble (" + bubble[1]+")"+" > "+"Heap ("+heap[1]+")"+" > "+"Quick ("+quick[1]+")");
            }
        }else if(quick[1]>bubble[1] && quick[1]>heap[1]) {
            if (bubble[1] > heap[1]) {
                System.out.println("Quick (" + quick[1] + ")" + " > " + "Bubble (" + bubble[1] + ")" + " > " + "Heap (" + heap[1] + ")");
            } else {
                System.out.println("Quick (" + quick[1] + ")" + " > " + "Heap (" + heap[1] + ")" + " > " + "Bubble (" + bubble[1] + ")");
            }
        } else{
            if(bubble[1]>quick[1]){
                System.out.println("Heap (" + heap[1]+")"+" > "+"Bubble ("+bubble[1]+")"+" > "+"Quick ("+quick[1]+")");
            }else{
                System.out.println("Heap (" + heap[1]+")"+" > "+"Quick ("+quick[1]+")"+" > "+"Bubble ("+bubble[1]+")");
            }
            }
    }

    /*public static void main(String[] args) {
        Comparator comparator = new Comparator();
        int [] ar = {1,6};
        int [] br = {3,1};
        int [] cr = {4,5};
        comparator.compareSorts(ar,br,cr);
    }*/

}
