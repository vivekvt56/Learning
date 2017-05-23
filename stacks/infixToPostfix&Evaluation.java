//Question : Infix to postfix conversion & evaluation of Postfix expression
package com;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class InfixToPostfix {
	static String s="(3+5*(7-4)^2)",a="";
	static Map<Character, Integer> operands=new LinkedHashMap<>();
	static List<Character> stack=new ArrayList<>();
	
	static List<Integer> stackCal=new ArrayList<>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addOperands();
		System.out.println("Infix exp : "+s);
		convert();
		System.out.println("Postfix exp : "+a);
		System.out.print("Postfix exp evaluate : ");
		calculate();
	}
	static void addOperands(){
		operands.put('^', 3);
		operands.put('/', 2);
		operands.put('*', 2);
		operands.put('+', 1);
		operands.put('-', 1);
	}
	
	static void calculate(){
		String a="3574-2^*+";
		for(int i=0;i<a.length();i++){
			if(a.charAt(i)==' ')
				continue;
			if(operands.containsKey(a.charAt(i))){
				int q=stackCal.get(stackCal.size()-1);
				stackCal.remove(stackCal.size()-1);
				int p=stackCal.get(stackCal.size()-1);
				stackCal.remove(stackCal.size()-1);
				if(a.charAt(i)=='+'){
					stackCal.add((p+q));
				}else if(a.charAt(i)=='-'){
					stackCal.add((p-q));
				}else if(a.charAt(i)=='*'){
					stackCal.add((p*q));
				}else if(a.charAt(i)=='/'){
					stackCal.add((p/q));
				}else if(a.charAt(i)=='^'){
					stackCal.add((int)(Math.pow(p,q)));
				}
			}else{
				stackCal.add(Integer.valueOf(String.valueOf(a.charAt(i))));
			}
		}
		System.out.println(stackCal.get(0));
	}
	
	static void convert(){
		for(int i=0;i<s.length();i++){
			char c=s.charAt(i);
			if(c==')'){
				while(true){
					if(stack.get(stack.size()-1)=='('){
						stack.remove(stack.size()-1);
						break;
					}
					a=a+stack.get(stack.size()-1)+" ";
					//System.out.print(stack.get(stack.size()-1)+" ");
					stack.remove(stack.size()-1);
				}
			}else if(c=='('){
				stack.add(c);
			}else{
				if(operands.containsKey(c)){
						int prt=operands.get(c);
						char prv=stack.get(stack.size()-1);
						if(operands.containsKey(prv)){
							while(true){
								prv=stack.get(stack.size()-1);
								if(!operands.containsKey(prv))
									break;
								int prv_prt=operands.get(prv);
								if(prv_prt>=prt){
									a=a+stack.get(stack.size()-1)+" ";
									//System.out.print(stack.get(stack.size()-1)+" ");
									stack.remove(stack.size()-1);
								}else{
									//stack.add(c);
									break;
								}
							}
							stack.add(c);
						}else{
							stack.add(c);
						}
				}else{
					a=a+c+" ";
					//System.out.print(c+" ");
				}
			}
		}
	}
}
/*
Output ::
Infix exp : (3+5*(7-4)^2)
Postfix exp : 3 5 7 4 - 2 ^ * + 
Postfix exp evaluate : 48
*/