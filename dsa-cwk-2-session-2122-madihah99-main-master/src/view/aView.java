package view;

import datastructures.BinarySearchTree;
import datastructures.Node;
import helpers.OutputHelper;
import model.DisplayOrder;
import model.StudentMarks;

public class aView {
    public void displayBSTItemAsc(Node<StudentMarks> root){
        // Add your code here
        if (root.leftNode != null) {
            displayBSTItemDesc(root.leftNode);
        }
        System.out.format("| %-25s | %-25s | %-25s | %-20s | %-8s | %-8s | %-8s |\n", root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.rightNode != null) {
            displayBSTItemAsc(root.rightNode);
        }
    }

    public void displayBSTItemDesc(Node<StudentMarks> root){
        // Add your code here
        if (root.rightNode != null) {
            displayBSTItemAsc(root.rightNode);
        }
        System.out.format("| %-25s | %-25s | %-25s | %-8s | %-8s | %-8s | %-20s |\n", root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.leftNode != null) {
            displayBSTItemDesc(root.leftNode);
        }
    }

    /*
    public void displayBSTItemPreorder(Node<StudentMarks> root){
        System.out.format("| %-25s | %-25s | %-25s | %-8s | %-8s | %-8s | %-20s |\n", root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
        if (root.rightNode != null) {
            displayBSTItemDesc(root.rightNode);
        }
        if (root.leftNode != null) {
            displayBSTItemDesc(root.leftNode);
        }
    }

    public void displayBSTItemPostorder(Node<StudentMarks> root){
        if (root.rightNode != null) {
            displayBSTItemDesc(root.rightNode);
        }
        if (root.leftNode != null) {
            displayBSTItemDesc(root.leftNode);
        }
        System.out.format("| %-25s | %-25s | %-25s | %-8s | %-8s | %-8s | %-20s |\n", root.getNodeData().getStudentID(), root.getNodeData().getGivenName(), root.getNodeData().getLastname(), root.getNodeData().getCT1(), root.getNodeData().getCT2(), root.getNodeData().getCT3(), root.getNodeData().getModuleMark());
    }*/

    public void displayBST(BinarySearchTree<StudentMarks> theBST, DisplayOrder order){
        // Add your code here
        System.out.println(OutputHelper.repeat("-", 141));
        System.out.format("| %-25s | %-25s | %-25s | %-8s | %-8s | %-8s | %-20s |\n", "Student ID", "Given Name", "Surname", "CT1", "CT2", "CT3", "Module Mark");
        System.out.println(OutputHelper.repeat("-",141));

        switch (order) {
            case ASCENDING:
                displayBSTItemAsc(theBST.getRoot());
                break;
            case DESCENDING:
                displayBSTItemDesc(theBST.getRoot());
                break;
           /* case PREORDER:
                displayBSTItemPreorder(theBST.getRoot());
                break;
            case POSTORDER:
                displayBSTItemPostorder(theBST.getRoot());
                break;*/
            default:
                System.out.println("Oops! Something has went wrong!");
                break;
        }

        System.out.println(OutputHelper.repeat("-",141));
    }

    public void displayABSTItem(StudentMarks anItem) {
        // Add your code here
        System.out.println(OutputHelper.repeat("-", 141));
        System.out.format("| %-25s | %-25s | %-25s | %-8s | %-8s | %-8s | %-20s |\n", "Student ID", "Given Name", "Surname", "CT1", "CT2", "CT3", "Module Mark");
        System.out.println(OutputHelper.repeat("-", 141));
        System.out.format("| %-25s | %-25s | %-25s | %-8s | %-8s | %-8s | %-20s |\n", anItem.getStudentID(), anItem.getGivenName(), anItem.getLastname(), anItem.getCT1(), anItem.getCT2(), anItem.getCT3(), anItem.getModuleMark());
        System.out.println(OutputHelper.repeat("-", 141));
        System.out.println();
    }



    public void displayStudentScoreInChart(Node<StudentMarks> root) {
        //Add your code here - FINISH

        System.out.format("| %-12s | %-110s |\n", root.getNodeData().getStudentID(), root.getNodeData().getModuleMark());
        System.out.format("%-12s", "1", "%-10s", "1", "%-10s", "2", "%-10s", "3", "%-10s", "4", "%-10s", "5", "%-10s", "6", "%-10s", "7", "%-10s", "8", "%-10s", "9", "%-10s", "1", "%-10s");
        System.out.format("%-22s 0 %-10s 0 %-10s 0 %-10s 0 %-10s 0 %-10s 0 %-10s 0 %-10s 0 %-10s 0 %-10s 0 %-10s");
        System.out.format("%-112s 0 %-10s");
        System.out.println(OutputHelper.repeat("-", 140));
        System.out.println(OutputHelper.repeat(" ", 25));
        System.out.println();
    }

    public void displayAsChart(BinarySearchTree<StudentMarks> theBST){
        // Add your code here - FINISH

    }
}
