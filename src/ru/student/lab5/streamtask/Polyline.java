package ru.student.lab5.streamtask;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public List<Point> getPoints() {
        return new ArrayList<>(points);
    }

    public void setPoints(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    @Override
    public String toString() {
        return "Линия [" + points.stream().map(Point::toString).collect(Collectors.joining(", ")) + "]";
    }
}
