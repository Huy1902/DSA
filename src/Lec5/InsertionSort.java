package Lec5;

public class InsertionSort {
  private static void swap(int[] a, int i, int j) {
    int temp = a[i];
    a[i] = a[j];
    a[j] = temp;
  }
  public static void sort(int[] a) {
    for(int i = 0 ; i < a.length ; i++) {
      int j = i;
      while((j > 0) && (a[j] < a[j - 1])) {
        swap(a, j, j - 1);
        --j;
      }
    }
  }
}
