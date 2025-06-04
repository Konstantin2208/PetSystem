package Repositorys;

import models.Appointment;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface IAppointmentRepo {
    List<Appointment> getAllAppointments();


}
