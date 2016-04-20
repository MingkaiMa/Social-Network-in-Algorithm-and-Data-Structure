package MainTest;

import Network.Network;

/**
 * 
 * @author Mingkai_Ma
 *
 */


public class Main {
	/**
	 * get the current time in second
	 * 
	 */
	public static int getCurrentTime() {
		return (int) (System.currentTimeMillis() / 1000L);
		}
	/**
	 * to give examples and test
	 * @param args
	 */
	public static void main(String[] args) {
		
Network u = new Network();
		
		u.createUserProfile("ma", 20);
		u.createUserProfile("A", 16);
		u.createUserProfile("B", 17);
		u.createUserProfile("C", 18);
		u.createUserProfile("D", 21);
		u.createUserProfile("E", 22);
		u.createUserProfile("F", 23);
		u.createUserProfile("G", 24);
		u.createCorporateProfile("apple");
		u.createCorporateProfile("H&M");
		

		
		u.connect("ma", "A");
		u.connect("A", "B");
		u.connect("B", "F");
		u.connect("F", "G");
		u.connect("G", "E");
		u.connect("E", "D");
		u.connect("D", "A");
		u.connect("ma", "C");
		
		u.rate("D", "apple", 3);
		u.rate("D", "H&M", 8);
		u.rate("C", "apple", 3);
		u.rate("E", "H&M", 1);
		u.rate("F", "H&M", 2);
		u.rate("A", "apple", 5);
		u.rate("A", "H&M", 5);

		
		u.printPath("C", "G");
		
		u.postMessage("B","Nice day", 2, 15, getCurrentTime()-7200);
		u.postMessage("ma", "hello world", 3, 15, getCurrentTime()-3600);
		u.postMessage("C", "want something interesting?", 0, 10, getCurrentTime()+36);
		u.postMessage("F", "gigi", 5, 14, getCurrentTime()+3600);
		u.postMessage("G", "haha", 3, 10, getCurrentTime()+7200);
		u.postMessage("E", "ohohoh", 2, 14, getCurrentTime()+7201);
		u.postMessage("D", "what a fuck day", 0, 10, getCurrentTime()+22);

		u.postAd("apple", "discount for students", 0, true, getCurrentTime()+3600);
		u.postAd("H&M", "want more?", 0, true, getCurrentTime());
		System.out.println(u);
		u.printWall("D");

		
		
	}

}
