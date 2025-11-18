import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
        Rover Rover = new Rover();

        Command cmdForward = new Forward(Rover);
        Command cmdBackward = new Backward(Rover);
        Command cmdTurnLeft = new TurnLeft(Rover);
        Command cmdTurnRight = new TurnRight(Rover);

        Controller manette = new Controller();
        manette.setCommand("f", cmdForward);
        manette.setCommand("b", cmdBackward);
        manette.setCommand("l", cmdTurnLeft);
        manette.setCommand("r", cmdTurnRight);

        ArrayList<String> button = new ArrayList<String>();
        button.add("f");
        button.add("f");
        button.add("r");
        button.add("f");
        button.add("f");
        
        ArrayList<Obstacle> obstacle = new ArrayList<Obstacle>();
        obstacle.add(new Obstacle(1, 0));

        manette.pressButton(button, obstacle);
        
        Rover.afficherPosition();
    }
}