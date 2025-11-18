import java.util.ArrayList;

public class Rover {
    Orientation orientation = Orientation.NORTH;
    private Integer positionX = 0;
    private Integer positionY = 0;
    
    // Stratégies de mouvement et rotation (Open/Closed Principle)
    private final MovementStrategy forwardMovement = new ForwardMovement();
    private final MovementStrategy backwardMovement = new BackwardMovement();
    private final RotationStrategy leftRotation = new LeftRotation();
    private final RotationStrategy rightRotation = new RightRotation();
    private final GridWrapper gridWrapper = new GridWrapper();

    public void forward(ArrayList<Obstacle> obstacles) {
        move(obstacles, forwardMovement, "Le Rover avance !");
    }

    public void backward(ArrayList<Obstacle> obstacles) {
        move(obstacles, backwardMovement, "Le Rover avance !");
    }

    // Méthode privée qui respecte Single Responsibility
    private void move(ArrayList<Obstacle> obstacles, MovementStrategy strategy, String message) {
        System.out.println(message);
        Position currentPosition = new Position(positionX, positionY);
        Position newPosition = strategy.calculateNewPosition(currentPosition, orientation);
        
        ObstacleDetector detector = new ObstacleDetector(obstacles);
        if (detector.isPositionBlocked(newPosition)) {
            System.out.println("je ne peut pas avancé");
            return;
        }
        
        this.positionX = newPosition.getX();
        this.positionY = newPosition.getY();
        this.isOnTheEdge();
    }

    public void left() {
        System.out.println("Le joueur tourne à gauche !");
        this.orientation = leftRotation.rotate(orientation);
    }

    public void right() {
        System.out.println("Le joueur tourne à doite !");
        this.orientation = rightRotation.rotate(orientation);
    }
    
    public Integer getPositionX() {
        return this.positionX;
    }
    
    public Integer getPositionY() {
        return this.positionY;
    }
    
    public void afficherPosition() {
        System.out.println("x = " + this.positionX + " y = " + this.positionY);
    }
    
    public void isOnTheEdge() {
        Position wrappedPosition = gridWrapper.wrapPosition(new Position(positionX, positionY));
        this.positionX = wrappedPosition.getX();
        this.positionY = wrappedPosition.getY();
    }
}
