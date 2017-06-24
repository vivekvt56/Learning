//Link :: http://www.geeksforgeeks.org/vertical-sum-in-a-given-binary-tree/
package com;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

class Node7{
	int data;
	Node7 left,right;
	public Node7(int i) {
		data=i;
	}
}
public class VerticalSumBT {
	static Node7 root;
	static Map<Integer, Integer> map=new LinkedHashMap<>();
	public static void main(String[] args) {
		createTree();
		CalVrtSum(root, 0);
		Iterator itr=map.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, Integer> entry=(Entry<Integer, Integer>) itr.next();
			System.out.println("Horizental Dis : "+entry.getKey()+" , SUM = "+entry.getValue());
		}
	}
	static void createTree(){
		root=new Node7(1);
		root.left=new Node7(2);
		root.right=new Node7(3);
		root.left.left=new Node7(4);
		root.left.right=new Node7(5);
		root.right.right=new Node7(8);
	}
	static void CalVrtSum(Node7 r,int sum){
		if(r==null){
			return;
		}
		if(map.containsKey(sum)){
			map.put(sum, map.get(sum)+r.data);
		}else
			map.put(sum, r.data);
		sum=sum-1;
		CalVrtSum(r.left,sum);
		sum=sum+1;
		//System.out.print(r.data);
		sum=sum+1;
		CalVrtSum(r.right,sum);
		sum=sum-1;
	}
}
/*
Output ::
Horizental Dis : 0 , SUM = 6
Horizental Dis : -1 , SUM = 2
Horizental Dis : -2 , SUM = 4
Horizental Dis : 1 , SUM = 3
Horizental Dis : 2 , SUM = 8
*/