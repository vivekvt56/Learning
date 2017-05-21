/*
Question :: Generate all the strings of length n drawn from 0... k – 1
*/
package com;

public class BinaryStringsModified1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k[]={0,1};
		int n=3;
		System.out.println("Strings of length "+n+" from "+k.length+" bit array is ::");
		generateString(new int[n], k, 0);
	}
	static void generateString(int[] a,int[] k,int n){
		if(n==a.length){
			for(int i:a){
				System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=0;i<k.length;i++){
			a[n]=k[i];
//			System.out.println("g");
			generateString(a, k, ++n);
//			System.out.println("a");
			--n;
		}
	}

}
/*
Output ::
Strings of length 3 from 2 bit array is ::
0 0 0 
0 0 1 
0 1 0 
0 1 1 
1 0 0 
1 0 1 
1 1 0 
1 1 1 
*/