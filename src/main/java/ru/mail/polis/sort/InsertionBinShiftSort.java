package ru.mail.polis.sort;


public class InsertionBinShiftSort {
    public static int[] sort(int[] arr) {
        for (int i=1; i<=arr.length-1;i++){
            int k = BinarySearch(arr, arr[i], -1,i);
            int arrith=arr[i];
            System.arraycopy(arr,k,arr,k+1,i-k);
            arr[k]=arrith;
        }
        return arr;
    }


    private static int BinarySearch(int[] arr, long key, int left, int right) {
        while (left < right - 1) {
            int mid = (left + right) / 2;
            if (arr[mid] < key)
                left = mid;
            else
                right = mid;
        }
        return right;
    }
}
