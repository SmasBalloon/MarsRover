public class GridWrapper {
    private static final int MIN_BOUNDARY = -50;
    private static final int MAX_BOUNDARY = 50;

    public Position wrapPosition(Position position) {
        int wrappedX = wrapCoordinate(position.getX());
        int wrappedY = wrapCoordinate(position.getY());
        return new Position(wrappedX, wrappedY);
    }

    private int wrapCoordinate(int coordinate) {
        if (coordinate > MAX_BOUNDARY) {
            return MIN_BOUNDARY;
        } else if (coordinate < MIN_BOUNDARY) {
            return MAX_BOUNDARY;
        }
        return coordinate;
    }
}
