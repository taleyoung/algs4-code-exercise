package task2;

public class InsertionSort {
	public static void sort(int[] a) {
		int N = a.length;
		for(int i = 1; i < N ; i++) {
			for(int j = i;j>0 && a[j]<a[j-1];j--) {
				int t= a[j];
				a[j] = a[j-1];
				a[j-1] = t;
			}
		}
	}
}
