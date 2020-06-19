package pl.egzamin.biblioteka.modele;

import javax.persistence.*;
import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "WYPOZYCZENIE")
public class Wypozyczenie {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "DANE_WYPOZYCZAJACEGO")
    private String daneWypozyczajacego;


    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "WYPOZYCZENIE_KSIAZKI", joinColumns = {
            @JoinColumn(name = "KSIAZKA_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "WYPOZYCZENIE_ID")})
    private List<Ksiazka>wypozyczoneKsiazki = new ArrayList<>();

    @Column(name = "OD_KIEDY", columnDefinition = "DATE")
    private LocalDate odKiedy;

    @Column(name = "DO_KIEDY", columnDefinition = "DATE")
    private LocalDate doKiedy;

    public Wypozyczenie() {
    }

    public Wypozyczenie(String daneWypozyczajacego, List<Ksiazka> wypozyczoneKsiazki, LocalDate odKiedy, LocalDate doKiedy) {
        this.daneWypozyczajacego = daneWypozyczajacego;
        this.wypozyczoneKsiazki = wypozyczoneKsiazki;
        this.odKiedy = odKiedy;
        this.doKiedy = doKiedy;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDaneWypozyczajacego() {
        return daneWypozyczajacego;
    }

    public void setDaneWypozyczajacego(String daneWypozyczajacego) {
        this.daneWypozyczajacego = daneWypozyczajacego;
    }

    public List<Ksiazka> getWypozyczoneKsiazki() {
        return wypozyczoneKsiazki;
    }

    public void setWypozyczoneKsiazki(List<Ksiazka> wypozyczoneKsiazki) {
        this.wypozyczoneKsiazki = wypozyczoneKsiazki;
    }

    public LocalDate getOdKiedy() {
        return odKiedy;
    }

    public void setOdKiedy(LocalDate odKiedy) {
        this.odKiedy = odKiedy;
    }

    public LocalDate getDoKiedy() {
        return doKiedy;
    }

    public void setDoKiedy(LocalDate doKiedy) {
        this.doKiedy = doKiedy;
    }
}
