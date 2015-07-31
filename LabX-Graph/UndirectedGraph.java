//Sirinapha Dube 
//Lab X: Graphs



import java.util.Iterator;
import java.util.Queue;


public class UndirectedGraph<T> implements BasicGraphInterface <T> {
	
	private DirectedGraph digraph;
	
	public UndirectedGraph() {
		
		digraph = new DirectedGraph<T>();
		
	}

	public boolean addVertex(T vertexLabel) {
		
		
		return digraph.addVertex(vertexLabel);
	}

	public boolean addEdge(T begin, T end, double edgeWeight) {
		
		return digraph.addEdge(begin, end, edgeWeight) && digraph.addEdge(end, begin, edgeWeight);
	} // end addEdge
	
	
	public boolean addEdge(T begin, T end) {
		
		
		return digraph.addEdge(begin, end) && digraph.addEdge(end, begin);
	}

	
	public boolean hasEdge(T begin, T end) {
		return digraph.hasEdge(begin, end);
	}

	
	public boolean isEmpty() {
		return (digraph.getNumberOfVertices()==0);
	}

	
	public int getNumberOfVertices() {
		return digraph.getNumberOfVertices();
	}

	
	public int getNumberOfEdges() {
		return digraph.getNumberOfEdges() / 2;
	}

	
	public void clear() {
		digraph.clear();
	}
	
	public Queue<T> getBreadthFirstTraversal(T origin) {
		return digraph.getBreadthFirstTraversal(origin);
	}
	
	public Queue<T> getDepthFirstTraversal(T origin) {
		return digraph.getDepthFirstTraversal(origin);
	}
	
	
	public boolean isConnected(T origin) {
		if (isEmpty())
	         return false;
	      
	      Iterator<T> it = digraph.getBreadthFirstTraversal(origin).iterator();
	      int count = 0;

	      while (it.hasNext())
	      {
	         it.next();
	         count++;
	      }
	      return (count == digraph.getNumberOfVertices());
	   }

}
