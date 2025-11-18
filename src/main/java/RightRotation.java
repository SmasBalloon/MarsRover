public class RightRotation implements RotationStrategy {
    @Override
    public Orientation rotate(Orientation currentOrientation) {
        switch (currentOrientation) {
            case NORTH:
                return Orientation.EAST;
            case SOUTH:
                return Orientation.WEST;
            case EAST:
                return Orientation.SOUTH;
            case WEST:
                return Orientation.NORTH;
            default:
                return currentOrientation;
        }
    }
}
