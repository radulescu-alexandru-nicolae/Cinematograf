package Controller;

import Model.Film;
import Model.ProgramareFilm;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllFilmTest {

    @Test
    void afisareListaFilme() {
        ControllFilm controllFilm=new ControllFilm();
        controllFilm.afisareListaFilme();
    }
    @Test
    void verificareFilm(){
        ControllFilm controllFilm=new ControllFilm();
        assertEquals(true,controllFilm.verificareFilm(new Film("Hulk",new ProgramareFilm("2021-01-01","11:00",2,"M1"))));
    }
    @Test
    void adaugaFilm(){
        ControllFilm controllFilm=new ControllFilm();
        controllFilm.adaugareFilm();
    }
}