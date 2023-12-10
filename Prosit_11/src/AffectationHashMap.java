import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;


public class AffectationHashMap {
    private Map<String, String> affectations;

    public AffectationHashMap() {
        affectations = new HashMap<>();
    }

    public void affecterEmploye(String employe, String departement) {

        if (!affectations.containsKey(employe)) {
            affectations.put(employe, departement);
            System.out.println("Affectation réussie : " + employe + " -> " + departement);
        } else {
            System.out.println("L'employé est déjà affecté à un département.");
        }
    }

    public String getDepartement(String employe) {
        return affectations.get(employe);
    }


    public void afficherAffectations() {
        System.out.println("Affectations :");
        for (Map.Entry<String, String> entry : affectations.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        AffectationHashMap affectationHashMap = new AffectationHashMap();

        affectationHashMap.affecterEmploye("Employe1", "Departement1");
        affectationHashMap.affecterEmploye("Employe2", "Departement2");
        affectationHashMap.affecterEmploye("Employe3", "Departement1");
        affectationHashMap.supprimerEmploye("Employe2");
        affectationHashMap.supprimerEmployeEtDepartement("Employe2", "Departement2");


        affectationHashMap.afficherAffectations();
        affectationHashMap.afficherEmployesEtDepartements();
        affectationHashMap.afficherEmployes();
        affectationHashMap.afficherDepartements();
        String employeRecherche = "Employe2";
        TreeMap<Employe, Departement> treeMap = affectationHashMap.treeMap();

        System.out.println("Collection triée :");
        for (Map.Entry<Employe, Departement> entry : treeMap.entrySet()) {
            System.out.println("Employé : " + entry.getKey().getNom() + ", Département : " + entry.getValue().getNom());
        }


        System.out.println("Département de Employe2 : " + affectationHashMap.getDepartement("Employe2"));
        System.out.println("Employe2 existe : " + affectationHashMap.rechercherEmploye("Employe2"));
        System.out.println("Employe4 existe : " + affectationHashMap.rechercherEmploye("Employe4"));

        System.out.println("Departement1 existe : " + affectationHashMap.rechercherDepartement("Departement1"));
        System.out.println("Departement3 existe : " + affectationHashMap.rechercherDepartement("Departement3"));
    }




    public void ajouterEmployeDepartement(Employe e, Departement d) {
        affecterEmploye(e.getNom(), d.getNom());
    }


    class Employe {
        private String nom;

        public Employe(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }
    }

    class Departement {
        private String nom;

        public Departement(String nom) {
            this.nom = nom;
        }

        public String getNom() {
            return nom;
        }

    }
    public void afficherEmployesEtDepartements() {
        System.out.println("Employés et Départements :");
        for (Map.Entry<String, String> entry : affectations.entrySet()) {
            System.out.println("Employé : " + entry.getKey() + ", Département : " + entry.getValue());
        }
    }
    public void supprimerEmploye(String employe) {
        if (affectations.containsKey(employe)) {
            affectations.remove(employe);
            System.out.println("Suppression réussie de l'employé : " + employe);
        } else {
            System.out.println("L'employé n'est pas présent dans la collection.");
        }
    }
    public void supprimerEmployeEtDepartement(String employe, String departement) {
        if (affectations.containsKey(employe) && affectations.get(employe).equals(departement)) {
            affectations.remove(employe);
            System.out.println("Suppression réussie de l'employé " + employe + " du département " + departement);
        } else {
            System.out.println("L'employé n'est pas présent dans le département spécifié.");
        }
    }
    public void afficherEmployes() {
        System.out.println("Liste des employés :");
        for (String employe : affectations.keySet()) {
            System.out.println(employe);
        }
    }
    public void afficherDepartements() {
        System.out.println("Liste des départements :");
        Set<String> departements = new HashSet<>(affectations.values());
        for (String departement : departements) {
            System.out.println(departement);
        }
    }
    public boolean rechercherEmploye(String employe) {
        return affectations.containsKey(employe);
    }
    public boolean rechercherDepartement(String departement) {
        return affectations.containsValue(departement);
    }
    public TreeMap<Employe, Departement> treeMap() {
        TreeMap<Employe, Departement> treeMap = new TreeMap<>(new EmployeComparator());

        for (Map.Entry<String, String> entry : affectations.entrySet()) {
            Employe employe = new Employe(entry.getKey());
            Departement departement = new Departement(entry.getValue());
            treeMap.put(employe, departement);
        }

        return treeMap;
    }
    private static class EmployeComparator implements java.util.Comparator<Employe> {
        @Override
        public int compare(Employe emp1, Employe emp2) {
            // Comparaison basée sur les identifiants des employés
            return emp1.getNom().compareTo(emp2.getNom());
        }
    }
}
