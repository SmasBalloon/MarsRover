import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<String, Command> commands = new HashMap<>();

    public void setCommand(String bouton, Command cmd){
        commands.put(bouton, cmd);
    }

    public void pressButton(ArrayList<String> button, ArrayList<Obstacle> obstcles){
    	for (String element : button) {
    		Command cmd = commands.get(element);
    		if (cmd != null) cmd.execute(obstcles);
    	}
    }
}
