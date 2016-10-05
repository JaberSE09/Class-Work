import java.util.ArrayList;

public class Queue<E> {

	ArrayList<E> thedata;
	public void offer(E item){
		thedata.add(item);	
		}
	public E peek(){
		return thedata.get(0);
	}
	public E pull(){
		E hold=thedata.get(0);
		thedata.remove(0);
		return hold;
	}
}
