package Controller;

import java.util.Scanner;

public class ControllTotal {
    private ControllFilm controllFilm=new ControllFilm();
    private ControllSala controllSala=new ControllSala();
    private ControllClient controllClient=new ControllClient();
public void play(){
    Scanner scanner=new Scanner(System.in);
    meniuFinal();
    int nr=scanner.nextInt();
    switch (nr){
        case 1:playmeniuAdmin();
        break;
        case 2:
            playMeniuClient();
            break;
    }
}
    public void playMeniuClient(){
        Scanner scanner = new Scanner(System.in);
        meniuClient();
        boolean quit=false;
        while (quit==false){
            int nr=scanner.nextInt();
            switch (nr){
                case 1:controllClient.cumparareBilet();
                break;
                case 2:
                    controllFilm.afisareListaFilme();
                    break;
                case 3:
                    controllSala.afisareSala();
                case 4:
                    quit=true;
                    break;
            }
        }
    }
    public void playmeniuAdmin(){
        Scanner scanner = new Scanner(System.in);
        boolean quit=false;
        meniuAdmin();
        while (quit==false){
            int nr=scanner.nextInt();
            switch (nr){
                case 0:
                    controllFilm.adaugareFilm();
                    break;
                case 1:
                    controllFilm.deleteFilm();
                    break;
                case 2:
                    controllFilm.updateFilm();
                    break;
                case 3:
                    controllClient.deleteClient();
                    break;
                case 4:
                    controllClient.updateClient();
                    break;
                case 5:
                    controllSala.deleteSala();
                    break;
                case 6:
                    controllSala.adaugareSala();
                    break;
                case 7:
                    controllSala.updateSala();
                    break;
                case 8:
                    quit=true;
            }
        }
    }
    public void meniuClient(){
        System.out.println("Daca doriti sa cumparati un bilet apasati tasta 1 apasati tasta 1");
        System.out.println("Daca doriti sa vedeti lista cu filme apasati tasta 2");
        System.out.println("Daca doresti sa vezi locurile libere de la un anumit film apasa tasta 3");
        System.out.println("Daca doriti sa iesiti din meniu apasati tasta 4");
    }
    public void meniuAdmin(){
        System.out.println("Daca doriti sa adaugati un film apasati tasta 0");
        System.out.println("Daca doriti sa stergeti un film apasati tasta 1");
        System.out.println("Daca doriti sa modificati un film apasati tasta 2");
        System.out.println("Daca doriti sa stergeti un client din baza noastra de date apasati 3");
        System.out.println("Daca doriti sa modificati un client apasati 4");
        System.out.println("Daca doriti sa stergeti o sala apasati tastas 5");
        System.out.println("Daca doriti sa adaugati o sala apasati tasta 6");
        System.out.println("Daca doriti sa modificati o sala apasati tasta 7");
        System.out.println("Daca doriti sa iesiti din meniu apasati tasta 8");
    }
    public void meniuFinal(){
        System.out.println("Daca sunteti admin apasati tasat 1");
        System.out.println("Daca sunteti client apasati tasta 2");
    }
}
