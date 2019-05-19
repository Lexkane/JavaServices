package com.booking.model.train;

import java.util.List;

public class Coach {
    private int coachId;
    private List<Seat> seats;
    private CoachType coachType;
    public Coach(int coachId, List<Seat> seats, CoachType coachType) {
        this.coachId = coachId;
        this.seats = seats;
        this.coachType = coachType;
    }

    public int getCoachId() {
        return coachId;
    }

    public void setCoachId(int coachId) {
        this.coachId = coachId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public CoachType getCoachType() {
        return coachType;
    }

    public void setCoachType(CoachType coachType) {
        this.coachType = coachType;
    }
}
