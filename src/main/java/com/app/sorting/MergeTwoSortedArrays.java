package com.app.sorting;

import java.util.Arrays;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int[] result = mergeArrays(new int[]{1, 4, 8, 9}, new int[]{2, 4, 10, 20, 30});
        Arrays.stream(result).forEach(ints -> System.out.println(ints));
    }

    public static int[] mergeArrays(int[]a, int[]b){
        int[] result= new int[a.length+b.length];

        int i=0,j=0,k=0;

        while(i<a.length && j<b.length){
            if(a[i]>b[j]){
                result[k]=b[j];

                j++;
            }else{
                result[k]=a[i];
                i++;
            }
            k++;
        }
        while(i<a.length){
            result[k]=a[i];
            k++;
            i++;

        }

        while(j<b.length){
            result[k]=b[j];
            k++;
            j++;

        }
        return result;
    }
}
