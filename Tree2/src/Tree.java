import java.util.ArrayList;

public class Tree {

	Node<String> root;
	
	
	
	class Node<E>{
		ArrayList<E> list;
		E data;
		public Node(E data) {
			this.data=data;
			list=new ArrayList<>();
		}
		
		
	}
}
