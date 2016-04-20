package DataStructure;


public class LinkedList {

	private class ListElement{
	   private Comparable el1;
	   private ListElement el2;
	   
	   public ListElement(Comparable el,ListElement nextElement){
		   el1=el;
		   el2=nextElement;
	   }
	   public ListElement(Comparable el){
		   this(el,null);
	   }
	   public Comparable first(){
		   return el1;
	   }
	   public ListElement rest(){
		   return el2;
	   }
	   public void setFirst(Comparable value){
		   el1=value;
	   }
	   public void setRest(ListElement value){
		   el2=value;
	   }
	}
	   private ListElement head;
	   public LinkedList(){
		   head=null;
	   }
	   public void addFirst(Comparable o){
		   //ListElement newElement=new ListElement(o,head);
		   //newElement.setFirst(o);
		   head=new ListElement(o,head);
	   }
	   public Comparable getFirst(){
		  return head.first(); 
	   }
	   public Comparable get(int n){
		   ListElement d=head;
		   while(n>0){
			   d=d.rest();
			   n--;
		   }
		   return d.first();
	   }
	   public Comparable get_value(Comparable n){
		   ListElement d=head;
		   while(d.first()!=n){
			   d=d.rest();
		   }
		   return d.first();
	   }
	  
	  public int size(){
		  int n=0;
		  ListElement d=head;
		  while(d!=null){
			  d=d.rest();
			  n++;
		  }
		  return n;
	  }
	  
	  public void clear(){
		  ListElement d = head;
		  d.el2 = null;
		  d.el1 = "\n";
	  }
	  
	  public Comparable getLast(){
		  ListElement d=head;
		  while(d.el2!=null){          
			  d=d.rest();
		  }
		  return d.first();
	  }
	  
	  public void addLast(Comparable o){
		  ListElement last=new ListElement(o,null); 
		  ListElement d=head;
		  
		  if(d==null){
			  head=new ListElement(o,head);
		  }else{
		  while(d.el2!=null){          
			  d=d.rest();
		  }
		  d.el2=last;}		  
	  }
	  
	  public void removeFirst(){
		  ListElement d=head;
		  head=head.el2;
	  }
	  
	  public void removeLast(){
		  ListElement d=head;
		  if(d == null ){
			  System.out.println("null linkedlist");
		  }else if(d.el2 == null){
			  head = null;
		  }else if(d.el2 != null){
			  while(d.el2.el2!=null){          
				  d=d.rest();
			  }
			  d.el2=null;
		  }
	  }
 
	  public void fropple(){
		  ListElement i=head;
		  ListElement j=i.el2;
		  ListElement k=j.el2;
		  head=head.el2;
		  while(j!=null){
			  j.el2=i;
			  if(k!=null&&k.el2!=null){
				  i.el2=k.el2;
			  }
			  else{
				  i.el2=k;
			  }
			  i=k;
			  if(k!=null){
				  j=k.el2;
			  }
			  else{
				  j=null;
			  }
			  if(k!=null&&k.el2!=null){
				  k=k.el2.el2;
			  }
			  else{
				  k=null;
			  }
		  }
		  
	  }

	  public void append(LinkedList list2){
		  ListElement d=head;
		  for(int i=0;i<list2.size();i++){
			  addLast(list2.get(i));
		  }
	  }
	  
	 public int count;
	  public void addSorted(Comparable o){
		  int count;
		  count=0;
		  if(head == null) head = new ListElement(o,null);
		  else if(head.first().compareTo(o)>0)
		  {
			  head = new ListElement(o,head);
			  
		  }
		  else{
			  ListElement d = head;
			  while((d.rest()!=null)&&(d.rest().first().compareTo(o)<0)){
				  
				  d = d.rest();
			  }
			  ListElement next = d.rest();
			  d.setRest(new ListElement(o,next));
		  }
		 count++;
		  
	  }
	
	   public void print(){
		   System.out.print(" ");
		   System.out.println();
		   ListElement d=head;
		   while(d!=null){
			   System.out.print(d.first()+" ");
			   d=d.rest();
		   }
		   System.out.println(" ");
	   }
	   
	   @Override
	   public String toString(){
		   String s = " ";
		   ListElement d=head;
		   while(d!=null){
			   s = s +d.first();
			   s = s + " ";
			   d=d.rest();
		   }
		   return s;
	   }
	
}

