public interface MovementStrategy {
    Position calculateNewPosition(Position currentPosition, Orientation orientation);
}
