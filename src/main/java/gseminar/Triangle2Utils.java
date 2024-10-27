package gseminar;

public class Triangle2Utils {
    /** 
     * This class does not need a instantiation.
     */
    private Triangle2Utils() {
    }

    public static boolean isValid(Triangle2 t) {
        return t.accept((maxSide, midSide, minSide) -> 
                (maxSide + minSide) > midSide && (maxSide + midSide) > minSide && (minSide + midSide) > maxSide);
    }

    public static boolean isEquilateral(Triangle2 t) {
        return t.accept((maxSide, midSide, minSide) -> 
                maxSide == minSide && minSide == midSide && maxSide == midSide);
    }

    public static boolean isRight(Triangle2 t) {
        return t.accept((maxSide, midSide, minSide) -> 
                isRightWithPythagoreanTheorem(maxSide, midSide, minSide));
    }

    public static boolean isObtuse(Triangle2 t){
        return t.accept((maxSide, midSide, minSide) -> 
                maxSide * maxSide > minSide * minSide + midSide * midSide);
    }

    public static boolean isAcute(Triangle2 t) {
        return t.accept((minSide, midSide, maxSide) -> 
                maxSide * maxSide < minSide * minSide + midSide * midSide);
    }

    public static boolean isIsosceles(Triangle2 t) {
        return t.accept((maxSide, midSide, minSide) -> 
                maxSide == minSide || minSide == midSide);
    }

    public static boolean isScalene(Triangle2 t) {
        return t.accept((maxSide, midSide, minSide) -> 
                maxSide != minSide && minSide != midSide);
    }

    public static Area calculateArea(Triangle2 t) {
        return t.accept((maxSide, midSide, minSide) -> 
                new Area(calculateAreaByHelonsFormula(maxSide, minSide, midSide)));
    }

    private static double calculateAreaByHelonsFormula(int sideA, int sideB, int sideC){
        double s = (sideA + sideB + sideC) / 2.0;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));
    }

    private static boolean isRightWithPythagoreanTheorem(int maxSide, int midSide, int minSide){
        assert maxSide >= midSide && midSide >= minSide: String.format("maxSide should be the longest side (%d, %d, %d)", maxSide, midSide, minSide);
        return minSide * minSide + midSide * midSide == maxSide * maxSide;
    }
}
