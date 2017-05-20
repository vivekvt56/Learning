package com;

public class SubsetSum {
	static int[] set={2,3,7,8,10};
	static int sum=9;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] a=new char[set.length][sum+1];
		createMatrix(a);
		for(int i=0;i<set.length;i++){
			for(int j=0;j<=sum;j++)
				System.out.print(a[i][j]+" | ");
			System.out.println();
		}
		findSubset(a);
	}
	static void createMatrix(char[][] a){
		for(int i=0;i<set.length;i++){
			for(int j=0;j<=sum;j++){
				if(i==0){
					if(j==0 || j==set[i])
						a[i][j]='T';
					else
						a[i][j]='F';
				}else{
					if(j<set[i])
						a[i][j]=a[i-1][j];
					else{
						if(a[i-1][j]=='T')
							a[i][j]='T';
						else{
							a[i][j]=a[i-1][j-set[i]];
						}
					}
				}
			}
		}
	}
	static void findSubset(char[][] a){
		int p=set.length-1,q=sum;
		System.out.print("{ ");
		while(p!=0){
			if(a[p][q]=='T'){
				if(a[p-1][q]=='T'){
					p--;
				}else{
					System.out.print(set[p]+",");
					q=q-set[p];
					p--;
				}
			}
		}
		if(p==0 && q!=0){
			System.out.print(set[p]+",");
		}
		System.out.println(" }");
	}
}
/*
output :::::::
T | F | T | F | F | F | F | F | F | F | 
T | F | T | T | F | T | F | F | F | F | 
T | F | T | T | F | T | F | T | F | T | 
T | F | T | T | F | T | F | T | T | T | 
T | F | T | T | F | T | F | T | T | T | 
{ 7,2, }

*/