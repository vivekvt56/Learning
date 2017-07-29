package com;

public class ShellSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a={15,19,20,38,24,41,30,31,12,12};
		int n=a.length;
		int gap=(int)(n/2);
		while(gap>0){
		//System.out.println("gap : "+gap);
		for(int i=0;i<n-gap;i++){
			//System.out.println(a[i]+" : "+a[i+gap]);
			if(a[i]>a[i+gap]){
				int t=a[i];
				a[i]=a[i+gap];
				a[i+gap]=t;
				for(int j=i;j>=gap;j-=gap){
					if(a[j-gap]>a[j]){
						int t1=a[j];
						a[j]=a[j-gap];
						a[j-gap]=t1;
					}
				}
			}
		}
		gap=(int)(gap/2);
		}
		for(int i:a){
			System.out.print(i+" ");
		}
	}

}
/*
Output 
12 12 15 19 20 24 30 31 38 41 
*/