package com;

class NodeAvl{
	int data,height;
	NodeAvl left,right;
	public NodeAvl(int data) {
		this.data=data;
		height=1;
	}
}
public class AVLTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeAvl root=null;
		root=insert(root, 1);
		root=insert(root, 2);
		root=insert(root, 3);
		root=insert(root, 6);
		root=insert(root, 15);
		root=insert(root, -2);
		root=insert(root, -5);
		root=insert(root, -8);
		System.out.println("preorder traversal of AVL Tree is :: ");
		preorder(root);
	}
	
	static void preorder(NodeAvl root){
		if(root==null)
			return;
		System.out.print(root.data+" , ");
		preorder(root.left);
		preorder(root.right);
	}
	
	static NodeAvl rightRotate(NodeAvl root){
		NodeAvl newRoot=root.left;
		root.left=newRoot.right;
		newRoot.right=root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}
	static NodeAvl leftRotate(NodeAvl root){
		NodeAvl newRoot=root.right;
		root.right=newRoot.left;
		newRoot.left=root;
		setHeight(root);
		setHeight(newRoot);
		return newRoot;
	}
	
	static NodeAvl insert(NodeAvl root,int data){
		if(root==null){
			return new NodeAvl(data);
		}else if(root.data>=data){
			root.left=insert(root.left, data);
		}else{
			root.right=insert(root.right, data);
		}
		int bal=balance(root.left,root.right);
		if(bal>1){
			if(height(root.left.left)>=height(root.left.right)){
				root=rightRotate(root);
			}else{
				root=leftRotate(root.left);
				root=rightRotate(root);
			}
		}else if(bal<-1){
			if(height(root.right.right)>=height(root.right.left)){
				root=leftRotate(root);
			}else{
				root=rightRotate(root.right);
				root=leftRotate(root);
			}
		}else{
			root.height=setHeight(root);
		}
		return root;
	}

	private static int setHeight(NodeAvl root) {
			return 1+(Math.max(height(root.left), height(root.right)));
	}

	private static int balance(NodeAvl left, NodeAvl right) {
		return (height(left)-height(right));
	}
	static int height(NodeAvl root){
		if(root==null)
			return 0;
		else
			return root.height;
	}
}
/*
Output ::
preorder traversal of AVL Tree is :: 
2 , -2 , -5 , -8 , 1 , 6 , 3 , 15 , 
*/