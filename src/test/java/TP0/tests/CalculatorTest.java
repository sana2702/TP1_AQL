package TP0.tests;
import TP0.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class CalculatorTest {
        @Test
        void addShouldReturnTheSumOfTwoNumbers() {
            // Arrange
            Calculator calculator = new Calculator();
            int a = 2;
            int b = 3;

            // Act
            int result = calculator.add(a, b);

            // Assert
            assertEquals(5, result);
        }

        @Test
        void subtractShouldReturnTheDifferenceOfTwoNumbers() {
            Calculator calculator = new Calculator();
            assertEquals(2, calculator.subtract(5, 3));
        }
    }

