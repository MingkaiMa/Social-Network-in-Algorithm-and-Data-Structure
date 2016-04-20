package Graph;

import DataStructure.LinkedList;
import DataStructure.Queue;
import DataStructure.Stack;
import Profile.Profile;
/**
 * This class is to implement the whole social network
 * @author Mingkai_Ma
 *
 */
public class Graph {
	
	static int MAXCOST=Integer.MAX_VALUE;
	
	private LinkedList nodes;
	private LinkedList BFSlist;
	public Graph(){
		nodes = new LinkedList();
	}
	public void addNode(Profile label){
		nodes.addLast(new Node(label));
	}
	/**
	 * find a specific node
	 * @param nodeLabel
	 * @return
	 */
	private Node findNode(Profile nodeLabel){
		Node res = null;
		for(int i =0;i<nodes.size();i++){
			Node n = (Node)nodes.get(i);
			if(n.getLabel().getUsername() == nodeLabel.getUsername()){
				res = n;
				break;
			}
		}
		return res;
	}
	/**
	 * to judge whether a node is a corporate node or not
	 * @param n
	 * @return
	 */
	public boolean isCorporate(Node n){
		boolean flag = false;
		if(n.getLabel().getAge() == -1){
			flag = true;
		}
		return flag;
	}
	/**
	 * add one node into a node's adjacency list 
	 * @param nodeLabel1
	 * @param nodeLabel2
	 * @param w
	 */
	public void addEdge(Profile nodeLabel1,Profile nodeLabel2,int w){
		Node n1 = findNode(nodeLabel1);
		Node n2 = findNode(nodeLabel2);
		n1.addEdge(new Edge(n2,w));
	}
	/**
	 * set all nodes' flag as false,that is,not visited
	 */
	public void refresh(){
		for(int i = 0; i < nodes.size(); i ++){
			((Node) nodes.get(i)).setFalse();
		}
	}
	/**
	 * according to the key,find the value
	 * @param username
	 * @return
	 */
	public Node find(String username){
		for(int i = 0; i < nodes.size(); i ++){
			if(((Node) nodes.get(i)).getLabel().getUsername() == username){
				return ((Node) nodes.get(i));
			}
			else{
				continue;
			}
		}
		return null;
	}
	/**
	 * traverse all node in graph,from a specific node,using breadth first search(BFS)
	 * @param name1
	 */
	public void BFSPath(String name1){
		refresh();											//set all nodes' flag as false,which means,not visited
		Node startState = find(name1);
		Queue toDoList = new Queue();
		toDoList.push(startState);
		while(!toDoList.empty()){
			Node currentNode = (Node) toDoList.pop();
			currentNode.setFlag();
			for(int i = 0;i<currentNode.getEdgeSize();i++){
				Edge e = (Edge)currentNode.getEdge(i);
				if(e.getNode().getFlag()){}
				else{
					toDoList.push(e.getNode());
					e.getNode().setPreNode(currentNode);
					e.getNode().setFlag();
				}
			}
		}
	}
	/**
	 * print path according BFS
	 * @param name1
	 * @param name2
	 */
	public void printPath(String name1,String name2){
		refresh();
		BFSlist = new LinkedList();
		Node startState = find(name1);
		Node endState = find(name2);
		BFSPath(name1);
		System.out.println();
		Stack s = new Stack();
		s.push(endState);
		while(!s.empty()){
			Node currentNode = (Node) s.pop();
			if(currentNode == null){
				System.out.println(startState.getLabel().getUsername()+"->"+endState.getLabel().getUsername()+":is Not connected");
				BFSlist.clear();
				break;
			}
			BFSlist.addFirst((Comparable) currentNode.getLabel().getUsername());
			if(currentNode == startState){}
			else{
				s.push(currentNode.getPreNode());
			}
		}
		PrintBFSlist();
	}
	/**
	 * print nodes in list searched by BFS
	 */
	public void PrintBFSlist(){
		for(int i=0;i<BFSlist.size()-1;i++){
			System.out.print(BFSlist.get(i));
			System.out.print("->");
		}
		System.out.print(BFSlist.getLast());
		System.out.println();
	}
	/**
	 * get distance between two nodes
	 * @param name1
	 * @param name2
	 * @return
	 */
	public int getDistance(String name1,String name2){
		refresh();
		BFSlist = new LinkedList();
		Node startState = find(name1);
		Node endState = find(name2);
		BFSPath(name1);
		System.out.println();
		Stack s = new Stack();
		s.push(endState);
		while(!s.empty()){
			Node currentNode = (Node) s.pop();
			if(currentNode == null){
				System.out.println(startState.getLabel().getUsername()+"->"+endState.getLabel().getUsername()+":is Not connected");
				return MAXCOST;
			}
			BFSlist.addFirst((Comparable) currentNode.getLabel().getUsername());
			if(currentNode == startState){}
			else{
				s.push(currentNode.getPreNode());
			}
		}
		return BFSlist.size()-1;
	}
	/**
	 * traverse all node in graph,exclude corporate nodes, from a specific node,using breadth first search(BFS)
	 * @param name1
	 */
	public void BFSpathExcludeCorporate(String name1){
		refresh();
		Node startState = find(name1);
		BFSlist = new LinkedList();
		Queue toDoList = new Queue();
		toDoList.push(startState);
		while(!toDoList.empty()){
			Node currentNode = (Node) toDoList.pop();
			currentNode.setFlag();
			for(int i = 0;i<currentNode.getEdgeSize();i++){
				Edge e = (Edge)currentNode.getEdge(i);
				if(e.getNode().getFlag()){}
				else{
					if(isCorporate(e.getNode())){
					}else{
						toDoList.push(e.getNode());
						e.getNode().setPreNode(currentNode);
						e.getNode().setFlag();
					}
				}
			}
		}	
	}
	/**
	 * print path between two nodes exclude corporate node
	 * @param name1
	 * @param name2
	 */
	public void printPathExcludeCorporate(String name1,String name2){
		refresh();
		BFSlist = new LinkedList();
		Node startState = find(name1);
		Node endState = find(name2);
		BFSpathExcludeCorporate(name1);
		System.out.println();
		Stack s = new Stack();
		s.push(endState);
		
		while(!s.empty()){
			Node currentNode = (Node) s.pop();
			if(currentNode == null){
				System.out.println(startState.getLabel().getUsername()+"->"+endState.getLabel().getUsername()+":is Not connected");
				BFSlist.clear();
				break;
			}
			BFSlist.addFirst((Comparable) currentNode.getLabel().getUsername());
		
			if(currentNode == startState){}
			else{
				s.push(currentNode.getPreNode());
			}
		}
		PrintBFSlist();
	}
	/**
	 * get distance between two nodes exclude corporate
	 * @param name1
	 * @param name2
	 * @return
	 */
	public int getDistanceExcludeCorporate(String name1,String name2){
		refresh();
		BFSlist = new LinkedList();
		Node startState = find(name1);
		Node endState = find(name2);
		BFSpathExcludeCorporate(name1);
		System.out.println();
		Stack s = new Stack();
		s.push(endState);
		while(!s.empty()){
			Node currentNode = (Node) s.pop();
			if(currentNode == null){
				System.out.println(startState.getLabel().getUsername()+"->"+endState.getLabel().getUsername()+":is Not connected");
				return MAXCOST;
			}
			BFSlist.addFirst((Comparable) currentNode.getLabel().getUsername());
			if(currentNode == startState){}
			else{
				s.push(currentNode.getPreNode());
			}
		}
		return BFSlist.size()-1;
	}
	
	
	@Override
	public String toString(){
		String s = "\n";

		for(int i=0;i<nodes.size();i++){
			if(!isCorporate((Node) nodes.get(i))){
				s = s + ((Node) nodes.get(i)).getLabel();
				s = s + "*****************";
				s = s + "\n";
			}
		}
		return s;
	}
	/**
	 * get a user's friend list
	 * @param name
	 */
	public void getList(String name){
		for(int i = 0; i < nodes.size(); i ++){
			if(((Node) nodes.get(i)).getLabel().getUsername() == name){
				for(int j = 0;j<((Node) nodes.get(i)).size(); j++){
					  System.out.print(((Node) nodes.get(i)).getEdgeElement(j)+ ",");	
					}
			}
		}
	}
	/**
	 * whether a node is exist or not in graph
	 * @param name
	 * @return
	 */
	public boolean isExist(String name){
		for(int i = 0; i < nodes.size(); i ++){
			if(((Node) nodes.get(i)).getLabel().getUsername() == name){
				return true;
			}
			else{
				continue;
			}
		}
		return false;
	}
	/**
	 * to judge whether a user rate a corporate 
	 * @param companyName
	 * @param userName
	 * @return
	 */
	public boolean isRate(String companyName,String userName){	
		for(int i = 0; i < nodes.size(); i ++){
			if(((Node) nodes.get(i)).getLabel().getUsername() == companyName){
				for(int j = 0;j<((Node) nodes.get(i)).size(); j++){
					 if(((Node) nodes.get(i)).getEdgeElement(j) == userName){
						 return true;
					 } 	
					}
			}
			else{
				continue;
			}	
		}
		return false;	
	}	
}
