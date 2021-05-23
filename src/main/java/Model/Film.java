package Model;

public class Film {
    private String numeFilm;
    private ProgramareFilm programareFilm;

    public Film(String numeFilm, ProgramareFilm programareFilm) {
        this.numeFilm = numeFilm;
        this.programareFilm = programareFilm;
    }

    public String getNumeFilm() {
        return numeFilm;
    }

    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }

    public ProgramareFilm getProgramareFilm() {
        return programareFilm;
    }

    public void setProgramareFilm(ProgramareFilm programareFilm) {
        this.programareFilm = programareFilm;
    }

    @Override
    public String toString() {
        return "Film{" +
                "numeFilm='" + numeFilm + '\'' +","+
                this.getProgramareFilm().toString();
    }
}
