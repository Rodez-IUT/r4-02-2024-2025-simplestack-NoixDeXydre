/*
 * SimpleStackTest.java             29 january 2025
 * IUT de Rodez, no rights reserved
 */

package org.example;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test behaviour of a SimpleStack")
class SimpleStackTest {

    @Test
    @DisplayName("Test the state of a newly created slack")
    public void testCreateEmptyStack() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        // Then… (oracle)
        assertTrue(stack.isEmpty(), "A new stack must be empty");
        assertEquals( 0, stack.getSize(), "A new stack has no element");


    }

    @Test
    @DisplayName("Test the state of a stack with one item")
    public void testCreateStackNotEmpty() { // Test case

        // When a freshly stack is created
        Stack stack = new SimpleStack();

        stack.push(new SimpleItem());
        assertTrue(!stack.isEmpty(), "A stack with one Item shouldn't be empty");
        assertEquals( 1, stack.getSize(), "The stack should have a size of 1");
    }

    @Test
    @DisplayName("Test the peek of a stack with no elements")
    public void testPeekEmptyStack() throws EmptyStackException {

        Stack stack = new SimpleStack();

        // When we "peek" the stack, should throws an EmptyStackException.
        assertThrows(EmptyStackException.class, ()->stack.peek(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::peek, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test the push of items")
    public void testPush() throws EmptyStackException {

        // Given an empty stack and an item
        Stack stack = new SimpleStack();
        Item item = new SimpleItem();

        // When the item is pushed in the stack
        stack.push(item);

        // Then…
        assertFalse(stack.isEmpty(), "The stack must not be empty");
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");
        assertSame(item, stack.peek(),"The pushed item must be is on top of the stack");

        // Given a new item to add
        Item item2 = new SimpleItem();

        // When we add the new item
        stack.push(item2);

        // then...
        assertFalse(stack.isEmpty(), "The stack must be not empty");
        assertEquals(2, stack.getSize(),"The stack must constain 2 items");
        assertSame( item2, stack.peek(),"The pushed item must be on top of the stack");
    }

    @Test
    @DisplayName("Test limit when trying to pop an empty stack")
    public void testPopOnEmptyStack() throws EmptyStackException {

        // Given an empty stack
        Stack stack = new SimpleStack();

        // When we "pop" the stack, should throws an EmptyStackException.
        assertThrows(EmptyStackException.class, ()->stack.pop(), "EmptyStackException not thrown");
        assertThrows(EmptyStackException.class, stack::pop, "EmptyStackException not thrown");
    }

    @Test
    @DisplayName("Test the stack after popping until emptiness ")
    public void testEmptyStackAfterSeveralPop() throws EmptyStackException {

        // Given an empty stack
        Stack stack = new SimpleStack();
        // We now test with the removal of two items
        SimpleItem item1 = new SimpleItem();
        SimpleItem item2 = new SimpleItem();

        stack.push(item1);
        stack.push(item2);

        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty(), "Stack must be empty after all the items removed");
    }

    @Test
    @DisplayName("Test returned value of pop")
    public void testReturnValuePop() throws EmptyStackException {

        // Given an empty stack
        Stack stack = new SimpleStack();
        // We now test with the removal of two items
        SimpleItem item1 = new SimpleItem();

        stack.push(item1);

        assertEquals(item1, stack.pop(), "The popped item must be returned");
    }

    @Test
    @DisplayName("Test of sizes of the stack after popping")
    public void testSizeShifting() throws EmptyStackException {

        // Given an empty stack
        Stack stack = new SimpleStack();

        SimpleItem item1 = new SimpleItem();
        SimpleItem item2 = new SimpleItem();

        stack.push(item1);
        stack.push(item2);

        stack.pop();
        assertEquals(1, stack.getSize(),"The stack must constain 1 item");

        stack.pop();
        assertEquals(0, stack.getSize(),"The stack must constain 0 item");
    }
}
