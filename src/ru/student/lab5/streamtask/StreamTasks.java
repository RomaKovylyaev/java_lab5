package ru.student.lab5.streamtask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class StreamTasks {
    private String title;

    public StreamTasks() {
        this("Стрим-задачи");
    }

    public StreamTasks(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Polyline buildPolyline(List<Point> points) {
        List<Point> result = points.stream()
                .distinct()
                .map(point -> new Point(point.getX(), Math.abs(point.getY())))
                .sorted(Comparator.comparingInt(Point::getX))
                .collect(Collectors.toList());
        return new Polyline(result);
    }

    public Map<Integer, List<String>> groupNamesByNumber(Path filePath) throws IOException {
        return Files.lines(filePath, StandardCharsets.UTF_8)
                .map(String::trim)
                .filter(line -> !line.isEmpty())
                .map(this::parsePerson)
                .filter(record -> record.getNumber() != null)
                .collect(Collectors.groupingBy(
                        PersonNumberRecord::getNumber,
                        Collectors.mapping(record -> formatName(record.getName()), Collectors.toList())
                ));
    }

    private PersonNumberRecord parsePerson(String line) {
        String[] parts = line.split(":", 2);
        String name = parts[0].trim();
        Integer number = null;
        if (parts.length == 2 && !parts[1].trim().isEmpty()) {
            number = Integer.parseInt(parts[1].trim());
        }
        return new PersonNumberRecord(name, number);
    }

    private String formatName(String name) {
        if (name == null || name.isBlank()) {
            return name;
        }
        String lower = name.toLowerCase();
        return Character.toUpperCase(lower.charAt(0)) + lower.substring(1);
    }

    @Override
    public String toString() {
        return "StreamTasks{title='" + title + "'}";
    }
}
