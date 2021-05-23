package Controller;

import Model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ControllSala {
    private SQLUTIL sqlutil = new SQLUTIL();
    private List<Film> listaFilme=sqlutil.listaFilme();
    private List<Bilet> listaBilete = sqlutil.listaBilete();
    private List<Sala> listaSali = sqlutil.listaSali();
    public void afisareSala(){
        System.out.println("Introduceti detaliile despre sala si film:numeSala,numeFilm");
        Scanner scanner=new Scanner(System.in);
        String prop[]=scanner.nextLine().split(",");
        afisareSala(returnareSala(prop[0]),prop[1]);
    }
    public void afisareSala(Sala sala, String numeFilm) {
        for (Sala s : listaSali) {
            if (sala.equals(s)==true){
                sala.setLocuri(new char[(int) Math.sqrt(sala.getNumarLocuri())][(int) Math.sqrt(sala.getNumarLocuri())]);
                for(int nr=0;nr<Math.sqrt(sala.getNumarLocuri());nr++){
                    System.out.print("  "+(char)('A'+nr));
                }
                System.out.println();
                for (int i = 0; i < Math.sqrt(sala.getNumarLocuri()); i++) {
                    System.out.print("| ");
                    for (int j = 0; j < Math.sqrt(sala.getNumarLocuri()); j++) {
                        if(listaBilete.isEmpty()==false){
                            for(Bilet b:listaBilete) {
                                if (b.getNumeFilm().equals(numeFilm) == true) {
                                    String numeScaun = b.getNumeScaun();
                                    sala.getLocuri()[Integer.parseInt(String.valueOf(numeScaun.charAt(1))) - 1][numeScaun.charAt(0) - 65] = 'x';
                                }
                            }
                        }
                            System.out.print(sala.getLocuri()[i][j]+ " | ");
                    }
                    System.out.println(i + 1);
                    System.out.println("----------------------------");
                }
            }

        }
    }
    public Sala returnareSala(String nume){
        for(Sala sala:listaSali){
            if(sala.getNume().equals(nume)==true){
                return sala;
            }
        }
        return null;
    }
    public void adaugareSala(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti detaliile despre sala:nume,numarLocuri");
        String[] prop=scanner.nextLine().split(",");
        adaugareSala(new Sala(prop[0],Integer.parseInt(prop[1])));
    }
    public void deleteSala(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele salii pe care doriti sa o stergeti");
        String nume=scanner.nextLine();
        deleteSala(returnareSala(nume));
    }
    private void deleteSala(Sala sala){
        if(verificareSala(sala)==true){
            sqlutil.deleteTabel(sala);
            sqlutil.deleteTabel(returnareFilm(sala.getNume()));

        }
    }
    private void adaugareSala(Sala sala){
        if(verificareSala(sala)==false){
            sqlutil.insertTabel(sala);
        }
    }
    public void updateSala(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti detalii despre sala:nume,NumarLocuri");
        String[]prop=scanner.nextLine().split(",");
        updateSala(new Sala(prop[0],Integer.parseInt(prop[1])));
    }
    private void updateSala(Sala sala){
        if(verificareSala(sala)==true){
            sqlutil.updateSala(sala);
        }
    }
    private boolean verificareSala(Sala sala){
        for(Sala s:listaSali){
            if(s.getNume().equals(sala.getNume())==true){
                return true;
            }
        }
        return false;
    }
    private Film returnareFilm(String sala){
        for(Film f:listaFilme){
            if(f.getProgramareFilm().getSala().equals(sala)){
                return f;
            }
        }
        return null;
    }
}

