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
public class StackTest {
    
    public StackTest() {
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

    @Test
    public void testStack() {
        Stack stack;
        stack = new Stack();
    }   
    @Test
    public void testStack2(){
        Stack stack2=new Stack(11);
    }
    @Test
    public void  testPop(){
        Stack stack=new Stack();
        stack.array[0]="test";
        stack.pop();
    }
      @Test
    public void  testPop2(){
        Stack stack=new Stack();
        stack.array[0]="test";
        stack.array[1]="here";
        stack.pop();
    }
    @Test
    public void testPush(){
        Stack stack=new Stack();
        stack.push("here");
    }
       @Test
    public void testPush2(){
        Stack stack=new Stack();
        stack.push("here");
        stack.push(1);
    } 
    
}
