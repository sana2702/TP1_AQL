package org.example.tests;


import org.example.Matrix;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatrixTest {

    @Test
    public void testAddValid() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);
        m1.set(0, 0, 1); m2.set(0, 0, 2);
        m1.set(1, 1, 3); m2.set(1, 1, 4);
        m1.add(m2);
        assertEquals(3, m1.get(0, 0));
        assertEquals(7, m1.get(1, 1));
    }

    @Test
    public void testAddInvalidSize() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(3);
        assertThrows(IllegalArgumentException.class, () -> m1.add(m2));
    }

    @Test
    public void testMultiplyValid() {
        Matrix m1 = new Matrix(2);
        Matrix m2 = new Matrix(2);
        m1.set(0, 0, 1); m1.set(0, 1, 2);
        m1.set(1, 0, 3); m1.set(1, 1, 4);
        m2.set(0, 0, 2); m2.set(0, 1, 0);
        m2.set(1, 0, 1); m2.set(1, 1, 2);
        m1.multiply(m2);
        assertEquals(4, m1.get(0, 0));
        assertEquals(4, m1.get(0, 1));
        assertEquals(10, m1.get(1, 0));
        assertEquals(8, m1.get(1, 1));
    }

    @Test
    public void testTranspose() {
        Matrix m = new Matrix(2);
        m.set(0, 1, 5);
        m.set(1, 0, 3);
        m.transpose();
        assertEquals(5, m.get(1, 0));
        assertEquals(3, m.get(0, 1));
    }

    @Test
    public void testToString() {
        Matrix m = new Matrix(2);
        m.set(0, 0, 1);
        m.set(0, 1, 2);
        m.set(1, 0, 3);
        m.set(1, 1, 4);
        String expected = "[1, 2]\n[3, 4]\n";
        assertEquals(expected, m.toString());
    }

    @Test
    public void testAddNullMatrix() {
        Matrix m = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m.add(null));
    }

    @Test
    public void testMultiplyNullMatrix() {
        Matrix m = new Matrix(2);
        assertThrows(NullPointerException.class, () -> m.multiply(null));
    }
}

