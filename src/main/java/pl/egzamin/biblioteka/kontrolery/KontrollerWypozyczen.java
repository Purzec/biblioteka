package pl.egzamin.biblioteka.kontrolery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.egzamin.biblioteka.bazadanych.KsiazkaRepository;
import pl.egzamin.biblioteka.bazadanych.WypozyczenieRepository;
import pl.egzamin.biblioteka.modele.Ksiazka;
import pl.egzamin.biblioteka.modele.Wypozyczenie;
import pl.egzamin.biblioteka.serwisy.PrzyjmowanieWypozyczen;
import pl.egzamin.biblioteka.serwisy.ZarzadcaKoszyka;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
public class KontrollerWypozyczen {

@Autowired
KsiazkaRepository ksiazkaRepository;

@Autowired
ZarzadcaKoszyka zarzadcaKoszyka;

@Autowired
    PrzyjmowanieWypozyczen przyjmowanieWypozyczen;

@Autowired
    WypozyczenieRepository wypozyczenieRepository;


    @GetMapping("/")
    public String wypozyczKsiazke(Model model, HttpSession httpSession) {
model.addAttribute("ksiazki",ksiazkaRepository.findAll());
model.addAttribute("koszyk",zarzadcaKoszyka.pobierzKoszyk(httpSession));

        return "wypozyczenie";
    }


    @GetMapping("/dodajDoKoszyka")
    public String dodajDoKoszyka(@RequestParam("ksiazka") Long idKsiazki, HttpSession httpSession) {
        zarzadcaKoszyka.dodajDoKoszyka(httpSession,ksiazkaRepository.findById(idKsiazki).get());
        return "redirect:/";
    }


    @GetMapping("/wypozyczKsiazki")
    public String wypozyczKsiazke( @RequestParam("wypozyczajacy") String wypozyczajacy,HttpSession httpSession ,Model model) {
       Wypozyczenie wypozyczenie = przyjmowanieWypozyczen.stworzWypozyczenie(zarzadcaKoszyka.pobierzKoszyk(httpSession), wypozyczajacy, 3);
model.addAttribute("ile",wypozyczenie.getWypozyczoneKsiazki().size());
model.addAttribute("dataDo",wypozyczenie.getDoKiedy().toString());

        return "komunikat";
    }




}
