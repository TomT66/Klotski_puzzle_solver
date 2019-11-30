import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solver {
	
	/*public int[] inputArgs() {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		System.out.print("plz input num of lyblocks: ");
		result.add(in.nextInt());		// result0 = Num of Lyblocks
		System.out.print("plz input num of stnblocks: ");
		result.add(in.nextInt());		//result1 = Num of Stnblocks
		System.out.print("plz input num of smlblocks: ");
		result.add(in.nextInt());		//result2 = Num of smlblocks
		
		System.out.print("plz input Xcoordinate of bigblock");
		result.add(in.nextInt());
		System.out.print("plz input Ycoordinate of bigblock");
		result.add(in.nextInt());		
		for(int x=0; x<result.get(0); x++) {
			System.out.print("plz input Xcoordinate of " + x + ". lyblock: ");
			result.add(in.nextInt());
			System.out.print("plz input Ycoordinate of " + x + ". lyblocks: ");
			result.add(in.nextInt());
		}
		for(int x=0; x<result.get(1); x++) {
			System.out.print("plz input Xcoordinate of " + x + ". stnblock: ");
			result.add(in.nextInt());
			System.out.print("plz input Ycoordinate of " + x + ". stnblocks: ");
			result.add(in.nextInt());
		}
		for(int x=0; x<result.get(2); x++) {
			System.out.print("plz input Xcoordinate of " + x + ". smlblock: ");
			result.add(in.nextInt());
			System.out.print("plz input Ycoordinate of " + x + ". smlblocks: ");
			result.add(in.nextInt());
		}
		in.close();
		return result.stream().mapToInt(i -> i).toArray();
	}*/
	
	//the frontend should send back a int array (length = 4x5=20) representing the puzzle state
	public int[] arrayToInputArgs(int[] args) {   //args.length == 20
		ArrayList<Integer> result = new ArrayList<Integer>();
		int lyBlockNum = 0, stnBlockNum = 0, smlBlockNum = 0;
		int BigblockPosX = 0, BigblockPosY = 0;
		ArrayList<Integer> lyblockPosArray = new ArrayList<Integer>();
		ArrayList<Integer> stnblockPosArray= new ArrayList<Integer>();
		ArrayList<Integer> smlblockPosArray = new ArrayList<Integer>();
		Set<Integer> skipSlots = new HashSet<Integer>();
		
		for(int i = 0 ; i < args.length ; i++) {
			if(!skipSlots.contains(i)) {
				switch(args[i]) {
				case 0:		break;
				case 1:		skipSlots.addAll(Arrays.asList(new Integer[]{i+1 , i+4 , i+5}));
							if(i < 4) {
								BigblockPosX = i;
								BigblockPosY = 0;
							}
							if(i >= 4 && i < 8) {
								BigblockPosX = i % 4;
								BigblockPosY = 1;
							}
							if(i >= 8 && i < 12) {
								BigblockPosX = i % 8;
								BigblockPosY = 2;
							}
							if(i >= 12 && i < 16) {
								BigblockPosX = i % 12;
								BigblockPosY = 3;
							}
							if(i >= 16 && i < 20) {
								BigblockPosX = i % 16;
								BigblockPosY = 4;
							}
							break;
				case 2:		lyBlockNum++; 
							skipSlots.add(i+1);
							if(i < 4) {
								lyblockPosArray.add(i);
								lyblockPosArray.add(0);
							}
							if(i >= 4 && i < 8) {
								lyblockPosArray.add(i % 4);
								lyblockPosArray.add(1);
							}
							if(i >= 8 && i < 12) {
								lyblockPosArray.add(i % 8);
								lyblockPosArray.add(2);
							}
							if(i >= 12 && i < 16) {
								lyblockPosArray.add(i % 12);
								lyblockPosArray.add(3);
							}
							if(i >= 16 && i < 20) {
								lyblockPosArray.add(i % 16);
								lyblockPosArray.add(4);
							}
							break;	
				case 3:		stnBlockNum++;	
							skipSlots.add(i+4);
							if(i < 4) {
								stnblockPosArray.add(i);
								stnblockPosArray.add(0);
							}
							if(i >= 4 && i < 8) {
								stnblockPosArray.add(i % 4);
								stnblockPosArray.add(1);
							}
							if(i >= 8 && i < 12) {
								stnblockPosArray.add(i % 8);
								stnblockPosArray.add(2);
							}
							if(i >= 12 && i < 16) {
								stnblockPosArray.add(i % 12);
								stnblockPosArray.add(3);
							}
							if(i >= 16 && i < 20) {
								stnblockPosArray.add(i % 16);
								stnblockPosArray.add(4);
							}
							break;
				case 4: 	smlBlockNum++;
							if(i < 4) {
								smlblockPosArray.add(i);
								smlblockPosArray.add(0);
							}
							if(i >= 4 && i < 8) {
								smlblockPosArray.add(i % 4);
								smlblockPosArray.add(1);
							}
							if(i >= 8 && i < 12) {
								smlblockPosArray.add(i % 8);
								smlblockPosArray.add(2);
							}
							if(i >= 12 && i < 16) {
								smlblockPosArray.add(i % 12);
								smlblockPosArray.add(3);
							}
							if(i >= 16 && i < 20) {
								smlblockPosArray.add(i % 16);
								smlblockPosArray.add(4);
							}
							break;
				}
			}
		}
		result.add(lyBlockNum);
		result.add(stnBlockNum);
		result.add(smlBlockNum);
		result.add(BigblockPosX);
		result.add(BigblockPosY);
		result.addAll(lyblockPosArray);
		result.addAll(stnblockPosArray);
		result.addAll(smlblockPosArray);
		
		return result.stream().mapToInt(i -> i).toArray();
	}
	
	public ArrayList<int[]> bruteforceStrate(){
		ArrayList<int[]> resultToFront = new ArrayList(); 
		
		int flag = 2;    // 1 means solved, 0 means not solved
		ArrayList<State> states = new ArrayList<State>();
		@SuppressWarnings("rawtypes")
		Set<ArrayList> mapSet = new HashSet<ArrayList>();
		State temp = new State();
		State state0 = new State();
		
		//state0.initialBlocks(new int[]{1,4,4,1,0,1,2,0,0,3,0,0,2,3,2,0,4,1,3,2,3,3,4}); //the classic klotski
		state0.initialBlocks(arrayToInputArgs(new int[] {3,1,1,3,3,1,1,3,3,2,2,3,3,4,4,3,4,0,0,4}));
		//state0.initialBlocks(inputArgs());		//user inputs his own Klotski puzzle
		long startTime = System.currentTimeMillis();
		state0.setMap();
		states.add(state0);
		mapSet.add(state0.mapToArrayList());
		
		System.out.println("start solving with bruteforce strategy...");
		for(int i=0; i<500000; i++) {
			if(i == states.size()) {
				System.out.println("the puzzle is unsolvabe.");
				break;
			}
			if(flag == 1) break;
			//bigblock move posibility, detector tells if it is able to go up/down/left/right,  
			//a new state is stored in "states" if same map hasn't been searched
			switch(states.get(i).bigblock.moveDetector(states.get(i).map)) {
			case "up":		states.get(i).assign(temp);
							temp.bigblock.moveUp();
							temp.setMap();
							if(!mapSet.contains(temp.mapToArrayList())) {
								State state = new State();
								temp.assign(state);
								state.preStateNr = i;
								states.add(state);
								mapSet.add(state.mapToArrayList());
							}
							break;
			case "down":	states.get(i).assign(temp);
							temp.bigblock.moveDown();
							temp.setMap();
							if(!mapSet.contains(temp.mapToArrayList())) {
								State state = new State();
								temp.assign(state);
								state.preStateNr = i;
								states.add(state);
								mapSet.add(state.mapToArrayList());
							}
							break;
			case "left":	states.get(i).assign(temp);
							temp.bigblock.moveLeft();
							temp.setMap();
							if(!mapSet.contains(temp.mapToArrayList())) {
								State state = new State();
								temp.assign(state);
								state.preStateNr = i;
								states.add(state);
								mapSet.add(state.mapToArrayList());
							}
							break;
			case "right":	states.get(i).assign(temp);
							temp.bigblock.moveRight();
							temp.setMap();
							if(!mapSet.contains(temp.mapToArrayList())) {
								State state = new State();
								temp.assign(state);
								state.preStateNr = i;
								states.add(state);
								mapSet.add(state.mapToArrayList());
							}break;
			}
			//bigblock move posibility
			//longlyingblocks move posibility
			for(int id=0; id<states.get(i).numOfLyblock; id++) {
				switch(states.get(i).lyblock[id].upddownDetector(states.get(i).map)) {
				case "up":		states.get(i).assign(temp);
								temp.lyblock[id].moveUp();
								temp.setMap();
								if(!mapSet.contains(temp.mapToArrayList())) {
									State state = new State();
									temp.assign(state);
									state.preStateNr = i;
									states.add(state);
									mapSet.add(state.mapToArrayList());
								}
								break;
				case "down":	states.get(i).assign(temp);
								temp.lyblock[id].moveDown();
								temp.setMap();
								if(!mapSet.contains(temp.mapToArrayList())) {
									State state = new State();
									temp.assign(state);
									state.preStateNr = i;
									states.add(state);
									mapSet.add(state.mapToArrayList());
								}
								break;	
				}
				if(states.get(i).lyblock[id].rightDetector(states.get(i).map) == "right") {
					states.get(i).assign(temp);
					temp.lyblock[id].moveRight();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
				if(states.get(i).lyblock[id].leftDetector(states.get(i).map) == "left") {
					states.get(i).assign(temp);
					temp.lyblock[id].moveLeft();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
			}
			//longlyingblocks move posibility
			//longstandingblocks move posibility
			for(int id=0; id<states.get(i).numOfStndblock; id++) {
				switch(states.get(i).stndblock[id].leftrightDetector(states.get(i).map)) {
				case "left":	states.get(i).assign(temp);
								temp.stndblock[id].moveLeft();
								temp.setMap();
								if(!mapSet.contains(temp.mapToArrayList())) {
									State state = new State();
									temp.assign(state);
									state.preStateNr = i;
									states.add(state);
									mapSet.add(state.mapToArrayList());
								}
								break;
				case "right":	states.get(i).assign(temp);
								temp.stndblock[id].moveRight();
								temp.setMap();
								if(!mapSet.contains(temp.mapToArrayList())) {
									State state = new State();
									temp.assign(state);
									state.preStateNr = i;
									states.add(state);
									mapSet.add(state.mapToArrayList());
								}
								break;
				}
				if(states.get(i).stndblock[id].upDetector(states.get(i).map) == "up") {
					states.get(i).assign(temp);
					temp.stndblock[id].moveUp();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
				if(states.get(i).stndblock[id].downDetector(states.get(i).map) == "down") {
					states.get(i).assign(temp);
					temp.stndblock[id].moveDown();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
			}//longstandingblocks move posibility
			//smallblock move posibility
			for(int id=0; id<states.get(i).numOfSmlblock; id++) {
				if(states.get(i).smlblock[id].upDetector(states.get(i).map) == "up") {
					states.get(i).assign(temp);
					temp.smlblock[id].moveUp();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
				if(states.get(i).smlblock[id].downDetector(states.get(i).map) == "down") {
					states.get(i).assign(temp);
					temp.smlblock[id].moveDown();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
				if(states.get(i).smlblock[id].rightDetector(states.get(i).map) == "right") {
					states.get(i).assign(temp);
					temp.smlblock[id].moveRight();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
				if(states.get(i).smlblock[id].leftDetector(states.get(i).map) == "left") {
					states.get(i).assign(temp);
					temp.smlblock[id].moveLeft();
					temp.setMap();
					if(!mapSet.contains(temp.mapToArrayList())) {
						State state = new State();
						temp.assign(state);
						state.preStateNr = i;
						states.add(state);
						mapSet.add(state.mapToArrayList());
					}
				}
			}//smallblock move posibility
			//check if bigblock reaches the escape point, yes->show and break, not->continue
			for(int m=i ;m<states.size() ;m++) {
				if(states.get(m).bigblock.positionX==1 && states.get(m).bigblock.positionY==3) {
					int step = 0;
					int index = states.get(m).preStateNr;
					states.get(m).showStateMap();
					resultToFront.add(states.get(m).mapToIntArray());
					System.out.println(" ");
					while(index!=0) {
						step++;
						System.out.println("upward¡ü");
						states.get(index).showStateMap();
						resultToFront.add(states.get(index).mapToIntArray());
						System.out.println(" ");
						index = states.get(index).preStateNr;
					}
					System.out.println("upward¡ü");
					states.get(0).showStateMap();
					resultToFront.add(states.get(0).mapToIntArray());
					flag = 1;
					System.out.println("shortest solution needs "+ ++step +" steps");
					System.out.println(i + " states searched!");
					break;
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("searching took " + (endTime - startTime) + " milliseconds");
		Collections.reverse(resultToFront);
		return resultToFront;
		
	}// end of bruteforceStrat

	public static void main(String[] args){
		Solver solver = new Solver();
		ArrayList<int[]> toFront = solver.bruteforceStrate();
		int i = 0;
		for(int[] value1 : toFront) {
			System.out.println(i++);
			for(int value2 : value1) {
				System.out.print(value2 + ", ");
			}
			System.out.println();
		}
	}
}
