
public class LongLyingBlock extends Block {
	public String upddownDetector(int[][] map) {
		if(positionY!=0 && map[positionX][positionY-1] == 0 && map[positionX+1][positionY-1] == 0) {
			return "up";
		}
		else if(positionY!=4 && map[positionX][positionY+1] == 0 && map[positionX+1][positionY+1] == 0) {
			return "down";
		}
		return "";
	}
	public String rightDetector(int[][] map) {
		if(positionX!=2 && map[positionX+2][positionY] == 0) {
			return "right";
		}
		return "";
	}
	public String leftDetector(int[][] map) {
		if(positionX!=0 && map[positionX-1][positionY] == 0) {
			return "left";
		}
		return "";
	}
}
