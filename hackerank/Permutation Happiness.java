package com;
import java.util.Set;
import java.util.TreeSet;

public class Ques5 {
	static Set<String> set=new TreeSet<>();
	public static void main(String[] args) {
		long l1=System.currentTimeMillis();
		int[] a={1,2,3,4,5,6,7,8,9,10,11};
		int[] map=new int[a.length];
		int[] result=new int[a.length];
		permute(a, map, result, 0);
		System.out.println(cnt);
		long l2=System.currentTimeMillis();
		System.out.println((l2-l1)+"msec");
	}
	static int cnt=0;
	
	static void permute(int[] a,int[] count,int[] result,int level){
		if(level==a.length){
			if(checkHappy(result, 7)){
				cnt++;
			}
			return;
		}
		for(int i=0;i<a.length;i++){
			if(count[i]==-1)
				continue;
			else{
				result[level]=a[i];
				count[i]--;
				permute(a, count, result, ++level);
				count[i]++;
				level--;
			}
		}
	}
	static boolean checkHappy(int[] a,int k){
		int count=0;
		for(int i=0;i<a.length;i++){
			if(count>=k)
				break;
			if(i==0){
				if(a[i]<a[i+1]){
					count++;
				}
			}else if(i==a.length-1){
				if(a[i]<a[i-1])
					count++;
			}else{
				if(a[i]<a[i+1] || a[i]<a[i-1]){
					count++;
				}
			}
		}
		if(count>=k)
			return true;
		else
			return false;
	}
}
