package com.assignment.four;

public class BinaryTreeOperations {
    private BinaryTreeNode root;

    public boolean isEmpty() {

        return (this.root == null);
    }

    public BinaryTreeNode getRoot() {
        return this.root;
    }

    public void insert(Integer data) {

        if(root == null) {
            this.root = new BinaryTreeNode(data);
            return;
        }

        insertNode(this.root, data);
    }

    private BinaryTreeNode insertNode(BinaryTreeNode root, Integer data) {

        BinaryTreeNode tmpNode = null;
        if(root.getData() >= data) {
            if(root.getLeft() == null) {
                root.setLeft(new BinaryTreeNode(data));
                return root.getLeft();
            } else {
                tmpNode = root.getLeft();
            }
        } else {
            if(root.getRight() == null) {
                root.setRight(new BinaryTreeNode(data));
                return root.getRight();
            } else {
                tmpNode = root.getRight();
            }
        }

        return insertNode(tmpNode, data);
    }

    public void delete(Integer data) {

        deleteNode(this.root, data);
    }

    private BinaryTreeNode deleteNode(BinaryTreeNode root, Integer data) {

        if(root == null) return root;

        if(data < root.getData()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if(data > root.getData()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            // node with no leaf nodes
            if(root.getLeft() == null && root.getRight() == null) {
//                System.out.println("deleting "+data);
                return null;
            } else if(root.getLeft() == null) {
                // node with one node (no left node)
//                System.out.println("deleting "+data);
                return root.getRight();
            } else if(root.getRight() == null) {
                // node with one node (no right node)
//                System.out.println("deleting "+data);
                return root.getLeft();
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Integer minValue = minValue(root.getRight());
                root.setData(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
//                System.out.println("deleting "+data);
            }
        }

        return root;
    }

    private Integer minValue(BinaryTreeNode node) {

        if(node.getLeft() != null) {
            return minValue(node.getLeft());
        }
        return node.getData();
    }

    public void inOrderTraversal() {
        doInOrder(this.root);
    }

    private void doInOrder(BinaryTreeNode root) {

        if(root == null) return;
        doInOrder(root.getLeft());
        System.out.print(root.getData()+" ");
        doInOrder(root.getRight());
    }

    /* Function for preOrder traversal */
    public void preOrderTraversal()
    {
        doPreOrder(this.root);
    }

    private void doPreOrder(BinaryTreeNode root)
    {
        if (root != null)
        {
            System.out.print(root.getData() +" ");
            doPreOrder(root.getLeft());
            doPreOrder(root.getRight());
        }
    }

    /* Function for postOrder traversal */
    public void postOrderTraversal()
    {
        doPostOrder(this.root);
    }

    private void doPostOrder(BinaryTreeNode root)
    {
        if (root != null)
        {
            doPostOrder(root.getLeft());
            doPostOrder(root.getRight());
            System.out.print(root.getData() +" ");
        }
    }

    /* Function to count number of nodes */
    public int countNodes()
    {
        return countNodes(this.root);
    }

    /* Function to count number of nodes recursively*/
    private int countNodes(BinaryTreeNode root)
    {
        if (root == null)
            return 0;
        else
        {
            int l = 1;
            l += countNodes(root.getLeft());
            l += countNodes(root.getRight());
            return l;
        }
    }

    /*Free the tree */
    public void free(){
        this.root = null;
    }

    /*private BinaryTreeNode deleteTree(BinaryTreeNode root) {
        if (root != null) {
            deleteTree(root.getLeft());
            deleteTree(root.getRight());
//            System.out.println("Deleting Node:" + root.getData());
            this.root=null;
            return root;
        }
        return null;
    }*/
}
