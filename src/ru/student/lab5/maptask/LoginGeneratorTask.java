package ru.student.lab5.maptask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginGeneratorTask {
    private Path filePath;

    public LoginGeneratorTask(Path filePath) {
        this.filePath = filePath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public List<String> generateLogins() throws IOException {
        List<String> lines = Files.readAllLines(filePath, StandardCharsets.UTF_8);
        if (lines.isEmpty()) {
            throw new IllegalArgumentException("Файл пуст");
        }

        int n = Integer.parseInt(lines.get(0).trim());
        if (lines.size() < n + 1) {
            throw new IllegalArgumentException("В файле недостаточно строк с учениками");
        }

        Map<String, Integer> counts = new HashMap<>();
        List<String> result = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            String[] parts = lines.get(i).trim().split("\\s+");
            if (parts.length != 2) {
                throw new IllegalArgumentException("Некорректная строка: " + lines.get(i));
            }
            StudentRecord record = new StudentRecord(parts[0], parts[1]);
            int count = counts.getOrDefault(record.getSurname(), 0) + 1;
            counts.put(record.getSurname(), count);
            result.add(count == 1 ? record.getSurname() : record.getSurname() + count);
        }
        return result;
    }

    @Override
    public String toString() {
        return "LoginGeneratorTask{filePath=" + filePath + "}";
    }
}
