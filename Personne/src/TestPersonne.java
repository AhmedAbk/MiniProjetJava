public class TestPersonne {
    public static void main(String[] args) {
        Personne pl = new Personne("Khelifa", "Afifa", 35, "F");
        Personne p2 = new Personne("Khelifa", "Bechir", 60, "H");
        Personne p3 = new Personne("Helaoui", "Fatma", 55, "F");
        pl.setPere(p2);
        pl.setMere(p3);
        Personne p4 = new Personne("Zguerni", "Helmi", 8, "H");
        p4.setMere(pl);
        Personne p5 = new Personne("Khelifa", "Afifa", 35, "F");
        p5.setPere(p2);
        p5.setMere(p3);
        pl.afficheArbre(1);
        p2.afficheArbre(1);
        p3.afficheArbre(1);
        p4.afficheArbre(1);
        if (Personne.estEgal(p5, p3))
            System.out.println("Les 2 personnes sont les mêmes");
        else
            System.out.println("Les 2 personnes ne sont pas les mêmes");
        Personne p6 = new Personne("Khelifa", "Hanene", 37, "F");
        p6.setPere(p2);
        p6.setMere(p3);
        if (Personne.sontFreres(pl, p6))
            System.out.println(pl + " et " + p6 + " sont frères!");
        else
            System.out.println(pl + " et " + p6 + " ne sont pas frères!");
        if (Personne.estUnProche(p4, p6))
            System.out.println(p4 + " est un proche de " + p6);
        else
            System.out.println(p4 + " n'est pas un proche de " + p6);
        Ville v = new Ville(100, "Mahdia");
        v.addHabitant(pl);
        v.addHabitant(p6);
        v.addHabitant(p2);
        v.addHabitant(p3);
        v.addHabitant(p4);
        v.addHabitant(p5);
        v.addHabitant(p6);
        Personne p7 = new Personne("Nahla", "Mejri", 38, "F");
        v.addHabitant(p7);
        pl.inviter(v);
        String relation;
        relation = Personne.quelleRelation(pl, p2);
        System.out.println(pl + " et " + p2 + " : " + relation);
        relation = Personne.quelleRelation(pl, p3);
        System.out.println(pl + " et " + p3 + " : " + relation);
        relation = Personne.quelleRelation(p2, pl);
        System.out.println(p2 + " et " + pl + " : " + relation);
        relation = Personne.quelleRelation(p3, pl);
        System.out.println(p3 + " et " + pl + " : " + relation);
        relation = Personne.quelleRelation(pl, p4);
        System.out.println(pl + " et " + p4 + " : " + relation);
        relation = Personne.quelleRelation(pl, p6);
        System.out.println(pl + " et " + p6 + " : " + relation);
        relation = Personne.quelleRelation(pl, p7);
        System.out.println(pl + " et " + p7 + " : " + relation);
        relation = Personne.quelleRelation(p2, p7);
        System.out.println(p2 + " et " + p7 + " : " + relation);
        relation = Personne.quelleRelation(pl, p5);
        System.out.println(pl + " et " + p5 + " : " + relation);
        relation = Personne.quelleRelation(p3, p4);
        System.out.println(p3 + " et " + p4 + " : " + relation);
    }
}
