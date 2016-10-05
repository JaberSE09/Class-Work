/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stack;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Sajid Jaber
 */
public class StackIT {
    
    public StackIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop() {
        System.out.println("pop");
        Stack instance = new Stack();
        Object expResult = "testing";
        instance.push(expResult);
        Object result=instance.pop();
        assertEquals(expResult, result);
    }
       /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop2() {
        System.out.println("pop");
        Stack instance = new Stack();
        Object expResult = "1";
        instance.push("one");
        instance.push("1");
        Object result = instance.pop();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush() throws Exception {
        System.out.println("push");
        Object item = 1;
        Stack instance = new Stack();
        Object expResult = 1;
        Object result = instance.push(item);
        assertEquals(expResult, result);
    }

    /**
     * Test of peek method, of class Stack.
     */
    @Test
    public void testPeek() {
        System.out.println("peek");
        Stack instance = new Stack();
        instance.push("here");
        Object expResult = "here";
        Object result = instance.peek();
        assertEquals(expResult, result);
    }

    /**
     * Test of size method, of class Stack.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        Stack instance = new Stack();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of capacity method, of class Stack.
     */
    @Test
    public void testCapacity() {
        System.out.println("capacity");
        Stack instance = new Stack();
        int expResult = 20;
        int result = instance.capacity();
        assertEquals(expResult, result);
    }

    /**
     * Test of clear method, of class Stack.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        Stack instance = new Stack();
        instance.clear();
    }

    /**
     * Test of empty method, of class Stack.
     */
    @Test
    public void testEmpty() {
        System.out.println("empty");
        Stack instance = new Stack();
        boolean expResult = true;
        boolean result = instance.empty();
        assertEquals(expResult, result);
    }

    /**
     * Test of equal method, of class Stack.
     */
    @Test
    public void testEqual() {
        System.out.println("equal");
        Stack stack = new Stack();
        stack.push("hi");
        Stack instance = new Stack();
        instance.push("hi");
        boolean expResult = true;
        boolean result = instance.equal(stack);
        assertEquals(expResult, result);
    }
    
}
