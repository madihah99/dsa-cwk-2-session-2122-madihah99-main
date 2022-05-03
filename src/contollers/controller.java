package contollers;

import daos.bstDAOImpl;
import helpers.InputHelper;
import helpers.OutputHelper;
import helpers.TextColours;
import model.DisplayOrder;
import model.StudentMarks;


public class controller {
    private final bstDAOImpl<StudentMarks> bstDAO;
    private final InputHelper inputHelper;

    public controller() {
        this.bstDAO = new bstDAOImpl<>();
        this.inputHelper = new InputHelper();
    }

    /**
     * Displays the menu and uses an InputHelper object
     * to accept valid user choice.
     * An appropriate private method is called to implement the choice.
     */
    public void run() {
        boolean finished = false;

        int iChoice;
        this.setup();

        do {
            this.theMenu();
            iChoice = inputHelper.readInt("Enter choice", 5,1);
            switch (iChoice) {
                // Add more cases
                case 1:
                    this.findMark();
                    System.out.println();
                    break;
                case 2:
                    this.displayMarks(DisplayOrder.ASCENDING);
                    System.out.println();
                    break;
                case 3:
                    this.displayMarks(DisplayOrder.DESCENDING);
                    System.out.println();
                    break;
                case 4:
                    this.displayAsChart();
                    System.out.println();
                    break;
                case 5:
                    System.out.println("All Complete! Goodbye~");
                    finished = true;
                    break;
                default: // invalid option
                    System.out.println("Oops! Something has went wrong!");
                    break;
            }
        }while(!finished);
    }
    private void theMenu() {
        // Print menu to console
        System.out.println(TextColours.TEXT_PURPLE + "Class Test Data");
        System.out.println("-----------------------"  + TextColours.TEXT_RESET);
        System.out.println("1: Find a Module Mark");
        System.out.println("2: Overall Module Marks in Ascending Order");
        System.out.println("3: Overall Module Marks in Descending Order");
        System.out.println("4: Display Module Marks as a Chart");
        System.out.println("5: Exit");
        System.out.println();
    }

    // Add your code here
    // Add more private methods for each of your cases
    private void findMark() {
        System.out.println("Find a Module Mark");
        System.out.println("------------------");
        int aMark = inputHelper.readInt("Please enter the module mark to find ");
        this.bstDAO.findData(aMark);
    }

    private void displayMarks(DisplayOrder order){
        System.out.format("Display Module Marks in %s order", order.toString());
        System.out.println();
        System.out.println("--------------------------------------");
        this.bstDAO.displayBST(order);
    }

    private void displayAsChart() {
        System.out.println("Display Module Marks as a Chart");
        System.out.println("-------------------------------");
        this.bstDAO.displayBSTChart();
    }

    private void setup(){

        this.bstDAO.loadFromFile("ClassTestData.txt");
    }

}
