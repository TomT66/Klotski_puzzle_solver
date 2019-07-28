import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solver {
	
	public int[] inputArgs() {
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> result = new ArrayList<Integer>();
		
		System.out.print("plz input num of lyblocks: ");
		int numoflyblocks = in.nextInt();
		result.add(numoflyblocks);
		System.out.print("plz input num of stnblocks: ");
		int numofstnblocks = in.nextInt();
		result.add(numofstnblocks);
		System.out.print("plz input num of smlblocks: ");
		int numofsmlblocks = in.nextInt();
		result.add(numofsmlblocks);
		
		System.out.print("plz input Xcoordinate of bigblock");
		result.add(in.nextInt());
		System.out.print("plz input Ycoordinate of bigblock");
		result.add(in.nextInt());
		
		for(int x=0; x<numoflyblocks; x++) {
			System.out.print("plz input Xcoordinate of " + x + ". lyblock: ");
			result.add(in.nextInt());
			System.out.print("plz input Ycoordinate of " + x + ". lyblocks: ");
			result.add(in.nextInt());
		}
		for(int x=0; x<numofstnblocks; x++) {
			System.out.print("plz input Xcoordinate of " + x + ". stnblock: ");
			result.add(in.nextInt());
			System.out.print("plz input Ycoordinate of " + x + ". stnblocks: ");
			result.add(in.nextInt());
		}
		for(int x=0; x<numofsmlblocks; x++) {
			System.out.print("plz input Xcoordinate of " + x + ". smlblock: ");
			result.add(in.nextInt());
			System.out.print("plz input Ycoordinate of " + x + ". smlblocks: ");
			result.add(in.nextInt());
		}
		in.close();
		return result.stream().mapToInt(i -> i).toArray();
	}
	
	public void bruteforceStrate(){
		int flag = 2;    // 1 means solved, 0 means not solved
		ArrayList<State> states = new ArrayList<State>();
		@SuppressWarnings("rawtypes")
		Set<ArrayList> mapSet = new HashSet<ArrayList>();
		State temp = new State();
		State state0 = new State();
		
		state0.initialBlocks(new int[]{1,4,4,1,0,1,2,0,0,3,0,0,2,3,2,0,4,1,3,2,3,3,4,}); //the classic klotski
		//state0.initialBlocks(inputArgs());		//user inputs his own Klotski puzzle
		long startTime = System.currentTimeMillis();
		state0.setMap();
		states.add(state0);
		mapSet.add(state0.mapToArrayList());
		
		System.out.println("start solving with bruteforce strategy...");
		for(int i=0; i<500000; i++) {
			if(i == states.size()) System.out.println("the puzzle is unsolvabe.");
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
					System.out.println(" ");
					while(index!=0) {
						step++;
						System.out.println("upward¡ü");
						states.get(index).showStateMap();
						System.out.println(" ");
						index = states.get(index).preStateNr;
					}
					System.out.println("upward¡ü");
					states.get(0).showStateMap();
					flag = 1;
					System.out.println("shortest solution needs "+ ++step +" steps");
					System.out.println(i + " states searched!");
					break;
				}	
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("searching took " + (endTime - startTime) + " milliseconds");
	}// end of bruteforceStrat

	public static void main(String[] args){
		Solver solver = new Solver();
		solver.bruteforceStrate();
	}
}
