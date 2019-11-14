
public class BigBlock extends Block {
	public String moveDetector(int[][] map) {
		if (positionY!=0 && map[positionX][positionY-1] == 0 && map[positionX+1][positionY-1] == 0) {
			return "up";
		}
		else if(positionX!=0 && map[positionX-1][positionY] == 0 && map[positionX-1][positionY+1] == 0) {
			return "left";
		}
		else if(positionX!=2 && map[positionX+2][positionY] == 0 && map[positionX+2][positionY+1] == 0) {
			return "right";
		}
		else if(positionY!=3 && map[positionX][positionY+2] == 0 && map[positionX+1][positionY+2] == 0) {
			return "down";
		}
		return null;
	}
}
