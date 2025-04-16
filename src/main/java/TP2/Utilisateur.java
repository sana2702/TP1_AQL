package TP2;

public class Utilisateur {
    private String nom;

    // Constructeur
    public Utilisateur(String nom) {
        this.nom = nom;
    }

    // Getter et Setter pour le nom
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // Méthode toString (facultatif, juste pour afficher l'utilisateur facilement)
    @Override
    public String toString() {
        return "Utilisateur{" +
                "nom='" + nom + '\'' +
                '}';
    }
}
