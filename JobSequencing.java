package com;

import java.util.Set;
import java.util.TreeSet;

class Job implements Comparable<Job>{
	int id,deadline,profit;
	public Job(int id,int deadline,int profit) {
		this.id=id;
		this.deadline=deadline;
		this.profit=profit;
	}
	@Override
	public int compareTo(Job o) {
		// TODO Auto-generated method stub
		return ((Integer)(o.profit)).compareTo(this.profit);
	}
}
public class JobSequencing {
	static Set<Job> jobs=new TreeSet<>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		createJob();
		for(Job i:jobs){
			System.out.println(i.id);
		}
		int[] a=jobSeq(3);
		System.out.println("After Job is sequenced :::::");
		for(int i:a)
			System.out.print(i+" : ");
	}
	static void createJob(){
		Job ob1=new Job(1, 2, 100);
		Job ob2=new Job(2, 1, 19);
		Job ob3=new Job(3, 2, 27);
		Job ob4=new Job(4, 1, 25);
		Job ob5=new Job(5, 3, 15);
		jobs.add(ob1);jobs.add(ob2);jobs.add(ob3);jobs.add(ob4);jobs.add(ob5);
	}
	static int[] jobSeq(int time){
		int[] a=new int[time];
		for(Job i:jobs){
			for(int j=i.deadline-1;j>=0;j--){
				if(a[j]==0){
					a[j]=i.id;
					break;
				}
			}
		}
		return a;
	}
}
/*
1
3
4
2
5
After Job is sequenced :::::
3 : 1 : 5 : 
*/