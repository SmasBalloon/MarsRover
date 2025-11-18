import java.util.ArrayList;

public class Forward implements Command{
    private Rover joueur;

    public Forward(Rover j){
        this.joueur = j;
    }

    public void execute(ArrayList<Obstacle> obstacles){
        joueur.forward(obstacles);
    }
}
