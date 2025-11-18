import java.util.ArrayList;

public class TurnRight implements Command{
    private Rover joueur;

    public TurnRight(Rover j){
        this.joueur = j;
    }

    public void execute(ArrayList<Obstacle> obstacles){
        joueur.right();
    }
}
