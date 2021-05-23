package Controller;

import Model.Sala;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllSalaTest {
    ControllSala controllSala=new ControllSala();
    @Test
    void afisareLocuri() {
        controllSala.afisareSala(new Sala("M1",16),"Avangers");

    }
}