package com;

import java.util.ArrayList;
import java.util.List;
class Node4{
	int data;
	Node4 next;
	public Node4(int i) {
		data=i;
	}
}
public class CycleIdnDFS {
	static List<Node4> list=new ArrayList<>();
	static int[] visited=new int[6];
	static int[] stack=new int[6];
	static int top=-1;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createVertex();
		for(Node4 p:list){
			while(p!=null){
				System.out.print(p.data+"-->");
				p=p.next;
			}
			System.out.println();
		}
		dfs();
	}
	static void createVertex(){
		for(int i=1;i<=6;i++){
			list.add(new Node4(i));
		}
		addEdge(1, 6);
		addEdge(1, 2);
		addEdge(2, 5);
		addEdge(2, 3);
		addEdge(3, 4);
		addEdge(4, 5);
	}
	static void addEdge(int a,int b){
		Node4 p=list.get(a-1);
		//System.out.println("kn +"+p.data);
		Node4 q=list.get(b-1);
		while(p.next!=null)
			p=p.next;
		p.next=new Node4(b);
		//System.out.println("kn +"+p.next.data);
		while(q.next!=null)
			q=q.next;
		q.next=new Node4(a);
	}
	static void dfs(){
		Node4 p=list.get(0);
		stack[++top]=p.data;
		visited[p.data-1]=1;
		//System.out.print(p.data+"===>");
		while(top!=-1){
			boolean bool=false;
			Node4 t=list.get(stack[top]-1);
			Node4 x=t;
			t=t.next;
			while(t!=null){
				if(visited[t.data-1]==0){
					stack[++top]=t.data;
					visited[t.data-1]=1;
					bool=true;
					System.out.print(x.data+"-"+t.data);
					break;
				}
				t=t.next;
			}
			if(bool)
				System.out.print("===>");
			else
				top--;
		}
	}
}

/*
1-->6-->2-->
2-->1-->5-->3-->
3-->2-->4-->
4-->3-->5-->
5-->2-->4-->
6-->1-->
1-6===>1-2===>2-5===>5-4===>4-3===>
*/