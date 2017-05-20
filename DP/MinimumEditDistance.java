package com;

public class MinimumEditDistance {
	static String s2="abcdef",s1="azced";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a=new int[s1.length()+1][s2.length()+1];
		createMatrix(a);
		for(int i=0;i<s1.length()+1;i++){
			for(int j=0;j<s2.length()+1;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}
	static void createMatrix(int[][]a){
		for(int i=0;i<s1.length()+1;i++){
			for(int j=0;j<s2.length()+1;j++){
				if(i==0){
					a[i][j]=j;
				}else if(j==0)
					a[i][j]=i;
				else{
					if(s1.charAt(i-1)==s2.charAt(j-1)){
						a[i][j]=a[i-1][j-1];
					}else{
						int t=a[i-1][j];
						if(a[i][j-1]<t)
							t=a[i][j-1];
						else if(a[i-1][j-1]<t)
							t=a[i-1][j-1];
						a[i][j]=t+1;
					}
				}
			}
		}
	}
}
/*
output
0 1 2 3 4 5 6 
1 0 1 2 3 4 5 
2 1 1 2 3 4 5 
3 2 2 1 2 3 4 
4 3 3 2 2 2 3 
5 4 4 3 2 3 3 

*/