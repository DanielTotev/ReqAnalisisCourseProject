package org.pu.fmi.requirement.engineering.manager;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.pu.fmi.requirement.engineering.exception.InvalidReservationTimeException;
import org.pu.fmi.requirement.engineering.exception.SeatAlreadyReservedException;
import org.pu.fmi.requirement.engineering.model.ReservationRequest;
import org.pu.fmi.requirement.engineering.model.User;

import java.time.LocalDateTime;

import static org.junit.Assert.assertEquals;
import static org.pu.fmi.requirement.engineering.testutils.MovieProjectionManagerFactory.createMovieProjectionManager;

public class CreateReservationStepDefinitions {
    private MovieProjectionManager movieProjectionManager;
    private User user;
    private ReservationRequest reservationRequest;
    private String result;

    @Given("User opens reservation screen")
    public void userOpensReservationScreen() {
        movieProjectionManager = createMovieProjectionManager();
        user = new User();
        reservationRequest = new ReservationRequest();
        reservationRequest.setUser(user);
    }

    @When("Username is {string}")
    public void usernameIs(String username) {
        user.setUsername(username);
    }

    @And("user selects movie {string}")
    public void userSelectsMovie(String movieTitle) {
        reservationRequest.setMovieName(movieTitle);
    }

    @And("user selects seat {string}")
    public void userSelectsSeat(String seatNumber) {
        reservationRequest.setSeatNumber(seatNumber);
    }

    @And("request time is {string}")
    public void requestTimeIs(String requestTimeInIsoFormat) {
        LocalDateTime localDateTime = LocalDateTime.parse(requestTimeInIsoFormat);
        reservationRequest.setRequestTime(localDateTime);
    }

    @And("user submits the request")
    public void userSubmitsTheRequest() {
        try {
            result = movieProjectionManager.createReservation(reservationRequest);
        } catch (InvalidReservationTimeException | SeatAlreadyReservedException e) {
            result = e.getMessage();
        }
    }

    @Then("result is {string}")
    public void resultIs(String expectedResult) {
        assertEquals(expectedResult, result);
    }
}
