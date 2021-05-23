package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgramareFilmTest {

    @Test
    void disponibilitate() {
        ProgramareFilm programareFilm=new ProgramareFilm("2021-01-01","10:00",2,"M1");
        System.out.println(programareFilm.disponibilitate(new ProgramareFilm("2021-01-01","15:00",2,"M1")));
    }
}