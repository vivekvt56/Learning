/*
Question :: Generate all the strings of n bits.
*/
package com;

public class BinaryStrings {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=3;
		System.out.println("Strings for n = "+n+" are :: ");
		generateString(new int[n], 0);
	}
	static void generateString(int[] a,int n){
		if(n==a.length){
			for(int i:a)
				System.out.print(i);
			System.out.println();
			return;
		}
		a[n]=0;
		generateString(a, ++n);
		a[--n]=1;
		generateString(a, ++n);
		
	}
}
/*
Output ::
Strings for n = 3 are :: 
000
001
010
011
100
101
110
111
*/