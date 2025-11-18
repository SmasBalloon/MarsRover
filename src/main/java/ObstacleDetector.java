import java.util.ArrayList;

public class ObstacleDetector {
    private final ArrayList<Obstacle> obstacles;

    public ObstacleDetector(ArrayList<Obstacle> obstacles) {
        this.obstacles = obstacles;
    }

    public boolean isPositionBlocked(Position position) {
        for (Obstacle obstacle : obstacles) {
            if (obstacle.getPositionX().equals(position.getX()) 
                && obstacle.getPositionY().equals(position.getY())) {
                return true;
            }
        }
        return false;
    }
}
