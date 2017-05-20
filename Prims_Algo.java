package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

class Node11{
	int i;
	Node11 next;
	public Node11(int i) {
		// TODO Auto-generated constructor stub
		this.i=i;
	}
}

public class Test_Prims {
	static List<Node11> list=new ArrayList<>();
	static Map<String, Integer> edges=new HashMap<>();
	static Map<Integer, Integer> mapHeap=new HashMap<>();
	static Map<Integer, String> vertices=new HashMap<>();
	static List<String> result=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		list.add(new Node11(1));
		list.add(new Node11(2));
		list.add(new Node11(3));
		list.add(new Node11(4));
		list.add(new Node11(5));
		list.add(new Node11(6));
		
		addEdge(1, 4, 1);
		addEdge(1, 2, 3);
		addEdge(2, 3, 1);
		addEdge(3, 6, 4);
		addEdge(5, 6, 2);
		addEdge(4, 5, 6);
		addEdge(2, 4, 3);
		addEdge(3, 4, 1);
		addEdge(3, 5, 5);
		for(Node11 p:list){
			while(p!=null){
				System.out.print(p.i+"-->");
				p=p.next;
			}
			System.out.println();
		}
		System.out.println("Edges");
		Iterator itr=edges.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<String, Integer> entry=(Entry<String, Integer>) itr.next();
			System.out.println(entry.getKey()+" : "+entry.getValue());
		}
		System.out.println("Min spanning Tree prims Algo : ");
		prims();
		//System.out.println("p : "+result.size()+vertices.size());
		for(String l:result){
			System.out.print(l+" : ");
		}

	}
	static void addEdge(int a,int b,int weg){
		Node11 p=list.get(a-1);
		Node11 q=list.get(b-1);
		edges.put(a+"-"+b, weg);
		//p=p.next;
		//q=q.next;
		Node11 w=p;
		while(p!=null){
			w=p;
			p=p.next;
		}
		w.next=new Node11(b);
		w=q;
		while(q!=null){
			w=q;
			q=q.next;
		}
		w.next=new Node11(a);
	}
	static void prims(){
		for(int i=0;i<list.size();i++){
			mapHeap.put(list.get(i).i, Integer.MAX_VALUE);
		}
		//System.out.println("maxheap : "+mapHeap);
		while(mapHeap.size()>0){
			Integer p=extractMin();
			if(vertices.containsKey(p)){
				result.add(vertices.get(p));
			}
			getAdj(p);
		}
	}
	static Integer extractMin(){
		Iterator itr=mapHeap.entrySet().iterator();
		int min=0,i=0;
		Integer index=null;
		while(itr.hasNext()){
			Map.Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr.next();
			int t=entry.getValue();
			if(i==0){
				min=t;
				i++;
				index=entry.getKey();
			}else if(t<min){
				min=t;
				index=entry.getKey();
			}
		}
		mapHeap.remove(index);
		//System.out.println("max : "+mapHeap.size());
		return index;
	}
	static void getAdj(Integer p){
		//System.out.println("a : "+(p-1));
		Node11 q= list.get(p-1);
		q=q.next;
		while(q!=null){
			//System.out.println("q : "+q.i);
			//System.out.println("maxheap : "+mapHeap);
			if(mapHeap.containsKey(q.i)){
				Integer edge=edges.get(p+"-"+q.i);
				//System.out.println("edge : "+edge);
				if(edge==null)
					edge=edges.get(q.i+"-"+p);
				if(mapHeap.get(q.i)>edge){
					mapHeap.put(q.i, edge);
					vertices.put(q.i, p+"-"+q.i);
				}
			}
			q=q.next;
		}
	}
}
