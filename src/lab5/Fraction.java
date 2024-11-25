package lab5;

public class Fraction implements IFraction {
    protected int numerator;
    protected int denominator;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.numerator = numerator;
            this.denominator = denominator;
        }
    }

    @Override
    public int getNumerator() {
        return numerator;
    }

    @Override
    public int getDenominator() {
        return denominator;
    }

    @Override
    public double getDoubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    @Override
    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        if (denominator < 0) {
            this.numerator = -numerator;
            this.denominator = -denominator;
        } else {
            this.denominator = denominator;
        }
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
    
        if (obj == null || getClass() != obj.getClass()) 
            return false;

        var other = (IFraction)obj;

        return this.numerator == other.getNumerator()
            && this.denominator == other.getDenominator();
    }
}

