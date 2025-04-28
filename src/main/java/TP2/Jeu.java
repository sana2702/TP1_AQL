package TP2;

public class Jeu {
    private Banque banque;
    private boolean ouvert = true;

    public Jeu(Banque banque) {
        this.banque = banque;
    }

    public void jouer(Joueur joueur, De de1, De de2) throws JeuFermeException, DebitImpossibleException {
        if (!ouvert) {
            throw new JeuFermeException("Le jeu est fermé.");
        }

        int mise = joueur.mise();

        try {
            joueur.debiter(mise); // Le joueur essaie de payer
        } catch (DebitImpossibleException e) {
            // Si le joueur ne peut pas payer, le jeu s'arrête là
            throw e;
        }

        banque.crediter(mise); // La banque encaisse la mise

        int somme = de1.lancer() + de2.lancer();
        if (somme != 7) {
            // Le joueur perd, fin du jeu
            return;
        }

        // Le joueur gagne
        int gain = 2 * mise;
        banque.debiter(gain); // La banque paie le gain
        joueur.crediter(gain);

        if (!banque.estSolvable()) {
            fermer();
        }
    }

    public void fermer() {
        ouvert = false;
    }

    public boolean estOuvert() {
        return ouvert;
    }
}
