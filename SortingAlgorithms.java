package com.rafaapp;

import java.util.Arrays;

public class SortingAlgorithms {

    public static void main (String[] args) {
        int[] array = {5,3,4, 3, 100, 2, 9, 18, 25, 33, 66,7,2,1,188,22,45,56,32,21,28,19,16,40,10000,345};
        //int[] array = {5,3,4, 1};
        SortingAlgorithms sortingAlgorithms = new SortingAlgorithms();
        int[] resultMerge = sortingAlgorithms.mergeSort(array);

        System.out.println("MergeSort = "+ Arrays.toString(resultMerge));

        int[] resultBubble = sortingAlgorithms.bubbleSort(array);
        System.out.println("BubbleSort = "+ Arrays.toString(resultBubble));

    }
    //O(n log n)
    int[] mergeSort(int[] a){
        int[] left;
        int[] right;
        //Array with One element is a Sorted Array
        if(a.length == 1) {
            return a;
        }

        if(isOdd(a)){
            left = new int[a.length /2];
            right = new int[(a.length /2)+1];
        }else{
            left = new int[a.length /2];
            right = new int[a.length /2];
        }

        for (int i=0; i<a.length; i++) {
            if (i < (a.length/2)) {
                left[i] = a[i];
            } else {
                right[i-a.length /2] = a[i];
            }
        }

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length+right.length];
        int leftIndex = 0;
        int rightIndex = 0;
        int leftValue =0;
        int rightValue=0;

        for(int i=0; i<result.length; i++) {
            if(leftIndex<left.length){
                leftValue = left[leftIndex];
            } else {
                leftValue = -1;
            }
            if(rightIndex<right.length){
                rightValue = right[rightIndex];
            } else {
                rightValue = -1;
            }
            if(leftValue <= rightValue && (-1 != leftValue)){
                result[i] = leftValue;
                leftIndex++;
            } else if (-1 != rightValue){
                result[i] = rightValue;
                rightIndex++;
            } else if(leftValue == -1 && rightValue != -1){
                result[i] = rightValue;
                rightIndex++;
                i++;
                while(rightIndex < right.length){
                    rightValue = right[rightIndex];
                    result[i] = rightValue;
                    rightIndex++;
                    i++;
                }
            } else if(rightValue == -1 && leftValue != -1) {
                result[i] = leftValue;
                leftIndex++;
                i++;
                while(leftIndex < left.length){
                    leftValue = left[leftIndex];
                    result[i] = leftValue;
                    leftIndex++;
                    i++;
                }
            }
        }
        return result;
    }

    boolean isOdd(int[] a){
        if(a.length % 2 != 0) {
            return true;
        }else{
            return false;
        }

    }

    int[] bubbleSort(int[] a){
        int temp = 0;
        for(int j=0; j<a.length; j++) {
            for(int i=0; i<a.length-1; i++) {
                if(a[i] > a[i+1]){
                    temp = a[i];
                    a[i] = a[i+1];
                    a[i+1] = temp;

                }
            }
        }

     return a;
    }
}
