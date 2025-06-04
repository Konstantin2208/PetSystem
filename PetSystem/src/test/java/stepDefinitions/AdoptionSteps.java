package stepDefinitions;

import Services.AdoptionService;
import Repositorys.AdoptionRepo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.AdoptionPost;
import models.User;


import static org.junit.Assert.assertEquals;

public class AdoptionSteps {

    AdoptionRepo repo = new AdoptionRepo();
    AdoptionService service = new AdoptionService(repo);
    String result;
    AdoptionPost post;

    @Given("Собственикът е автентикиран")
    public void ownerIsAuthenticated() {
        // no-op for now
    }

    @When("попълни форма със заглавие {string} и описание {string}")
    public void fillAdoptionForm(String title, String description) {
        User owner = new User("owner", "pass", "email");
        post = new AdoptionPost(title, description, owner);
        result = service.createPost(post);
    }

    @Then("системата запазва обявата със статус {string}")
    public void verifyPostStatusPending(String expectedStatus) {
        assertEquals("pending", post.getStatus());
    }

    @Given("Администраторът вижда нова обява със статус {string}")
    public void adminSeesPostWithStatus(String status) {
        User owner = new User("owner", "pass", "email");
        post = new AdoptionPost("Коте за осиновяване", "Много мило", owner);
        post.setStatus(status);
        repo.posts.add(post);
    }

    @When("я одобри")
    public void adminApprovesPost() {
        result = service.approvePost(post);
    }

    @When("я отхвърли")
    public void adminRejectsPost() {
        result = service.rejectPost(post);
    }

    @Then("обявата се публикува със статус {string}")
    public void postShouldBeApproved(String expectedStatus) {
        assertEquals(expectedStatus, post.getStatus());
    }

    @Then("обявата се отбелязва със статус {string}")
    public void postShouldBeRejected(String expectedStatus) {
        assertEquals(expectedStatus, post.getStatus());
    }

    @Then("системата показва съобщение за грешка: {string}")
    public void systemShowsErrorMessage(String expectedMessage) {
        assertEquals(expectedMessage, result);
    }
}
