package com.vineethds.sorting;

/**
 * @author Vineeth
 * Input: {4,5,3,2,1}
 * Output: {1,2,3,4,5}
 * Order: O(n^2)
 *
 */
public class ComboSort {
/*
 * Algorithm Description:
 * Sorts the array by using gap and shrink factor
 * shrink factor has a default values as 1.3f
 * the gap  shrinks for every iteration until the gap becomes one
 * the elements are compared apart the gap as the gap shrinks
 * if a[i]> a[i+gap] swap i and i+gap;
 * 
 */
	
	private void printArray(int[] array) {
		for(int a :array) {
			System.out.print(a+" ");
		}
	}

	private void comboSort(int[] a) {
		
		if(a == null || a.length == 0) {
			return;
		}
		boolean isSwapped = true;
		int gap = a.length;
		int n = a.length;
		final double SHRINK_FACTOR = 1.3;
		while(isSwapped || gap >1) {
			isSwapped = false;
			 gap = (int)(gap / SHRINK_FACTOR);
			for(int i = 0; i < n-gap;i++) {
				if(a[i] > a[i+gap]) {
					swap(a,i,i+gap);
					isSwapped = true;
				}
			}
			
		}
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	public static void main(String[] args) {
		ComboSort cs = new ComboSort();
		int[] a = {4,5,3,2,1};
		cs.comboSort(a);
		cs.printArray(a);
	}

}
