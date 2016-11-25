package ru.mail.polis.sort;


public class QuickSort {
    public static int[] sort(int arr[]) {
        qsort(arr,0,arr.length-1);
        return arr;
    }
    private static void qsort(int[] arr, int left, int right) {
        if (left>=right) return;
        int idx=partition(arr,left,right);
        qsort(arr,left,idx);
        qsort(arr,idx+1,right);
    }

    private static int partition(int[] arr, int left, int right) {
        int p = arr[left + (right - left + 1) / 2];
        int i = left;
        int j = right;

        while (i <= j) {
            while (arr[i] < p) i++;
            while (arr[j] > p) j--;
            if (i <= j) {
                arr[j] = arr[j] ^ arr[i] ^ (arr[i] = arr[j]);
                i++;
                j--;
            }
        }
        return j;
    }
}
