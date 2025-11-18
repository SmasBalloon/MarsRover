import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

public class RoverTest {
    
    private Rover rover;
    private Controller controller;
    private ArrayList<Obstacle> obstacles;
    
    @Before
    public void setUp() {
        rover = new Rover();
        obstacles = new ArrayList<>();
        
        Command cmdForward = new Forward(rover);
        Command cmdBackward = new Backward(rover);
        Command cmdTurnLeft = new TurnLeft(rover);
        Command cmdTurnRight = new TurnRight(rover);
        
        controller = new Controller();
        controller.setCommand("f", cmdForward);
        controller.setCommand("b", cmdBackward);
        controller.setCommand("l", cmdTurnLeft);
        controller.setCommand("r", cmdTurnRight);
    }
    
    @Test
    public void testForwardNorth() {
        assertEquals(Orientation.NORTH, rover.orientation);
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("f");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(0), rover.getPositionX());
        assertEquals(Integer.valueOf(1), rover.getPositionY());
    }
    
    @Test
    public void testForwardSouth() {
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("r");
        buttons.add("r");
        controller.pressButton(buttons, obstacles);
        assertEquals(Orientation.SOUTH, rover.orientation);
        buttons.clear();
        buttons.add("f");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(0), rover.getPositionX());
        assertEquals(Integer.valueOf(-1), rover.getPositionY());
    }
    
    @Test
    public void testForwardEast() {
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("r");
        controller.pressButton(buttons, obstacles);
        assertEquals(Orientation.EAST, rover.orientation);
        buttons.clear();
        buttons.add("f");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(1), rover.getPositionX());
        assertEquals(Integer.valueOf(0), rover.getPositionY());
    }
    
    @Test
    public void testForwardWest() {
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("l");
        controller.pressButton(buttons, obstacles);
        assertEquals(Orientation.WEST, rover.orientation);
        buttons.clear();
        buttons.add("f");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(-1), rover.getPositionX());
        assertEquals(Integer.valueOf(0), rover.getPositionY());
    }
    
    @Test
    public void testBackwardNorth() {
        assertEquals(Orientation.NORTH, rover.orientation);
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("b");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(0), rover.getPositionX());
        assertEquals(Integer.valueOf(-1), rover.getPositionY());
    }
    
    @Test
    public void testBackwardSouth() {
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("r");
        buttons.add("r");
        controller.pressButton(buttons, obstacles);
        assertEquals(Orientation.SOUTH, rover.orientation);
        buttons.clear();
        buttons.add("b");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(0), rover.getPositionX());
        assertEquals(Integer.valueOf(1), rover.getPositionY());
    }
    
    @Test
    public void testBackwardEast() {
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("r");
        controller.pressButton(buttons, obstacles);
        assertEquals(Orientation.EAST, rover.orientation);
        buttons.clear();
        buttons.add("b");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(-1), rover.getPositionX());
        assertEquals(Integer.valueOf(0), rover.getPositionY());
    }
    
    @Test
    public void testBackwardWest() {
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("l");
        controller.pressButton(buttons, obstacles);
        assertEquals(Orientation.WEST, rover.orientation);
        buttons.clear();
        buttons.add("b");
        controller.pressButton(buttons, obstacles);
        assertEquals(Integer.valueOf(1), rover.getPositionX());
        assertEquals(Integer.valueOf(0), rover.getPositionY());
    }
    
    @Test
    public void testForwardWithObstacle() {
        Obstacle obstacle = new Obstacle(0, 1);
        ArrayList<Obstacle> obstacleList = new ArrayList<>();
        obstacleList.add(obstacle);
        
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("f");
        controller.pressButton(buttons, obstacleList);
        assertEquals(Integer.valueOf(0), rover.getPositionX());
        assertEquals(Integer.valueOf(0), rover.getPositionY());
    }
    
    @Test
    public void testBackwardWithObstacle() {
        Obstacle obstacle = new Obstacle(0, -1);
        ArrayList<Obstacle> obstacleList = new ArrayList<>();
        obstacleList.add(obstacle);
        
        ArrayList<String> buttons = new ArrayList<>();
        buttons.add("b");
        controller.pressButton(buttons, obstacleList);
        assertEquals(Integer.valueOf(0), rover.getPositionX());
        assertEquals(Integer.valueOf(0), rover.getPositionY());
    }
}
