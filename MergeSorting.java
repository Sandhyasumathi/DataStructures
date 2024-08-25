package datastruct;

import java.util.Arrays;

public class MergeSorting {

	 public int[] mergeSort(int[] arr) {
		 if(arr.length == 1)
			 return arr;
		 int mid = arr.length/2;
		 int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		 int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		 
		 return merge(left,right);
	 }

	private int[] merge(int[] left, int[] right) {
		int i=0,j=0,k=0;
		int[] joined = new int[left.length + right.length];
		while(i<left.length && j<right.length) {
			if(left[i]<right[j]) {
				joined[k++] = left[i++];
			}else {
				joined[k++] = right[j++];
			}
		}
		
		while(i<left.length) {
			joined[k++] = left[i++];
		}
		
		while(j<right.length) {
			joined[k++] = right[j++];
		}
		return joined;
	}
	
	 public void mergeSortInPlace(int[] arr,int start,int end) {
		 if(end-start == 1)
			 return;
		 int mid = (start+end)/2;
		 
		 mergeSortInPlace(arr,start,mid);
		 mergeSortInPlace(arr,mid,end);
		 
		 mergeInPlace(arr,start,mid,end);
	 }

	private void mergeInPlace(int[] arr, int start, int mid, int end) {
		int i=start,j=mid,k=0;
		int[] joined = new int[end-start];
		
		while(i<mid && j<end) {
			if(arr[i]<arr[j]) {
				joined[k++] = arr[i++];
			}else {
				joined[k++] = arr[j++];
			}
		}
		
		while(i<mid) {
			joined[k++] = arr[i++];
		}
		while(j<end) {
			joined[k++] = arr[j++];
		}
		
		for(k=0;k<joined.length;k++) {
			arr[start+k] = joined[k];
		}
	}

}
