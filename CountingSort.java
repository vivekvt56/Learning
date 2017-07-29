package com;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] a={1,4,1,2,7,5,2};
		int[] a={15,19,20,38,24,41,30,31,12};
		int min=1000,max=0;
		for(int i=0;i<a.length;i++){
			if(a[i]>max)
				max=a[i];
			if(a[i]<min)
				min=a[i];
		}
		System.out.println("min - "+min+" : max - "+max);
		int[] count=new int[max-min+1];
		for(int i=0;i<a.length;i++){
			count[a[i]-min]++;
		}
		for(int i=1;i<count.length;i++){
			count[i]=count[i]+count[i-1];
		}
		/*for(int i:count){
			System.out.print(i+" ");
		}*/
		int[] tmp=new int[a.length];
		for(int i=0;i<a.length;i++){
			int loc=count[a[i]-min];
			//System.out.println("loc : "+loc);
			tmp[loc-1]=a[i];
			count[a[i]-min]--;
		}
		for(int i:tmp){
			System.out.print(i+" ");
		}
	}

}
/*
Output 
min - 12 : max - 41
12 15 19 20 24 30 31 38 41 
*/