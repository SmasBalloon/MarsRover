public class LeftRotation implements RotationStrategy {
    @Override
    public Orientation rotate(Orientation currentOrientation) {
        switch (currentOrientation) {
            case NORTH:
                return Orientation.WEST;
            case SOUTH:
                return Orientation.EAST;
            case EAST:
                return Orientation.NORTH;
            case WEST:
                return Orientation.SOUTH;
            default:
                return currentOrientation;
        }
    }
}
