package TP0.tests;

import TP0.Stack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    @Test
    void newStackShouldBeEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }

    @Test
    void pushShouldAddElement() {
        Stack stack = new Stack();
        stack.push(10);
        assertEquals(10, stack.peek());
    }

    @Test
    void popShouldRemoveAndReturnLastElement() {
        Stack stack = new Stack();
        stack.push(57);
        assertEquals(57, stack.pop());
        assertTrue(stack.isEmpty());
    }
}

