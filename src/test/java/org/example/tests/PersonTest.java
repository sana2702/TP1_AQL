package org.example.tests;

import org.example.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class PersonTest {
    @Test
    public void testFullname() {
        Person p = new Person("a", "b", 50);
        Assertions.assertEquals("a b", p.getFullName());
    }

    @Test
    public void testAgeAdult() {
        Person p = new Person("a", "b", 50);
        Assertions.assertTrue(p.isAdult());
    }

    @Test
    public void testAgeNotAdult() {
        Person p = new Person("a", "b", 4);
        Assertions.assertFalse(p.isAdult());
    }

    @Test
    public void testAge18Exactly() {
        Person p = new Person("a", "b", 18);
        Assertions.assertTrue(p.isAdult());
    }
}
