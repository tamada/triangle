package gseminar;

public class Sides {
    private int sideA, sideB, sideC;

    public Sides(String sideAString, String sideBString, String sideCString){
        this.sideA = parseSide(sideAString);
        this.sideB = parseSide(sideBString);
        this.sideC = parseSide(sideCString);
        checkTriangle();
    }

    private int parseSide(String value){
        int side = toInt(value);
        if(side <= 0) throw new NegativeValueException("negative value is not allowed");
        return side;
    }

    private int toInt(String string) {
        return Integer.parseInt(string);
    }

    /**
     * calculate area of triangle by Heron’s formula.
     */
    public Area calculateArea() {
        double s = (sideA + sideB + sideC) / 2.0;
        return new Area(Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC)));
    }

    private void checkTriangle(){
        if((sideA + sideB) <= sideC || (sideA + sideC) <= sideB || (sideB + sideC) <= sideA)
            throw new NotTriangleException("not triangle");
    }
}
