package TP3.tests;

import static org.mockito.Mockito.*;

import TP2.Utilisateur;
import TP2.UtilisateurApi;
import TP2.UtilisateurService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UtilisateurServiceTest {

    @Test
    void testCreerUtilisateur() {
        // Création du mock de l'API
        UtilisateurApi utilisateurApiMock = mock(UtilisateurApi.class);

        // Création d'un utilisateur fictif
        Utilisateur utilisateur = new Utilisateur("John Doe");

        // Définir le comportement du mock
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);

        // Création du service avec le mock
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurApiMock);

        // Appel de la méthode à tester
        boolean resultat = utilisateurService.creerUtilisateur(utilisateur);

        // Vérification du résultat
        assertTrue(resultat);

        // Vérification que la méthode a bien été appelée sur le mock
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
}

