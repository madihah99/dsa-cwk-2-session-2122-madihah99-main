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
    }

    public Node<E> balancedTree(ArrayList<E> dataList, int leftCurrentRange, int rightCurrentRange){
        // Add your code here
        return null; // Add your return type here
    }


    @Override
    public void addNode(E theItem){
        // Add your code here
    }

    private Node<E> addNode(Node<E> localRoot, E theItem) {
        // Add your code here
        return null; // Add your return type here
    }

    @Override
    public boolean nodeContains(E desiredItem){
        // Add your code here
        return true;
    }

    @Override
    public E findItem(E desiredItem){
        // Add your code here
        return null; // Add your return type here
    }
    private E findItem(Node<E> localRoot, E desiredItem) {
        // Add your code here
        return null; // Add your return type here
    }

    @Override
    public E deleteNode(E desiredItem){
        // Add your code here
        return null; // Add your return type here
    }
    
    private Node<E> deleteNode(Node<E> localRoot, E desiredItem){
        // Add your code here
        return null; // Add your return type here
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
