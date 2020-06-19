package pl.egzamin.biblioteka.bazadanych;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.egzamin.biblioteka.modele.Wypozyczenie;

public interface WypozyczenieRepository extends JpaRepository<Wypozyczenie,Long> {
}
