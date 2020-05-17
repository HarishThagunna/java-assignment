package com.assignment.four;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String a[]) {
        BinaryTreeOperations bst = new BinaryTreeOperations();
        InputStorage inputStorage = new InputStorage();

        System.out.println("Binary Tree Operations\n");

        int [] numsForBinaryTree = {};

       /* HashMap<String, Integer> operations = new HashMap<String, Integer>();
        for(int loop=0;loop<=0;loop++){
            numsForBinaryTree = inputStorage.getNumberSets(0).numbers;
            operations = inputStorage.getNumberSets(0).operations;

            for (Map.Entry<String,Integer> entry : operations.entrySet()){
                System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            }

        }*/

        numsForBinaryTree = new int []{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,-999};
        /* 1. Create a binary tree*/
        for(int i=0;i<numsForBinaryTree.length;i++){
            if(numsForBinaryTree[i] != -999){
                bst.insert(numsForBinaryTree[i]);
            }
        }

        /* 2. Print the tree using "inorder", 'preorder', and 'postorder */
        System.out.println("\nIn-Order : ");
        bst.inOrderTraversal();
        System.out.println("\nPre-Order : ");
        bst.preOrderTraversal();
        System.out.println("\nPost-Order : ");
        bst.postOrderTraversal();

        /* 3. Call a súbroutine "count", which returns the number of nodes in the tree */
        System.out.println("\n\nNumber of Nodes in a Tree: "+ bst.countNodes());

        /* 4. Call a subroutine "children" which prints the number of children each node has */
        /* 5. Insert and delete several nodes according to the Instructions given */

        bst.insert(26);
        bst.delete(17);
        bst.delete(10);

        /* 6. Print the tree again using 'inorder, "preorder", and "postorder */
        System.out.println("In-Order Current: ");
        bst.inOrderTraversal();
        System.out.println("\nPre-Order Current: ");
        bst.preOrderTraversal();
        System.out.println("\nPost-Order Current: ");
        bst.postOrderTraversal();

        /* 7. Call subroutine *count again, which returns the number of nodes in the tree */
        System.out.println("\n\nCurrent Number of Nodes in a Tree: "+ bst.countNodes());

        /* 8. Call a subroutine *children" again, which prints the number of children each node has */
        /* 9. Free the tree */
        bst.free();

        /*System.out.println("Final InOrder");
        bst.inOrderTraversal();
        bst.insert(5);
        bst.inOrderTraversal();*/
    }
}
