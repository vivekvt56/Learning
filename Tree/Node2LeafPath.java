package com;

import java.util.ArrayList;
import java.util.List;

/*class Node1{
	int data;
	Node1 left,right;
	public Node1(int i) {
		data=i;
	}
}*/
public class Node2LeafPath {
	static Node1 root;
	static List<Node1> stack=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createTree();
		System.out.println("All paths from node to leaf are :: ");
		TraversePath(root);
	}
	static void createTree(){
		root=new Node1(1);
		root.left=new Node1(2);
		root.right=new Node1(3);
		root.left.left=new Node1(4);
		root.left.right=new Node1(5);
		root.right.right=new Node1(8);
	}
	static void TraversePath(Node1 t){
		if(t==null)
			return;
		if(t.left==null && t.right==null){
			stack.add(t);
			for(Node1 n:stack)
				System.out.print(n.data+" ");
			System.out.println();
			stack.remove(stack.size()-1);
		}
		stack.add(t);
		TraversePath(t.left);
		TraversePath(t.right);
		stack.remove(stack.size()-1);
	}
}
/*
Output ::
All paths from node to leaf are :: 
1 2 4 
1 2 5 
1 3 8 

*/