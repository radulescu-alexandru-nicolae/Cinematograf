package Model;

public class Bilet {
    private String numeFilm;
    private String numeClient;
    private String numeScaun;
    private String sala;

    public Bilet(String numeFilm, String numeClient, String numeScaun,String sala) {
        this.numeFilm = numeFilm;
        this.numeClient = numeClient;
        this.numeScaun = numeScaun;
        this.sala=sala;
    }

    public String getNumeFilm() {
        return numeFilm;
    }

    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }

    public String getNumeClient() {
        return numeClient;
    }

    public void setNumeClient(String numeClient) {
        this.numeClient = numeClient;
    }

    public String getNumeScaun() {
        return numeScaun;
    }

    public void setNumeScaun(String numeScaun) {
        this.numeScaun = numeScaun;
    }

    @Override
    public String toString() {
        return "Bilet{" +
                "numeFilm='" + numeFilm + '\'' +
                ", numeClient='" + numeClient + '\'' +
                ", numeScaun='" + numeScaun + '\'' +
                ", sala='" + sala + '\'' +
                '}';
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
}
