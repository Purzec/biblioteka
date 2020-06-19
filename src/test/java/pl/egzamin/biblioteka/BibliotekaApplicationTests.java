package pl.egzamin.biblioteka;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.hamcrest.collection.IsCollectionWithSize;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.egzamin.biblioteka.bazadanych.KsiazkaRepository;
import pl.egzamin.biblioteka.modele.Koszyk;
import pl.egzamin.biblioteka.modele.Ksiazka;
import pl.egzamin.biblioteka.modele.Wypozyczenie;
import pl.egzamin.biblioteka.serwisy.KonfiguracjaCzasu;
import pl.egzamin.biblioteka.serwisy.PrzyjmowanieWypozyczen;

import java.time.LocalDate;


@SpringBootTest
class BibliotekaApplicationTests {

    @MockBean
    KonfiguracjaCzasu konfiguracjaCzasu;

    @Autowired
    KsiazkaRepository ksiazkaRepository;

    @Autowired
    PrzyjmowanieWypozyczen przyjmowanieWypozyczen;

    @Test
    void contextLoads() {
    }

    @Test
    void powinnoNaliczycGrzywne() {
        //given
        Wypozyczenie wypozyczenie = new Wypozyczenie();
        wypozyczenie.setOdKiedy(LocalDate.of(2020, 6, 19));
        wypozyczenie.setDoKiedy(LocalDate.of(2020, 6, 21));
        Mockito.when(konfiguracjaCzasu.getDate()).thenReturn(LocalDate.of(2020, 6, 22));
        //when
        int grzywna = przyjmowanieWypozyczen.naliczGrzywne(wypozyczenie);
        //then
        assert grzywna == 2;
    }


}
