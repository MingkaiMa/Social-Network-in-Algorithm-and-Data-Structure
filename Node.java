package Graph;

import DataStructure.LinkedList;
import Profile.Profile;

public class Node implements Comparable{
	
	private Profile info;
	private LinkedList edges;
	boolean flag;
	private Node pre;
	
	public Node(Profile label){
		info = label;
		edges = new LinkedList();
		flag = false;
		pre = null;
	}
	public void addEdge(Edge e){
		edges.addLast(e);
	}
	
	public void setFlag(){
		flag = true;
	}
	public boolean getFlag(){
		return flag;
	}
	
	public void setFalse(){
		flag = false;
	}
	
	public void setPreNode(Node a){
		pre = a;
	}
	
	public Node getPreNode(){
		return pre;
	}
	
	public int getEdgeSize(){
		return edges.size();
	}
	
	public Edge getEdge(int n){
		return (Edge) edges.get(n);
	}
	
	public int compareTo(Object o){
		Node n = (Node)o;
		return n.info.compareTo(info);
	}
	
	public Profile getLabel(){
		return info;
	}
	public Object getEdgeElement(int n){
		return ((Edge) edges.get(n)).getEdgeEle();
	}
	public int getEdgeWeight(int n){
		return ((Edge) edges.get(n)).getweight();
	}
	public int size(){
		return edges.size();
	}
	

}