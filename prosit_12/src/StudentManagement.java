import java.util.List;
import java.util.function.*;
import java.util.Comparator;
import java.util.stream.Stream;
import java.util.ArrayList;

public class StudentManagement implements Management {


    public static void main(String[] args) {
        List<Etudient> Etudient = List.of(
                new Etudient(1, "John", 20),
                new Etudient(2, "olfa", 23),
                new Etudient(3, "Doe", 21)
        );

        StudentManagement studentManagement = new StudentManagement();


        studentManagement.displayStudents(Etudient, etudiant -> {
            System.out.println("Etudiant ID: " + etudiant.getId());
            System.out.println("Etudiant Name: " + etudiant.getNom());
            System.out.println("Etudiant Age: " + etudiant.getAge());
        });
        studentManagement.displayStudentsByFilter(Etudient, etudiant -> etudiant.getAge() > 20, etudiant -> {
                    System.out.println("Etudiant ID: " + etudiant.getId());
                    System.out.println("Etudiant Name: " + etudiant.getNom());
                    System.out.println("Etudiant Age: " + etudiant.getAge());
        });
        String concatenatedNames = studentManagement.returnStudentsNames(Etudient,etudiant -> etudiant.getNom());

        System.out.println("Concatenated Names: " + concatenatedNames);
        Etudient newEtudient = studentManagement.createStudent(() -> new Etudient(1, "Olfa Hn", 23));

        Comparator<Etudient> idComparator = (etudiant1, etudiant2) -> Integer.compare(etudiant1.getId(), etudiant2.getId());


        List<Etudient> sortedStudents = studentManagement.sortStudentsById(Etudient, idComparator);
        for (Etudient etudient : sortedStudents) {
            System.out.println("Etudiant ID: " + etudient.getId());
            System.out.println("Etudiant Name: " + etudient.getNom());
            System.out.println("Etudiant Age: " + etudient.getAge());
        }
        Stream<Etudient> studentStream = studentManagement.convertToStream(Etudient);
        studentStream.map(etudiant -> etudiant.getNom()).forEach(System.out::println);
    }

    @Override
    public void displayStudents(List<Etudient> etudiant, Consumer<Etudient> consumer) {
        for (Etudient Etudient: etudiant) {
            consumer.accept(Etudient);
        }
    }

    @Override
    public void displayStudentsByFilter(List<Etudient> etudiant, Predicate<Etudient> pre, Consumer<Etudient> con) {
        for (Etudient Etudient : etudiant) {
            if (pre.test(Etudient)) {
                con.accept(Etudient);
            }
        }
    }

    @Override
    public String returnStudentsNames(List<Etudient> etudiant, Function<Etudient, String> fun) {
        StringBuilder names = new StringBuilder();
        for (Etudient Etudient : etudiant) {
            names.append(fun.apply(Etudient)).append(" ");
        }
        return names.toString().trim();
    }

    @Override
    public Etudient createStudent(Supplier<Etudient> sup) {
        return  sup.get();
    }

    @Override
    public List<Etudient> sortStudentsById(List<Etudient> etudiant, Comparator<Etudient> com) {
        List<Etudient> mutableList = new ArrayList<>(etudiant);
        mutableList.sort(com);
        return mutableList;

    }

    @Override
    public Stream<Etudient> convertToStream(List<Etudient> etudiant) {
        return etudiant.stream();
    }

}

