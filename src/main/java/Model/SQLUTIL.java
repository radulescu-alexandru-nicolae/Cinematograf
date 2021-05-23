package Model;
import java.sql.*;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SQLUTIL {
    private String JDBCurl="jdbc:mysql://localhost:3306/cinematograf?autoReconnect=true&&uSSL=false";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;
    public SQLUTIL(){
        try{
            connection= DriverManager.getConnection(JDBCurl,username,password);
            statement=connection.createStatement();

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void executeStatement(String execute){
        try{
            statement.execute(execute);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
    public void insertTabel(Object obj){
        String insertTo="";
        if(obj instanceof Bilet){
            Bilet bilet=(Bilet) obj;
            insertTo+="insert into bilet(numeFilm,numeClient,numeScaun,numeSala) values(";
            insertTo+=String.format("'%s','%s','%s','%s'",bilet.getNumeFilm(),bilet.getNumeClient(),bilet.getNumeScaun(),bilet.getSala());
            insertTo+=")";
            executeStatement(insertTo);
        }else if(obj instanceof Client){
            Client client=(Client) obj;
            insertTo+="insert into client(nume,numarTelefon) values(";
            insertTo+=String.format("'%s','%d'",client.getName(),client.getNumarTelefon());
            insertTo+=")";
            executeStatement(insertTo);
        }else if(obj instanceof Film){
            Film film=(Film) obj;
            int durata=(int) ChronoUnit.MINUTES.between(film.getProgramareFilm().getDataInceput(),film.getProgramareFilm().getDataSfarsit());
            insertTo+="insert into film(numeFilm,dataInceput,durata,sala)values(";
            insertTo+=String.format("'%s','%s','%d','%s'",film.getNumeFilm(),film.getProgramareFilm().getDataInceput(),durata,film.getProgramareFilm().getSala());
            insertTo+=")";
            executeStatement(insertTo);
        }else if(obj instanceof Sala){
            Sala sala=(Sala)obj;
            insertTo+="insert into sala(nume,numarLocuri)values(";
            insertTo+=String.format("'%s','%d'",sala.getNume(),sala.getNumarLocuri());
            insertTo+=")";
            executeStatement(insertTo);
        }
    }
    public void deleteTabel(Object obj){
        String delete="";
        if(obj instanceof Bilet){
            Bilet bilet=(Bilet) obj;
            delete+=String.format("delete from bilet where numeFilm='%s' and numeSala='%s' and numeScaun='%s'",bilet.getNumeFilm(),bilet.getSala(),bilet.getNumeScaun());
            executeStatement(delete);
        }else if(obj instanceof Client){
            Client client=(Client)obj;
            delete+=String.format("delete from client where nume='%s'",client.getName());
            executeStatement(delete);
        }else if(obj instanceof Film){
            Film film=(Film)obj;
            delete+=String.format("delete from film where numeFilm='%s'",film.getNumeFilm());
            executeStatement(delete);
        }else if(obj instanceof Sala){
            Sala sala=(Sala)obj;
            delete+=String.format("delete from sala where num='%s'",sala.getNume());
            executeStatement(delete);
        }
    }
    public void updateClient(Client client){
        String update="update client set";
        System.out.println("Introduceti detaliile pe care doriti sa le schimbati nume,numarTelefon");
        Scanner scanner = new Scanner(System.in);
        String[] prop=scanner.nextLine().split(",");
        for(String s:prop){
            switch (s){
                case "nume":
                    String nume=scanner.nextLine();
                    if(prop[0].equals("nume")){
                        update+=String.format(" nume='%s'",nume);
                    }else{
                        update+=String.format(",nume='%s'",nume);

                    }
                    break;
                case "numarTelefon":
                    int nr=scanner.nextInt();
                    if(prop[0].equals("numarTelefon")) {
                        update += String.format(" numarTelefon='%d'", nr);
                    }else{
                        update += String.format(",numarTelefon='%d'", nr);
                    }
                    }
            update+=String.format(" where nume='%s'",client.getName());
            executeStatement(update);
        }

    }
    public void updateBilet(Bilet bilet){
        Scanner scanner = new Scanner(System.in);
        String update="update bilet set";
        System.out.println("Introduceti detaliile pe care doriti sa le schimbati:numeFilm,numeClient,numeScaun,numeSala");
        String[] prop=scanner.nextLine().split(",");
        for(String s:prop){
            switch (s){
                case "numeFilm":
                    String numeNou=scanner.nextLine();
                    if(prop[0].equals("numeFilm")) {
                        update += String.format(" numeFilm='%s'", numeNou);
                    }else{
                        update += String.format(",numeFilm='%s'", numeNou);
                    }
                    break;
                case "numeClient":
                    String numeClient=scanner.nextLine();
                    if(prop[0].equals("numeClient")){
                        update+=String.format(" numeClient='%s'",numeClient);

                    }else {
                        update += String.format(",numeClient='%s'", numeClient);
                    }
                    break;
                case "numeScaun":
                    String numeScaun=scanner.nextLine();
                    if(prop[0].equals("numeScaun")) {
                        update += String.format(" numeScaun='%'", numeScaun);
                    }else{
                        update += String.format(",numeScaun='%'", numeScaun);
                    }
                    break;
                case "numeSala":
                    String numeSala=scanner.nextLine();
                    if(prop[0].equals("numeSala")) {
                        update += String.format(" numeSala='%s'", numeSala);
                    }else{
                        update += String.format(",numeSala='%s'", numeSala);

                    }
                    }
        }
        update+=String.format(" where numeFilm='%s' and numeClient='%s'",bilet.getNumeFilm(),bilet.getNumeClient());
        executeStatement(update);
    }
    public void updateSala(Sala sala){
        String update="update sala set";
        System.out.println("Introduceti detaliile pe care doriti sa le schimbati:nume,numarLocuri");
        Scanner scanner = new Scanner(System.in);
        String[] prop=scanner.nextLine().split(",");
        for(String s:prop){
            switch (s){
                case "nume":
                    String nume=scanner.nextLine();
                    if(prop[0].equals("nume")){
                        update+=String.format(" nume='%s'",nume);
                    }else{
                        update+=String.format(" nume='%s'",nume);
                    }
                    break;
                case "numarLocuri":
                    int nr=scanner.nextInt();
                    if(prop[0].equals("numarLocuri")){
                        update+=String.format(" numarLocuri='%d'",nr);
                    }else{
                        update+=String.format(",numarLocuri='%d'",nr);
                    }
                    break;
            }
        }
        update+=String.format(" where nume='%s'",sala.getNume());
        executeStatement(update);
    }
    public void updateFilm(Film film){
        Scanner scanner = new Scanner(System.in);
        String update="update film set ";
        System.out.println("Introduceti detaliile pe care doriti sa le modificati:numeFilm,dataInceput,durata,sala");
        String[] prop=scanner.nextLine().split(",");
        for(String s:prop){
            switch (s){
                case "numeFilm":
                    String nume=scanner.nextLine();
                    if(prop[0].equals("numeFilm")){
                        update+=String.format(" numeFilm='%s'",nume);
                    }else{
                        update+=String.format(",numeFilm='%s'",nume);
                    }
                    break;
                case "dataInceput":
                    String dataInceput=scanner.nextLine();
                    if(prop[0].equals("dataInceput")) {
                        update += String.format(" dataInceput='%s'", dataInceput);
                    }else{
                        update += String.format(",dataInceput='%s'", dataInceput);
                    }
                    break;
                case "durata":
                    int durata=scanner.nextInt();
                    if(prop[0].equals("durata")){
                        update+=String.format(" durata='%s'",durata);
                    }else{
                        update+=String.format(",durata='%s'",durata);
                    }
                    break;
                case "sala":
                    String sala=scanner.nextLine();
                    if(prop[0].equals("sala")){
                        update+=String.format(" sala='%s'",sala);
                    }else{
                        update+=String.format(",sala='%s'",sala);
                    }
                    break;
            }
            update+=String.format(" where numeFilm='%s' and dataInceput='%s' and sala='%s'",film.getNumeFilm(),film.getProgramareFilm().getDataInceput(),film.getProgramareFilm().getSala());
            executeStatement(update);
        }
    }
    private ResultSet allBilet(){
        executeStatement("select * from bilet");
        try{
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat");
        return null;
        }
    }
    private ResultSet allClient(){
        executeStatement("select * from client");
        try{
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat");
            return null;
        }
    }
    private ResultSet allFilm(){
        executeStatement("select * from film");
        try{
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat");
            return null;
        }
    }
    private ResultSet allSala(){
        executeStatement("select * from sala");
        try{
            return statement.getResultSet();
        }catch (Exception e){
            System.out.println("Nu s-a executat");
            return null;
        }
    }
    public List<Bilet> listaBilete(){
        ResultSet set=allBilet();
        List<Bilet> bilete=new ArrayList<>();
        try{
            while (set.next()){
                bilete.add(new Bilet(set.getString(2),set.getString(3),set.getString(4),set.getString(5)));
            }
            return bilete;
        }catch (Exception e){
            System.out.println("Nu s-a creat lista bilete");
            return null;
        }
    }
    public List<Client> listaClienti(){
        ResultSet set=allClient();
        List<Client> listaClienti=new ArrayList<>();
        try{
            while (set.next()){
                listaClienti.add(new Client(set.getString(2),Integer.parseInt(set.getString(3))));
            }
            return listaClienti;
        }catch (Exception e){
            System.out.println("Nu s-a creat lista clienti");
            return null;
        }
    }
    public List<Film> listaFilme(){
        ResultSet set=allFilm();
        List<Film> listaFilme=new ArrayList<>();
        try{
            while (set.next()){
                listaFilme.add(new Film(set.getString(2),new ProgramareFilm(set.getString(3).split(" ")[0],set.getString(3).split(" ")[1],Integer.parseInt(set.getString(4)),set.getString(5))));
            }
            return listaFilme;
        }catch (Exception e){
            System.out.println("Nu s-a creat lista filme");
            return null;
        }
    }
    public List<Sala> listaSali(){
        ResultSet set=allSala();
        List<Sala> sali=new ArrayList<>();
        try{
            while (set.next()){
                sali.add(new Sala(set.getString(2),Integer.parseInt(set.getString(3))));
            }
            return sali;
        }catch (Exception e){
            System.out.println("Nu s-a creat lista sali");
            return null;
        }
    }

}
