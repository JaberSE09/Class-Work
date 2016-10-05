import java.util.ArrayList;

public class Stack<E> {

	ArrayList<E> thedata;
		public E push(E item){
			thedata.add(item);
			return item;
	}
		public E pop(){
			E hold=thedata.get(thedata.size()-1);
			thedata.remove(thedata.size()-1);
			return hold;		
			}
		public E peek(){
			return thedata.get(thedata.size()-1);
		}
		
}