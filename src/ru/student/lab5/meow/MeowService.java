package ru.student.lab5.meow;

public class MeowService {
    private String serviceName;

    public MeowService() {
        this("Сервис мяуканья");
    }

    public MeowService(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public void meowAll(Meowable... meowables) {
        if (meowables == null) {
            throw new IllegalArgumentException("Набор мяукающих объектов не может быть null");
        }
        for (Meowable meowable : meowables) {
            if (meowable != null) {
                meowable.meow();
            }
        }
    }

    @Override
    public String toString() {
        return "MeowService{name='" + serviceName + "'}";
    }
}
