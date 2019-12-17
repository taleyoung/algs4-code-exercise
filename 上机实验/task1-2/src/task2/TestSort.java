package task2;
import java.lang.Math;

public class TestSort {
	public double testInsertionTime(int[] a,int times) {
		int N = a.length,count = 0;
		long total = 0;
		while(count < times) {
			for(int i = 0;i < a.length;i++){
				a[i] = (int)(Math.random()*100000);
			}

			long timeStart = System.currentTimeMillis();
			InsertionSort.sort(a);
			long timeEnd = System.currentTimeMillis();
			long timeInterval = timeEnd - timeStart;
			total += timeInterval;
			count++;
		}
		return (double)(total)/times;
		
	}
	
	public double testMergeSortTime(int[] a,int times) {
		int N = a.length,count = 0;
		long total = 0;
		while(count < times) {
			for(int i = 0;i < a.length;i++)
				a[i] = (int)(Math.random()*100000);
			long timeStart = System.currentTimeMillis();
			MergeSort.sort(a);
			long timeEnd = System.currentTimeMillis();
			long timeInterval = timeEnd - timeStart;
			total += timeInterval;
			count++;
		}
		return (double)(total)/times;
		
	}
	
	public double testQuickSortTime(int[] a,int times) {
		int N = a.length,count = 0;
		long total = 0;
		while(count < times) {
			for(int i = 0;i < a.length;i++)
				a[i] = (int)(Math.random()*100000);
			long timeStart = System.currentTimeMillis();
			QuickSort.sort(a);
			long timeEnd = System.currentTimeMillis();
			long timeInterval = timeEnd - timeStart;
			total += timeInterval;
			count++;
		}
		return (double)(total)/times;
	}
	
	public double testThreeWayQuickSortTime(int[] a,int times) {
		int N = a.length,count = 0;
		long total = 0;
		while(count < times) {
			for(int i = 0;i < a.length;i++)
				a[i] = (int)(Math.random()*100000);
			long timeStart = System.currentTimeMillis();
			ThreeWayQuickSort.sort(a);
			long timeEnd = System.currentTimeMillis();
			long timeInterval = timeEnd - timeStart;
			total += timeInterval;
			count++;
		}
		return (double)(total)/times;
	}
	
	
	public double testBUMergeSortTime(int[] a,int times) {
		int N = a.length,count = 0;
		long total = 0;
		while(count < times) {
			for(int i = 0;i < a.length;i++)
				a[i] = (int)(Math.random()*100000);
			long timeStart = System.currentTimeMillis();
			BottomupMergesort.sort(a);
			long timeEnd = System.currentTimeMillis();
			long timeInterval = timeEnd - timeStart;
			total += timeInterval;
			count++;
		}
		return (double)(total)/times;
	}

	public double testQSonRepetitiveEntries(int[] a,int times) {
		int N = a.length,count = 0;
		long total = 0;
		while(count < times) {
			for(int i = 0;i < a.length;i++)
				a[i] = (int)(Math.random()*10);
			long timeStart = System.currentTimeMillis();
			QuickSort.sort(a);
			long timeEnd = System.currentTimeMillis();
			long timeInterval = timeEnd - timeStart;
			total += timeInterval;
			count++;
		}
		return (double)(total)/times;
	}
	public double testThreeWayRepetitveQuickSortTime(int[] a,int times) {
		int N = a.length,count = 0;
		long total = 0;
		while(count < times) {
			for(int i = 0;i < a.length;i++)
				a[i] = (int)(Math.random()*10);
			long timeStart = System.currentTimeMillis();
			ThreeWayQuickSort.sort(a);
			long timeEnd = System.currentTimeMillis();
			long timeInterval = timeEnd - timeStart;
			total += timeInterval;
			count++;
		}
		return (double)(total)/times;
	}
		
	
	public static void main(String args[]) {
		int[] a = new int[10];
		int[] b = new int[1000];
		int[] c = new int[100000];
 		TestSort TestSort1 = new TestSort();
		System.out.println("各排序算法在输入10次后的平均时间如下：");
		System.out.println("Insertion sort："+TestSort1.testInsertionTime(a,10)+"ms");
		System.out.println("Top-down Mergesort sort: "+TestSort1.testMergeSortTime(a,10)+"ms");
		System.out.println("Bottom-up Mergesort sort: "+TestSort1.testBUMergeSortTime(a,10)+"ms");
		System.out.println("Quicksort sort: "+TestSort1.testQuickSortTime(a,10)+"ms");
		System.out.println("ThreewayQuicksort sort: "+TestSort1.testThreeWayQuickSortTime(a,10)+"ms");
		System.out.print("\n");
		System.out.println("各排序算法在输入1000次后的平均时间如下：");
		System.out.println("Insertion sort: "+TestSort1.testInsertionTime(b,10)+"ms");
		System.out.println("Top-down Mergesort sort: "+TestSort1.testMergeSortTime(b,10)+"ms");
		System.out.println("Bottom-up Mergesort sort: "+TestSort1.testBUMergeSortTime(b,10)+"ms");
		System.out.println("Quicksort sort: "+TestSort1.testQuickSortTime(b,10)+"ms");
		System.out.println("ThreewayQuicksort sort: "+TestSort1.testThreeWayQuickSortTime(b,10)+"ms");
		System.out.print("\n");
		System.out.println("各排序算法在输入10000次后的平均时间如下：");
		System.out.println("Insertion sort："+TestSort1.testInsertionTime(c,10)+"ms");
		System.out.println("Top-down Mergesort sort："+TestSort1.testMergeSortTime(c,10)+"ms");
		System.out.println("Bottom-up Mergesort sort："+TestSort1.testBUMergeSortTime(c,10)+"ms");
		System.out.println("Quicksort sort："+TestSort1.testQuickSortTime(c,10)+"ms");
		System.out.println("ThreewayQuicksort sort："+TestSort1.testThreeWayQuickSortTime(c,10)+"ms");
		System.out.print("\n");
		System.out.println("各排序算法在输入100000次后的平均时间如下：");
		System.out.println("Quicksort sor："+TestSort1.testQSonRepetitiveEntries(c,10)+"ms");
		System.out.println("ThreewayQuicksort sort on 100000： "+TestSort1.testThreeWayRepetitveQuickSortTime(c,10)+"ms");

	}

}
