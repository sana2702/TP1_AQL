package TP2.tests;
import static org.mockito.Mockito.*;

import TP2.Calculatrice;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatriceTest {

    @Test
    void testAdditionner() {

        Calculatrice calculatrice = mock(Calculatrice.class);
        when(calculatrice.additionner(2, 3)).thenReturn(5);
        int resultat = calculatrice.additionner(2, 3);
        assertEquals(5, resultat);
        verify(calculatrice).additionner(2, 3);
    }

}

