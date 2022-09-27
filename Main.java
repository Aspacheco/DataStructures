package main;
import java.util.*;

import static java.util.Collections.swap;

public class Main {

    public static void main(String[] args) {
        String option = "";

        do {
            List<Integer> list = new ArrayList<Integer>();

            //Binary Search
            //System.out.println("\t\tBinary Search");
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("Please enter the numbers you want for your list of numbers from 0 to 99: ");
            Scanner scanner = new Scanner(System.in);
            while (scanner.hasNextBigInteger()) {
                list.add(scanner.nextInt());
            }
            scanner.nextLine();

            //System.out.println("Please enter the number you want to find in the array you created: ");
            System.out.println("~ performing QuickSort ~");
            QuickSort(list, 0, list.size() - 1);
            System.out.println(list);

            //get number from user
            System.out.print("Now please enter the number you wish to search for: ");
            int n = scanner.nextInt();
            scanner.nextLine();
            System.out.println("\nThe number " + n + " is in index " + BinarySearch(n, list, 0, list.size() -1));

            System.out.println("Do you wish to go again? Type Y to continue, type N to quit");
            option = scanner.next();

        }while(option.toLowerCase().equals("y"));
        System.out.println("\t\tGoodbye!");
    }// end main

    public static void QuickSort(List<Integer> arr, int minIndex, int maxIndex) {
        //base case
        if(minIndex<maxIndex){
            int pivot = partition(arr, minIndex, maxIndex);
            QuickSort(arr, minIndex, pivot -1);  //left
            QuickSort(arr, pivot + 1, maxIndex);   //right
        }
    }// end Quicksort()

    private static int partition(List<Integer> arr, int lowIndex, int highIndex){
        int pivot = arr.get(highIndex);
        int i = lowIndex -1;

        for(int j=lowIndex; j<=highIndex -1; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        i++;
        swap(arr, i, highIndex);
        return i;
    }// end partition

    public static <list> int BinarySearch(int n, List<Integer> list, int low, int high){
        //initialize variables
        if(low<=high){
            int mid = low + (high - low) /2;

            if(list.get(mid)==n)
                return mid;
            if(list.get(mid)>n)      // search for right part
                return BinarySearch(n, list, low, mid -1);
            if(list.get(mid)<n)
                return BinarySearch(n, list, mid+1, high);
        }// end while
        return -1; // target not found;
    }// end binary
}//end class
