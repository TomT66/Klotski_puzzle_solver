public class Solver {

	public static void main(String[] args) {
		int flag = 2;
		State[] state = new State[100000];
		for(int i=0; i<100000; i++) {
			state[i] = new State();
			for(int j=0; j<4; j++) {
				state[i].smlblock[j] = new SmallBlock();
				state[i].stndblock[j] = new LongStandingBlock();
			}
		}
		State temp = new State();
		for(int i=0; i<4; i++) {
			temp.stndblock[i] = new LongStandingBlock();
			temp.smlblock[i] = new SmallBlock();
		}
		int stateNr = 0;
		state[0].initialBlocks();
		state[0].setMap();

		for(int i=0; i<50000; i++) {
			if(flag ==3) break;
			//bigblock move posibility
			switch(state[i].bigblock.moveDetector(state[i].map)) {		
			case "up":		state[i].assign(temp);
							temp.bigblock.moveUp();
							temp.setMap();
							
							for(int j=0; j<stateNr; j++) {		
								if(temp.mapEqual(state[j]) == 1) {
									flag = 0;
								}
							}
							if(flag != 0) {
								state[i].assign(state[++stateNr]);
								state[stateNr].bigblock.moveUp();
								
								state[stateNr].setMap();
						//		state[stateNr].showStateMap();
								state[stateNr].preStateNr = i;
							}
							flag = 1;
							break;
			case"down":		state[i].assign(temp);
							temp.bigblock.moveDown();
							temp.setMap();
							
							for(int j=0; j<stateNr; j++) {		
								if(temp.mapEqual(state[j]) == 1) {
									flag = 0;
								}
							}
							if(flag != 0) {
								state[i].assign(state[++stateNr]);
								state[stateNr].bigblock.moveDown();
								
								state[stateNr].setMap();
							//	state[stateNr].showStateMap();
								state[stateNr].preStateNr = i;
							}
							flag = 1;
							break;
			case"right":	state[i].assign(temp);
							temp.bigblock.moveRight();
							temp.setMap();
							for(int j=0; j<stateNr; j++) {		
								if(temp.mapEqual(state[j]) == 1) {
									flag = 0;
								}
							}
							if(flag != 0) {
								state[i].assign(state[++stateNr]);
								state[stateNr].bigblock.moveRight();
							
								state[stateNr].setMap();
						//		state[stateNr].showStateMap();
								state[stateNr].preStateNr = i;
							}
							flag = 1;
							break;
			case"left":		state[i].assign(temp);
							temp.bigblock.moveLeft();
							temp.setMap();
							for(int j=0; j<stateNr; j++) {		
								if(temp.mapEqual(state[j]) == 1) {
									flag = 0;
								}
							}
							if(flag != 0) {
								state[i].assign(state[++stateNr]);
								state[stateNr].bigblock.moveLeft();
								
								state[stateNr].setMap();
					//			state[stateNr].showStateMap();
								state[stateNr].preStateNr = i;
							}
							flag = 1;
							break;							
			}
			//longlyingblock move posibility
			switch(state[i].lyblock.upddownDetector(state[i].map)) {
			case "up":		state[i].assign(temp);
							temp.lyblock.moveUp();
							temp.setMap();
							for(int j=0; j<stateNr; j++) {		
								if(temp.mapEqual(state[j]) == 1) {
									flag = 0;
								}
							}
							if(flag != 0) {
								state[i].assign(state[++stateNr]);
								state[stateNr].lyblock.moveUp();
								
								state[stateNr].setMap();
						//		state[stateNr].showStateMap();
								state[stateNr].preStateNr = i;
							}
							flag = 1;
							break;
			case"down":		state[i].assign(temp);
							temp.lyblock.moveDown();
							temp.setMap();
							for(int j=0; j<stateNr; j++) {		
								if(temp.mapEqual(state[j]) == 1) {
									flag = 0;
								}
							}
							if(flag != 0) {
								state[i].assign(state[++stateNr]);
								state[stateNr].lyblock.moveDown();
								
								state[stateNr].setMap();
						//		state[stateNr].showStateMap();
								state[stateNr].preStateNr = i;
							}
							flag = 1;
							break;
			}
			if(state[i].lyblock.rightDetector(state[i].setMap()) == "right") {
				state[i].assign(temp);
				temp.lyblock.moveRight();
				temp.setMap();
				for(int j=0; j<stateNr; j++) {		
					if(temp.mapEqual(state[j]) == 1) {
						flag = 0;
					}
				}
				if(flag != 0) {
					state[i].assign(state[++stateNr]);
					state[stateNr].lyblock.moveRight();
				
					state[stateNr].setMap();
				//	state[stateNr].showStateMap();
					state[stateNr].preStateNr = i;
				}
				flag = 1;
			}
			if(state[i].lyblock.leftDetector(state[i].setMap()) == "left") {
				state[i].assign(temp);
				temp.lyblock.moveLeft();
				temp.setMap();
				for(int j=0; j<stateNr; j++) {		
					if(temp.mapEqual(state[j]) == 1) {
						flag = 0;
					}
				}
				if(flag != 0) {
					state[i].assign(state[++stateNr]);
					state[stateNr].lyblock.moveLeft();
					
					state[stateNr].setMap();
			//		state[stateNr].showStateMap();
					state[stateNr].preStateNr = i;
				}
				flag = 1;
			}
			//longstandingblock move posibility
			for(int id=0; id<4; id++) {
				switch(state[i].stndblock[id].leftrightDetector(state[i].setMap())) {
				case"left":		state[i].assign(temp);
								temp.stndblock[id].moveLeft();
								temp.setMap();
								for(int j=0; j<stateNr; j++) {		
									if(temp.mapEqual(state[j]) == 1) {
										flag = 0;
									}
								}
								if(flag != 0) {
									state[i].assign(state[++stateNr]);
									state[stateNr].stndblock[id].moveLeft();
									
									state[stateNr].setMap();
							//		state[stateNr].showStateMap();
									state[stateNr].preStateNr = i;
								}
								flag = 1;
								break;
				case"right":	state[i].assign(temp);
								temp.stndblock[id].moveRight();
								temp.setMap();
								for(int j=0; j<stateNr; j++) {		
									if(temp.mapEqual(state[j]) == 1) {
										flag = 0;
									}
								}
								if(flag != 0) {
									state[i].assign(state[++stateNr]);
									state[stateNr].stndblock[id].moveRight();
									
									state[stateNr].setMap();
						//			state[stateNr].showStateMap();
									state[stateNr].preStateNr = i;
								}
								flag = 1;
								break;
				}
				if(state[i].stndblock[id].upDetector(state[i].setMap()) == "up") {
					state[i].assign(temp);
					temp.stndblock[id].moveUp();
					temp.setMap();
					for(int j=0; j<stateNr; j++) {		
						if(temp.mapEqual(state[j]) == 1) {
							flag = 0;
						}
					}
					if(flag != 0) {
						state[i].assign(state[++stateNr]);
						state[stateNr].stndblock[id].moveUp();
						
						state[stateNr].setMap();
					//	state[stateNr].showStateMap();
						state[stateNr].preStateNr = i;
					}
					flag = 1;
				}
				if(state[i].stndblock[id].downDetector(state[i].setMap()) == "down") {
					state[i].assign(temp);
					temp.stndblock[id].moveDown();
					temp.setMap();
					for(int j=0; j<stateNr; j++) {		
						if(temp.mapEqual(state[j]) == 1) {
							flag = 0;
						}
					}
					if(flag != 0) {
						state[i].assign(state[++stateNr]);
						state[stateNr].stndblock[id].moveDown();
						
						state[stateNr].setMap();
				//		state[stateNr].showStateMap();
						state[stateNr].preStateNr = i;
					}
					flag = 1;
				}
			}
			//smallblock move posibility
			for(int id=0; id<4; id++) {
				if(state[i].smlblock[id].upDetector(state[i].setMap()) == "up") {
					state[i].assign(temp);
					temp.smlblock[id].moveUp();
					temp.setMap();
					for(int j=0; j<stateNr; j++) {		
						if(temp.mapEqual(state[j]) == 1) {
							flag = 0;
						}
					}
					if(flag != 0) {
						state[i].assign(state[++stateNr]);
						state[stateNr].smlblock[id].moveUp();
						
						state[stateNr].setMap();
			//			state[stateNr].showStateMap();
						state[stateNr].preStateNr = i;
					}
					flag = 1;
				}
				if(state[i].smlblock[id].downDetector(state[i].setMap()) == "down") {
					state[i].assign(temp);
					temp.smlblock[id].moveDown();
					temp.setMap();
					for(int j=0; j<stateNr; j++) {		
						if(temp.mapEqual(state[j]) == 1) {
							flag = 0;
						}
					}
					if(flag != 0) {
						state[i].assign(state[++stateNr]);
						state[stateNr].smlblock[id].moveDown();
						
						state[stateNr].setMap();
			//			state[stateNr].showStateMap();
						state[stateNr].preStateNr = i;
					}
					flag = 1;
				}
				if(state[i].smlblock[id].rightDetector(state[i].setMap()) == "right") {
					state[i].assign(temp);
					temp.smlblock[id].moveRight();
					temp.setMap();
					for(int j=0; j<stateNr; j++) {		
						if(temp.mapEqual(state[j]) == 1) {
							flag = 0;
						}
					}
					if(flag != 0) {
						state[i].assign(state[++stateNr]);
						state[stateNr].smlblock[id].moveRight();
						
						state[stateNr].setMap();
				//		state[stateNr].showStateMap();
						state[stateNr].preStateNr = i;
					}
					flag = 1;
				}
				if(state[i].smlblock[id].leftDetector(state[i].setMap()) == "left") {
					state[i].assign(temp);
					temp.smlblock[id].moveLeft();
					temp.setMap();
					for(int j=0; j<stateNr; j++) {		
						if(temp.mapEqual(state[j]) == 1) {
							flag = 0;
						}
					}
					if(flag != 0) {
						state[i].assign(state[++stateNr]);
						state[stateNr].smlblock[id].moveLeft();
						
						state[stateNr].setMap();
			//			state[stateNr].showStateMap();
						state[stateNr].preStateNr = i;
					}
					flag = 1;
				}
			}
			//check if bigblock reaches the escape point, yes->show and break, not->continue
			for(int m=i;m<=stateNr;m++) {
				if(state[m].bigblock.positionX==1 && state[m].bigblock.positionY==3) {
					int step = 0;
					int index = state[m].preStateNr;
					state[m].showStateMap();
					System.out.println(" ");
					while(index!=0) {
						step++;
						System.out.println("upward¡ü");
						state[index].showStateMap();
						System.out.println(" ");
						index = state[index].preStateNr;
					}
					step++;
					state[0].showStateMap();
					flag = 3;
					System.out.println(i);
					System.out.println("solved after "+step+" steps");
					System.out.println(i);
					break;
				}
			}
		}
		System.out.println("finish");
	}
}
