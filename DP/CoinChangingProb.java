package com;

public class CoinChanging {
	static int[] set={1,5,6,8};
	static int sum=13;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a=new int[set.length][sum+1];
		createMatrix(a);
		for(int i=0;i<set.length;i++){
			for(int j=0;j<=sum;j++){
				System.out.print(a[i][j]+" | ");
			}
			System.out.println();
		}
		System.out.println("no of coins are : "+a[set.length-1][sum]);
		System.out.println("\n Coins are :: ");
		traverseCoins(a);
	}
	static void createMatrix(int[][] a){
		for(int i=0;i<set.length;i++){
			for(int j=1;j<=sum;j++){
				if(i==0)
					a[i][j]=j;
				else{
					if(j<set[i]){
						a[i][j]=a[i-1][j];
					}else{
						if(a[i-1][j]<(a[i][j-set[i]]+1)){
							a[i][j]=a[i-1][j];
						}else
							a[i][j]=a[i][j-set[i]]+1;
					}
				}
			}
		}
	}
	static void traverseCoins(int[][] a){
		int p=set.length-1,q=sum;
		System.out.print("{ ");
		while(q>0){
			if(a[p][q]==a[p-1][q]){
				p--;
			}else{
				System.out.print(set[p]+", ");
				q=q-set[p];
			}
		}
		System.out.print("}");
	}
}
/*
output :::
0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 | 13 | 
0 | 1 | 2 | 3 | 4 | 1 | 2 | 3 | 4 | 5 | 2 | 3 | 4 | 5 | 
0 | 1 | 2 | 3 | 4 | 1 | 1 | 2 | 3 | 4 | 2 | 2 | 2 | 3 | 
0 | 1 | 2 | 3 | 4 | 1 | 1 | 2 | 1 | 2 | 2 | 2 | 2 | 2 | 
no of coins are : 2

 Coins are :: 
{ 8, 5, }
*/