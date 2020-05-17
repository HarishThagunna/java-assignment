package com.assignment.four;

public class BinaryTreeNode {

    private BinaryTreeNode left;
    private BinaryTreeNode right;
    private Integer data;

    public BinaryTreeNode(Integer data) {
        this.data = data;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }
    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }
    public BinaryTreeNode getRight() {
        return right;
    }
    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
