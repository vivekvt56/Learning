package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Node12{
	int data;
	Node12 next;
	public Node12(int i) {
		data=i;
	}
}
public class CylDirGraph {
	static List<Node12> list=new ArrayList<>();
	static Set<Node12> whiteSet=new LinkedHashSet<>();
	static Set<Node12> graySet=new LinkedHashSet<>();
	static Set<Node12> blackSet=new LinkedHashSet<>();
	static Map<Integer, Integer> map=new HashMap<>();
	
	public static void main(String[] args) {
		createGraph();
		System.out.println("Graph is :::::");
		for(Node12 n:list){
			while(n!=null){
				System.out.print(n.data+"-->");
				n=n.next;
			}
			System.out.println();
		}
		detectCycle();
		System.out.println(whiteSet.size()+" : "+graySet.size()+" : "+blackSet.size());
		System.out.println("whiteSet :");
		for(Node12 n:whiteSet){
			System.out.print(n.data+"-->");
			n=n.next;
		}
		System.out.println("\nBlackSet :");
		for(Node12 n:blackSet){
			System.out.print(n.data+"-->");
			n=n.next;
		}
		System.out.println("\nGraySet :");
		for(Node12 n:graySet){
			System.out.print(n.data+"-->");
			n=n.next;
		}
	}
	static void createGraph(){
		for(int i=0;i<6;i++){
			list.add(new Node12(i));
		}
		makeEdge(0, 1);
		makeEdge(1, 2);
		makeEdge(0, 2);
		makeEdge(3, 0);
		makeEdge(3, 4);
		makeEdge(4, 5);
		makeEdge(5, 3);
	}
	static void makeEdge(int a,int b){
		Node12 p=list.get(a);
		while(p.next!=null)
			p=p.next;
		p.next=new Node12(b);
	}
	static void detectCycle(){
		for(Node12 n:list){
			whiteSet.add(new Node12(n.data));
		}
		while(whiteSet.size()!=0){
			Node12 p=whiteSet.iterator().next();
			dfs(p,-1);
		}
	}
	static void dfs(Node12 n,int parent){
		whiteSet.remove(n);
		graySet.add(n);
		map.put(n.data, parent);
		Node12 p=list.get(n.data);
		Node12 t1=n;
		Node12 t2=p;
		while(p!=null){
			p=p.next;
			if(p==null)
				break;
			if(graySet.contains(p)){
				System.out.println("Cycle is detected :: ");
				continue;
			}
			if(blackSet.contains(p)){
				continue;
			}
			//whiteSet.remove(p);
			//graySet.add(p);
			dfs(p, t1.data);
		}
		graySet.remove(t1);
		blackSet.add(t2);
	}
}
/*
Graph is :::::
0-->1-->2-->
1-->2-->
2-->
3-->0-->4-->
4-->5-->
5-->3-->
Cycle is detected :: 
Cycle is detected :: 
Cycle is detected :: 
0 : 0 : 6
whiteSet :

BlackSet :
2-->1-->0-->3-->5-->4-->
GraySet :

*/