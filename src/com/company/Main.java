package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        int[] arr = {1, 5 ,6, 8 , 20, 5, 5};

        Main main = new Main();

        main.mergeSort(arr, arr.length);

        for(int i = 0; i< arr.length; i++) {
            System.out.println("====>" + arr[i]);
        }
    }

    private void mergeSort(int[] arr, int numberOfElements) {

        if(numberOfElements < 2) {
            return;
        } else {

            int middle = numberOfElements / 2;
            int[] leftArr = new int[middle];
            int[] rightArr = new int[numberOfElements - middle];

            //Fill up partitions(arrays -> left and right)

            //This if for left array
            for(int i = 0; i < middle; i++) {
                leftArr[i] = arr[i];
            }

            //This is for right array
            for(int i = middle; i < numberOfElements; i++) {
                rightArr[i - middle] = arr[i];
            }

            mergeSort(leftArr, middle);
            mergeSort(rightArr, numberOfElements - middle);

            merge(arr, leftArr, rightArr, middle, numberOfElements - middle);
        }
    }

    private void merge(int[] arr, int[] leftArr, int[] rightArr, int left, int right) {

        int i = 0, j = 0, k = 0;

        while( i < left && j < right) {

            if(leftArr[i] <= rightArr[j]) {

                arr[k++] = leftArr[i++];

            } else {

                arr[k++] = rightArr[j++];
            }

        }

        while( i < left) {
            arr[k++] = leftArr[i++];
        }

        while( j < right) {
            arr[k++] = rightArr[j++];
        }

    }
}
