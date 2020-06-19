package pl.egzamin.biblioteka.serwisy;


import org.springframework.stereotype.Service;
import pl.egzamin.biblioteka.modele.Koszyk;
import pl.egzamin.biblioteka.modele.Ksiazka;

import javax.servlet.http.HttpSession;

@Service
public class ZarzadcaKoszyka {

    private static final String idKoszyka = "asdaf";

    public Koszyk dodajDoKoszyka(HttpSession httpSession, Ksiazka ksiazka) {
        Koszyk nowyKoszyk = (Koszyk) httpSession.getAttribute(idKoszyka);

        if (nowyKoszyk == null) {
            nowyKoszyk = new Koszyk();
            dodajKoszykDoSesji(httpSession, nowyKoszyk);
        }
        nowyKoszyk.dodajDoKoszyka(ksiazka);
        return nowyKoszyk;

    }

    public void dodajKoszykDoSesji(HttpSession httpSession, Koszyk koszyk) {
        httpSession.setAttribute(idKoszyka, koszyk);
    }

    public  Koszyk pobierzKoszyk(HttpSession httpSession){
        Koszyk nowyKoszyk = (Koszyk) httpSession.getAttribute(idKoszyka);

        if (nowyKoszyk == null) {
            nowyKoszyk = new Koszyk();
            dodajKoszykDoSesji(httpSession, nowyKoszyk);

        }

      return  (Koszyk) httpSession.getAttribute(idKoszyka);
    }

    public void usunKoszyk(HttpSession httpSession) {
        httpSession.removeAttribute(idKoszyka);
    }


}
