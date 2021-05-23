package Controller;

import Model.Bilet;
import Model.Client;
import Model.SQLUTIL;

import java.util.List;
import java.util.Scanner;

public class ControllClient {
    private SQLUTIL sqlutil=new SQLUTIL();
    private List<Client> clienti=sqlutil.listaClienti();
    private ControllSala controllSala=new ControllSala();
    public void cumparareBilet(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti detalii despre dumneavoastra:nume,numarTelefon");
        String detalii[]=scanner.nextLine().split(",");
        cumparareBilet(new Client(detalii[0],Integer.parseInt(detalii[1])));
    }
    public void deleteClient(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti detaliile clientului:nume,numarTelefon");
        String[] prop=scanner.nextLine().split(",");
        deleteClient(new Client(prop[0],Integer.parseInt(prop[1])));

    }
    public void updateClient(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Introduceti detaliile clientului:nume,numarTelefon");
        String[] prop=scanner.nextLine().split(",");
        updateClient(new Client(prop[0],Integer.parseInt(prop[1])));
    }
    public void cumparareBilet(Client client){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceti numele filmului si al salii");
        String[] prop=scanner.nextLine().split(",");
        controllSala.afisareSala(controllSala.returnareSala(prop[1]),prop[0]);
        System.out.println("Introduceti locul in care doriti sa stati");
        String loc=scanner.nextLine();
        sqlutil.insertTabel(new Bilet(prop[0],client.getName(),loc,prop[1]));
        sqlutil.insertTabel(client);
    }
    private void deleteClient(Client client){
        if(verificaerClient(client)==true){
            sqlutil.deleteTabel(client);
        }
    }
    private void updateClient(Client client){
        if(verificaerClient(client)==true){
            sqlutil.updateClient(client);
        }
    }
    private boolean verificaerClient(Client client){
        for(Client c:clienti){
            if(c.equals(client)==true){
                return true;
            }
        }
        return false;
    }

}
