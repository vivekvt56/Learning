package com;

import java.util.ArrayList;
import java.util.List;

class Node4{
	int data;
	Node4 left,right;
	public Node4(int i) {
		data=i;
	}
}
public class LCABT {
	static Node4 root,root2;
	static List<Node4> queue=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createTree();
		root2=root;
		Integer i=inOrder(root,4,5);
		System.out.println("LCA of BT is :: "+i);
	}
	static void createTree(){
		root=new Node4(1);
		root.left=new Node4(2);
		root.right=new Node4(3);
		root.left.left=new Node4(4);
		root.left.right=new Node4(5);
		root.right.right=new Node4(8);
	}
	static Integer inOrder(Node4 t,int n1,int n2){
		if(t==null)
			return null;
		if(t.data==n1 || t.data==n2)
			return t.data;
		Integer a=inOrder(t.left, n1, n2);
		Integer b=inOrder(t.right, n1, n2);
		if(a!=null && b==null)
			return a;
		else if(a==null && b!=null)
			return b;
		else if(a!=null && b!=null)
			return t.data;
		else
			return null;
	}
}
/*
Output ::
LCA of BT is :: 2

*/