package pl.egzamin.biblioteka.serwisy;


import org.springframework.stereotype.Component;

import java.time.LocalDate;


@Component
public class KonfiguracjaCzasu {

    public LocalDate getDate() {
        return LocalDate.now();
    }
}
