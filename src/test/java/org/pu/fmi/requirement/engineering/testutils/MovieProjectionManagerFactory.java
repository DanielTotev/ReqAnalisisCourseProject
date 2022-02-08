package org.pu.fmi.requirement.engineering.testutils;

import org.pu.fmi.requirement.engineering.manager.MovieProjectionManager;
import org.pu.fmi.requirement.engineering.model.*;

import java.time.LocalDateTime;
import java.util.Set;

public final class MovieProjectionManagerFactory {
    private MovieProjectionManagerFactory() { }

    public static MovieProjectionManager createMovieProjectionManager() {
        MovieProjectionManager movieProjectionManager = new MovieProjectionManager();
        movieProjectionManager.setMovieProjections(createMovieProjections());
        return movieProjectionManager;
    }

    private static Set<MovieProjection> createMovieProjections() {
        MovieProjection movieProjection = new MovieProjection();
        movieProjection.setTitle("Venom");
        LocalDateTime movieStartTime = LocalDateTime.parse("2022-01-27T18:00:00");
        movieProjection.setStartTime(movieStartTime);
        Room room = createRoom();
        movieProjection.setRoom(room);
        Seat seat = room.getSeats().stream().filter(s -> s.getSeatNumber().equals("S2"))
                .findFirst()
                .orElseThrow();
        movieProjection.getReservations().add(createReservation(seat));
        return Set.of(movieProjection);
    }

    private static Reservation createReservation(Seat seat) {
        User user = new User();
        user.setUsername("TestUser");
        return new Reservation(seat, user);
    }

    private static Room createRoom() {
        Room room = new Room();
        room.setSeats(createSeats());
        return room;
    }

    private static Set<Seat> createSeats() {
        Seat firstSeat = new Seat();
        firstSeat.setSeatNumber("S1");
        Seat secondSeat = new Seat();
        secondSeat.setSeatNumber("S2");
        return Set.of(firstSeat, secondSeat);
    }
}
