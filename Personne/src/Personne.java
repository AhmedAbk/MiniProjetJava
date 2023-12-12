import java.util.ArrayList;
import java.util.List;

public class Personne {

    private String nom;
    private String prenom;
    private int age;
    private String genre;
    private Personne mere;
    private Personne pere;

    public Personne(String nom, String prenom, int age, String genre) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.genre = genre;
        this.mere = null;
        this.pere = null;
    }

    public Personne(String nom, String prenom, int age, String genre, Personne pere, Personne mere) {
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.genre = genre;
        this.mere = mere;
        this.pere = pere;
    }

    public Personne() {
        this.nom = "";
        this.prenom = "";
        this.age = 0;
        this.genre = "";
        this.mere = null;
        this.pere = null;
    }

    public void setMere(Personne mere) {
        this.mere = mere;
    }

    public void setPere(Personne pere) {
        this.pere = pere;
    }

    public boolean estEgal(Personne p) {
        return this.nom.equals(p.nom) && this.prenom.equals(p.prenom) && this.age == p.age && this.genre.equals(p.genre);
    }

    public static boolean estEgal(Personne p1, Personne p2) {
        return p1.estEgal(p2);
    }

    public boolean aMemePere(Personne p) {
        return this.pere != null && p.pere != null && this.pere.estEgal(p.pere);
    }

    public boolean aMemeMere(Personne p) {
        return this.mere != null && p.mere != null && this.mere.estEgal(p.mere);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        if (this.pere != null) {
            result.append("Lien établi entre ").append(this.pere.prenom).append(" ").append(this.pere.nom)
                    .append(" et ").append(this.prenom).append(" ").append(this.nom).append("\n");
        }
        if (this.mere != null) {
            result.append("Lien établi entre ").append(this.mere.prenom).append(" ").append(this.mere.nom)
                    .append(" et ").append(this.prenom).append(" ").append(this.nom).append("\n");
        }

        result.append(this.prenom).append(" ").append(this.nom).append(" ").append(this.age).append(" ans").append("\n");

        if (this.pere != null) {
            result.append("Père: ").append(this.pere.prenom).append(" ").append(this.pere.nom).append(" ").append(this.pere.age)
                    .append(" ans").append(" Mère: ").append(this.mere != null ? this.mere.prenom + " " + this.mere.nom : "")
                    .append("\n");
        }

        return result.toString();
    }

    public void afficheArbre(int nbg) {
        System.out.println("Arbre généalogique pour " + this.prenom + " " + this.nom + ":");
        afficheArbreGenealogique(this, 0, nbg);
    }

    private void afficheArbreGenealogique(Personne personne, int profondeur, int profondeurMax) {
        if (personne == null || profondeur > profondeurMax) {
            return;
        }

        StringBuilder indentation = new StringBuilder();
        for (int i = 0; i < profondeur; i++) {
            indentation.append("  ");
        }

        System.out.println(indentation.toString() + personne.prenom + " " + personne.nom);

        afficheArbreGenealogique(personne.mere, profondeur + 1, profondeurMax);
        afficheArbreGenealogique(personne.pere, profondeur + 1, profondeurMax);
    }

    public boolean estUnEnfant(Personne p) {
        return this.mere != null && this.mere.estEgal(p) || this.pere != null && this.pere.estEgal(p);
    }

    public boolean estUnAncetre(Personne p) {
        if (p == null) {
            return false;
        }

        if (this.estEgal(p)) {
            return true;
        }

        return this.estUnAncetre(p.mere) || this.estUnAncetre(p.pere);
    }

    public static boolean sontFreres(Personne p1, Personne p2) {
        return p1.aMemePere(p2) && p1.aMemeMere(p2);
    }

    public static boolean estUnProche(Personne p1, Personne p2) {
        return p1.estUnProche(p2, 3);
    }

    public boolean estUnProche(Personne p, int maxGenerations) {
        if (this.estEgal(p)) {
            return true;
        }

        List<Personne> ancetresP1 = getAncetres(new ArrayList<>());
        List<Personne> ancetresP2 = p.getAncetres(new ArrayList<>());

        for (Personne ancetre : ancetresP1) {
            if (ancetresP2.contains(ancetre)) {
                int distanceP1 = ancetresP1.indexOf(ancetre);
                int distanceP2 = ancetresP2.indexOf(ancetre);

                if (distanceP1 <= maxGenerations && distanceP2 <= maxGenerations) {
                    return true;
                }
            }
        }

        return false;
    }

    private List<Personne> getAncetres(List<Personne> ancetres) {
        if (this == null) {
            return ancetres;
        }

        ancetres.add(this);
        if (this.mere != null) {
            this.mere.getAncetres(ancetres);
        }
        if (this.pere != null) {
            this.pere.getAncetres(ancetres);
        }

        return ancetres;
    }

    public void inviter(Ville v) {
        System.out.println(this.prenom + " " + this.nom + " est invité(e) dans la ville de " + v.getNomVille());
    }

    public static String quelleRelation(Personne p1, Personne p2) {
        if (p1.estEgal(p2)) {
            return "Même personne";
        } else if (p1.estUnAncetre(p2) || p2.estUnAncetre(p1)) {
            return p1.prenom + " " + p1.nom + " et " + p2.prenom + " " + p2.nom + " ont une relation familiale.";
        } else if (p1.aMemePere(p2)) {
            return p1.prenom + " " + p1.nom + " et " + p2.prenom + " " + p2.nom + " ont le même père.";
        } else if (p1.aMemeMere(p2)) {
            return p1.prenom + " " + p1.nom + " et " + p2.prenom + " " + p2.nom + " ont la même mère.";
        } else {
            return "Aucune relation spécifique trouvée.";
        }
    }
}
