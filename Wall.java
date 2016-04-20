package DataStructure;

/**
 * Wall class to represent user's message wall and advertisement wall,
 * both of them use priority queue to store content with priority
 * @author Mingkai_Ma
 *
 */
public class Wall {
	private PriorityQueue MessageWall;
	private PriorityQueue AdWall;
	
	public Wall(){
		MessageWall = new PriorityQueue();
		AdWall = new PriorityQueue();
	}
		
	 /**
	  * post message on message wall with priority
	  * @param m
	  * @param priority
	  */
	 public void MessageWall(Message m,int priority){
		 MessageWall.push(m,priority);
	 }
	 
	 /**
	  * post advertisement on advertisement wall with priority
	  * @param ad
	  * @param priority
	  */
	 public void AdWall(AdMessage ad,int priority){
		 AdWall.push(ad, priority);
	 }	 
	 
	 /**
	  * 
	  * @return message wall's size
	  */
	 public int MessageSize(){
		 return MessageWall.size();
	 }
	 
	 /**
	  * 
	  * @return advertisement wall's size
	  */
	 public int AdSize(){
		 return AdWall.size();
	 }
	 
	 /**
	  * to get specific position message 
	  * @param n
	  * @return
	  */
	 
	 @Override
	 public String toString(){
			String s ="\n";
			int k = AdWall.size();
			for(int i = MessageWall.size()-1;i>=0;i = i - 4){         //for every 4 user messages one ad is inserted
				for(int j = i;j>i-4&&j>=0;j--){
					s = s + MessageWall.get(j);
					s = s + "\n";
					s = s + "\n";				
				}
				if(k <= 0 || i - 4 < 0){		
					continue;
				}
				else{
					s = s + "**Advertisement**";
					s = s + "\n";
					s = s + AdWall.get(k-1);
					s = s + "\n";
					s = s + "\n";
					k = k - 1;
				}
			}
		return s;	
		}
}
