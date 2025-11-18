import java.util.ArrayList;

public class TurnLeft implements Command{
    private Rover joueur;

    public TurnLeft(Rover j){
        this.joueur = j;
    }

    public void execute(ArrayList<Obstacle> obstacles){
        joueur.left();
    }
}
