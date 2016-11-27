package ru.mail.polis.sort;


public class MergeSort {

    private static void merge(int[] arr, int[] t, int left, int mid, int right) {
        for (int i = left; i <= right; i++) {
            t[i] = arr[i];
        }
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) arr[k] = t[j++];
            else if (j > right) arr[k] = t[i++];
            else if (t[j] < t[i]) arr[k] = t[j++];
            else arr[k] = t[i++];
        }

    }

    public static int[] sort(int arr[]) {
        int n = arr.length;
        int t[] = new int[n];
        for (int len = 1; len < n; len *= 2) {
            for (int left = 0; left < n - len; left += len + len) {
                int mid = left + len - 1;
                int right = Math.min(left + len + len - 1, n - 1);
                merge(arr, t, left, mid, right);
            }
        }
        return arr;
    }
}
