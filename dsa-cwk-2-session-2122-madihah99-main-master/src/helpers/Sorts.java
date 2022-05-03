package helpers;

import java.util.ArrayList;


//sort is using generics and is extending comparable so it can compare different values
public class Sorts<E extends Comparable<E>> {

    /**
     * sorts data prior to insertion in the Binary Search tree
     * @param dataToSort is an ArrayList of the type <E>
     */
    public void BSort3(ArrayList<E> dataToSort){
        boolean sorted = true;
        while (sorted) {
            sorted = false;
            for (int i = 0;  i < dataToSort.size() - 1; i++){
                int swap = dataToSort.get(i).compareTo(dataToSort.get(i+1));
                if(swap > 0) {
                    //create temporary value which holds onto data at given index (i)
                    E temp = dataToSort.get(i);
                    //.set() is used as it is an arraylist
                    //the index is provided followed by the data that we want to swap it with (index +1)
                    dataToSort.set(i, dataToSort.get(i +1));
                    //does the same as above but swaps index + 1 with the value in temp
                    dataToSort.set(i + 1, temp);
                    sorted = true;
                }
            }
        }
    }

    /**
     public void swap(ArrayList<E> dataToSort, int index){
     E temp = dataToSort.get(index);
     dataToSort.set(index,dataToSort.get(index + 1) );
     dataToSort.set(index+1,temp );
     }


     * This method will sort in ascending order the data provided
     * @param dataToSort is an ArrayList Of type </E> (Generic)

    public void BSort(ArrayList<E> dataToSort){
        for(int outer = 0; outer < dataToSort.size() - 1; outer++){
            for(int inner = 0; inner < dataToSort.size() - 1; inner++){
                if(dataToSort.get(inner).compareTo(dataToSort.get(inner+1))>0){
                    swap(dataToSort,inner);
                }
            }
        }
    }
     */
}

