package stepDefinitions;

import Services.AppointmentService;
import Repositorys.AppointmentRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Appointment;
import models.User;


import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;


public class AppointmentSteps {

    AppointmentRepo repo = new AppointmentRepo();
    AppointmentService service = new AppointmentService(repo);
    String result;

    @Given("Собственикът е влязъл в системата")
    public void theOwnerIsLoggedIn() {

    }

    @When("избира дата {string}, час {string} и ветеринар {string}")
    public void chooseValidSlot(String date, String time, String vetName) {
        Appointment appointment = new Appointment(
                LocalDate.parse(date),
                LocalTime.parse(time),
                new User(vetName, "pass", "email")
        );
        result= service.bookAppointment(appointment);

    }

    @When("избира дата {string}, час {string}, който вече е зает")
    public void chooseTakenSlot(String date, String time) {
        User vet = new User("Dr. Ivanov", "pass", "email");
        Appointment taken = new Appointment(LocalDate.parse(date), LocalTime.parse(time), vet);
        repo.appointments.add(taken);
        result= service.bookAppointment(taken);


    }

    @When("избира дата {string}, час {string} без да посочи ветеринар")
    public void chooseSlotWithoutVet(String date, String time) {
        Appointment appointment = new Appointment(
                LocalDate.parse(date),
                LocalTime.parse(time),
                null);
                result= service.bookAppointment(appointment);
    }

    @Then("системата потвърждава записа на час")
    public void systemConfirms() {
        assertEquals("Записът е успешен", result);
    }

    @Then("системата показва съобщение: {string}")
    public void systemMassage(String expectedMassage) {
        assertEquals(expectedMassage, result);
    }

    @Then("системата показва грешка: {string}")
    public void systemShowsError(String expectedError) {
        assertEquals(expectedError, result);
    }
}
