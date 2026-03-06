package ru.student.lab5.fraction;

public class CachedFraction extends Fraction {
    private Double cachedValue;

    public CachedFraction() {
        super();
    }

    public CachedFraction(int numerator, int denominator) {
        super(numerator, denominator);
    }

    @Override
    public double toDouble() {
        if (cachedValue == null) {
            cachedValue = super.toDouble();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        super.setNumerator(numerator);
        cachedValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        super.setDenominator(denominator);
        cachedValue = null;
    }

    @Override
    public String toString() {
        return "CachedFraction{fraction=" + super.toString() + ", cachedValue=" + cachedValue + "}";
    }
}
