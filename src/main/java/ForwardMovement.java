public class ForwardMovement implements MovementStrategy {
    @Override
    public Position calculateNewPosition(Position currentPosition, Orientation orientation) {
        int newX = currentPosition.getX();
        int newY = currentPosition.getY();

        switch (orientation) {
            case NORTH:
                newY++;
                break;
            case SOUTH:
                newY--;
                break;
            case EAST:
                newX++;
                break;
            case WEST:
                newX--;
                break;
        }

        return new Position(newX, newY);
    }
}
