package tp1;

import TP1.Palindrome;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

    @Test
    void shouldReturnTrue_ForPalindromeWord() {
        // Ce test va échouer à cause de l'erreur dans la méthode
        assertTrue(Palindrome.isPalindrome("radar"));
    }

    @Test
    void shouldReturnTrue_ForPalindromeWithSpaces() {
        // Ce test va aussi échouer à cause de l'incrémentation inversée
        assertTrue(Palindrome.isPalindrome("nurses run"));
    }

    @Test
    void shouldReturnTrue_ForPalindromeWithMixedCase() {
        // Ce test va échouer car la méthode ne compare pas bien
        assertTrue(Palindrome.isPalindrome("Madam"));
    }

    @Test
    void shouldReturnFalse_ForNonPalindrome() {
        // Même les faux positifs peuvent échouer ici
        assertFalse(Palindrome.isPalindrome("hello"));
    }

    @Test
    void shouldReturnTrue_ForEmptyString() {
        // Devrait passer : 0 caractère → palindrome par défaut
        assertTrue(Palindrome.isPalindrome(""));
    }

    @Test
    void shouldReturnTrue_ForSingleCharacter() {
        // Devrait passer : un seul caractère est toujours un palindrome
        assertTrue(Palindrome.isPalindrome("a"));
    }

    @Test
    void shouldThrowException_WhenInputIsNull() {
        assertThrows(NullPointerException.class, () -> Palindrome.isPalindrome(null));
    }

    @Test
    void testFailure_DetectWrongLoopLogic() {
        // Ce test montre bien que la méthode ne fonctionne pas comme prévu
        assertFalse(Palindrome.isPalindrome("abba")); // Devrait être true, mais ce sera false avec la logique actuelle
    }
}