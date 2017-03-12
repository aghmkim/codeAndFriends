
public class RoutingNode {
	private String name;
	Hashtable 
	/**
	 * Used to set a two-way connection between two nodes
	 * @param destination
	 */
	public void createBidirectionalEdge(RoutingNode destination, int dist){
		destination.CreateMonodirectionalEdge(this, dist);
		this.CreateMonodirectionalEdge(destination, dist);
	}
	
	/**
	 * Used to set a one-way connection from this node to another. 
	 * @param node
	 * @param dist
	 */
	public void CreateMonodirectionalEdge(RoutingNode node, int dist) {
		
	}
	
	public String getName(){
		return name;
	}
}
