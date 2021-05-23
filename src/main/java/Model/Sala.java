package Model;

public class Sala {
    private String nume;
    private int numarLocuri;
    private String film;
    private char[][] locuri;
    public Sala(String nume, int numarLocuri) {
        this.nume = nume;
        this.numarLocuri = numarLocuri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public void setNumarLocuri(int numarLocuri) {
        this.numarLocuri = numarLocuri;
    }

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public char[][] getLocuri() {
        return locuri;
    }

    public void setLocuri(char[][] locuri) {
        this.locuri = locuri;
    }

    @Override
    public boolean equals(Object obj) {
        Sala s1=(Sala)obj;
        return s1.getNume().equals(this.getNume());
    }
}
