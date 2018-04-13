public class MazeSolver{
	
	Maze candidate;
	
	/**
	Create a maze
	*/
	public MazeSolver(Maze mazeToSolve){
		candidate = mazeToSolve;
	}
	
	/**
	Maze Solver
	*/
	public boolean solve(){
		//System.out.println("here we go" + System.lineSeparator() + candidate);
		//System.out.println(candidate.explorerIsOnA() == Maze.TREASURE);
		//System.out.println("snapshot below" + System.lineSeparator());
		
		if (candidate.explorerIsOnA() == Maze.WALL){}
		
		else if (candidate.explorerIsOnA() == Maze.TREASURE){
			return true;
		}

		else {		
			Maze snapshot = new Maze(candidate);
						
			candidate.dropA(Maze.WALL);
			candidate.go(Maze.EAST);
			if (solve()) return true;
			
			candidate = new Maze(snapshot);
			candidate.dropA(Maze.WALL);
			candidate.go(Maze.NORTH);
			if (solve()) return true;
			
			candidate = new Maze(snapshot);
			candidate.dropA(Maze.WALL);
			candidate.go(Maze.WEST);
			if (solve()) return true;
			
			candidate = new Maze(snapshot);
			candidate.dropA(Maze.WALL);
			candidate.go(Maze.SOUTH);
			if (solve()) return true;
			
			else {
				candidate = new Maze(snapshot);
				candidate.dropA(Maze.WALL);
				if (solve()) return true;
			}			
			
		}
	
		return false;
	}
}