package com;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class TravSalesProb {
	static Set<String> sets=new LinkedHashSet<>();
	static int[][] dist;
	static Set<String> trav=new LinkedHashSet<>();
	static Map<String, Integer> map=new LinkedHashMap<>();
	static Map<String, Integer> mapparent=new LinkedHashMap<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//no of vertex
		int n=4;
		createSubset(n-1);
		dist=new int[n][n];
		//start vertes : s
		int startVertex=0;
		createDisMatrix();
		System.out.println("Min cost Hamiltonian Circuit : "+eval_Trav(n, startVertex));
		findPath();
	}
	static void createSubset(int n){
		int l=(int)Math.pow(2, n);
		for(int i=0;i<l;i++){
			String s="";
			int j=1;
			int k=1;
			s=s+"[";
			while(j<l){
				int t=j&i;
				if(t!=0){
					s=s+k+" ";
				}
				k++;
				j=j<<1;
			}
			s=s+"]";
			sets.add(s);
		}
	}
	static void createDisMatrix(){
		dist[0][1]=1;
		dist[0][2]=15;
		dist[0][3]=6;
		dist[1][0]=2;
		dist[1][2]=7;
		dist[1][3]=3;
		dist[2][0]=9;
		dist[2][1]=6;
		dist[2][3]=12;
		dist[3][0]=10;
		dist[3][1]=4;
		dist[3][2]=8;
	}
	static int eval_Trav(int n,int startVertex){
		int hamiltonian=0;
		for(String s:sets){
			String k="";
			if(!s.equals("[]")){
				String t=s.substring(1,s.length()-2);
				boolean b=false;
				for(int j=1;j<n;j++){
					if(!t.contains(String.valueOf(j))){
						k="["+j+","+s+"]";
						trav.add(k);
						//System.out.println("["+j+","+s+"]");
						b=true;
					}
				}
				if(!b){
					k="["+startVertex+","+s+"]";
					trav.add(k);
					//System.out.println("["+startVertex+","+s+"]");
				}
			}else{
				for(int j=1;j<n;j++){
					k="["+j+",[$]"+"]";
					trav.add(k);
					//System.out.println("["+j+",$"+"]");
				}
			}
			//trav.add(k);
		}
		for(String j:trav){
			System.out.println(j);
			String a=j.substring(1,2).trim();
			String t=j.substring(j.indexOf("[", 1)+1,j.length()-2).trim();
			//System.out.println(a+"-->"+t);
			if(t.equals("$")){
				map.put(j, dist[0][Integer.parseInt(a)]);
				mapparent.put(j, 0);
				System.out.println("cost : "+dist[0][Integer.parseInt(a)]);
			}else if(t.length()==1){
				map.put(j, (dist[0][Integer.parseInt(t)]
						+dist[Integer.parseInt(t)][Integer.parseInt(a)]));
				mapparent.put(j, Integer.parseInt(t));
				System.out.println("cost is : "+(dist[0][Integer.parseInt(t)]
						+dist[Integer.parseInt(t)][Integer.parseInt(a)]));
			}else{
				String[] k=t.split(" ");
				int min=Integer.MAX_VALUE;
				int parent=0;
				String e="[";
				for(String s:k){
					e=e+s+",[";
					for(String s1:k){
						if(!s1.equals(s)){
							e=e+s1+" ";
						}
					}
					e=e+"]]";
					//System.out.println("e : "+e);
					int temp=(dist[Integer.parseInt(s)][Integer.parseInt(a)]+map.get(e));
					if(temp<min){
						min=temp;
						parent=Integer.parseInt(s);
					}
					//System.out.println("cost is : "+);
					//map.put(j, (dist[Integer.parseInt(s)][Integer.parseInt(a)]+map.get(e)));
					e="[";
					//System.out.println("cost is : "+(dist[0][Integer.parseInt(s)]
						//	+" "+dist[Integer.parseInt(s)][Integer.parseInt(a)]));
				}
				map.put(j, min);
				mapparent.put(j, parent);
				System.out.println("cost is : "+min+" : "+parent);
				hamiltonian=min;
			}
		}
		return hamiltonian;
	}
	static void findPath(){
		String s="[0,[1 2 3 ]]";
		int p=mapparent.get(s);
		System.out.println("Route is : ");
		System.out.print("0<--"+p+"<--");
		while(true){
		s=s.substring(s.indexOf("[",1)+1,s.length()-2).trim();
		//System.out.println("s : "+s);
		String t1="["+p+",";
		if(s.length()==1){
			t1=t1+"[$]";
		}else{
		t1=t1+"[";
		for(String t:s.split(" ")){			
			if(!t.equals(String.valueOf(p))){
				t1=t1+t+" ";
			}
		}
		t1=t1+"]";
		}
		t1=t1+"]";
		//System.out.println("t1 : "+t1);
		p=mapparent.get(t1);
		System.out.print(p+"<--");
		s=t1;
		if(p==0)
			break;
		}
	}
}


//Output
/*
[1,[$]]
cost : 1
[2,[$]]
cost : 15
[3,[$]]
cost : 6
[2,[1 ]]
cost is : 8
[3,[1 ]]
cost is : 4
[1,[2 ]]
cost is : 21
[3,[2 ]]
cost is : 27
[3,[1 2 ]]
cost is : 20 : 2
[1,[3 ]]
cost is : 10
[2,[3 ]]
cost is : 14
[2,[1 3 ]]
cost is : 12 : 3
[1,[2 3 ]]
cost is : 20 : 2
[0,[1 2 3 ]]
cost is : 21 : 2
Min cost Hamiltonian Circuit : 21
Route is : 
0<--2<--3<--1<--0<--
*/