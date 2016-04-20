package Network;

import DataStructure.AdMessage;
import DataStructure.Dictionary;
import DataStructure.Message;
import Graph.Graph;
import Profile.Profile;
/**
 * 
 * @author Mingkai_Ma
 *
 */
public class Network implements NetworkInterface{

	private Dictionary datauser;;  		  //////to store user 
	private Dictionary datacompany; 	  /////to store company
	private Graph connection;       	  ////to build connection between users and users,users and companies
	/*
	 * initialize the class:network
	 */
	public Network(){
		datauser = new Dictionary();
		datacompany = new Dictionary();
		connection = new Graph();
	}
	/**
	 * Create user profile and add user node in graph
	 */
	public void createUserProfile(String name,int age){
	    Profile user = new Profile(name,age);
	    datauser.add(name, user);
	    connection.addNode((Profile) datauser.find(name));
	}
	/**
	 * Create corporate profile and add corporate node in graph
	 */
	public void createCorporateProfile(String name){
		Profile company = new Profile(name,-1);
	    datacompany.add(name, company);
	    connection.addNode((Profile) datacompany.find(name));
	}
	/**
	 * Print a specific user's wall
	 */
	public void printWall(String username){
		System.out.println(datauser.find(username));
	}
	/**
	 * Post message to users in the network according rules
	 */
	public void postMessage(String username, String message,int privacy, int ageLimit, int timestamp){
		String author = username;
		for(int i=0;i<datauser.getSize();i++){
			Message m = new Message(message,author,privacy,ageLimit,timestamp);
			int a = ((Profile) datauser.getValue(i)).getAge();
			if(a<ageLimit){}
			else{
				 if(distanceExcludeCorporate(author,(String) datauser.getKey(i)) == privacy || privacy==0){
					((Profile) datauser.getValue(i)).postMessageOnWall(m,timestamp);
				 }
			}	
		}
	}
	/**
	 * Post advertisement to users in the network according rules.
	 */
	public void postAd(String username, String message, int ageLimit,boolean paid, int timestamp){
		String cname = username;
		for(int i=0;i<datauser.getSize();i++){
			AdMessage a = new AdMessage(message,cname,ageLimit);
			int age = ((Profile) datauser.getValue(i)).getAge();
			if(age < ageLimit){}
			else{
				if(paid){
					if(connection.isRate(cname, (String) datauser.getKey(i))){
						int t = timestamp + 3600*((Profile) datacompany.find(cname)).getStart();
						((Profile) datauser.getValue(i)).postAdOnWall(a,t);
					}
					else{
						((Profile) datauser.getValue(i)).postAdOnWall(a,timestamp);
					}
				}
				else{
					if(connection.isRate(cname, username)){
						int t = timestamp + 3600*((Profile) datacompany.find(cname)).getStart();
						((Profile) datauser.getValue(i)).postAdOnWall(a,t);
					}
				}
			}
		}
		
	}
	/**
	 * To let user rate a corporate,giving stars
	 */
	public void rate(String username,String corporatename,int starts){
    	connection.addEdge((Profile) datacompany.find(corporatename), (Profile) datauser.find(username), starts);
    	connection.addEdge((Profile) datauser.find(username), (Profile) datacompany.find(corporatename), 0);
    	((Profile) datacompany.find(corporatename)).RateStart(starts);
    }
	/**
	 * Connect two users in the network
	 */
	public void connect(String username1,String username2){	
		if(connection.isExist(username1)){}      
		else{
			connection.addNode((Profile) datauser.find(username1));
		}
		if(connection.isExist(username2)){}
		else{
			connection.addNode((Profile) datauser.find(username2));
		}
		connection.addEdge((Profile) datauser.find(username1), (Profile) datauser.find(username2), 1);
		connection.addEdge((Profile) datauser.find(username2), (Profile) datauser.find(username1), 1);
	}
	/**
	 * Print a user's friend list
	 */
	public void printFriendList(String username){
		System.out.println(((Profile) datauser.find(username)).getUsername()+"'s FriendList:");
		connection.getList(username);		
	}
	/**
	 * Get distance between two users,including corporate nodes
	 */
	public int distance(String name1,String name2){
		return connection.getDistance(name1, name2);
	}
	/**
	 * Print two users' path,including corporate nodes
	 */
	public void printPath(String name1,String name2){
		connection.printPath(name1, name2);
	}
	/**
	 * get distance between two users,not including the corporate nodes
	 */
	public int distanceExcludeCorporate(String name1,String name2){
		return  connection.getDistanceExcludeCorporate(name1, name2);
	}
	/**
	 * Print two users' path,not including corporate nodes
	 */
	public void printPathExcludeCorporate(String name1,String name2){
		connection.printPathExcludeCorporate(name1, name2);
	}
	
	@Override
	public String toString(){
		String s = "\n";
		s = s + connection;
		return s;
	}
	
}
