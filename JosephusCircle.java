package com;

class NodeJC{
	int data;
	NodeJC next;
	public NodeJC(int i) {
		data=i;
	}
}
public class JosephusCircle {
	static NodeJC head;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createList(10);
		NodeJC t=head;
		System.out.println("People in circle");
		System.out.print(t.data+" ");
		t=t.next;
		while(t!=head){
			System.out.print(t.data+" ");
			t=t.next;
		}
		josephusCircle();
	}
	static void createList(int n){
		head=new NodeJC(1);
		NodeJC t=head;
		for(int i=2;i<=n;i++){
			t.next=new NodeJC(i);
			t=t.next;
		}
		t.next=head;
	}
	static void josephusCircle(){
		NodeJC t=head;
		while(t.next!=t){
			//NodeJC N=t.next;
			t.next=t.next.next;
			t=t.next;
		}
		System.out.println("\nChosen Place is :: ");
		System.out.println(t.next.data);
	}
}
/*
Output :::
People in circle
1 2 3 4 5 6 7 8 9 10 
Chosen Place is :: 
5
*/