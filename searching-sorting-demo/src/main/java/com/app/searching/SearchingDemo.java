package com.app.searching;

import jdk.jfr.Description;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchingDemo {


    @Test
    void shouldFindSecondLargestNumber(){
        Assertions.assertEquals(25,findSecondLargestNumber(new int[]{20,4,1,40,3,25}));
    }


    @Test
    @Description("will do the binary search")
    void shouldDoBinarySearch(){
        int[] input = {1, 3, 5, 9, 10, 33,44};
        System.out.println(input[  binarySearch(input,10)]);
        Assertions.assertEquals(4,binarySearch(input,10));
    }



    @Description("It will return the second largest number from int array.")
     public int findSecondLargestNumber(int[] input){
        int max=0,j=0;
        for(int i=0;i<input.length;i++){
            if(max<input[i]){
                j=max;
                max=input[i];
            }
            else if(j<input[i]){
                j=input[i];
            }
        }
        return j;
    }

    public int binarySearch(int[] input,int target){

        int low=0,high=input.length-1;
        while(low<=high){
            int mid=(low+high)/2;

            if(input[mid]==target){
                return mid;
            }else if(input[mid]<target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }

        return -1;
    }
}
