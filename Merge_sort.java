//Link : https://www.youtube.com/watch?v=KF2j-9iSf4Q

package com;

public class Merge_Sort {
	static int[] a={3,2,4,2,2,2,1,7,6};
	public static void main(String[] args) {
		merge_sort(a,new int[a.length], 0, a.length-1);
		for(int s:a)
			System.out.print(s+" ");
	}
	static void merge_sort(int[] a,int[] t,int leftstart,int rightend){
		if(leftstart>=rightend)
			return;
		int middle=(leftstart+rightend)/2;
		merge_sort(a, t, leftstart, middle);
		merge_sort(a, t, middle+1, rightend);
		merge(a, t, leftstart, rightend);
	}
	static void merge(int[] a,int[] t,int leftstart,int rightend){
		int leftend=(leftstart+rightend)/2;
		int rightstart=leftend+1;
		int left=leftstart;
		int right=rightstart;
		int i=leftstart;		
		while(left<=leftend && right<=rightend){
			if(a[left]>=a[right]){
				t[i++]=a[right];
				right++;
			}else if(a[left]<a[right]){
				t[i++]=a[left];
				left++;
			}
		}
		while(left<=leftend)
			t[i++]=a[left++];
		while(right<=rightend)
			t[i++]=a[right++];
		while(leftstart<=rightend)
			a[leftstart]=t[leftstart++];
	}
}
