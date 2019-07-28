import java.util.ArrayList;

public class State {
	int numOfLyblock;
	int numOfStndblock;
	int numOfSmlblock;
	public int[][] map = new int[4][5];
	public int preStateNr = 0;
	public int nextStateNr = 0;
	
	BigBlock bigblock = new BigBlock();
	LongLyingBlock[] lyblock = new LongLyingBlock[10];
	LongStandingBlock[] stndblock = new LongStandingBlock[10];
	SmallBlock[] smlblock = new SmallBlock[10];
	
	public void initialBlocks(int[] args) {
		int argindex = 0;
		
		numOfLyblock = args[0];
		numOfStndblock = args[1];
		numOfSmlblock = args[2];		
		
		bigblock = new BigBlock();
		bigblock.positionX = args[3];
		bigblock.positionY = args[4];
		argindex = 5;
		
		for(int i=0; i<numOfLyblock; i++) {
			lyblock[i] = new LongLyingBlock();
			lyblock[i].positionX = args[argindex];
			argindex++;
			lyblock[i].positionY = args[argindex];
			argindex++;
		}
		for(int i = 0; i<numOfStndblock; i++) {
			stndblock[i] = new LongStandingBlock();
			stndblock[i].positionX = args[argindex];
			argindex++;
			stndblock[i].positionY = args[argindex];
			argindex++;
		}
		for(int i=0; i<numOfSmlblock; i++) {
			smlblock[i] = new SmallBlock();
			smlblock[i].positionX = args[argindex];
			argindex++;
			smlblock[i].positionY = args[argindex];
			argindex++;
		}
	}
	
	public int[][] setMap() {
		for(int i=0; i<4; i++) {
			for (int j=0; j<5; j++) {
				map[i][j]=0;
			}
		}
		map[bigblock.positionX][bigblock.positionY] = 1;
		map[bigblock.positionX][bigblock.positionY+1] = 1;
		map[bigblock.positionX+1][bigblock.positionY] = 1;
		map[bigblock.positionX+1][bigblock.positionY+1] = 1;
		for(int i=0; i<numOfLyblock; i++) {
			map[lyblock[i].positionX][lyblock[i].positionY] = 2;
			map[lyblock[i].positionX+1][lyblock[i].positionY] = 2;
		}
		for(int i=0; i<numOfStndblock; i++) {
			map[stndblock[i].positionX][stndblock[i].positionY] = 3;
			map[stndblock[i].positionX][stndblock[i].positionY+1] = 3;
		}
		for(int i=0; i<numOfSmlblock; i++) {
			map[smlblock[i].positionX][smlblock[i].positionY] = 4;
		}
		return map;
	}
	
	public void showStateMap() {
		for(int i=0; i<5; i++) {
			System.out.println(map[0][i] + " " + map[1][i] + " " + map[2][i] + " " + map[3][i]);
		}
	}
	
	public void assign(State targetState) {		
		targetState.numOfLyblock = numOfLyblock;
		targetState.numOfSmlblock = numOfSmlblock;
		targetState.numOfStndblock = numOfStndblock;
		
		targetState.bigblock.positionX = bigblock.positionX;
		targetState.bigblock.positionY = bigblock.positionY;
		for(int i=0; i<numOfLyblock; i++) {
			targetState.lyblock[i] = new LongLyingBlock();
			targetState.lyblock[i].positionX = lyblock[i].positionX;
			targetState.lyblock[i].positionY = lyblock[i].positionY;
		}
		for(int i=0; i<numOfSmlblock; i++) {
			targetState.smlblock[i] = new SmallBlock();
			targetState.smlblock[i].positionX = smlblock[i].positionX;
			targetState.smlblock[i].positionY = smlblock[i].positionY;
		}
		for(int i=0; i<numOfStndblock; i++) {
			targetState.stndblock[i] = new LongStandingBlock();
			targetState.stndblock[i].positionX = stndblock[i].positionX;
			targetState.stndblock[i].positionY = stndblock[i].positionY;
		}
		targetState.setMap();
	}
	
	public int mapEqual(State existState) {
		int exst = 1;
		for(int i=0; i<4; i++) {
			for(int j=0; j<5; j++) {
				if(map[i][j] != existState.map[i][j]) {
					exst = 0;
				}
			}
		}
		return exst;
	}
	
	@SuppressWarnings("rawtypes")
	public ArrayList mapToArrayList() {
		ArrayList<Integer> result = new ArrayList<Integer>(); 
		for(int i=0; i<5; i++) {
			result.add(map[0][i]);
			result.add(map[1][i]);
			result.add(map[2][i]);
			result.add(map[3][i]);
		}
		return result;
	}
	
}
