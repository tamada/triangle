package gseminar;

public class Triangle2 {
    private int maxSide;
    private int minSide;
    private int midSide;

    public Triangle2(int sideA, int sideB, int sideC){
        this.maxSide = Math.max(sideA, Math.max(sideB, sideC));
        this.minSide = Math.min(sideA, Math.min(sideB, sideC));
        this.midSide = sideA + sideB + sideC - minSide - maxSide;
        if (failOnNegativeValue(sideA, sideB, sideC))
            throw new NegativeValueException(String.format("zero and negative value is not allowed (%d, %d, %d)", sideA, sideB, sideC));
        if (!Triangle2Utils.isValid(this))
            throw new NotTriangleException(String.format("not triangle (%d, %d, %d)", sideA, sideB, sideC));
    }

    public <T> T accept(TriangleVisitor<T> visitor) {
        return visitor.visit(maxSide, midSide, minSide);
    }

    private boolean failOnNegativeValue(int sideA, int sideB, int sideC){
        return sideA <= 0 || sideB <= 0 || sideC <= 0;
    }
}
