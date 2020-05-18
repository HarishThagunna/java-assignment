package com.assignment.five;

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




    }

}