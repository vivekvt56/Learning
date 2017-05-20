package com;

import java.util.LinkedHashMap;
import java.util.Map;

public class OptimalBST {
	static Map<Integer, Integer> map=new LinkedHashMap<>();
	static int[] b={10,12,16,21};
	static int[][] a=new int[4][4];
	static int[][] root=new int[4][4];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		map.put(10, 4);
		map.put(12, 2);
		map.put(16, 6);
		map.put(21, 3);
		createBSTMatrix();
		System.out.println("BST matrix is : ");
		for(int i=0;i<map.size();i++){
			for(int j=0;j<map.size();j++)
				System.out.print(a[i][j]+" | ");
			System.out.println();
		}
		System.out.println("Min cost is : "+a[0][3]);
		System.out.println("root is : ");
		for(int i=0;i<map.size();i++){
			for(int j=0;j<map.size();j++)
				System.out.print(root[i][j]+" | ");
			System.out.println();
		}
	}
	static void createBSTMatrix(){
		for(int l=1;l<=map.size();l++){
			for(int i=0;i<map.size()-l+1;i++){
				checkOpt(i,l);
			}
		}
	}
	static void checkOpt(int i,int l){
		int min=10000,t1=0,r=-1;
		for(int j=i;j<(i+l);j++){
			t1=t1+map.get(b[j]);
			if(l==1){
				a[j][j]=map.get(b[j]);
				root[j][j]=j;
				return;
			}else{
				if(j==i){
					//System.out.println((j+1)+" : "+(i+l-1));
					//System.out.println(l);
						if(a[j+1][i+l-1]<min){
							min=a[j+1][i+l-1];
							r=j;
						}
				}else if(j==i+l-1){
					if(a[i][i+l-1-1]<min){
						min=a[i][i+l-1-1];
						r=j;
					}
				}else{
					int t=a[i][j-1]+a[j+1][i+l-1];
					if(t<min){
						min=t;
						r=j;
					}
				}
			}
		}
		a[i][i+l-1]=t1+min;
		root[i][i+l-1]=r;
	}
	/*static void findBST(int[][] root){
		int i=root[0][3];
		while(true){
			
		}
	}*/
}
/*
BST matrix is : 
4 | 8 | 20 | 26 | 
0 | 2 | 10 | 16 | 
0 | 0 | 6 | 12 | 
0 | 0 | 0 | 3 | 
Min cost is : 26
root is : 
0 | 0 | 2 | 2 | 
0 | 1 | 2 | 2 | 
0 | 0 | 2 | 2 | 
0 | 0 | 0 | 3 | 
*/