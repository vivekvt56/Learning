package com;

import java.util.ArrayList;
import java.util.List;

class Node2{
	int data;
	Node2 left,right;
	public Node2(int i) {
		data=i;
	}
}
public class Node2LeafSum {
	static Node2 root;
	static List<Node2> stack=new ArrayList<>();
	static int sum=8,temp;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createTree();
		if(TraversePath(root)){
			System.out.println("Path found with sum :: "+sum);
			System.out.println("Path is :: ");
			for(Node2 n:stack)
				System.out.print(n.data+" ");
		}
		else
			System.out.println("Path not found of sum :: "+sum);
	}
	static void createTree(){
		root=new Node2(1);
		root.left=new Node2(2);
		root.right=new Node2(3);
		root.left.left=new Node2(4);
		root.left.right=new Node2(5);
		root.right.right=new Node2(8);
	}
	static boolean TraversePath(Node2 t){
		if(t==null)
			return false;
		if(t.left==null && t.right==null){
			stack.add(t);
			temp=temp+t.data;
			if(temp==sum){
				//System.out.println("Path found with sum :: "+sum);
				return true;
			}
			System.out.println();
			temp=temp-t.data;
			stack.remove(stack.size()-1);
		}
		temp=temp+t.data;
		stack.add(t);
		if(TraversePath(t.left))
			return true;
		if(TraversePath(t.right))
			return true;
		temp=temp-t.data;
		stack.remove(stack.size()-1);
		return false;
	}
}
/*
OutPut ::

Path found with sum :: 8
Path is :: 
1 2 5 

*/