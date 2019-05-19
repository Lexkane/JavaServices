package com.booking.model.train;



import java.util.LinkedList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CoachTest {

    @Test
    void getCoachId() {
        List<Seat> testSeats = new LinkedList<>();
        testSeats.add(0, new Seat(1));
        Coach testCoach = new Coach(1,testSeats, CoachType.BERTH);
        int actual = testCoach.getCoachId();

//        Assert.assertEquals(1, actual);
//        Не це а от це треба юзати Assert це дефолтний класс java.util )) 
//        assertEquals();
    }


    @Test
    void setCoachId() {
        List<Seat> testSeats = new LinkedList<>();
        testSeats.add(0, new Seat(1));
        Coach testCoach = new Coach(1,testSeats, CoachType.BERTH);

        testCoach.setCoachId(2);
        int actual = testCoach.getCoachId();

//        Assert.assertEquals(2, actual);
    }

    @Test
    void getSeats() {
        List<Seat> testSeats = new LinkedList<>();
        Seat testSeat = new Seat(1);
        testSeats.add(0, testSeat);
        Coach testCoach = new Coach(1,testSeats, CoachType.BERTH);

        Seat actual = testCoach.getSeats().get(0);

//        Assert.assertEquals(testSeat, actual);

    }

    @Test
    void setSeats() {
        List<Seat> testSeats = new LinkedList<>();
        testSeats.add(0, new Seat(1));
        Coach testCoach = new Coach(1, null, CoachType.BERTH);

        testCoach.setSeats(testSeats);

//        Assert.assertEquals(testSeats, testCoach.getSeats());
    }

    @Test
    void getCoachType() {
        List<Seat> testSeats = new LinkedList<>();
        testSeats.add(0, new Seat(1));
        Coach testCoach = new Coach(1,testSeats, CoachType.BERTH);

        CoachType actual = testCoach.getCoachType();

//        Assert.assertEquals(CoachType.BERTH, actual);
    }

    @Test
    void setCoachType() {
        List<Seat> testSeats = new LinkedList<>();
        testSeats.add(0, new Seat(1));
        Coach testCoach = new Coach(1,testSeats, null);

        testCoach.setCoachType(CoachType.BERTH);

//        Assert.assertEquals(CoachType.BERTH, testCoach.getCoachType());
    }
}