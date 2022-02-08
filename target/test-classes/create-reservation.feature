Feature: Create Reservation

  # PRECONDITIONS
  # Available movie - "Venom"
  # Movie start time - 2022-01-27T18:00:00(using ISO string format for dates)
  # Seats in room - S1,S2
  # Seat "S2" is already taken by another user

  Scenario: Create Reservation when user logged in and seat is available and time to movie is more than 60 minutes
    Given User opens reservation screen
    When Username is "DanielT"
    And user selects movie "Venom"
    And user selects seat "S1"
    And request time is "2022-01-27T15:15:30"
    And user submits the request
    Then result is "Reservation successful"

  Scenario: Create Reservation when user logged in and seat is available and time to movie is less than 60 minutes
    Given User opens reservation screen
    When Username is "DanielT"
    And user selects movie "Venom"
    And user selects seat "S1"
    And request time is "2022-01-27T17:15:30"
    And user submits the request
    Then result is "Reservations should be made at least one hour before the movie projection"

  Scenario: Create Reservation when user logged in and seat is available and movie already started
    Given User opens reservation screen
    When Username is "DanielT"
    And user selects movie "Venom"
    And user selects seat "S1"
    And request time is "2022-01-27T18:15:30"
    And user submits the request
    Then result is "Reservations should be made at least one hour before the movie projection"

  Scenario: Create Reservation when user logged in and seat is available and time to movie is exactly one hour
    Given User opens reservation screen
    When Username is "DanielT"
    And user selects movie "Venom"
    And user selects seat "S1"
    And request time is "2022-01-27T17:00:00"
    And user submits the request
    Then result is "Reservation successful"

  Scenario: Create Reservation when user not logged in and seat is available and time to movie is more than 60 minutes
    Given User opens reservation screen
    And user selects movie "Venom"
    And user selects seat "S1"
    And request time is "2022-01-27T16:00:00"
    And user submits the request
    Then result is "Reservation successful"

  Scenario: Create Reservation when user logged in and seat is not available and time to movie is more than one hour
    Given User opens reservation screen
    When Username is "DanielT"
    And user selects movie "Venom"
    And user selects seat "S2"
    And request time is "2022-01-27T17:00:00"
    And user submits the request
    Then result is "Seat is already taken"