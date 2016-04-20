package DataStructure;

import java.util.Comparator;

public class Queue {
   private LinkedList s;
   
   public Queue(){
	   s=new LinkedList();
   }
   public void push(Comparable o){
	   s.addLast(o);
   }
   public Comparable pop(){
	   if(s.size()!=0){
		   Comparable a= s.getFirst();
		   s.removeFirst();
		   return a;
	   }
	   else{
		   return null;
	   }
	   
   }
   
   public Comparable top(){
		  Comparable a= s.getFirst();
		  System.out.println(a);
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
	   System.out.println(") ");
   }
   
   
}
