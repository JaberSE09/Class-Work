import java.util.Arrays;


public class KWArrayList<E> {
	 // Data Fields

    /** The default initial capacity */
    private static final int INITIAL_CAPACITY = 10;
    /** The underlying data array */
    private E[] theData;
    /** The current size */
    private int size = 0;
    /** The current capacity */
    private int capacity = 0;

    /**
     * Construct an empty KWArrayList with the default
     * initial capacity
     */
    public KWArrayList() {
        capacity = INITIAL_CAPACITY;
        theData = (E[]) new Object[capacity];
    }    
    /**
     * Add an entry to the data inserting it before the
     * item at the specified index.
     * @param index - The index of the time that the new
     *        value it to be inserted in front of.
     * @param theValue - The value to be inserted
     * @throws ArrayIndexOUtOfBoundsException if index is
     *         less than zero or greater than size
     */
    public boolean add(E anEntry) {
        if (size == capacity) {
            reallocate();
        }
        theData[size] = anEntry;
        size++;
        return true;
    }

    /**
     * Get a value in the array based on its index.
     * @param index - The index of the item desired
     * @return The contents of the array at that index
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return theData[index];
    }

    /**
     * Set the value in the array based on its index.
     * @param index - The index of the item desired
     * @param newValue - The new value to store at this position
     * @return The old value at this position
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E set(int index, E newValue) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E oldValue = theData[index];
        theData[index] = newValue;
        return oldValue;
    }

    /**
     * Remove an entry based on its index
     * @param index - The index of the entry to be removed
     * @return The value removed
     * @throws ArrayIndexOutOfBoundsException - if the index
     *         is negative or if it is greater than or equal to the
     *         current size
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = theData[index];
        for (int i = index + 1; i < size; i++) {
            theData[i - 1] = theData[i];
        }
        size--;
        return returnValue;
    }

    /**
     * Allocate a new array to hold the directory
     */
    private void reallocate() {
        capacity = 2 * capacity;
        theData = Arrays.copyOf(theData, capacity);
    }

    /**
     * Get the current size of the array
     * @return The current size of the array
     */
    public int size() {
        return size;
    }

    /**
     * Find the target, return the index in the array
     * where it is found. Return -1 if not found. 
     * @return The index of the target or -1 if not found.
     */
    public int indexOf(E target){
    	for (int i = 0; i < size; i++) {
			if(target.equals(theData[i])){
				return i;
}
		}
		return -1;

    }

    /**
     * Returns a copy of the list.
     */
    public KWArrayList<E> copy(){

    	KWArrayList<E> copy =new KWArrayList<E>();
    	for (int i = 0; i < size; i++) {
    	copy.add(theData[i]);
    	}
    	
    return copy;
    	
    }
  
    /**
     * Reverse the array.
     */
    public void reverse(){
    	for (int j = 0; j < size/2; j++) {
    	E temp = theData[j];
        theData[j] = theData[size - j - 1];
        theData[size - j - 1] = temp;
    }
    }
    /**
     * Remove duplicate elements from the array.
     */
    public void removeDuplicates(){
    	
    	   for (int i = 0; i < size; i++) {
    	        for (int j = 0; j < size; j++) {
    	        if ((theData[i].equals(theData[j])) & (i != j)) {
    	             remove(j);
    	        }    	           
    	       }
    	 }
    }
    /**
     * Return list of unique elements from this list.
     * If the array is [1,1,2,2,1], [1,2] is returend.
     */
    public KWArrayList<E> unique(){
    	 KWArrayList<E> holder = new KWArrayList<E>();
    	
    	 for (int i = 0; i < size; i++) {
    		 for (int k = 0; k < theData.length; k++) {
			if(theData[i].equals(theData[k]) & !theData[i].equals(theData[i+1])){
				holder.add(theData[i]);
				break;
			}
    		 }
		}
    	
		
    	 
		return holder;
    }

    public String toString(){
    	String s="[";
    	for (int i = 0; i < size; i++) {
			if(i!=size-1)s+=theData[i]+",";
			if(i==size-1)s+=theData[i];
		
    	}
    	s+="]";
    	return s;
    }
    public static void main(String[] args){
      KWArrayList<Integer> list = new KWArrayList<Integer>();
      list.add(1); list.add(1); list.add(2);
      list.add(3); list.add(3); list.add(3); list.add(4);
      System.out.println(list);
      System.out.println(list.indexOf(1));
      System.out.println(list.indexOf(5));
      System.out.println(list.indexOf(4));
      KWArrayList<Integer> copy = list.copy();
      System.out.println(copy);
      copy.reverse();
      System.out.println(copy);
      copy.removeDuplicates();
      System.out.println(copy);
      System.out.println(list.unique()); 
    }
    
    
}
