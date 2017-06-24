package com;


class Node6{
	char data;
	Node6 left,right;
	public Node6(char i) {
		data=i;
	}
}
public class CreateBTUsgInordrPostordr {
	static String inorder="DBEAFC",preorder="ABDECF";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node6 root=null;
		System.out.println("Before : Inorder = "+inorder+" , Preorder = "+preorder);
		root=buildTree(0, 5, root);
		System.out.println("After Creation Binary Tree Inorder Traversal : ");
		inOrder(root);
		//System.out.println(root.right.data);
	}
	static Node6 buildTree(int start,int end,Node6 root){
		char t=findRoot(start, end);
		//System.out.print(t+" ");
		root=new Node6(t);
		if(start==end)
			return root;
		int indexRoot=inorder.indexOf(t);
		Node6 root1=root;
		if(indexRoot!=0){
			root.left=buildTree(start, indexRoot-1, root.left);
		}
		root=root1;
		if(indexRoot!=5){
			root.right=buildTree(indexRoot+1, end, root.right);
		}
		return root;
	}
	static char findRoot(int start,int end){
		int min=preorder.length()-1;
		for(int i=start;i<=end;i++){
			char r=inorder.charAt(i);
			int t=preorder.indexOf(r);
			if(t<min){
				min=t;
			}
		}
		return preorder.charAt(min);
	}
	static void inOrder(Node6 root){
		if(root==null)
			return;
		inOrder(root.left);
		System.out.print(root.data+" : ");
		inOrder(root.right);
	}
}
/*
Output ::
Before : Inorder = DBEAFC , Preorder = ABDECF
After Creation Binary Tree Inorder Traversal : 
D : B : E : A : F : C : 
*/