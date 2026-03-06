package ru.student.lab5.meow;

public class MeowCounter implements Meowable {
    private final Meowable target;
    private int count;

    public MeowCounter(Meowable target) {
        if (target == null) {
            throw new IllegalArgumentException("Объект для отслеживания мяуканья не может быть null");
        }
        this.target = target;
    }

    public Meowable getTarget() {
        return target;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void meow() {
        count++;
        target.meow();
    }

    @Override
    public String toString() {
        return "MeowCounter{target=" + target + ", count=" + count + "}";
    }
}
