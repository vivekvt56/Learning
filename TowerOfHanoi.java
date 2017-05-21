package com;

public class TowerOfHanoi {
	static int noOfMoves;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Vaid Moves :: ");
		Towers(4, "A", "B", "C");
		System.out.println("Min No of Moves :: "+noOfMoves);
	}
	static void Towers(int n,String from,String aux,String to){
		if(n==1){
			System.out.println("Move disk from "+from+" to "+to);
			noOfMoves++;
			return;
		}else{
			//noOfMoves++;
			Towers(n-1, from, to, aux);
			Towers(1, from, aux, to);
			Towers(n-1, aux, from, to);
		}
	}

}
/*
Output ::::
Vaid Moves :: 
Move disk from A to B
Move disk from A to C
Move disk from B to C
Move disk from A to B
Move disk from C to A
Move disk from C to B
Move disk from A to B
Move disk from A to C
Move disk from B to C
Move disk from B to A
Move disk from C to A
Move disk from B to C
Move disk from A to B
Move disk from A to C
Move disk from B to C
Min No of Moves :: 15
*/