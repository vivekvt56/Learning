//Link : - http://algorithms.tutorialhorizon.com/binary-min-max-heap/


package com;

import java.util.ArrayList;
import java.util.List;

public class Test8 {
	static int a[]={-1,8,7,2,6,4,5};
	static List<Integer> list=new ArrayList<>();
	static List<Integer> list1=new ArrayList<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list.add(-1);
		list.add(8);
		list.add(7);
		list.add(2);
		list.add(6);
		list.add(4);
		list.add(5);
		System.out.println("Before");
		for(int s:list)
			System.out.print(s+" : ");
		list.add(-2);
		list.add(0);
		//list.remove(list.indexOf(6));
		binaryHeap();
		System.out.println("\nAfter");
		for(int s:list1)
			System.out.print(s+" : ");
		System.out.println("\nAfter delete");
		delete(5);
		for(int s:list1)
			System.out.print(s+" : ");
		delete(list1.get(0));
		System.out.println("\nAFter extract min");
		for(int s:list1)
			System.out.print(s+" : ");
	}
	static void insert(int a){
		if(list1.size()==0){
			list1.add(a);
		}else{
			list1.add(a);
			for(int j=list1.size()-1;j>0;j--){
				int p=(j-1)/2;
				//System.out.println(list1.get(p)+" | "+list1.get(j));
				if(list1.get(p)>list1.get(j)){
					int t1=list1.get(j);
					list1.set(j, list1.get(p));
					list1.set(p, t1);
				}
			}
		}
	}
	static void binaryHeap(){
		for(int i=0;i<list.size();i++){
			insert(list.get(i));
		}
	}
	static void delete(int n){
		int p=list1.indexOf(n);
		list1.set(p, list1.get(list1.size()-1));
		list1.remove(list1.size()-1);
		sinkDown(p);
	}
	static void sinkDown(int index){
		for(int i=index;i<list1.size();i++){
			int l=2*i+1;
			int r=2*i+2;
			//System.out.println(r);
			if(l>=list1.size() || r>=list1.size())
				break;
			if(list1.get(i)>list1.get(l)){
				int t1=list1.get(i);
				list1.set(i, list1.get(l));
				list1.set(l, t1);
			}if(list1.get(i)>list1.get(r)){              //Here it should be IF not else if
				int t1=list1.get(i);
				list1.set(i, list1.get(r));
				list1.set(r, t1);
			}
		}
	}
}
//-1 : 2 : 4 : 8 : 6 : 7 : 5 : 