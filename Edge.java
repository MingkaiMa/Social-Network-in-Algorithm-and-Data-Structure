package Graph;

public class Edge implements Comparable{
	private Node toNode;
	private int w;
	public Edge(Node to,int weight){
		toNode = to;
		w = weight;
	}
	public Object getEdgeEle(){
		return toNode.getLabel().getUsername();
	}
	public int getweight(){
		return w;
	}
	public Node getNode(){
		return toNode;
	}
	public int compareTo(Object o){
		Edge n = (Edge)o;
		return n.toNode.compareTo(toNode);
	}
}