import java.util.ArrayList;

public class Backward implements Command{
    private Rover joueur;

    public Backward(Rover j){
        this.joueur = j;
    }

    public void execute(ArrayList<Obstacle> obstacles){
        joueur.backward(obstacles);
    }
}
