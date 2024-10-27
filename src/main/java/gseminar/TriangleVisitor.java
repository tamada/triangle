package gseminar;

public interface TriangleVisitor<S> {
    S visit(int maxSide, int midSide, int minSide);
}
