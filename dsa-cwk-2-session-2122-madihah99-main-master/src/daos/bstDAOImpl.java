package daos;

import app.StudentMarksBST;
import datastructures.BinarySearchTree;
import helpers.Sorts;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;
import view.aView;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class bstDAOImpl<E> extends DAO<E>{

    private BinarySearchTree<StudentMarks> theBST;
    private final aView theView;
    public static final char DELIMITER = ',';
    public static final char EOLN='\n';
    public static final String QUOTE="\"";
    public static final String USERDIRECTORY = System.getProperty("user.dir");

    private String stripQuotes(String str) {
        return str.substring(1, str.length()-1);
    }

    public bstDAOImpl() {
        // Add your code here
        this.theBST = new BinarySearchTree<>();
        this.theView = new aView();
    }

    public BinarySearchTree<StudentMarks> getTheBST() {
        // Add your code here
        return theBST; // Add your return type here
    }

    public void setTheBST(BinarySearchTree<StudentMarks> theBST) {
        // Add your code here
        this.theBST = theBST;
    }

    @Override
    public void loadFromFile(String filename) {
        String transactionFile = USERDIRECTORY + "\\" + filename;
        // Add your variables here
        ArrayList<StudentMarks> dataSet = new ArrayList<>();
        Sorts<StudentMarks> sort = new Sorts<>();

        try (BufferedReader br = new BufferedReader(new FileReader(transactionFile))) {
            // declares variables
            String studentID;
            String givenName;
            String lastName;
            int ct1;
            int ct2;
            int ct3;
            int moduleMark;

            String[] temp;
            String line = br.readLine();
            while(line!=null){
                // splits each line and stores the values in variables
                temp = line.split(Character.toString(DELIMITER));
                studentID = temp[0];
                givenName = temp[1];
                lastName = temp[2];
                ct1 = Integer.parseInt(temp[3]);
                ct2 = Integer.parseInt(temp[4]);
                ct3 = Integer.parseInt(temp[5]);
                moduleMark = Integer.parseInt(temp[6]);

                // Creates required instances of your modelled data
                StudentMarks anEntry= new StudentMarks();
                anEntry.setStudentID(studentID);
                anEntry.setGivenName(givenName);
                anEntry.setLastname(lastName);
                anEntry.setCT1(ct1);
                anEntry.setCT2(ct2);
                anEntry.setCT3(ct3);
                anEntry.calculateModuleMark();

                // Insert into the dataset
                //this.theBST.addNode(anEntry);
                dataSet.add(anEntry);
                line = br.readLine();

            }
            br.close();
        } catch (IOException ex) {
            Logger.getLogger(StudentMarksBST.class.getName()).log(Level.INFO, null, ex);
        }
        // sorts the dataset
        sort.BSort3(dataSet);
        // creates a balanced tree
        this.theBST.createBalancedTree(dataSet,0, dataSet.size() - 1);
    }

    @Override
    public void writeToFile(String filename) {
        // Add your code here
        try {
            File myFile = new File(USERDIRECTORY +"\\" + filename);

            if(myFile.exists()){
                myFile.delete();
                System.out.println("File deleted: " + myFile.getName());
            }
            else if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public void add(E theData) {
        // Add your code here
        this.theBST.addNode((StudentMarks) theData);
    }

    @Override
    public void update(E theData) {

    }

    @Override
    public void findData(int theData) {
        // Add your code here
        StudentMarks dataToFind = new StudentMarks("",  "", "", 0,0,0,0);
        StudentMarks found = theBST.findItem(dataToFind);
        if(found != null){
            this.theView.displayABSTItem(found);
        }
        else{
            System.out.format("The entry %s was %s found!\n", theData, TextColours.TEXT_RED + "not" + TextColours.TEXT_RESET);
        }
    }

    @Override
    public E getData(String theData) {
        return null;
    }

    @Override
    public void removeData(int theData) {
        // Add your code here
        StudentMarks dataToFind = new StudentMarks("", "", "", 0,0,0,0);
        StudentMarks found = theBST.findItem(dataToFind);
        if(found != null){
            this.theBST.deleteNode(found);
            System.out.format("The entry below has been %s from the tree!\n", TextColours.TEXT_RED + "deleted" + TextColours.TEXT_RESET);
            this.theView.displayABSTItem(found);
        }
        else{
            System.out.format("The entry %s was %s found!\n", theData, TextColours.TEXT_RED + "not" + TextColours.TEXT_RESET);
        }
    }

    public void displayBST(DisplayOrder order){
        // Add your code here
        this.theView.displayBST(this.theBST, order);
    }

   public void displayBSTChart(){
        //Add your code here
        this.theView.displayAsChart(this.theBST);
    }

}
