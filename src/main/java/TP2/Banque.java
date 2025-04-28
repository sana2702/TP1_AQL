package TP2;

public interface Banque {
    void crediter(int somme);
    boolean estSolvable();
    void debiter(int somme);
}
