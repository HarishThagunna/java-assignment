package com.assignment.five;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class FamilyTree {


    // This represents a node of an n-ary tree
    static class Node
    {
        String key;
        Vector<Node> child = new Vector<>();
    };

    //Function to create a new tree node
    static Node newNode(String key)
    {
        Node temp = new Node();
        temp.key = key;
        return temp;
    }

    //Prints the n-ary tree level wise
    private void printTreeLevelWise(Node root)
    {
        if (root == null)
            return;

        // Standard level order traversal code
        // using queue
        Queue<Node> queue = new LinkedList<>(); // Create a queue
        queue.add(root); // Enqueue root
        while (!queue.isEmpty())
        {
            int n = queue.size();

            // If this node has children
            while (n > 0)
            {
                // Dequeue an item from queue
                // and print it
                Node p = queue.peek();
                queue.remove();
                System.out.print(p.key + " ");

                // Enqueue all children of
                // the dequeued item
                for (int i = 0; i < p.child.size(); i++)
                    queue.add(p.child.get(i));
                n--;
            }

            // Print new line between two levels
            System.out.println();
        }
    }

    public String findFather(String child, Node root){
        String father = "";

        if (root == null)
            return null;

        // Standard level order traversal code
        // using queue
        Queue<Node> queue = new LinkedList<>(); // Create a queue
        queue.add(root); // Enqueue root
        while (!queue.isEmpty())
        {
            int n = queue.size();

            // If this node has children
            while (n > 0)
            {
                // Dequeue an item from queue
                // and print it
                Node p = queue.peek();
                queue.remove();

//                System.out.print(p.key + " ");

                // Enqueue all children of
                // the de-queued item
                for (int i = 0; i < p.child.size(); i++)
                {
//                    System.out.println("Child-findFather--- "+p.child.get(i).key);
                    if(p.child.get(i).key == child){
                        father = p.key;
                        return father;
                    }else{
                        queue.add(p.child.get(i));
                    }

                }
                n--;
            }
        }

        return father;
    }

    public ArrayList<String> findAllTheSons(String father, Node root){
        ArrayList<String> sons = new ArrayList<>();

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int n = queue.size();
            while (n > 0)
            {
                Node p = queue.peek();
                queue.remove();

                //check if the input node is the current one
                if(p.key == father){
                    for (int i = 0; i < p.child.size(); i++)
                    {
                        sons.add(p.child.get(i).key);
                    }
                    return sons;
                }

                for (int i = 0; i < p.child.size(); i++)
                {
                    queue.add(p.child.get(i));
                }
            }
            n--;
        }

        return sons;
    }

    public ArrayList<String> findAllTheBrothers(String input, Node root){
        ArrayList<String> brothers = new ArrayList<>();
        String father = findFather(input,root);
//        System.out.println("father ===== " + father);
        brothers = findAllTheSons(father,root);
        brothers.remove(input);;
        return brothers;
    }

    public String findOldestBrother(String bro, Node root){
        String brother = "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Enqueue root
        while (!queue.isEmpty())
        {
            int n = queue.size();

            while (n > 0)
            {
                Node p = queue.peek();
                queue.remove();

                for (int i = 0; i < p.child.size(); i++)
                {
                    if(p.child.get(i).key == bro){
                        brother = p.child.get(0).key;
                        return brother;
                    }else{
                        queue.add(p.child.get(i));
                    }
                }
                n--;
            }
        }

        return brother;
    }

    public String findYoungestBrother(String bro, Node root){
        String brother = "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Enqueue root
        while (!queue.isEmpty())
        {
            int n = queue.size();

            while (n > 0)
            {
                Node p = queue.peek();
                queue.remove();

                for (int i = 0; i < p.child.size(); i++)
                {
                    if(p.child.get(i).key == bro){
                        brother = p.child.get(p.child.size()-1).key;
                        return brother;
                    }else{
                        queue.add(p.child.get(i));
                    }
                }
                n--;
            }
        }

        return brother;
    }

    public String findOldestSon(String father, Node root){
        String son = "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Enqueue root
        while (!queue.isEmpty())
        {
            int n = queue.size();

            while (n > 0)
            {
                Node p = queue.peek();
                queue.remove();

                if(p.key == father && p.child.size() != 0){
                    son = p.child.get(0).key;
                    return son;
                }

                for (int i = 0; i < p.child.size(); i++)
                {
                    queue.add(p.child.get(i));
                }

                n--;
            }
        }
        return son;
    }

    public String findYoungestSon(String father, Node root){
        String son = "";

        Queue<Node> queue = new LinkedList<>();
        queue.add(root); // Enqueue root
        while (!queue.isEmpty())
        {
            int n = queue.size();

            while (n > 0)
            {
                Node p = queue.peek();
                queue.remove();

                if(p.key == father && p.child.size() != 0){
                    son = p.child.get(p.child.size()-1).key;
                    return son;
                }

                for (int i = 0; i < p.child.size(); i++)
                {
                    queue.add(p.child.get(i));
                }
                n--;
            }
        }
        return son;
    }

    public ArrayList<String> findAllUncles(String bhatiz, Node root){
        ArrayList<String> uncles = new ArrayList<>();
        String father = findFather(bhatiz,root);
//        System.out.println("father ===== " + father);
        if(father != "") {
            uncles = findAllTheBrothers(father,root);
        }

        return uncles;
    }

    public String findGrandfather(String nati, Node root){
        String grandFather = "";
        String father = findFather(nati, root);
        if(father != "") {
            grandFather = findFather(father,root);
        }
        return grandFather;
    }


    public static void main(String[] args) {
        /*
         *      Jones
         *     / / \ \
         *     Bob   Dan     Brian
         *     / \         | / | \
         *Richard  Jake     Michael
                    \       \
                    Bill    Deville
         * */

        FamilyTree familyTree = new FamilyTree();
        ArrayList<String> returnResult = new ArrayList<>();
        String returnStrNode = "";
        String input;

        Node root = newNode("Jones");
        (root.child).add(newNode("Bob"));
        (root.child).add(newNode("Dan"));
        (root.child).add(newNode("Brian"));


        (root.child.get(0).child).add(newNode("Richard"));
        (root.child.get(0).child).add(newNode("Jake"));
        (root.child.get(2).child).add(newNode("Michael"));


        (root.child.get(0).child.get(1)).child.add(newNode("Bill"));
        (root.child.get(2).child.get(0)).child.add(newNode("Deville"));

        System.out.println("---Family Tree Level Wise---");
        familyTree.printTreeLevelWise(root);

        System.out.println("\n\n-------Operations-------\n");

        /*1) Who is the father of p? */
        input = "Bob";
        returnStrNode = familyTree.findFather(input, root);
        if (returnStrNode !="") {
            System.out.println("Father of "+input +" is :" + returnStrNode);
        }else {
            System.out.println("Father of "+input +" not found. Invalid input or input is root.");
        }

        /* 2) Who are all the sons of p? */
        input = "Brian";
        returnResult = familyTree.findAllTheSons(input, root);
        if(returnResult.size()==0){
            System.out.println(input + " doesn't have any son/s.\n");
        }else {
            System.out.println("All the son/s of "+input+ " : "+returnResult);

        }

        /* 3) Who are all the brothers of p? */
        input = "Bob";
        returnResult = familyTree.findAllTheBrothers(input, root);
        if(returnResult.size()==0){
            System.out.println(input + " doesn't have any brother/s.\n");
        }else {
            System.out.println("All the brother/s of " + input + " : " + returnResult);
        }

        /* 4) Who is the oldest brother of p? */
        input = "Brian";
        returnStrNode = familyTree.findOldestBrother(input, root);
        if (returnStrNode != input && returnStrNode != "") {
            System.out.println("Oldest brother of "+input +" is :" + returnStrNode);
        }else if(returnStrNode == input){
            System.out.println(input + " is single/oldest child.");
        }else {
            System.out.println("No brother/s of "+input);
        }

        /* 5) Who is the youngest brother of p? */
        input = "Brian";
        returnStrNode = familyTree.findYoungestBrother(input, root);
        if (returnStrNode != input && returnStrNode != "") {
            System.out.println("Youngest brother of "+input +" is :" + returnStrNode);
        }else if(returnStrNode == input){
            System.out.println(input + " is a single/youngest child.");
        }else {
            System.out.println("No brother/s of "+input);
        }

        /*6) Who is the oldest son of p? .*/
        input = "Bill";
        returnStrNode = familyTree.findOldestSon(input, root);
        if (returnStrNode !="") {
            System.out.println("Oldest son of "+input +" is :" + returnStrNode);
        }else {
            System.out.println("No son/s of "+input +" found. ");
        }

        /* 7) Who is the youngest son of p? */
        input = "Jones";
        returnStrNode = familyTree.findYoungestSon(input, root);
        if (returnStrNode !="") {
            System.out.println("Youngest son of "+input +" is :" + returnStrNode);
        }else {
            System.out.println("No son/s of "+input +" found. ");
        }

        /*8) Who are the uncles of p? */
        input = "Jones";
        returnResult = familyTree.findAllUncles(input, root);
        if(returnResult.size()==0){
            System.out.println(input + " doesn't have any uncle/s.\n");
        }else {
            System.out.println("All the uncle/s of "+input+ " : "+returnResult);

        }

         /* 9) Who is the grandfather of p?*/
        input = "Bob";
        returnStrNode = familyTree.findGrandfather(input, root);
        if (returnStrNode !="") {
            System.out.println("Grandfather of "+input +" is :" + returnStrNode);
        }else {
            System.out.println("No grandfather of "+input +" found. ");
        }
    }

}
