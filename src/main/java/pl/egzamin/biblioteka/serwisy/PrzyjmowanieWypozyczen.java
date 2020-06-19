package pl.egzamin.biblioteka.serwisy;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.egzamin.biblioteka.bazadanych.WypozyczenieRepository;
import pl.egzamin.biblioteka.modele.Koszyk;
import pl.egzamin.biblioteka.modele.Wypozyczenie;

import java.time.Period;
import java.time.temporal.ChronoUnit;

@Service
public class PrzyjmowanieWypozyczen {

    @Autowired
    private WypozyczenieRepository wypozyczenieRepository;

    @Autowired
    KonfiguracjaCzasu konfiguracjaCzasu;

    public Wypozyczenie stworzWypozyczenie(Koszyk koszyk,String wypozyczajacy, int iloscDni)
    {
        Wypozyczenie wypozyczenie = new Wypozyczenie();
        wypozyczenie.getWypozyczoneKsiazki().addAll(koszyk.getKsiazkiDoWypozyczenia());
        wypozyczenie.setDaneWypozyczajacego(wypozyczajacy);
        wypozyczenie.setOdKiedy(konfiguracjaCzasu.getDate());
        wypozyczenie.setDoKiedy(konfiguracjaCzasu.getDate().plus(iloscDni, ChronoUnit.DAYS));
    return wypozyczenieRepository.save(wypozyczenie);
    }

    public int naliczGrzywne(Wypozyczenie wypozyczenie) {
        if (konfiguracjaCzasu.getDate().compareTo(wypozyczenie.getDoKiedy()) > 0) {
            Period okresczasu = Period.between(wypozyczenie.getOdKiedy(), konfiguracjaCzasu.getDate());
            int iloscdni = okresczasu.getDays();
            return (2 * iloscdni) - 4;

        }
        return 0;
    }


}
