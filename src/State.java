import java.util.Scanner;

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
	
	public void initialBlocks() {
		Scanner in = new Scanner(System.in);
		
		System.out.print("input number of lying blocks: ");
		numOfLyblock = in.nextInt();
		System.out.print("input number of standing blocks: ");
		numOfStndblock = in.nextInt();
		System.out.print("input number of small blocks: ");
		numOfSmlblock = in.nextInt();		
		
		bigblock = new BigBlock();
		System.out.print("set initial X position of bigblock : ");
		bigblock.positionX = in.nextInt();
		System.out.print("set initial Y position of bigblock : ");
		bigblock.positionY = in.nextInt();
		
		for(int i=0; i<numOfLyblock; i++) {
			lyblock[i] = new LongLyingBlock();
			System.out.print("set initial X position of lying block" + (i+1) +" :");
			lyblock[i].positionX = in.nextInt();
			System.out.print("set initial Y position of lying block" + (i+1) +" :");
			lyblock[i].positionY = in.nextInt();
		}
		for(int i = 0; i<numOfStndblock; i++) {
			stndblock[i] = new LongStandingBlock();
			System.out.print("set initial X position of stndblock" + (i+1) + " :");
			stndblock[i].positionX = in.nextInt();
			System.out.print("set initial Y position of stndblock" + (i+1) + " :");
			stndblock[i].positionY = in.nextInt();
		}
		for(int i=0; i<numOfSmlblock; i++) {
			smlblock[i] = new SmallBlock();
			System.out.print("set initial X position of smlblock" + (i+1) + " :");
			smlblock[i].positionX = in.nextInt();
			System.out.print("set initial Y position of smlblock" + (i+1) + " :");
			smlblock[i].positionY = in.nextInt();
		}
		in.close();
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
		
		//targetState.bigblock.name = bigblock.name;
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
		//targetState.setMap();
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
}
