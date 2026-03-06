package ru.student.lab5.streamtask;

public class PersonNumberRecord {
    private String name;
    private Integer number;

    public PersonNumberRecord(String name, Integer number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "PersonNumberRecord{name='" + name + "', number=" + number + "}";
    }
}
