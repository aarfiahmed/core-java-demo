package com.app.sorting;

public class InsertionSort {

    public static void main(String[] args) {
        int[] input =null;
         for(int i:  input=  doInsertionSort(new int[]{10,2,1,7,10,4})){
            System.out.println(i);
        }
    }

    static int[] doInsertionSort(int[] input){

        for(int i=1;i<input.length;i++){
            int j =i-1;
            int temp = input[i];

            while(j>=0 && temp<input[j]){
                input[j+1]=input[j];
                j--;
            }
            input[j+1]=temp;
        }
        return input;


    }
}
