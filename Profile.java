package Profile;

import DataStructure.AdMessage;
import DataStructure.Message;
import DataStructure.Wall;

/**
 * This class is to implement both user profile and corporate profile
 * @author Mingkai_Ma
 *
 */

public class Profile implements Comparable{

    private String name;
    private int age;
    private Wall wall;
    private int starts = -1;     // variable start is only used by corporate profile,its initial value is -1
  
    public Profile(String _name,int _age){
    	name = _name;
    	age = _age;
        wall = new Wall();
 
    }
    
    public void postMessageOnWall(Message m,int priority){
    	wall.MessageWall(m,priority);
    }

    public void postAdOnWall(AdMessage m,int priority){
    	wall.AdWall(m, priority);
    }
    
    public void RateStart(int n){
		starts = n;
		//return true;
	}
	
    public int getStart(){
		return starts;
	}
	
    
    public int getAge(){
    	return age;
    }
    
    public Object getUsername(){
    	return name;
    }

    public String toString(){
    	String s = name;
    	 s = s + "\n";
    	 s = s + "\n";
    	 s = s + wall.toString();
    	 return s;
        
    }
    
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
    
}


