package com.app.sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int[] input={3,6,1,10,3};
        for (int i : input = bubbleSort(input)) {
            System.out.println(i);
        }
    }


    static int[] bubbleSort(int[] input){

        for(int i=0;i<input.length-1;i++){
            for(int j=0;j<input.length-1-i;j++){

                if(input[j]>input[j+1]){
                    int temp = input[j];
                    input[j]=input[j+1];
                    input[j+1]=temp;
                }
            }
        }


        return input;
    }

}
