public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction (int numerator, int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("Denominator cannot be zero");
        }
        if (denominator < 0) {
            denominator = -denominator;
            numerator = -numerator;
        }
        this.denominator = denominator;
        this.numerator = numerator;
    }

    public Fraction (int numerator) {
        this.numerator = numerator;
        this.denominator = 1;
    }

    public Fraction() {
        this.numerator = 0;
        this.denominator = 1;
    }

    public int getNumerator() {
        return this.numerator;
    }

    public int getDenominator() {
        return this.denominator;
    }

    public String toString() {
        return (this.numerator + "/" + this.denominator);
    }

    public double toDouble() {
        return (this.numerator/this.denominator);
    }

    public Fraction add(Fraction other) {
        Fraction addedFraction = new Fraction();
        addedFraction.numerator = (this.numerator*other.denominator) + (other.numerator*this.denominator);
        addedFraction.denominator = this.denominator*other.denominator;
        return addedFraction;
    }

    public Fraction subtract(Fraction other) {
        Fraction subtractedFraction = new Fraction();
        subtractedFraction.numerator = (this.numerator*other.denominator) - (other.numerator*this.denominator);
        subtractedFraction.denominator = this.denominator*other.denominator;
        return subtractedFraction;
    }

    public Fraction multiply(Fraction other) {
        Fraction multipliededFraction = new Fraction();
        multipliededFraction.numerator = this.numerator*other.numerator;
        multipliededFraction.denominator = this.denominator*other.denominator;
        return multipliededFraction;
    }

    public Fraction divide(Fraction other) {
        if (other.numerator == 0) {
            throw new IllegalArgumentException();
        }
        Fraction dividedFraction = new Fraction();
        dividedFraction.numerator = this.numerator * other.denominator
        dividedFraction.denominator = this.denominator*other.numerator;
        return dividedFraction;
    }

    public boolean equals(Object other) {
        return ((this.numerator/this.denominator) == (((Fraction)other).numerator/((Fraction)other).denominator));
    }

    public static int gcd(int a, int b) {
        while(a != 0 || b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }

    public void toLowestTerms() {
        int gcd = gcd(this.numerator, this.denominator);
        while (gcd != 1) {
            this.numerator = this.numerator/gcd;
            this.denominator = this.denominator/gcd;
            gcd = gcd(this.numerator, this.denominator);
        }
    }
}
