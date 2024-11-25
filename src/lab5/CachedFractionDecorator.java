package lab5;

public class CachedFractionDecorator implements IFraction {
    private final IFraction fraction;
    private Double cachedValue;

    public CachedFractionDecorator(IFraction fraction) {
        this.fraction = fraction;
    }

    @Override
    public double getDoubleValue() {
        if (cachedValue == null) {
            cachedValue = fraction.getDoubleValue();
        }
        return cachedValue;
    }

    @Override
    public void setNumerator(int numerator) {
        fraction.setNumerator(numerator);
        cachedValue = null;
    }

    @Override
    public void setDenominator(int denominator) {
        fraction.setDenominator(denominator);
        cachedValue = null;
    }

    @Override
    public String toString() {
        return fraction.toString();
    }

    @Override
    public int getNumerator() {
        return fraction.getNumerator();
    }

    @Override
    public int getDenominator() {
        return fraction.getDenominator();
    }

    @Override
    public boolean equals(Object obj) {
        return fraction.equals(obj);
    }
}