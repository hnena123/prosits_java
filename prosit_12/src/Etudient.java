public class Etudient {
    private int id;
    private String nom;
    private int age;
    public Etudient(int id, String nom, int age) {
        this.id = id;
        this.nom = nom;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Etudient{" + "id=" + id +
                ", nom='" + nom + '\'' +
                ", age=" + age +
                '}';
    }
    public static void main(String[] args) {

        Etudient etudient1 = new Etudient(1, "John Doe", 20);
        Etudient etudient2 = new Etudient(2, "Olfa Hn", 23);


        System.out.println(etudient1.toString());
        System.out.println(etudient2.toString());
    }
}
