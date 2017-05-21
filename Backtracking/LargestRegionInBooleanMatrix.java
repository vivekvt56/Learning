// Ouestion :: Finding the length of connected cells of 1s (regions) in an matrix of Os and 1s
package com;

public class RegionInBooleanMatrix {
	static int rowlgt=5,collgt=5;
	static boolean bool[][]=new boolean[rowlgt][collgt];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int M[][] = {{0, 0, 1, 1, 0},{1, 0, 1, 1, 0},{0, 1, 0, 0, 0},{0, 0, 0, 0, 1}};
		int M[][]={{1,1,0,0,0},{0,1,1,0,0},{0,0,1,0,1},{1,0,0,0,1},{0,1,0,1,1}};
		for(int i=0;i<rowlgt;i++){
			for(int j=0;j<collgt;j++){
				findMaxRegion(M, i, j);
				if(t>max){
					max=t;
				}
				t=1;
			}
		}
		System.out.println("Largest region is of length :: "+max);
	}
	static int max=0,t=1;
	static void findMaxRegion(int[][] M,int i,int j){
		//System.out.println(i+" : "+j);
		int[][] dir={{-1,0},{-1,-1},{0,-1},{1,-1},{1,0},{1,1},{0,1},{-1,1}};
		if(M[i][j]==1){
			bool[i][j]=true;
		for(int r=0;r<8;r++){
			int newi=i+dir[r][0];
			int newj=j+dir[r][1];
			//System.out.println(newi+" : "+newj);
			if(newi>=rowlgt || newj>=collgt || newi<0 || newj<0)
				continue;
			if(M[newi][newj]==1 && !bool[newi][newj]){
				t++;
				bool[newi][newj]=true;
				findMaxRegion(M, newi, newj);
			}
		}		
		}
	}
}
/*
Output ::
Largest region is of length :: 5
*/ 