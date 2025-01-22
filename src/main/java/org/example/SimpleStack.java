package org.example;

import java.util.ArrayList;

public class SimpleStack implements Stack {

    /** Total size of the stack */
    private int stackSize;

    /** Array of items in the stack */
    private ArrayList<Item> items;

    /**
     * Initialize a new empty stack
     */
    public SimpleStack() {
        stackSize = 0;
        items = new ArrayList<>();
    }

    /**
     * Tests if this stack is empty
     */
    @Override
    public boolean isEmpty() {
        return stackSize == 0;
    }

    /**
     * Returns the number of items in this stack.
     */
    @Override
    public int getSize() {
        return stackSize;
    }

    /**
     * Pushes an item onto the top of this stack.
     * null item is allowed.
     *
     * @param item an item of the stack
     */
    @Override
    public void push(Item item) {
        items.add(item);
        stackSize++;
    }

    /**
     * Looks at the object at the top of this stack without removing it from the stack.
     */
    @Override
    public Item peek() throws EmptyStackException {
        return items.get(items.size() - 1);
    }

    /**
     * Removes the object at the top of this stack and returns
     * that object as the value of this function.
     *
     * @throws EmptyStackException if this stack is empty.
     */
    @Override
    public Item pop() throws EmptyStackException {

        if (stackSize == 0) {
            throw new EmptyStackException();
        }

        stackSize--;
        return items.remove(items.size() - 1);
    }
}
