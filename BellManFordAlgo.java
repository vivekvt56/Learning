package com;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

// BellMan Ford
public class BellmanFord {
	static Map<Integer, Integer> distance=new LinkedHashMap<>();
	static Map<Integer, Integer> parent=new LinkedHashMap<>();
	static Map<String, Integer> edges=new LinkedHashMap<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=5;
		for(int i=0;i<n;i++){
			distance.put(i, 12345);
			parent.put(i, null);
		}
		addEdges();
		BellFord(n);
		Iterator itr=parent.entrySet().iterator();
		System.out.println("Parent Map is : ");
		while(itr.hasNext()){
			Map.Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		Iterator itr1=distance.entrySet().iterator();
		System.out.println("Distance Map is : ");
		while(itr1.hasNext()){
			Map.Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr1.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		System.out.println("path from 3 to 0");
		findPath(3);
	}
	static void addEdges(){
		edges.put("3-4", 2);
		edges.put("4-3", 1);
		edges.put("2-4", 4);
		edges.put("0-2", 5);
		edges.put("1-2", -3);
		edges.put("0-3", 8);
		edges.put("0-1", 4);
	}
	static void BellFord(int n){
		distance.put(0, 0);
		parent.put(0, null);
		for(int i=0;i<n-1;i++){
			Iterator itr=edges.entrySet().iterator();
			while(itr.hasNext()){
				Map.Entry<String, Integer> entry=(Entry<String, Integer>) itr.next();
				String a[]=entry.getKey().split("-");
				relax(Integer.parseInt(a[0]), Integer.parseInt(a[1]), entry.getValue());
			}
		}
	}
	static void relax(int a,int b,int w){
		//System.out.println(a+" : "+b+" : "+w);
		if(distance.get(b)>(distance.get(a)+w)){
			distance.put(b, distance.get(a)+w);
			parent.put(b, a);
		}
	}
	static void findPath(int n){
		Integer p=parent.get(n);
		System.out.print(n+"<--");
		while(p!=null){
			System.out.print(p+"<--");
			p=parent.get(p);
		}
		//System.out.println("\ncost is : "+cost);
	}
}
/*
Output :::::::
Parent Map is : 
0 : null
1 : 0
2 : 1
3 : 4
4 : 2
Distance Map is : 
0 : 0
1 : 4
2 : 1
3 : 6
4 : 5
path from 3 to 0
3<--4<--2<--1<--0<--
*/