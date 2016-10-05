
import java.util.*;

class DoubleLinkedList<E> implements Iterable<E> {

private static class Node<E> {
private E data;
private Node<E> next;
private Node<E> prev;
private Node(E item) { data = item; }
}

private Node<E> head; 
private Node<E> tail;

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
if (t != null) t.prev = head;
} else { //adding anywhere other than front
Node<E> left = getNode(index - 1);
Node<E> node = new Node(item);
Node<E> right = left.next;
left.next = node;
node.next = right;
if (right != null) right.prev = node;
node.prev = left;
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
throw new UnsupportedOperationException("set");
}

//EXERCISE: remove element at index, return it.
public E remove(int index) {
throw new UnsupportedOperationException("set");
}

//EXERCISE: return a copy of the list 
public DoubleLinkedList copy() {
throw new UnsupportedOperationException("remove");
}

//EXERCISE: reverse the list
public void reverse() {
throw new UnsupportedOperationException("remove");
}

@Override
public ListIterator iterator(){
return new DoubleLinkedListIterator();
}

private class DoubleLinkedListIterator implements ListIterator<E>{
private Node<E> nextItem = head;
private Node<E> lastItemReturned;
private int index;

@Override
/**
* Add an item between the item that will be returned by next
* and item that will be returned by previous.
* There are three cases.
* 1. Add to an empty list
* 2. Add at the front.
* 3. Add at the tail.
* 4. Add in the middle.
*/
public void add(E e){

if (head == null){ //case 1
head = new Node<>(e);
tail = head;
} else if (nextItem == head){ //case 2
Node<E> n = new Node<>(e);
n.next = nextItem;
nextItem.prev = n;
head = n;
} else if (nextItem == null){ //case 3
Node<E> n = new Node<>(e);
tail.next = n;
n.prev = tail;
tail = n;
} else { //case 4
Node<E> n = new Node<>(e);
n.prev = nextItem.prev;
nextItem.prev.next = n;
n.next = nextItem;
nextItem.prev = n;
}
size++;
index++;
lastItemReturned = null;
}

@Override
public boolean hasNext(){
return index < size;
}

@Override
public E next(){
if (!hasNext()) throw new NoSuchElementException();
lastItemReturned = nextItem;
nextItem = nextItem.next;
index++;
return lastItemReturned.data;
}

@Override
public boolean hasPrevious(){
return index > 0;
}

@Override
public int nextIndex(){
return index == size-1 ? size : index+1;
}

@Override
public E previous(){
if (!hasPrevious()) throw new NoSuchElementException();

if (nextItem == null) nextItem = tail;
nextItem = lastItemReturned ;
E data = lastItemReturned.data;
lastItemReturned = lastItemReturned.prev;
index--;
return data;

}

@Override
public int previousIndex(){
return index == 0 ? -1 : index -1;
}

@Override
public void remove(){
if (lastItemReturned == null) throw new IllegalStateException();
if (lastItemReturned == head) head = lastItemReturned.next;
else if (lastItemReturned == tail) {
tail = lastItemReturned.prev;
tail.next = null;
} else {
Node<E> tmp = lastItemReturned;
lastItemReturned.next.prev = tmp.prev;
tmp.prev.next = tmp.next;
lastItemReturned = null;
}
size--;
index--;
}

@Override
public void set(E e){
if (lastItemReturned == null) throw new IllegalStateException();
lastItemReturned.data = e;
}
}

public static void main(String[] args){
DoubleLinkedList<Integer> l = new DoubleLinkedList<>();
for(int i=0; i<10; i++) l.add(i);
for(int i=0; i<l.size(); i++) System.out.println(l.get(i));

ListIterator i = l.iterator();
System.out.println("Forward");
while(i.hasNext()){
System.out.println(i.next());
}

System.out.println("Backward");
while(i.hasPrevious()){
System.out.println(i.previous());
}

i.add(200);
i.add(300);
i.next();
i.next();
i.add(500);
while(i.hasNext()){
i.next();
} 
//i.add(600);

System.out.println(l);
//i.add(5,10);
System.out.println(l);
}

}
