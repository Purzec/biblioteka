package pl.egzamin.biblioteka.modele;


import java.util.ArrayList;
import java.util.List;

public class Koszyk {

    List<Ksiazka> ksiazkiDoWypozyczenia = new ArrayList<>();


    public Koszyk() {

    }


    public void dodajDoKoszyka(Ksiazka ksiazka) {
        for (int i = 0; i < ksiazkiDoWypozyczenia.size(); i++) {
            ksiazkiDoWypozyczenia.get(i).getId().equals(ksiazka.getId());
            {
                return;
            }
        }
        ksiazkiDoWypozyczenia.add(ksiazka);
    }



    public Koszyk(List<Ksiazka> ksiazkiDoWypozyczenia) {
        this.ksiazkiDoWypozyczenia = ksiazkiDoWypozyczenia;
    }



    public List<Ksiazka> getKsiazkiDoWypozyczenia() {
        return ksiazkiDoWypozyczenia;
    }

    public void setKsiazkiDoWypozyczenia(List<Ksiazka> ksiazkiDoWypozyczenia) {
        this.ksiazkiDoWypozyczenia = ksiazkiDoWypozyczenia;
    }
}
