package DataStructure;
/**
 * AdMessage to represent corporate name,
 * advertisement content and age limit
 * 
 * @author Mingkai_Ma
 *
 */
public class AdMessage {
	
      private String content;
      private String corporateName;
      private int agelimit;
      
      /**
       * initialize the class
       * 
       * @param c represent advertisement content
       * @param a represent corporate name
       * @param age represent age limit
       */
      public AdMessage(String c,String a,int age){
    	  content = c;
    	  corporateName = a;
    	  agelimit = age;
      }
      
      @Override
      public String toString(){
    	  String s = "<";
    	  s = s + corporateName;
    	  s = s + ">";
    	  s = s + "\n";
    	  s = s + content;
    	  s = s + "\n";
    	  s = s + "Age limit:";
    	  s = s + agelimit;
    	  return s;
      }
}