package TP2;

public class UtilisateurService {
    private UtilisateurApi utilisateurApi;

    public UtilisateurService(UtilisateurApi utilisateurApi) {
        this.utilisateurApi = utilisateurApi;
    }

    public boolean creerUtilisateur(Utilisateur utilisateur) {
        return utilisateurApi.creerUtilisateur(utilisateur);
    }
}
