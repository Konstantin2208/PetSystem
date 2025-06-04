package models;


import java.time.LocalDate;
import java.time.LocalTime;


public class Appointment {
    private LocalDate date;
    private LocalTime time;

    private User veterinarian;

    public Appointment(LocalDate date, LocalTime time, User veterinarian) {

        this.date = date;
        this.time = time;
        this.veterinarian = veterinarian;
    }




    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }


    public User getVeterinarian() {
        return veterinarian;
    }

    public void setVeterinarian(User veterinarian) {
        this.veterinarian = veterinarian;
    }
}
