package com.bees360;

import java.util.Arrays;

public class ReadFile9 {
	private static String[] getStaggeredMergeArray(String[] arr1, String[] arr2) {
	    String[] arr = new String[arr1.length + arr2.length];
	    int i, j;
	    for (i = 0, j = 0; i < arr1.length; i++) {
	        j = 2 * i;
	        if (j > 2 * arr2.length)//若arr1数组长度长等于arr2
	            j = arr2.length + i;
	        arr[j] = arr1[i];//0 2 4 
	    }
	    for (i = 0, j = 0; i < arr2.length; i++) {
	        j = 2 * i + 1;
	        if (j > 2 * arr1.length)//若arr2数组长度长等于arr1
	            j = arr1.length + i;
	        arr[j] = arr2[i];//1 3 5 
	    }
	    return arr;
	}

	public static void main(String[] args) {

	    String[] arr1 = { "a", "B", "c", "D" };
	    String[] arr2 = { "1", "2", "3" };       

	    String[] arr = getStaggeredMergeArray(arr1, arr2);

	    System.out.println(Arrays.toString(arr));
	}
}
