package Model;
public class Client {
    private String name;
    private int numarTelefon;

    public Client(String name, int numarTelefon) {
        this.name = name;
        this.numarTelefon = numarTelefon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public int getNumarTelefon() {
        return numarTelefon;
    }

    public void setNumarTelefon(int numarTelefon) {
        this.numarTelefon = numarTelefon;
    }

    @Override
    public boolean equals(Object obj) {
        Client c1=(Client) obj;
        return c1.getName().equals(this.name)&&c1.getNumarTelefon()==this.getNumarTelefon();
    }
}
