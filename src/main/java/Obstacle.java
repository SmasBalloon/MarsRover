
public class Obstacle {
	private static Integer positionX;
	private static Integer positionY;

	public Obstacle(Integer positionX, Integer positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public static Integer getPositionX() {
		return positionX;
	}

	public static Integer getPositionY() {
		return positionY;
	}
}
