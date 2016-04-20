package DataStructure;
/**
 * Message to represent user name,message content,
 * privacy,age limit and time stamp
 * 
 * @author Mingkai_Ma
 *
 */
public class Message {
	
      private String content;
      private String author;
      private int privacy;
      private int agelimit;
      private int time;
      /**
       * 
       * @param c to represent message content
       * @param a to represent user's name
       * @param pri to represent privacy
       * @param age to represent age limit
       * @param timestamp to represent post time 
       */
      public Message(String c,String a,int pri,int age,int timestamp){
    	  content = c;
    	  author = a;
    	  privacy = pri;
    	  agelimit = age;
    	  time = timestamp;
      }
      
      @Override
      public String toString(){
    	  String s = "content:";
    	  s = s + content;
    	  s = s + "\n";
    	  s = s + "author:";
    	  s = s + author;
    	  s = s + "\n";
    	  s = s + "privacy:";
    	  s = s + privacy;
    	  s = s + "\n";
    	  s = s + "age limit:";
    	  s = s + agelimit;
    	  s = s + "\n";
    	  s = s + new java.text.SimpleDateFormat("HH:mm:ss MM-dd yyyy").format(time*1000L);
    	  return s;
      }
}
