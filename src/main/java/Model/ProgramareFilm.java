package Model;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class ProgramareFilm {
    private String numeFilm;
    private LocalDateTime dataInceput;
    private LocalDateTime dataSfarsit;
    private String sala;
    public ProgramareFilm(String dataInceput,String ora,int durata,String sala){
        this.dataInceput=LocalDateTime.of(LocalDate.parse(dataInceput), LocalTime.parse(ora));
        this.dataSfarsit=this.dataInceput.plusHours(durata);
        this.sala=sala;
    }
    public String getNumeFilm() {
        return numeFilm;
    }
    public void setNumeFilm(String numeFilm) {
        this.numeFilm = numeFilm;
    }
    public LocalDateTime getDataInceput() {
        return dataInceput;
    }
    public void setDataInceput(LocalDateTime dataInceput) {
        this.dataInceput = dataInceput;
    }
    public LocalDateTime getDataSfarsit() {
        return dataSfarsit;
    }
    public void setDataSfarsit(LocalDateTime dataSfarsit) {
        this.dataSfarsit = dataSfarsit;
    }
    public String getSala() {
        return sala;
    }
    public void setSala(String sala) {
        this.sala = sala;
    }
    public boolean disponibilitate(ProgramareFilm p1){
        if(p1.getDataInceput().getDayOfMonth()==this.getDataInceput().getDayOfMonth()){
            if(this.getDataSfarsit().compareTo(p1.getDataInceput())==0) return false;
            else if(p1.getDataSfarsit().compareTo(this.getDataInceput())==0) return false;
            else if(this.getDataSfarsit().isAfter(p1.getDataInceput())&&this.getDataSfarsit().isBefore(p1.getDataSfarsit())) return false;
            else if(this.getDataInceput().isBefore(p1.getDataInceput())&&this.getDataSfarsit().isAfter(p1.getDataSfarsit())) return false;
            else if(this.getDataInceput().isBefore(p1.getDataInceput())&&this.getDataSfarsit().compareTo(p1.getDataSfarsit())==0) return false;
            else if(this.getDataInceput().compareTo(p1.getDataInceput())==0&&this.getDataSfarsit().isAfter(p1.getDataSfarsit())) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return
                "dataInceput=" + dataInceput +
                ", dataSfarsit=" + dataSfarsit +
                ", sala='" + sala + '\'' +
                '}';
    }
}
