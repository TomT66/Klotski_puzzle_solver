import java.util.Scanner;

public class State {
	public int[][] map = new int[4][5];
	public int preStateNr = 0;
	public int nextStateNr = 0;
	int totalStates = 0;
	
	BigBlock bigblock = new BigBlock();
	LongLyingBlock lyblock = new LongLyingBlock();
	LongStandingBlock[] stndblock = new LongStandingBlock[4];
	SmallBlock[] smlblock = new SmallBlock[4];
	
	public void initialBlocks() {
		for(int i=0; i<4; i++) {
			stndblock[i] = new LongStandingBlock();
			smlblock[i] = new SmallBlock();
		}
		
		bigblock.name = "bigblock";
		lyblock.name = "lyingblock";
		stndblock[0].name = "standingblock1";
		stndblock[1].name = "standingblock2";
		stndblock[2].name = "standingblock3";
		stndblock[3].name = "standingblock4";
		smlblock[0].name = "smallblock1";
		smlblock[1].name = "smallblock2";
		smlblock[2].name = "smallblock3";
		smlblock[3].name = "smallblock4";
		
		Scanner in = new Scanner(System.in);
		
		System.out.print("set initial X position of bigblock : ");
		bigblock.positionX = in.nextInt();
		System.out.print("set initial Y position of bigblock : ");
		bigblock.positionY = in.nextInt();
		
		System.out.print("set initial X position of lyingblock : ");
		lyblock.positionX = in.nextInt();
		System.out.print("set initial Y position of lyingblock : ");
		lyblock.positionY = in.nextInt();
		
		for(int i = 0; i<4; i++) {
			System.out.print("set initial X position of " + stndblock[i].name + " :");
			stndblock[i].positionX = in.nextInt();
			System.out.print("set initial Y position of " + stndblock[i].name + " :");
			stndblock[i].positionY = in.nextInt();
		}

		for(int i=0; i<4; i++) {
			System.out.print("set initial X position of " + smlblock[i].name + " :");
			smlblock[i].positionX = in.nextInt();
			System.out.print("set initial Y position of " + smlblock[i].name + " :");
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
		
		map[lyblock.positionX][lyblock.positionY] = 2;
		map[lyblock.positionX+1][lyblock.positionY] = 2;
		
		map[stndblock[0].positionX][stndblock[0].positionY] = 3;
		map[stndblock[0].positionX][stndblock[0].positionY+1] = 3;
		map[stndblock[1].positionX][stndblock[1].positionY] = 3;
		map[stndblock[1].positionX][stndblock[1].positionY+1] = 3;
		map[stndblock[2].positionX][stndblock[2].positionY] = 3;
		map[stndblock[2].positionX][stndblock[2].positionY+1] = 3;
		map[stndblock[3].positionX][stndblock[3].positionY] = 3;
		map[stndblock[3].positionX][stndblock[3].positionY+1] = 3;
		
		map[smlblock[0].positionX][smlblock[0].positionY] = 4;
		map[smlblock[1].positionX][smlblock[1].positionY] = 4;
		map[smlblock[2].positionX][smlblock[2].positionY] = 4;
		map[smlblock[3].positionX][smlblock[3].positionY] = 4;
		
		return map;
	}
	
	public void showStateMap() {
		for(int i=0; i<5; i++) {
			System.out.println(map[0][i] + " " + map[1][i] + " " + map[2][i] + " " + map[3][i]);
		}
	}
	
	public void assign(State targetState) {		
		targetState.bigblock.name = bigblock.name;
		targetState.bigblock.positionX = bigblock.positionX;
		targetState.bigblock.positionY = bigblock.positionY;
		
		targetState.lyblock.name = lyblock.name;
		targetState.lyblock.positionX = lyblock.positionX;
		targetState.lyblock.positionY = lyblock.positionY;
		
		for(int i=0;i<4;i++) {
			targetState.smlblock[i].name = smlblock[i].name;
			targetState.smlblock[i].positionX = smlblock[i].positionX;
			targetState.smlblock[i].positionY = smlblock[i].positionY;
			
			targetState.stndblock[i].name = stndblock[i].name;
			targetState.stndblock[i].positionX = stndblock[i].positionX;
			targetState.stndblock[i].positionY = stndblock[i].positionY;
		}
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
