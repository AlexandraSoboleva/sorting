package ru.mail.polis.sort;


public class InsertionSort {
    public static int[] sort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                arr[j] = arr[j] ^ arr[j - 1] ^ (arr[j - 1] = arr[j]);
            }
        }
        return arr;
    }
}
