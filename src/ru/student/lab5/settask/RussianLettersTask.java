package ru.student.lab5.settask;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.TreeSet;

public class RussianLettersTask {
    private static final Set<Character> VOICED = Set.of('б', 'в', 'г', 'д', 'ж', 'з');
    private Path filePath;

    public RussianLettersTask(Path filePath) {
        this.filePath = filePath;
    }

    public Path getFilePath() {
        return filePath;
    }

    public void setFilePath(Path filePath) {
        this.filePath = filePath;
    }

    public Set<Character> findVoicedConsonants() throws IOException {
        String text = Files.readString(filePath, StandardCharsets.UTF_8).toLowerCase();
        Set<Character> result = new TreeSet<>();
        for (char ch : text.toCharArray()) {
            if (VOICED.contains(ch)) {
                result.add(ch);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "RussianLettersTask{filePath=" + filePath + "}";
    }
}
