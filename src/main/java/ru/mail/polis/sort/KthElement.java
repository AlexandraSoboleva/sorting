package ru.mail.polis.sort;



public class KthElement {
    public static int sort(int arr[], int k) {
        kElem(arr, k);
        return arr[k];
    }

    private static void kElem(int[] array, int k) {

        int left = 0;
        int right = array.length - 1;
        while (right > left) {
            int pivotInd = left + (right - left + 1) / 2;
            int mid = partition(array, left, right, pivotInd);
            if (k < mid) right = mid - 1;
            else if (k > mid) left = mid + 1;
            else return;
        }
    }


    private static int partition(int[] arr, int left, int right, int pivot) {
        if (left > right) return right;

        int p = arr[pivot];
        int i = left;
        int j = right;
        Helper.swap(arr, j--, pivot);
        while (i <= j) {
            while (i <= j && arr[i] < p) i++;
            while (i <= j && arr[j] > p) j--;
            if (i >= j) break;
            Helper.swap(arr, i++, j--);
        }
        Helper.swap(arr,i,right);
        return i;
    }
}
