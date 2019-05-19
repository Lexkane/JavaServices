package com.booking.model.train;

//import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class TrainTest {

    @Test
    void getTrainId() {
//        List<Coach> testCoaches = new LinkedList();
//        testCoaches.add(1, new Coach(1, null, CoachType.BERTH));
        Train testTrain = new Train(1, TrainType.BASIC_TRAIN, null);

        int actual = testTrain.getTrainId();

//        Assert.assertEquals(1, actual);
    }

    @Test
    void setTrainId() {
        Train testTrain = new Train(1, TrainType.BASIC_TRAIN, null);

        testTrain.setTrainId(2);
        int actual = testTrain.getTrainId();

//        Assert.assertEquals(2, actual);
    }

    @Test
    void getType() {
        Train testTrain = new Train(1, TrainType.BASIC_TRAIN, null);

        TrainType actual = testTrain.getType();

//        Assert.assertEquals(TrainType.BASIC_TRAIN, actual);

    }

    @Test
    void setType() {
        Train testTrain = new Train(1, TrainType.BASIC_TRAIN, null);

        testTrain.setType(TrainType.SPEED_TRAIN);
        TrainType actual = testTrain.getType();

//        Assert.assertEquals(TrainType.SPEED_TRAIN, actual);
    }

    @Test
    void getCoaches() {
        List<Coach> testCoaches = new LinkedList<>();
        testCoaches.add(0, new Coach(0, null, CoachType.BERTH));
        Train testTrain = new Train(1, TrainType.BASIC_TRAIN, testCoaches);

//        Assert.assertEquals(testCoaches, testTrain.setCoachesByType());
    }

    @Test
    void setCoaches() {
        List<Coach> testCoaches = new LinkedList<>();
        testCoaches.add(0, new Coach(0, null, CoachType.BERTH));
        Train testTrain = new Train(1, TrainType.BASIC_TRAIN, null);

        testTrain.setCoaches(testCoaches);

//        Assert.assertEquals(testCoaches, testTrain.setCoachesByType());
    }
}