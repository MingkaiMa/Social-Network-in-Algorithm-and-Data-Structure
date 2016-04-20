package DataStructure;

import java.util.Comparator;
public class PriorityQueue {

	public class PriorityPair implements Comparable{
		
		private Object element;
		private Object priority;
		
		public PriorityPair(Object element,Object priority){
			this.element=element;
			this.priority=priority;
		}
		
		public void setElement(){
		    this.element = element;
		}
		
		public void setPriority(){
			this.priority=priority;
		}
		public Object getElement(){
			return element;
		}
		public Object getPriority(){
			return priority;
		}
		
		public int compareTo(Object o){
			PriorityPair p2=(PriorityPair)o;
			return((Comparable)priority).compareTo(p2.priority);
		}	
	}
	
	public LinkedList s;
	public PriorityQueue(){
		s=new LinkedList();
	}
	
	private PriorityPair a;
	public void push(Object o,int priority){
       a=new PriorityPair(o,priority);
		 s.addSorted(a);	
	}
	
	public void pop(){
	    s.removeFirst();	
	}
	
	public Object top(){
		Object a=((PriorityPair) s.getFirst()).getElement();
		s.removeFirst();
		return a;
	}
	
	public int size(){
		return s.size();
	}
	   
	public Object get(int n){
		return ((PriorityPair) s.get(n)).getElement();
	}
	
   public void print(){
	   for(int i=s.size()-1;i>=0;i--){
		   System.out.print(((PriorityPair) s.get(i)).getElement());
		   System.out.print("   ");
		   System.out.println(((PriorityPair) s.get(i)).getPriority());
	  	}
   }	
}
