import java.util.ArrayList;
import java.util.List;

public class Ville {

    private int maxHabitants;
    private String nomVille;
    private List<Personne> habitants;

    public Ville(int maxHabitants, String nomVille) {
        this.maxHabitants = maxHabitants;
        this.nomVille = nomVille;
        habitants = new ArrayList<>();
    }

    public void addHabitant(Personne h) {
        if (habitants.size() < maxHabitants) {
            habitants.add(h);
        } else {
            System.out.println("The city is full.");
        }
    }

    public List<Personne> listHabitants() {
        return habitants;
    }

    public int getNbHabitants() {
        return habitants.size();
    }

    public boolean existe(Personne p) {
        return habitants.contains(p);
    }

    public String getNomVille() {
        return nomVille;
    }
}
