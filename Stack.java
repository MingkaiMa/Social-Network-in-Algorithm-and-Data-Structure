package DataStructure;

import java.util.Comparator;

public class Stack {
   private LinkedList s;
   
   public Stack(){
	   s=new LinkedList();
   }
   public void push(Comparable o){
	   s.addLast(o);
   }
   public Comparable pop(){
	   if(s.size()!=0){
		   Comparable a= s.getLast();
		   s.removeLast();
		   return a;
	   }
	   else{
		   return null;
	   }
	   
   }
   public Comparable top(){
	  Comparable a= s.getLast();
	  System.out.println(a);
//	  s.removeLast();
	  return a;
   }
   public int size(){
	   return s.size();
   }
   
   public boolean empty(){
	   if(s.size()==0){
		   return true;
	   }
	   else{
		   return false;
	   }
   }
   
   public void print(){
	   System.out.print("( ");
	   for(int i=0;i<s.size();i++){
		   System.out.print(s.get(i)+" ");
	   }
	   System.out.print(") ");
   }
   
   
}
