package ru.mail.polis.sort.valid;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

<<<<<<< HEAD
import ru.mail.polis.sort.*;
=======
import ru.mail.polis.sort.BubbleSort;
import ru.mail.polis.sort.Helper;
>>>>>>> b80252a6a2cd89dfa854c82ae786fe92000019a4

@RunWith(value = Parameterized.class)
public class Tester {

<<<<<<< HEAD
    private static final Random r = ThreadLocalRandom.current();

=======
>>>>>>> b80252a6a2cd89dfa854c82ae786fe92000019a4
    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(final Description description) {
            System.err.println("=== Running " + description.getMethodName());
        }
    };
<<<<<<< HEAD
    @Parameterized.Parameter
    public int[] array;

    private static int[] gen(int n) {
        int[] a = new int[n];

        //средний случай
        for (int i = a.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            Helper.swap(a, i, j);
        }
        return a;
    }

    private static int[] random(int n, int m) {
        Random rand = new Random();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = rand.nextInt(m);
        }
        return a;
    }

    private static int[] sawtooth(int n, int m) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i % m;
        }
        return a;
    }

    private static int[] stagger(int n, int m) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = m * (i + 1) % n;
        }
        return a;
    }

    private static int[] plateau(int n, int m) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Math.min(i, m);
        }
        return a;
    }

    private static int[] reverse(int n, int begin, int end) {
        end--;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        int k=(end - begin) / 2;
        for (int i = 0; i <=k ; i++) {
            Helper.swap(a, begin+i,  end-i);
        }

        return a;
    }

    private static int[] partSortArray(int n){
        int[] a = new int[n];
        Random random=new Random();
        int r=random.nextInt(n/2+1)-(n/2-n/4);
        for (int i = 0; i < a.length; i++) {
            a[i]=r++;
            if (r==a.length) r=1;
        }
        return a;
    }

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        int n = 1000;
        int m = n*3/4;
        return Arrays.asList(new int[][]{
          /*  {0},
=======

    @Parameterized.Parameter
    public int[] array;

    @Parameterized.Parameters(name = "{index}")
    public static Collection<int[]> data() {
        return Arrays.asList(new int[][]{
            {0},
>>>>>>> b80252a6a2cd89dfa854c82ae786fe92000019a4
            {0, 0, 0, 0},
            {4, 3, 2, 1},
            {0, 1, 1, 0},
            {1},
            {Integer.MAX_VALUE, 0, 0, Integer.MIN_VALUE},
<<<<<<< HEAD
            gen(1),
            gen(10),
            gen(100),
            gen(1000),
            gen(10000),

              random(n, m),
               sawtooth(n, m),
                stagger(n,m),
                plateau(n,m),
                reverse(n,0,n),
                reverse(n,0,n/2),
                reverse(n,n/2,n),*/

                //тесты для mergesort без дополнительной памяти (требуется массив, состоящий ищ двух отсртированных частей)
               partSortArray(n),
                gen(n)

        });
    }


    private boolean isSorted(int[] a) {
        boolean isSorted = true;
      /* for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1]; //исходная проверка на отсортированность - годится только в случае n-перестановки
        }*/
        int[] arr = new int[a.length];
        for (int i = 0; i < arr.length; i++) {
            // arr[i]=i; //в случае n-перестановки
            arr[i] = a[i]; // в остальных случаях
        }
        Arrays.sort(arr);// в остальных случаях
        for (int i = 0; i < a.length && isSorted; i++) {
            isSorted = a[i] == arr[i];
=======
            Helper.gen(1),
            Helper.gen(10),
            Helper.gen(100),
            Helper.gen(1000),
            Helper.gen(10000),
        });
    }

    private boolean isSorted(int[] a) {
        boolean isSorted = true;
        for (int i = 0; i < a.length - 1 && isSorted; i++) {
            isSorted = a[i] <= a[i + 1];
>>>>>>> b80252a6a2cd89dfa854c82ae786fe92000019a4
        }
        return isSorted;
    }

<<<<<<< HEAD
    private boolean isKthEl(int[] a,int k, int res) {
        boolean isKth;
        Arrays.sort(a);
       return isKth=res==a[k];
    }

=======
>>>>>>> b80252a6a2cd89dfa854c82ae786fe92000019a4
    @Test
    public void test01_checkBubbleSort() throws IOException {
        Assert.assertTrue(isSorted(BubbleSort.sort(array)));
    }

<<<<<<< HEAD
    @Test
    public void test01_checkInsertionSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionSort.sort(array)));
    }

    @Test
    public void test01_checkInsertionBinSort() throws IOException {
        Assert.assertTrue(isSorted(InsertionBinShiftSort.sort(array)));
    }

    @Test
    public void test01_checkShellSort() throws IOException {
        Assert.assertTrue(isSorted(ShellSort.sort(array)));
    }

    @Test
    public void test01_checkMergeSort() throws IOException {
        Assert.assertTrue(isSorted(MergeSort.sort(array)));
    }

    @Test
    public void test01_checkMergeSortWithoutExtraMem() throws IOException {
        Assert.assertTrue(isSorted(MergeSortWithoutExtraMem.sort(array)));
    }

    @Test
    public void test01_checkQuickSort() throws IOException {
        Assert.assertTrue(isSorted(QuickSort.sort(array)));
    }

    @Test
    public void test01_checkQuickRand3PartSort() throws IOException {
        Assert.assertTrue(isSorted(QuickRand3PartSort.sort(array)));
    }

    @Test
    public void test01_checkQKthElement() throws IOException {
        Random rand=new Random();
       int k=rand.nextInt(1);
        Assert.assertTrue(isKthEl(array,k,(KthElement.sort(array,k))));
    }

    @Test
    public void test01_checkQKthElementLin() throws IOException {
        Random rand=new Random();
        int k=rand.nextInt(10);
        Assert.assertTrue(isKthEl(array,k,(KthElementLin.sort(array,k))));
    }

=======
>>>>>>> b80252a6a2cd89dfa854c82ae786fe92000019a4
}
