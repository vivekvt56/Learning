package com;

public class LongestCmnSubSeq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1="abcdaf",s2="acbcf";
		//String s1="aggtab",s2="gxtxayb";
		int[][] a=new int[s2.length()+1][s1.length()+1];
		findSubSeq(a, s1, s2);
		System.out.println();
		for(int i=0;i<=s2.length();i++){
			for(int j=0;j<=s1.length();j++){
				System.out.print(a[i][j]+" : ");
			}
			System.out.println();
		}
		System.out.println("\nlength of subsequence is : "+a[s2.length()][s1.length()]);
	}
	static void findSubSeq(int[][] a,String s1,String s2){
		for(int i=0;i<=s2.length();i++){
			for(int j=0;j<=s1.length();j++){
				if(i==0||j==0){
					a[i][j]=0;
				}
				else if(i==1 || j==1){
					a[i][j]=1;
				}else{
					if(s1.charAt(j-1)!=s2.charAt(i-1)){
						if(a[i-1][j]>a[i][j-1]){
							a[i][j]=a[i-1][j];
						}else
							a[i][j]=a[i][j-1];
					}else{
						a[i][j]=a[i-1][j-1]+1;
					}
				}
			}
		}
		int r=s2.length(),c=s1.length();
		System.out.println("String is : ");
		while(r!=0 && c!=0){
			if(s2.charAt(r-1)!=s1.charAt(c-1)){
				if(a[r][c-1]==a[r][c]){
					c--;
				}else
					r--;
			}
			else if(s2.charAt(r-1)==s1.charAt(c-1)){
				System.out.print(s2.charAt(r-1)+" ");
				r--;
				c--;
			}
		}
		if(r>0)
			System.out.print(s1.charAt(r-1));
		else if (c>0)
			System.out.print(s2.charAt(c-1));
	}	
}
/*
output :::::;
String is : 
f c b a 
0 : 0 : 0 : 0 : 0 : 0 : 0 : 
0 : 1 : 1 : 1 : 1 : 1 : 1 : 
0 : 1 : 1 : 2 : 2 : 2 : 2 : 
0 : 1 : 2 : 2 : 2 : 2 : 2 : 
0 : 1 : 2 : 3 : 3 : 3 : 3 : 
0 : 1 : 2 : 3 : 3 : 3 : 4 : 

length of subsequence is : 4

*/