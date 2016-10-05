import java.awt.image.DataBufferShort;

import javax.xml.crypto.Data;

/**
   Homework:  Complete the methods: 
      1  set, 
      2  remove, 
      3  copy, and 
      4  reverse
    They currently return an UnsupportOperationException.
 */

class SingleLinkedList<E>  {

  private static class Node<E> {
    private E data;
    private Node<E> next;
    private Node(E item) { data = item; }
  }

  private Node<E> head; 
  private int size;

  /* Insert item at index, returns true if add is successful.*/
  public boolean add(int index, E item) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("" + index);
    }

    if (index == 0) { //adding to the front
      Node<E> t = head;
      head = new Node<>(item);
      head.next = t;
    } else {  //adding anywhere other than front
      Node<E> left = getNode(index - 1);
      Node<E> node = new Node(item);
      Node<E> right = left.next;
      left.next = node;
      node.next = right;
    }
    size++;
    return true;
  }

  
  /* Add item at end of list, returns true if successful.*/
  public boolean add(E item) {
    return add(size, item);
  }

  /* Return item at index */
  public E get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("" + index);
    }
    return getNode(index).data;
  }

  /* Return the number of items */
  public int size() {
    return size;
  }

  /* Returns a string representation of the list */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (Node<E> n = head; n != null; n = n.next) {
      sb.append(n.data); sb.append(" ");
    }
    sb.append("]");
    return sb.toString();
  }

  /* Return the node at location index */
  private Node<E> getNode(int index) {
    Node<E> n = head;
    for (int i = 0; i < index; i++) n = n.next;
    return n;
  }

  //--------------------------------------------------------
  //EXERCISE: update element at index with newValue, return old value
  public E set(int index, E newValue) {
	  	  if (index < 0 || index > size) {
	      	throw new IndexOutOfBoundsException("" + index);
	    	}
	  	  else if (index == 0) {
		      Node<E> t = head;
		      head = new Node<>(newValue);
		      head.next = t;
		      return head.data;
		    } else {  
		      Node<E> left = getNode(index-1);
		      Node<E> node = new Node(newValue);
		      Node<E> right = left.next;
		      left.next = node;
		      node.next = right;
		      return node.data;
		    }
  }

  //EXERCISE: remove element at index, return it.
  public E remove(int index) {
	  if (index < 0 || index > size) {
	      throw new IndexOutOfBoundsException("" + index);
	    }  
	  Node<E> hold=getNode(index);
	  if(index>0){		
		  size--;
		  getNode(index-1).next=hold.next;
		  
	  }
	  else if(index==0){
		   head=hold.next;
	  }
	  return hold.data;
  }

  //EXERCISE: return a copy of the list 
public SingleLinkedList<E> copy() {

	  SingleLinkedList<E> copy = new SingleLinkedList<E>();
	      Node<E> t = head;
	      copy.head = new Node<>(getNode(0).data);
	      copy.head.next = t.next;
	  return copy;
  }
  
  //EXERCISE: reverse the list
  public void reverse() {
	  head = getNode(0);
	  Node<E> current = head;
	  while(current != null && current.next != null){
	      Node<E> temp = current.next;
	      current.next = temp.next;
	      temp.next = head;
	      head = temp;
	  }
	   
  }

  public static void main(String[] args){
    SingleLinkedList<Integer> l = new SingleLinkedList<>();
    for(int i=0; i<10; i++) l.add(i);
    for(int i=0; i<l.size(); i++) System.out.println(i);
    System.out.println(l);
    Integer item=9;
    l.set(1,item);
    l.remove(1);
    l.add(5,10);
    System.out.println(l);
    System.out.println(l.copy().toString());
    l.reverse();
    System.out.println(l.toString());
  }
  
}
