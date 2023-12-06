package entities;

import java.util.Objects;

public class Departement implements Comparable<Departement>{

    private int id ;
    private String nom_de_departement ;
    private int nombre_des_employes ;

    public Departement() {
    }

    public Departement(int id, String nom_de_departement, int nombre_des_employes) {
        this.id = id;
        this.nom_de_departement = nom_de_departement;
        this.nombre_des_employes = nombre_des_employes;
    }

    public int getId() {
        return id;
    }

    public String getNom_de_departement() {
        return nom_de_departement;
    }

    public int getNombre_des_employes() {
        return nombre_des_employes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom_de_departement(String nom_de_departement) {
        this.nom_de_departement = nom_de_departement;
    }

    public void setNombre_des_employes(int nombre_des_employes) {
        this.nombre_des_employes = nombre_des_employes;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj == null) return false ;
        if (obj instanceof Departement d){
            return this.id==d.id && this.nom_de_departement.equals(d.nom_de_departement) ;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nom_de_departement='" + nom_de_departement + '\'' +
                ", nombre_des_employes=" + nombre_des_employes +
                '}';
    }

    @Override
    public int compareTo(Departement o) {
        return this.nom_de_departement.compareTo(o.getNom_de_departement());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom_de_departement);
    }


}