package com;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Test19 {
	static String s="abcde";
	static Map<Character,Integer> map=new TreeMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(char c:s.toCharArray()){
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
		}
		Iterator itr=map.entrySet().iterator();
		char[] elm=new char[map.size()];
		int[] count=new int[map.size()];
		int i=0;
		System.out.println(elm.toString());
		while(itr.hasNext()){
			Map.Entry<Character, Integer> entry=(Map.Entry<Character, Integer>)itr.next();
			elm[i]=entry.getKey();
			count[i++]=entry.getValue();
			//System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		//System.out.println(elm.length);
		char[] result=new char[s.length()];
		permute(elm, count, result, 0);
	}
	static void permute(char a[],int count[],char[] result,int level){
		if(level==s.length()){
			//System.out.println("as"+result.toString());
			printArray(result);
			return;
		}else{
			//System.out.println("a");
			for(int i=0;i<count.length;i++){
				if(count[i]==0){
					continue;
				}
				result[level]=a[i];
				count[i]--;
				permute(a, count, result, level+1);
				count[i]++;
			}
		}
	}
	static void printArray(char[] c){
		for(char a:c)
			System.out.print(a);
		System.out.println();
	}

}
