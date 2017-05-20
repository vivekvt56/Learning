package com;

public class LongestIncSubseqLgt {
	static int[] set={3,4,-1,0,6,2,3};
	static int[] temp={1,1,1,1,1,1,1};
	public static void main(String[] args) {
		LongestSubseqLgt();
		for(int i:temp)
			System.out.print(i+" ");
		System.out.println("\nlongest inc Subsequence Length :: "+temp[set.length-1]);
	}
	static void LongestSubseqLgt(){
		for(int i=1;i<set.length;i++){
			for(int j=0;j<i;j++){
				if(set[i]>set[j]){
					if(temp[i]<(temp[j]+1)){
						temp[i]=temp[j]+1;
					}
				}
			}
		}
	}

}
/*
Output:::
1 2 1 2 3 3 4 
longest inc Subsequence Length :: 4
*/