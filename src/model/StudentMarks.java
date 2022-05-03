package model;

public class StudentMarks implements Comparable<StudentMarks>{
    // declared variables
    private String StudentID;
    private String GivenName;
    private String LastName;
    private int CT1;
    private int CT2;
    private int CT3;
    private int ModuleMark;

    //constructor 1
    public StudentMarks(){
        // Add your code here
        this.StudentID = "";
        this.GivenName = "";
        this.LastName = "";
        this.CT1 = 0;
        this.CT2 = 0;
        this.CT3 = 0;
        this.ModuleMark = 0;
    }

    //constructor 2 - data passed in
    public StudentMarks(String studentID, String givenName, String lastName, int CT1, int CT2, int CT3, int moduleMark){
        this.StudentID = studentID;
        this.GivenName = givenName;
        this.LastName = lastName;
        this.CT1 = CT1;
        this.CT2 = CT2;
        this.CT3 = CT3;
        this.ModuleMark = moduleMark;
    }

    //getter and setters
    public String getStudentID() {return this.StudentID;}

    public void setStudentID(String studentID) {this.StudentID = studentID;}

    public String getGivenName() {return this.GivenName;}

    public void setGivenName(String givenName) {this.GivenName = givenName;}

    public String getLastname() {return this.LastName;}

    public void setLastname(String lastname) {this.LastName = lastname;}

    public int getCT1() {return this.CT1;}

    public void setCT1(int CT1) {this.CT1 = CT1;}

    public int getCT2(){return this.CT2;}

    public void setCT2(int CT2) {this.CT2 = CT2;}

    public int getCT3(){return this.CT3;}

    public void setCT3(int CT3) {this.CT3 = CT3;}

    public int getModuleMark(){return this.ModuleMark;}

    public void setModuleMark(int moduleMark) {this.ModuleMark = moduleMark;}

    //calculates the module mark total by adding the class test 1, 2 and 3 marks
    public void calculateModuleMark(){
        // Add your code here
        int moduleMark = this.CT1 + this.CT2 + this.CT3;
        this.setModuleMark(moduleMark);
    }

    public String CSVFormat(){
        String outputStr = this.StudentID + "," + this.GivenName + ","
                + this.LastName+ "," + this.CT1+ "," + this.CT2+ ","
                + this.CT3+ "," + this.ModuleMark;
        return outputStr;

    }

    @Override
    public String toString() {
        return "StudentMarks{" +
                "StudentID='" + this.StudentID + '\'' +
                ", GivenName='" + this.GivenName + '\'' +
                ", LastName='" + this.LastName + '\'' +
                ", CT1=" + this.CT1 +
                ", CT2=" + this.CT2 +
                ", CT3=" + this.CT3 +
                ", ModuleMark=" + this.ModuleMark +
                '}';
    }

    @Override
    public int compareTo(StudentMarks anEntry) {
        // Add your code here
        if(this.ModuleMark == anEntry.getModuleMark())
        {
            return 0;
        }
        else
        {
            if (this.ModuleMark > anEntry.ModuleMark) {
                return 1;
            }
            else {
                return -1;
            }
        }

       // return this.StudentID.compareToIgnoreCase(anEntry.getStudentID());
    }
}
