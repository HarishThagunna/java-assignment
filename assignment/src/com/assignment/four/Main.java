package com.assignment.four;

public class Main {
    public static void main(String a[]) {
        BinaryTreeOperations bst = new BinaryTreeOperations();
        InputStorage inputStorage = new InputStorage();

        System.out.println("Binary Tree Operations\n");

        int [] numsForBinaryTree = {};

        for(int loop=0;loop<7;loop++){
            System.out.println("--------Start Of Set "+(loop+1)+" Operations------");
            numsForBinaryTree = inputStorage.getNumberSets(loop);

            /* 1. Create a binary tree*/
            for(int i=0;i<numsForBinaryTree.length;i++){
                if(numsForBinaryTree[i] != -999){
                    bst.insert(numsForBinaryTree[i]);
                }
            }
            System.out.println("\nTree Creation Completed...");

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

            switch (loop){
                case 0:
                    System.out.println("\nSet 1 Operations");
                    bst.insert(21);
                    bst.delete(1);
                    bst.insert(0);
                    bst.delete(10);
                    bst.delete(11);
                    bst.delete(5);
                    bst.delete(2);
                    bst.insert(10);
                    break;
                case 1:
                    System.out.println("\nSet 2 Operations");
                    bst.delete(3);
                    bst.delete(1);
                    break;
                case 2:
                    System.out.println("\nSet 3 Operations");
                    bst.delete(15);
                    bst.delete(20);
                    bst.insert(30);
                    bst.delete(10);
                    bst.insert(5);
                    bst.insert(10);
                    bst.delete(5);
                    bst.delete(15);
                    bst.insert(20);
                    bst.delete(30);
                    break;
                case 3:
                    System.out.println("\nSet 4 Operations");
                    bst.delete(2);
                case 4:
                    System.out.println("\nSet 5 Operations");
                    bst.delete(37);
                    bst.delete(15);
                    bst.insert(40);
                    bst.insert(99);
                    break;
                case 5:
                    System.out.println("\nSet 6 Operations");
                    break;
                case 6:
                    System.out.println("\nSet 7 Operations");
                    break;
                default:
                    break;
            }

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

            System.out.println("--------End of Set "+(loop+1)+" Operations------\n");
        }
    }
}
