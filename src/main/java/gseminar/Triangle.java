package gseminar;

public class Triangle {
    private int maxSide;
    private int minSide;
    private int midSide;

    public Triangle(int sideA, int sideB, int sideC){
        this.maxSide = Math.max(sideA, Math.max(sideB, sideC));
        this.minSide = Math.min(sideA, Math.min(sideB, sideC));
        this.midSide = sideA + sideB + sideC - minSide - maxSide;
        if (failOnNegativeValue(sideA, sideB, sideC))
            throw new NegativeValueException(String.format("zero and negative value is not allowed (%d, %d, %d)", sideA, sideB, sideC));
        if (!isValid(sideA, sideB, sideC))
            throw new NotTriangleException(String.format("not triangle (%d, %d, %d)", sideA, sideB, sideC));
    }

    public boolean isEquilateral() {
        return maxSide == minSide && minSide == midSide;
    }

    public boolean isRight() {
        return isRightWithPythagoreanTheorem(minSide, midSide, maxSide);
    }

    public boolean isObtuse(){
        return maxSide * maxSide > minSide * minSide + midSide * midSide;
    }

    public boolean isAcute() {
        return maxSide * maxSide < minSide * minSide + midSide * midSide;
    }

    public boolean isIsosceles() {
        return maxSide == minSide || maxSide == midSide || minSide == midSide;
    }

    public boolean isScalene() {
        return maxSide != minSide && minSide != midSide;
    }

    public Area calculateArea() {
        return new Area(calculateAreaByHelonsFormula(maxSide, minSide, midSide));
    }

    private double calculateAreaByHelonsFormula(int sideA, int sideB, int sideC){
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    private boolean isRightWithPythagoreanTheorem(int minSide, int midSide, int maxSide){
        return minSide * minSide + midSide * midSide == maxSide * maxSide;
    }

    private boolean failOnNegativeValue(int sideA, int sideB, int sideC){
        return sideA <= 0 || sideB <= 0 || sideC <= 0;
    }

    private boolean isValid(int sideA, int sideB, int sideC){
        return (sideA + sideB) > sideC && (sideA + sideC) > sideB && (sideB + sideC) > sideA;
    }
}
