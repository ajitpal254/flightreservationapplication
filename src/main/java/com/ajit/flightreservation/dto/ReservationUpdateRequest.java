package com.ajit.flightreservation.dto;

public class ReservationUpdateRequest {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getCheckedIn() {
        return checkedIn;
    }

    public void setCheckedIn(Boolean checkIn) {
        this.checkedIn = checkIn;
    }

    public int getNumberOfBags() {
        return numberOfBags;
    }

    public void setNumberOfBags(int numberOfBags) {
        this.numberOfBags = numberOfBags;
    }

    private Long id;
    private Boolean checkedIn;
    private int numberOfBags;
}
