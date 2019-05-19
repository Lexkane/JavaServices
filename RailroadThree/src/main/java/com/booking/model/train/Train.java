package com.booking.model.train;

import java.util.List;

public class Train {
    private int trainId;
    private TrainType type;
    private List<Coach> coaches;

    public int getTrainId() {
        return trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public TrainType getType() {
        return type;
    }

    public void setType(TrainType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Train{" +
                "trainId=" + trainId +
                ", type=" + type +
                '}';
    }

    public Train(int trainId, TrainType type, List<Coach> coaches) {
        this.trainId = trainId;
        this.type = type;
        this.coaches = coaches;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}
