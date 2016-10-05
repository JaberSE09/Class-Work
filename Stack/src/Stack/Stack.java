/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import com.sun.org.apache.bcel.internal.ExceptionConstants;
import java.util.Arrays;
import java.util.EmptyStackException;

/**
 *
 * @author Sajid Jaber
 * @param <E>
 */
public class Stack<E> {
   public E array[];
   private int size;
   public int capacity;
    public Stack() {
        this.size = 0;
        capacity=20;
        array=(E[]) new Object[capacity];
    }
    public Stack(int capacity1){
        this.size = 0;
        capacity=capacity1;
        array=(E[]) new Object[capacity];
    }
    public E pop(){
        if(empty()){
        throw new EmptyStackException();
        }
      size--;
      E result = array[size];
      array[size] = null; 
       return result;
        }
    
    public E push(E item) {
        if(size==capacity){
            throw new FullStackException();
        }
        
        array[size]=item;
        size++;
        return item;
                
    }
    public E peek(){
        if(empty()){
        throw new EmptyStackException();
        }
      
      return array[size-1];
    }
    
    public int size(){
        return size;
    }
    public int capacity(){
        return capacity;
    }
    public void clear(){
        Arrays.fill(array, null);
    }
    public boolean empty(){
        return size == 0==true ;
    }
    public boolean equal(Stack stack){
            return Arrays.equals(array, stack.array); 
    }

    private static class FullStackException extends RuntimeException{

        public FullStackException()  {
            super("Error reached max");
        }
    }
}
