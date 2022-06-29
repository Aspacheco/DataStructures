package main;
import java.util.*;
public class Main {

    public static void main(String[] args) {


        int[] arr = {0,1,2,3,4,5,6,7,8,9,10};

        //Binary Search
        System.out.println("\t\tBinary Search");
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Please enter the number you want to find in an array of numbers from 0 to 10: ");

        //get number from user
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println("The number "+ n + " is in index " + BinarySearch(n, arr));
        System.out.println("\n");



        //Quick Sort
        System.out.println("\t\tQuick Sort");
        System.out.println("------------------------------------------------------------------------------");

        //create array
        int[] arr2 = {7,2,5,6,9,10,4,1,3,8};
        System.out.println("Array before sorting");
        printArray(arr2);
        System.out.println("\nArray after sorting");
        printArray(QuickSort(arr2, 0, arr2.length-1));


        System.out.println("------------------------------------------------------------------------------");

        int[] arr1 ={12,75,29,84,26,64,25,19,0,65,43,39};
        System.out.println("Array before sorting");
        printArray(arr1);
        System.out.println("\nArray after sorting");
        printArray(QuickSort(arr1, 0, arr1.length-1));


    }// end main


    public static int[] QuickSort(int[] arr, int lowIndex, int maxIndex) {

        //base case
        if (lowIndex < maxIndex) {
            int pivot = partition(arr, lowIndex, maxIndex);
            QuickSort(arr, 0, pivot);    //left
            QuickSort(arr, pivot + 1, maxIndex);   //right
        }// end if
        return arr;
    }// end Quicksort()


    private static int partition(int[] arr, int lowIndex, int highIndex){

        int pivot = arr[highIndex];

        int lpointer = lowIndex;
        int hpointer = highIndex -1;

        while(lpointer<(hpointer-1)) {
            while (arr[lpointer] <= pivot && lpointer < hpointer)
                lpointer++;

            while (arr[hpointer] > pivot && lpointer < hpointer)
                hpointer--;


            if (arr[lpointer] > arr[hpointer] && lpointer<(hpointer -1)){ // this will avoid one pointer passing the other
                swap(arr, lpointer, hpointer);
                lpointer++;
                hpointer--;
            }else{
                swap(arr, lpointer, hpointer);
            }


        }// end while

        if(arr[lpointer]>pivot)
            swap(arr, lpointer, highIndex);
        else
            swap(arr,lpointer+1,highIndex);

        return lpointer;

        }// end partition


    private static int[] swap(int[] arr, int low, int high){

        int temp = arr[high];
        arr[high] = arr[low];
        arr[low] =temp;

        return arr;
    }// end swap

    public static int BinarySearch(int n, int[] arr){
        //initialize variables
        int low = arr[0];
        int high = arr.length - 1;

        while(low<=high){
            int mid = low + (high - low) /2;

            if(arr[mid]==n)
                return mid;
            if(arr[mid]<n)      // search for right part
                low = arr[mid] + 1;
            if(arr[mid]>n)
                high = arr[mid] -1;
        }// end while
        return -1; // target not found;
    }// end binary



    public static void printArray(int[] arr){
        for(int i =0; i<arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

}//end class
