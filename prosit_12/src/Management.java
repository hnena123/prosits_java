
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.Comparator;
import java.util.stream.Stream;
public interface Management  {
        void displayStudents(List<Etudient> etudiant, Consumer<Etudient> con);
        void displayStudentsByFilter(List<Etudient> etudiant, Predicate<Etudient> pre, Consumer<Etudient> con);
        String returnStudentsNames(List<Etudient> etudiant, Function<Etudient, String> fun);
        Etudient createStudent(Supplier<Etudient> sup);
        List<Etudient> sortStudentsById(List<Etudient> etudiant, Comparator<Etudient> com);
        Stream<Etudient> convertToStream(List<Etudient> etudiant);
}

