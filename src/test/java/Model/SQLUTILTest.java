package Model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SQLUTILTest {
    SQLUTIL sqlutil=new SQLUTIL();
    @Test
    void insertTabel() {
        sqlutil.insertTabel(new Bilet("Singur Acasa","Mihnea","A2","M1"));
    }

    @Test
    void listaBilete() {
        List<Bilet> lista=sqlutil.listaBilete();
        System.out.println(lista);
    }

    @Test
    void listaClienti() {
    }

    @Test
    void listaFilme() {
    }

    @Test
    void listaSali() {
    }
}