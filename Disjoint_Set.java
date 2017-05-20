//Link : http://www.geeksforgeeks.org/disjoint-set-data-structures-java-implementation/

package com;

import java.util.ArrayList;
import java.util.List;

class Node12{
	int data;
	Node12 parent;
	int rank;
}
public class Disjoint_Test {
	static List<Node12> list=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		makeSet(1);
		makeSet(2);
		makeSet(3);
		makeSet(4);
		makeSet(5);
		makeSet(6);
		makeSet(7);
		
		union(1, 2);
		union(2, 3);
		union(4, 5);
		union(6, 7);
		union(5, 6);
		union(3, 7);
		
		System.out.println(findSet(7).data);
		pathComp();
	}
	static void makeSet(int p){
		Node12 n=new Node12();
		n.data=p;
		n.rank=0;
		n.parent=n;
		list.add(n);
	}
	static void union(int a, int b){
		Node12 p=findSet(a);
		Node12 q=findSet(b);
		System.out.println(p.data+":"+q.data);
		if(p.rank<q.rank){
			p.parent=q;
			//q.rank++;
			//System.out.println(p.rank);
		}else{
			q.parent=p;
			if(p.rank==q.rank)
				p.rank++;
			//System.out.println(q.rank);
		}
	}
	static Node12 findSet(int a){
		Node12 p=list.get(a-1);
		//System.out.println(p.parent.data);
		if(p.parent==p)
			return p;
		else{
			return findSet(p.parent.data);
		}
	}
	static void pathComp(){
		Node12 p=findSet(1);
		for(Node12 a:list){
			a.parent=p;
		}
	}
}
