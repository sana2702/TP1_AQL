package TP0.tests;

import TP0.RomanNumeral;
import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;



public class RomanNumeralTest {



    @Test

    public void singleNumber() {

        RomanNumeral roman = new RomanNumeral();

        int result = roman.convert("I");



        Assertions.assertEquals(1, result);

    }
    @Test

    public void numberWithManyDigits() {

        RomanNumeral roman = new RomanNumeral();

        int result = roman.convert("VIII");

        Assertions.assertEquals(8, result);

    }



}
