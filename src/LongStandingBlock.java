
public class LongStandingBlock extends Block {
	public String leftrightDetector(int[][] map) {
		if(positionX!=0 && map[positionX-1][positionY] == 0 && map[positionX-1][positionY+1] == 0) {
			return "left";
		}
		else if(positionX!=3 && map[positionX+1][positionY] == 0 && map[positionX+1][positionY+1] == 0) {
			return "right";
		}
		return null;
	}
	public String upDetector(int[][] map) {
		if(positionY!=0 && map[positionX][positionY-1] == 0) {
			return "up";
		}
		return null;
	}
	public String downDetector(int[][] map) {
		if(positionY!=3 && map[positionX][positionY+2] == 0) {
			return "down";
		}
		return null;
	}
}
