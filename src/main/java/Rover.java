import java.util.ArrayList;

public class Rover {
	private Orientation orientation = Orientation.NORTH;
	private Integer positionX = 0;
	private Integer positionY = 0;
	

    public void forward(ArrayList<Obstacle> obstacles){
    	Boolean isValid = true;
        System.out.println("Le Rover avance !");
        if (this.orientation == Orientation.NORTH) {
        	isValid = isValid(obstacles, isValid, getPositionX(), getPositionY() + 1);
        	if (isValid) {
        		this.positionY++;
        	} else {
        		System.out.println("je ne peut pas avancé");
        	}
        } else if (this.orientation == Orientation.SOUTH) {
        	isValid = isValid(obstacles, isValid, getPositionX(), getPositionY() - 1);
        	if (isValid) {
        		this.positionY--;
        	} else System.out.println("je ne peut pas avancé");

        } else if (this.orientation == Orientation.EAST) {
        	isValid = isValid(obstacles, isValid, getPositionX() + 1, getPositionY());
        	if (isValid) {
        		this.positionX++;
        	} else System.out.println("je ne peut pas avancé");

        } else if (this.orientation == Orientation.WEST) {
        	isValid = isValid(obstacles, isValid, getPositionX() - 1 , getPositionY());
        	if (isValid) {
        		this.positionX--;
        	} else System.out.println("je ne peut pas avancé");
        }
        this.isOnTheEdge();
    }

    public void backward(ArrayList<Obstacle> obstacles){
    	Boolean isValid = true;
        System.out.println("Le Rover avance !");
        if (this.orientation == Orientation.NORTH) {
        	isValid = isValid(obstacles, isValid, getPositionX(), getPositionY() - 1);
        	if (isValid) {
        		this.positionY--;
        	} else System.out.println("je ne peut pas avancé");

        } else if (this.orientation == Orientation.SOUTH) {
        	isValid = isValid(obstacles, isValid, getPositionX(), getPositionY() + 1);
        	if (isValid) {
        		this.positionY++;
        	} else System.out.println("je ne peut pas avancé");

        } else if (this.orientation == Orientation.EAST) {
        	isValid = isValid(obstacles, isValid, getPositionX() - 1, getPositionY());
        	if (isValid) {
        		this.positionX--;
        	} else System.out.println("je ne peut pas avancé");

        } else if (this.orientation == Orientation.WEST) {
        	isValid = isValid(obstacles, isValid, getPositionX() + 1, getPositionY());
        	if (isValid) {
        		this.positionX++;
        	} else System.out.println("je ne peut pas avancé");
        }
        this.isOnTheEdge();
    }

    public void left(){
        System.out.println("Le joueur tourne à gauche !");
        if (this.orientation == Orientation.NORTH) {
        	this.orientation = Orientation.WEST;
        } else if (this.orientation == Orientation.SOUTH) {
        	this.orientation = Orientation.EAST;
        } else if (this.orientation == Orientation.EAST) {
        	this.orientation = Orientation.NORTH;
        } else if (this.orientation == Orientation.WEST) {
        	this.orientation = Orientation.SOUTH;
        }
    }

    public void right(){
        System.out.println("Le joueur tourne à doite !");
        if (this.orientation == Orientation.NORTH) {
        	this.orientation = Orientation.EAST;
        } else if (this.orientation == Orientation.SOUTH) {
        	this.orientation = Orientation.WEST;
        } else if (this.orientation == Orientation.EAST) {
        	this.orientation = Orientation.SOUTH;
        } else if (this.orientation == Orientation.WEST) {
        	this.orientation = Orientation.NORTH;
        }
    }
    
    private Integer getPositionX() {
    	return this.positionX;
    }
    
    private Integer getPositionY() {
    	return this.positionY;
    }
    
    public void afficherPosition() {
    	System.out.println("x = " + this.positionX + " y = " + this.positionY);
    }
    
    private Boolean isValid(ArrayList<Obstacle> obstacles, Boolean isValid, Integer positionX, Integer positionY) {
		for (Obstacle obstacle: obstacles) {
			if (Obstacle.getPositionX() == positionX && Obstacle.getPositionY() == positionY) {
				isValid = false;
			}
		}
		return isValid;
	}
    
    public void isOnTheEdge() {
    	if (this.getPositionX() == 51) {
    		this.positionX = -50;
    	} else if (this.getPositionX() == -51){
    		this.positionX = 50;
    	}
    	if (this.getPositionY() == 51) {
    		this.positionX = -50;
    	} else if (this.getPositionY() == -51){
    		this.positionX = 50;
    	}
    }
    
}
