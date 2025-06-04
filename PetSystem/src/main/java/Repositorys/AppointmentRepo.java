package Repositorys;

import models.Appointment;
import models.User;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import java.util.List;

public class AppointmentRepo implements IAppointmentRepo {
    public List<Appointment> appointments = new ArrayList<>();
    User vet = new User("vet1", "vet@example.com", "pass");


    @Override
    public List<Appointment> getAllAppointments() {
        ArrayList<Appointment> appointments = new ArrayList<>();
        User vet = new User("vet1", "vet@example.com", "pass");
        appointments.add(new Appointment(LocalDate.of(2025, 6, 1), LocalTime.of(10, 0), vet));
        return appointments;

    }
}

