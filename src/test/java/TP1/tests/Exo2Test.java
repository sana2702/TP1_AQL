package TP1.tests;

import TP1.Exo2;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class Exo2Test {

    @Test
    public void testIsAnagram_Anagrams() {
        // Test des anagrammes valides
        assertAll(
                () -> assertTrue(Exo2.isAnagram("chien", "niche"), "Test simple avec des mots courants"),
                () -> assertTrue(Exo2.isAnagram("ecoute", "coute"), "Test sans espace et casse ignorée"),
                () -> assertTrue(Exo2.isAnagram("abc", "cba"), "Test avec permutation de lettres"),
                () -> assertTrue(Exo2.isAnagram("Listen", "Silent"), "Casse ignorée dans un exemple classique"),
                () -> assertTrue(Exo2.isAnagram("conversation", "voices rant on"), "Test avec des mots longs et espacés")
        );
    }

    @Test
    public void testIsAnagram_NotAnagrams() {
        // Test des cas où les chaînes ne sont pas des anagrammes
        assertAll(
                () -> assertFalse(Exo2.isAnagram("chien", "chat"), "Longueurs différentes, pas d'anagramme"),
                () -> assertFalse(Exo2.isAnagram("hello", "world"), "Mots sans lettres communes"),
                () -> assertFalse(Exo2.isAnagram("abc", "def"), "Aucune lettre en commun"),
                () -> assertFalse(Exo2.isAnagram("apple", "applz"), "Un caractère différent suffit à rompre l'anagramme")
        );
    }

    @Test
    public void testIsAnagram_EmptyStrings() {
        // Test des chaînes vides
        assertTrue(Exo2.isAnagram("", ""), "Deux chaînes vides doivent être considérées comme des anagrammes");
    }

    @Test
    public void testIsAnagram_NullInput() {
        // Test avec des chaînes nulles
        assertThrows(NullPointerException.class, () -> Exo2.isAnagram(null, "niche"), "NullPointerException attendu avec premier argument null");
        assertThrows(NullPointerException.class, () -> Exo2.isAnagram("chien", null), "NullPointerException attendu avec second argument null");
        assertThrows(NullPointerException.class, () -> Exo2.isAnagram(null, null), "NullPointerException attendu avec les deux arguments null");
    }

    @Test
    public void testIsAnagram_SpacesAndCaseIgnored() {
        // Test avec des espaces et des différences de casse ignorées
        assertAll(
                () -> assertTrue(Exo2.isAnagram("Listen ", " Silent"), "Les espaces et la casse doivent être ignorés"),
                () -> assertTrue(Exo2.isAnagram("  C O D E", " dE Co"), "Espaces et casse ignorés avec des mots séparés"),
                () -> assertTrue(Exo2.isAnagram(" Tom Marvolo Riddle", "I am Lord Voldemort"), "Phrase classique d'anagramme avec espaces et casse ignorée")
        );
    }

    @Test
    public void testIsAnagram_SpecialCharacters() {
        // Test avec des caractères spéciaux, chiffres et ponctuation
        assertAll(
                () -> assertTrue(Exo2.isAnagram("1234@abc!", "a1b2c3!4"), "Anagramme avec chiffres et symboles"),
                () -> assertTrue(Exo2.isAnagram("hello!!", "he!!ol"), "Gestion correcte des symboles"),
                () -> assertFalse(Exo2.isAnagram("abc123", "123xyz"), "Les caractères supplémentaires doivent affecter le résultat")
        );
    }

    @Test
    public void testIsAnagram_SingleCharacterStrings() {
        // Test avec des chaînes d'un seul caractère
        assertAll(
                () -> assertTrue(Exo2.isAnagram("a", "a"), "Deux lettres identiques doivent être des anagrammes"),
                () -> assertFalse(Exo2.isAnagram("a", "b"), "Lettres différentes ne sont pas des anagrammes")
        );
    }

    @Test
    public void testIsAnagram_LongStrings() {
        // Test avec des chaînes longues
        String longString1 = "a".repeat(1000) + "b".repeat(1000);
        String longString2 = "b".repeat(1000) + "a".repeat(1000);
        assertTrue(Exo2.isAnagram(longString1, longString2), "Les chaînes longues avec mêmes caractères doivent être des anagrammes");
    }

    @Test
    public void testIsAnagram_IdenticalStrings() {
        // Cas avec des chaînes identiques
        assertTrue(Exo2.isAnagram("identical", "identical"), "Les chaînes identiques sont des anagrammes");
    }

    @Test
    public void testIsAnagram_IgnoreAccents() {
        // Vérification que les accents sont correctement ignorés
        assertTrue(Exo2.isAnagram("café", "face"), "Les accents doivent être ignorés dans les anagrammes");
    }

    @Test
    public void testIsAnagram_PerformanceWithLargeInput() {
        // Test avec de très grandes chaînes pour évaluer la performance
        String largeStr1 = "a".repeat(100000) + "b".repeat(100000);
        String largeStr2 = "b".repeat(100000) + "a".repeat(100000);
        assertTrue(Exo2.isAnagram(largeStr1, largeStr2), "Les grandes chaînes identiques doivent être des anagrammes");
    }

    @Test
    public void testIsAnagram_MultipleWords() {
        // Test avec plusieurs mots et les espaces doivent être ignorés
        assertTrue(Exo2.isAnagram("i am lord voldemort", "tom marvolo riddle"), "Les espaces dans des phrases longues doivent être ignorés");
    }
}
