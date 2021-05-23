package Controller;
import Model.Film;
import Model.ProgramareFilm;
import Model.SQLUTIL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class ControllFilm {
    private SQLUTIL sqlutil=new SQLUTIL();
    private List<Film> lisstaFilme=sqlutil.listaFilme();
    public void adaugareFilm(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti detaliile despre film:numeFilm,dataInceput(yy-MM-dd HH:mm) durata si sala");
        String[] prop=scanner.nextLine().split(",");
        adaugareFilm(new Film(prop[0],new ProgramareFilm(prop[1].split(" ")[0],prop[1].split(" ")[1],Integer.parseInt(prop[2]),prop[3])));
    }
    public void deleteFilm(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti detalii despre film:nume,sala");
        String[] prop=scanner.nextLine().split(",");
        deleteFilm(returnareFilm(prop[0],prop[1]));
    }
    public void updateFilm(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti detalii despre film:nume,sala");
        String[] prop=scanner.nextLine().split(",");
        updateFilm(returnareFilm(prop[0],prop[1]));
    }
    public void adaugareFilm(Film film){
        if(verificareFilm(film)==true){
            sqlutil.insertTabel(film);
        }
    }
    public void afisareListaFilme(){
        for(Film f:lisstaFilme){
            System.out.println(f);
        }
    }
    public void afisareFilmeOra(String data,String ora){
        for(Film f:lisstaFilme){
            if(f.getProgramareFilm().getDataInceput().compareTo(LocalDateTime.of(LocalDate.parse(data), LocalTime.parse(ora)))==0){
                System.out.println(f);
            }
        }
    }
    public boolean verificareFilm(Film film){
        for(Film f:lisstaFilme){
            if(f.getProgramareFilm().disponibilitate(film.getProgramareFilm())==false){
                return false;
            }
        }
        return true;
    }
    private void deleteFilm(Film film){
        if(verificareFilm(film)==true){
            sqlutil.deleteTabel(film);
        }

    }
    private Film returnareFilm(String nume,String sala){
        for(Film f:lisstaFilme){
            if(f.getNumeFilm().equals(nume)&&f.getProgramareFilm().getSala().equals(sala)){
                return f;
            }
        }
        return null;
    }
    private void updateFilm(Film film){
        if (verificareFilm(film)) {
            sqlutil.updateFilm(film);
        }
    }
}
