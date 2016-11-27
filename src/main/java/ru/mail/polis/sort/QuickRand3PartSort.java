package ru.mail.polis.sort;


import java.util.Random;

public class QuickRand3PartSort {
    public static int[] sort(int arr[]) {
        Random random=new Random();
        qsort(arr,0,arr.length-1,random);
        return arr;
    }

    private static void qsort(int[] arr, int left, int right, Random random) {
        if (left >= right) return;

        int ind = random.nextInt(right - left) + left;
        int pivot=arr[ind];
        int p = left;
        int j=left;

        Helper.swap(arr,left,ind);

        for(int i=left+1; i<=right;i++){
            if (arr[i]<pivot) Helper.swap(arr,++j,i);
            else if (arr[i]==pivot){
                Helper.swap(arr,i,++j);
                Helper.swap(arr,++p,j);
            }
        }
        int q=j;
        for(int i=left;i<=p;i++) Helper.swap(arr,i,j--);

        qsort(arr, left, j,random);
        qsort(arr,q+1, right, random);
    }
}
