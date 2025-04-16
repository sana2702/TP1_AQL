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
        UtilisateurApi utilisateurApiMock = mock(UtilisateurApi.class);
        Utilisateur utilisateur = new Utilisateur("John Doe");
        when(utilisateurApiMock.creerUtilisateur(utilisateur)).thenReturn(true);
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurApiMock);
        boolean resultat = utilisateurService.creerUtilisateur(utilisateur);
        assertTrue(resultat);
        verify(utilisateurApiMock).creerUtilisateur(utilisateur);
    }
    @Test
    void testCreerUtilisateurAvecException() {

        UtilisateurApi utilisateurApiMock = mock(UtilisateurApi.class);
        when(utilisateurApiMock.creerUtilisateur(any(Utilisateur.class))).thenThrow(new RuntimeException("Erreur serveur"));
        UtilisateurService utilisateurService = new UtilisateurService(utilisateurApiMock);
        assertThrows(RuntimeException.class, () -> utilisateurService.creerUtilisateur(new Utilisateur("John")));
    }

}

