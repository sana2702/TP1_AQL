package TP3.tests;
import static org.mockito.Mockito.*;

import TP2.Calculatrice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatriceTest {

    @Test
    void testAdditionner() {
        // Création du mock
        Calculatrice calculatrice = mock(Calculatrice.class);

        // Définition du comportement attendu
        when(calculatrice.additionner(2, 3)).thenReturn(5);

        // Appel de la méthode à tester
        int resultat = calculatrice.additionner(2, 3);

        // Vérification du résultat
        assertEquals(5, resultat);

        // Vérification de l'appel avec les bons arguments
        verify(calculatrice).additionner(2, 3);
    }
}

