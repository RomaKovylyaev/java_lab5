package ru.student.lab5.maptask;

public class StudentRecord {
    private String surname;
    private String name;

    public StudentRecord(String surname, String name) {
        setSurname(surname);
        setName(name);
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) {
            throw new IllegalArgumentException("Фамилия не может быть пустой");
        }
        this.surname = surname.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name.trim();
    }

    @Override
    public String toString() {
        return surname + " " + name;
    }
}
