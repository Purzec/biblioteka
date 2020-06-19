package pl.egzamin.biblioteka.modele;

import javax.persistence.*;

@Entity
@Table(name = "KSIAZKA")
public class Ksiazka {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "NAZWA_KSIAZKI")
    private String nazwaKsiazki;

    @Column(name = "AUTOR_KSIAZKI")
    private String autorKsiazki;

    @Column(name = "OPIS_KSIAZKI")
    private String opisKsiazki;

    @Enumerated(value = EnumType.STRING)
    private  Gatunek gatunek;

    public Ksiazka() {
    }

    public Ksiazka(String nazwaKsiazki, String autorKsiazki, String opisKsiazki,Gatunek gatunek) {
        this.nazwaKsiazki = nazwaKsiazki;
        this.autorKsiazki = autorKsiazki;
        this.opisKsiazki = opisKsiazki;
        this.gatunek=gatunek;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwaKsiazki() {
        return nazwaKsiazki;
    }

    public void setNazwaKsiazki(String nazwaKsiazki) {
        this.nazwaKsiazki = nazwaKsiazki;
    }

    public String getAutorKsiazki() {
        return autorKsiazki;
    }

    public void setAutorKsiazki(String autorKsiazki) {
        this.autorKsiazki = autorKsiazki;
    }

    public String getOpisKsiazki() {
        return opisKsiazki;
    }

    public void setOpisKsiazki(String opisKsiazki) {
        this.opisKsiazki = opisKsiazki;
    }

    public Gatunek getGatunek() {
        return gatunek;
    }

    public void setGatunek(Gatunek gatunek) {
        this.gatunek = gatunek;
    }

    public String htmlSelectDisplay()
    {
        return nazwaKsiazki+ "("+ autorKsiazki + ")  " + gatunek.name();
    }

    public static enum Gatunek {
        Historyczna,
        Fantastyczna,
        Naukowa

    }

}
