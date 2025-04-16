package TP0.tests;

import TP0.Prime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrimeTest {

    @Test
    public void testNegativeNumbers() {
        Assertions.assertFalse(Prime.isPrime(-1));
        assertFalse(Prime.isPrime(-10));
    }

    @Test
    public void testZeroAndOne() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
    }

    @Test
    public void testSmallPrimes() {
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(3));
        assertTrue(Prime.isPrime(5));
        assertTrue(Prime.isPrime(7));
    }

    @Test
    public void testSmallNonPrimes() {
        assertFalse(Prime.isPrime(4));
        assertFalse(Prime.isPrime(6));
        assertFalse(Prime.isPrime(8));
        assertFalse(Prime.isPrime(9));
    }

    @Test
    public void testLargePrime() {
        assertTrue(Prime.isPrime(7919)); // Un grand nombre premier
    }

    @Test
    public void testLargeNonPrime() {
        assertFalse(Prime.isPrime(8000)); // Un grand nombre non premier
    }
}
