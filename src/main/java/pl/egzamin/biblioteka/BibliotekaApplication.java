package pl.egzamin.biblioteka;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import pl.egzamin.biblioteka.modele.Ksiazka;
import pl.egzamin.biblioteka.bazadanych.KsiazkaRepository;

@SpringBootApplication
public class BibliotekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BibliotekaApplication.class, args);
    }



    @Bean
    CommandLineRunner initDatabase(KsiazkaRepository ksiazkaRepository) {
        return args -> {
            ksiazkaRepository.save(new Ksiazka( "Podstawy c++","Jan Nowak","Oogolny przewodnik o podstawach w tym ciekawym i docenianym jezyku" , Ksiazka.Gatunek.Naukowa));
            ksiazkaRepository.save(new Ksiazka( "Biblia","Nieznany","Znana na całym swiecie podstawa wiary katolickiej" , Ksiazka.Gatunek.Historyczna ));
            ksiazkaRepository.save(new Ksiazka( "Podstawy Javy","Andrzej Grabowski","Oogolny przewodnik o podstawach w tym ciekawym i" , Ksiazka.Gatunek.Naukowa));
            ksiazkaRepository.save(new Ksiazka( "Wladca Pierscieni","J.R.R Tolkien","Klasyka fantastyki, Ekranizacja zdobyła ponad 5 oskarów", Ksiazka.Gatunek.Fantastyczna ));
            ksiazkaRepository.save(new Ksiazka( "Podrecznik Dungeon and Dragons ","Robert Kubica","Poradnik dla poczatkujących graczy RPG edycja piąta", Ksiazka.Gatunek.Fantastyczna));
        };
    }
}
