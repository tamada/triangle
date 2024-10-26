package gseminar;

public class Triangle {
    private int sideA;
    private int sideB;
    private int sideC;

    public Triangle(int sideA, int sideB, int sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        if (failOnNegativeValue(sideA, sideB, sideC))
            throw new NegativeValueException(String.format("zero and negative value is not allowed (%d, %d, %d)", sideA, sideB, sideC));
        if (!isValid())
            throw new NotTriangleException(String.format("not triangle (%d, %d, %d)", sideA, sideB, sideC));
    }

    public Triangle(String sideAString, String sideBString, String sideCString){
        this(parseSide(sideAString), parseSide(sideBString), parseSide(sideCString));
    }

    public boolean isRight() {
        int minSide = Math.min(sideA, Math.min(sideB, sideC));
        int maxSide = Math.max(sideA, Math.max(sideB, sideC));
        int midSide = sideA + sideB + sideC - minSide - maxSide;
        return isRightWithPythagoreanTheorem(minSide, midSide, maxSide);
    }

    public boolean isEquilateral() {
        return sideA == sideB && sideB == sideC;
    }


    public Area calculateArea() {
        return new Area(calculateAreaByHelonsFormula(sideA, sideB, sideC));
    }

    private double calculateAreaByHelonsFormula(int sideA, int sideB, int sideC){
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    private static int parseSide(String value){
        int side = Integer.valueOf(value);
        if(side <= 0) throw new NegativeValueException("negative value is not allowed");
        return side;
    }

    private boolean isRightWithPythagoreanTheorem(int minSide, int midSide, int maxSide){
        return minSide * minSide + midSide * midSide == maxSide * maxSide;
    }

    private boolean failOnNegativeValue(int sideA, int sideB, int sideC){
        return sideA <= 0 || sideB <= 0 || sideC <= 0;
    }

    private boolean isValid(){
        return (sideA + sideB) > sideC && (sideA + sideC) > sideB && (sideB + sideC) > sideA;
    }
}
