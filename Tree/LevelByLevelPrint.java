package com;

import java.util.ArrayList;
import java.util.List;

class Node1{
	int data;
	Node1 left,right;
	public Node1(int i) {
		data=i;
	}
}
public class LevelByLevelPrint {
	static Node1 root;
	static List<Node1> queue1=new ArrayList<>();
	static List<Node1> queue2=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createTree();
		TraverseLvlByLvl();
	}
	static void createTree(){
		root=new Node1(1);
		root.left=new Node1(2);
		root.right=new Node1(3);
		root.left.left=new Node1(4);
		root.left.right=new Node1(5);
		root.right.right=new Node1(8);
	}
	static void TraverseLvlByLvl(){
		queue1.add(root);
		while(true){
			if(queue1.size()==0 && queue2.size()==0)
				break;
			while(queue1.size()!=0){
				Node1 t=queue1.get(0);
				queue1.remove(0);
				System.out.print(t.data+" ");
				if(t.left!=null)
					queue2.add(t.left);
				if(t.right!=null)
					queue2.add(t.right);
			}
			System.out.println();
			while(queue2.size()!=0){
				Node1 t=queue2.get(0);
				queue2.remove(0);
				System.out.print(t.data+" ");
				if(t.left!=null)
					queue1.add(t.left);
				if(t.right!=null)
					queue1.add(t.right);
			}
			System.out.println();
		}
	}
}
/*
Output ::
1 
2 3 
4 5 8 

*/