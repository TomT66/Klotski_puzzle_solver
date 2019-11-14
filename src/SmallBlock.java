
public class SmallBlock extends Block{
	public String upDetector(int[][] map) {
		if(positionY!=0 && map[positionX][positionY-1] == 0) {
			return "up";
		}
		return null;
	}
	public String downDetector(int[][] map) {
		if(positionY!=4 && map[positionX][positionY+1] == 0) {
			return "down";
		}
		return null;
	}
	public String leftDetector(int[][] map) {
		if(positionX!=0 && map[positionX-1][positionY] == 0) {
			return "left";
		}
		return null;
	}
	public String rightDetector(int[][] map) {
		if(positionX!=3 && map[positionX+1][positionY] == 0) {
			return "right";
		}
		return null;
	}
}
