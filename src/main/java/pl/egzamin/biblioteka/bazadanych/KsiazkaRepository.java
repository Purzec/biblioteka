package pl.egzamin.biblioteka.bazadanych;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.egzamin.biblioteka.modele.Ksiazka;

public interface KsiazkaRepository extends JpaRepository<Ksiazka, Long> {
}
