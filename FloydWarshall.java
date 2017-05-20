package com;

public class FloydWarshall {
	static int n=4;
	static int[][] dist=new int[n][n];
	static int[][] path=new int[n][n];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createDisMatx();
		createPathMatx();
		FloydTrav();
		System.out.println("Dist Matrix : ");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(dist[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("Path Matrix is : ");
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(path[i][j]+"\t");
			}
			System.out.println();
		}
		findPath(3, 1);
	}
	static void createDisMatx(){
		dist[0][0]=0;
		dist[0][1]=3;
		dist[0][2]=6;
		dist[0][3]=15;
		dist[1][0]=1234;
		dist[1][1]=0;
		dist[1][2]=-2;
		dist[1][3]=1234;
		dist[2][0]=1234;
		dist[2][1]=1234;
		dist[2][2]=0;
		dist[2][3]=2;
		dist[3][0]=1;
		dist[3][1]=1234;
		dist[3][2]=1234;
		dist[3][3]=0;		
	}
	static void createPathMatx(){
		path[0][0]=n;
		path[0][1]=0;
		path[0][2]=0;
		path[0][3]=0;
		path[1][0]=n;
		path[1][1]=n;
		path[1][2]=1;
		path[1][3]=n;
		path[2][0]=n;
		path[2][1]=n;
		path[2][2]=n;
		path[2][3]=2;
		path[3][0]=3;
		path[3][1]=n;
		path[3][2]=n;
		path[3][3]=n;		
	}
	static void FloydTrav(){
		for(int k=0;k<n;k++){
			for(int i=0;i<n;i++){
				for(int j=0;j<n;j++){
					if(dist[i][j]>(dist[i][k]+dist[k][j])){
						dist[i][j]=dist[i][k]+dist[k][j];
						path[i][j]=path[k][j];
					}
				}
			}
		}
	}
	static void findPath(int a,int b){
		System.out.println("Shortest distance is b/w "+a+" & "+b+" : "+dist[a][b]);
		String p="";//String.valueOf(b);
		while(a!=b){
			p=b+"-->"+p;
			int t=path[a][b];
			b=t;
			//System.out.print(b+"<--");
		}
		p=a+"-->"+p;
		System.out.print("Route is : "+p);
	}
}
/*
Output :::::::::::
Dist Matrix : 
0	3	1	3	
1	0	-2	0	
3	6	0	2	
1	4	2	0	
Path Matrix is : 
4	0	1	2	
3	4	1	2	
3	0	4	2	
3	0	1	4	
Shortest distance is b/w 3 & 1 : 4
Route is : 3-->0-->1-->
*/