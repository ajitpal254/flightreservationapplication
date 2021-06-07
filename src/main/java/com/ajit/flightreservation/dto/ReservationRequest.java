package com.ajit.flightreservation.dto;

public class ReservationRequest {
    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getPassangerFirstName() {
        return passangerFirstName;
    }

    public void setPassangerFirstName(String passangerFirstName) {
        this.passangerFirstName = passangerFirstName;
    }

    public String getPassangerLastName() {
        return passangerLastName;
    }

    public void setPassangerLastName(String passangerLastName) {
        this.passangerLastName = passangerLastName;
    }

    public String getPassangerEmail() {
        return passangerEmail;
    }

    public void setPassangerEmail(String passangerEmail) {
        this.passangerEmail = passangerEmail;
    }

    public String getPassangerPhone() {
        return passangerPhone;
    }

    public void setPassangerPhone(String passangerPhone) {
        this.passangerPhone = passangerPhone;
    }

    public String getNameOnTheCard() {
        return nameOnTheCard;
    }

    public void setNameOnTheCard(String nameOnTheCard) {
        this.nameOnTheCard = nameOnTheCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getSecurityCode() {
        return securityCode;
    }

    public void setSecurityCode(String securityCode) {
        this.securityCode = securityCode;
    }

    @Override
    public String toString() {
        return "ReservationRequest{" +
                "flightId=" + flightId +
                ", passangerFirstName='" + passangerFirstName +
                ", passangerLastName='" + passangerLastName +
                ", passangerEmail='" + passangerEmail +
                ", passangerPhone='" + passangerPhone +
                ", nameOnTheCard='" + nameOnTheCard +
                ", cardNumber='" + cardNumber +
                ", expirationDate='" + expirationDate +
                ", securityCode='" + securityCode +
                '}';
    }

    private Long flightId;
    private String passangerFirstName;
    private String passangerLastName;
    private String passangerEmail;
    private String passangerPhone;
    private String nameOnTheCard;
    private String cardNumber;
    private String expirationDate;
    private String securityCode;

}
