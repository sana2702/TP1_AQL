package TP3.tests;

import TP2.*;
import TP2.JeuFermeException;
import TP2.DebitImpossibleException;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class JeuTest {

    private Banque banqueMock;
    private Joueur joueurMock;
    private De de1Mock;
    private De de2Mock;
    private Jeu jeu;

    @Before
    public void setUp() {
        banqueMock = mock(Banque.class);
        joueurMock = mock(Joueur.class);
        de1Mock = mock(De.class);
        de2Mock = mock(De.class);
        jeu = new Jeu(banqueMock);
    }

    // Test 1: Le jeu est fermé et on essaie de jouer
    @Test(expected = JeuFermeException.class)
    public void testJeuFerme() throws JeuFermeException, DebitImpossibleException {
        jeu.fermer(); // Fermer le jeu avant de jouer
        jeu.jouer(joueurMock, de1Mock, de2Mock);
    }

    // Test 2: Le joueur ne peut pas payer la mise (DebitImpossibleException)
    @Test(expected = DebitImpossibleException.class)
    public void testDebitImpossible() throws JeuFermeException, DebitImpossibleException {
        when(joueurMock.mise()).thenReturn(10);
        doThrow(DebitImpossibleException.class).when(joueurMock).debiter(10); // Utilisation de doThrow pour les méthodes void
        jeu.jouer(joueurMock, de1Mock, de2Mock);
    }

    // Test 3: Le joueur perd (le lancer des dés donne une somme différente de 7)
    @Test
    public void testPerte() throws JeuFermeException, DebitImpossibleException, JeuFermeException {
        when(joueurMock.mise()).thenReturn(10);
        doNothing().when(joueurMock).debiter(10); // On suppose que le débit est ok
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4); // Somme = 7, donc pas un cas de perte

        jeu.jouer(joueurMock, de1Mock, de2Mock); // Le joueur ne gagne pas, donc le jeu continue.
    }

    // Test 4: Le joueur gagne (lancer des dés donne la somme égale à 7)
    @Test
    public void testGain() throws JeuFermeException, DebitImpossibleException {
        when(joueurMock.mise()).thenReturn(10);
        doNothing().when(joueurMock).debiter(10); // On suppose que le débit est ok
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4); // Somme = 7

        // On vérifie les actions
        jeu.jouer(joueurMock, de1Mock, de2Mock);

        verify(banqueMock).debiter(20); // La banque doit débiter le gain du joueur
        verify(joueurMock).crediter(20); // Le joueur doit être crédité du gain
    }

    // Test 5: La banque devient insolvable après le paiement du gain
    @Test
    public void testBanqueInsolvable() throws JeuFermeException, DebitImpossibleException {
        when(joueurMock.mise()).thenReturn(10);
        doNothing().when(joueurMock).debiter(10); // On suppose que le débit est ok
        when(de1Mock.lancer()).thenReturn(3);
        when(de2Mock.lancer()).thenReturn(4); // Somme = 7

        // Simuler une banque solvable, puis devenir insolvable après avoir débité le gain
        when(banqueMock.estSolvable()).thenReturn(true).thenReturn(false);

        jeu.jouer(joueurMock, de1Mock, de2Mock);

        verify(banqueMock).debiter(20); // La banque doit payer le gain
        verify(joueurMock).crediter(20); // Le joueur est crédité du gain

        // On s'assure que le jeu est fermé lorsque la banque devient insolvable
        assert !jeu.estOuvert();
    }
}
