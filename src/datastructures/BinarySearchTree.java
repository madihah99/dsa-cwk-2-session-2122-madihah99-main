/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.ArrayList;

/**
 *
 * @author rla
 * @param <E>
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements IBSearchTree<E> {
    // <E extends Comparable<E>>

    @Override
    public void createBalancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange){
        // Add your code here
        root = balancedTree(dataList, leftCurrentRange, rightCurrentRange);
    }

    /**
     * This method will create a balanced BST based on the provided data, the left range and the right range.
     * @param dataList is an ArrayList of type E
     * @param leftCurrentRange is the starting value for the left hand subtree
     * @param rightCurrentRange is the ending value for the right hand subtree
     * @return Node<E></E> which is a generic tree element
     */

    public Node<E> balancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange){
        // Add your code here
        if(leftCurrentRange > rightCurrentRange){
            return null;
        }
        int mid = (leftCurrentRange + rightCurrentRange)/2;
        Node<E> aNode = new Node<>(dataList.get(mid));
        aNode.leftNode = balancedTree(dataList, leftCurrentRange, mid - 1);
        aNode.rightNode = balancedTree(dataList, mid + 1, rightCurrentRange);
        return aNode;
    }


    @Override
    public void addNode(E theItem){
        // Add your code here
        root = addNode(root, theItem);
    }

    private Node<E> addNode(Node<E> localRoot, E theItem) {
        // Add your code here
        if (localRoot == null) {
            // item is not in the tree insert it.
            System.out.println("Item has been inserted in the BST!\n");
            return new Node<>(theItem);
        } else if (theItem.compareTo(localRoot.getNodeData()) == 0) {
            // item is equal to localRoot.data
            System.out.println("Item already exists in the BST!");
            return localRoot;
        } else if (theItem.compareTo(localRoot.getNodeData()) < 0) {
            // item is less than localRoot.data
            localRoot.leftNode = addNode(localRoot.leftNode, theItem);
            return localRoot;
        } else {
            // item is greater than localRoot.data
            localRoot.rightNode = addNode(localRoot.rightNode, theItem);
            return localRoot;
        }
    }

    @Override
    public boolean nodeContains(E desiredItem){
        // Add your code here
        return findItem(desiredItem)!= null;
    }

    @Override
    public E findItem(E desiredItem){
        // Add your code here
        return findItem(root, desiredItem);
    }
    private E findItem(Node<E> localRoot, E desiredItem) {
        // Add your code here
        if (localRoot == null) {
            return null;
        }
        // Compare the target with the data field at the root.
        int compResult = desiredItem.compareTo(localRoot.getNodeData());
        if (compResult == 0) {
            return localRoot.getNodeData();
        } else if (compResult < 0) {
            return findItem(localRoot.leftNode, desiredItem);
        } else {
            return findItem(localRoot.rightNode, desiredItem);
        }
    }

    @Override
    public E deleteNode(E desiredItem){
        // Add your code here
        root = deleteNode(root, desiredItem);
        return root.getNodeData();
    }
    
    private Node<E> deleteNode(Node<E> localRoot, E desiredItem){
        // Add your code here
        if (localRoot == null)
            return localRoot;

        int compResult = desiredItem.compareTo(localRoot.nodeData);
        if (compResult < 0) {
            localRoot.leftNode = deleteNode(localRoot.leftNode, desiredItem);
        } else if (compResult > 0) {
            localRoot.rightNode = deleteNode(localRoot.rightNode, desiredItem);
        } else {

            if (localRoot.leftNode == null) {
                return localRoot.rightNode;
            } else if (localRoot.rightNode == null)
                return localRoot.leftNode;

            localRoot.nodeData = inOrderSuccessor(localRoot.rightNode);
            localRoot.rightNode = deleteNode(localRoot.rightNode, localRoot.nodeData);
        }

        return localRoot;
    }
    private E inOrderSuccessor(Node<E> localRoot) {
        // If the left child has no left child, it is
        // the inorder successor.
        if (localRoot.leftNode.leftNode == null) {
            E minimum = localRoot.leftNode.nodeData;
            localRoot.leftNode = localRoot.leftNode.rightNode;
            return minimum;
        }
        return inOrderSuccessor(localRoot.leftNode);
    }
    
    @Override
    public boolean removeNode(E desiredItem){
        return deleteNode(desiredItem) != null;
    }

}
