package pl.egzamin.biblioteka.kontrolery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.egzamin.biblioteka.bazadanych.KsiazkaRepository;
import pl.egzamin.biblioteka.bazadanych.WypozyczenieRepository;
import pl.egzamin.biblioteka.modele.Ksiazka;
import pl.egzamin.biblioteka.modele.Wypozyczenie;

import java.util.List;
import java.util.Optional;

@RestController
public class RestCOntroller {

    @Autowired
    KsiazkaRepository ksiazkaRepository;

    @Autowired
    WypozyczenieRepository wypozyczenieRepository;


    @GetMapping("/zestawienie")
    public List<Ksiazka> all() {
        return ksiazkaRepository.findAll();
    }


    @GetMapping("/zestawienie/{id}")
    public Optional<Wypozyczenie> one(@PathVariable Long id) {

        return wypozyczenieRepository.findById(id);

    }

}
