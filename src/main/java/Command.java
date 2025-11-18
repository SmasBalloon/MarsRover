import java.util.ArrayList;

public interface Command {
    void execute(ArrayList<Obstacle> obstacles);
}
