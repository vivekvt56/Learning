package com;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Node13{
	int data;
	Node13 next;
	public Node13(int d) {
		super();
		data=d;
	}
}
public class DijkstraAlgo_1 {
	static List<Node13> list=new ArrayList<Node13>();
	static Map<String,Integer> edges=new LinkedHashMap<>();
	
	static Map<Integer,Integer> map=new LinkedHashMap<>();
	static Map<Integer,Integer> distMap=new LinkedHashMap<>();
	static Map<Integer,Integer> parntMap=new LinkedHashMap<>();
	public static void main(String[] args) {
		Node13 n1=new Node13(1);
		Node13 n2=new Node13(2);
		Node13 n3=new Node13(3);
		Node13 n4=new Node13(4);
		Node13 n5=new Node13(5);
		Node13 n6=new Node13(6);
		list.add(n1);
		list.add(n2);
		list.add(n3);
		list.add(n4);
		list.add(n5);
		list.add(n6);
		addVertex(1,2);
		addVertex(1,4);
		addVertex(1,5);
		addVertex(2,3);
		addVertex(4,3);
		addVertex(4,6);
		addVertex(5,6);
		for(Node13 n:list){
			while(n!=null){
				System.out.print(n.data+"-->");
				n=n.next;
			}
			System.out.println();
		}
		addEdges(1, 2, 5);
		addEdges(1, 4, 9);
		addEdges(1, 5, 2);
		addEdges(2, 3, 2);
		addEdges(3, 4, 3);
		addEdges(4, 6, 2);
		addEdges(5, 6, 3);
		djPath(1, 6);
		Iterator itr=parntMap.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr.next();
			System.out.println(entry.getKey()+" ; "+entry.getValue());
		}
		find_path(1, 4);
		System.out.println();
		find_path(1, 2);
	}
	static public void addVertex(int a,int b){
		Node13 n1=list.get(a-1);
		Node13 n2=list.get(b-1);
		while(n1.next!=null){
			n1=n1.next;
		}
		n1.next=new Node13(b);
		while(n2.next!=null){
			n2=n2.next;
		}
		n2.next=new Node13(a);
	}
	static public void addEdges(int a,int b,int w){
		edges.put(a+"-"+b, w);
	}
	static void djPath(int source,int n){
		map.put(source, 0);
		for(int i=1;i<=n;i++){
			if(i!=source)
				map.put(i, Integer.MAX_VALUE);
		}
		int key=0;
		while(true){
			key=extractMin();
			if(key==-1)
				break;
			if(key==source){
				parntMap.put(source, null);
			}
				adjVtx(key);
		}
	}
	static int extractMin(){
		int key=0,min=Integer.MAX_VALUE;
		Iterator itr=map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr.next();
			if(entry.getValue()<min){
				min=entry.getValue();
				key=entry.getKey();
			}
		}
		if(map.size()!=0){
			distMap.put(key, map.get(key));
			map.remove(key);
			return key;
		}else{
			return -1;
		}
	}
	static void adjVtx(int a){
		Node13 n=list.get(a-1);
		Node13 n2=n.next;
		while(n2!=null){
			if(map.get(n2.data)!=null){
				Integer w2=edges.get(n.data+"-"+n2.data);
				if(w2==null)
					w2=edges.get(n2.data+"-"+n.data);
				//System.out.println(w2);
				Integer w1=distMap.get(n.data);
				if(w1==null)
					w1=0;
				System.out.println("n2.data : "+n2.data+" : "+(w1+w2));
				if(map.get(n2.data)>(w1+w2)){
					map.put(n2.data, w1+w2);
					parntMap.put(n2.data, n.data);
				}
			}
			n2=n2.next;
		}
	}
	static void find_path(int source,int dest){
		System.out.print(dest+"-->");
		Integer n=parntMap.get(dest);
		while(n!=null){
			System.out.print(n+"-->");
			n=parntMap.get(n);
		}
	}
}


Output 
-----------------------------------
1-->2-->4-->5-->
2-->1-->3-->
3-->2-->4-->
4-->1-->3-->6-->
5-->1-->6-->
6-->4-->5-->
1 ; null
2 ; 1
4 ; 6
5 ; 1
6 ; 5
3 ; 2
4-->6-->5-->1-->
2-->1-->