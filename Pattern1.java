/*
1
2*3
4*5*6
7*8*9*10
7*8*9*10
4*5*6
2*3
1
*/

package com;

public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=4,s=0,t=1;
		String a="";
		for(int j=1;j<=2*n;j++){
			if(j<=n){
				for(int k=1;k<=j;k++){
				if(j%2!=0){
					if(k==j)
						a=a+t;
					else
						a=a+t+"*";
				}
				else{
					if(k!=j)
						a="*"+t+a;
					else
						a=t+a;
				}
				t++;
			}
			}
			else if(j>n){
			for(int k=2*n-j+1;k>=1;k--){
				if(j%2!=0)
					a=a+"*"+(--t);
				else
					a="*"+(--t)+a;
			}
			}
			System.out.println(a);
			a="";
		}

	}

}
