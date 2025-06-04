package Services;

import Repositorys.AppointmentRepo;
import models.Appointment;
import models.User;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentService {
    private final AppointmentRepo repository;

    public AppointmentService(AppointmentRepo repository) {
        this.repository = repository;
    }

    public boolean isSlotAvailable(LocalDate date, LocalTime time, User vet) {
        for (Appointment appointment : repository.appointments) {
            boolean sameDate = appointment.getDate().equals(date);
            boolean sameTime = appointment.getTime().equals(time);
            boolean sameVet = appointment.getVeterinarian().equals(vet);

            if (sameDate && sameTime && sameVet) {
                return false;
            }
        }
        return true;
    }


    public String bookAppointment(Appointment appointment) {
        if (appointment.getVeterinarian() == null) {
            return "Моля, изберете ветеринар";
        }

        if (!isSlotAvailable(appointment.getDate(), appointment.getTime(), appointment.getVeterinarian())) {
            return "Избраният час не е наличен";
        }

        repository.appointments.add(appointment);
        return "Записът е успешен";
    }

}
