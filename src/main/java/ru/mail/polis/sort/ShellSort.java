package ru.mail.polis.sort;


public class ShellSort {
    public static int[] sort(int arr[]) {
        int n = arr.length;
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }
        while (h > 0) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
                    arr[j] = arr[j] ^ arr[j - h] ^ (arr[j - h] = arr[j]);
                }
            }
            h /= 3;
        }
        return arr;
    }
}
