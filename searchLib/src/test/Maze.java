package test;

import java.util.HashMap;

import searchable.Searchable;
import sharedSearch.SearchAction;
import sharedSearch.State;

public class Maze implements Searchable<Position>{

	char[][] maze = 
		{{'#','#','#','#','#','#','#','#'},
			{'#','#','A','#','#','#','#','#'},
			{'#','#',' ',' ',' ','G','#','#'},
			{'#','#',' ','#','#','#','#','#'},
			{'#','#','#','#','#','#','#','#'}};
	

	@Override
	public State<Position> getInitialState() {
		for(int i = 0;i<maze.length;i++){
			for(int j=0;j<maze[i].length;j++)
				if(maze[i][j]=='A')
					return new State<Position>(new Position(i,j));
		}
		return null;
	}

	@Override
	public State<Position> getGoalState() {
		for(int i = 0;i<maze.length;i++){
			for(int j=0;j<maze[i].length;j++)
				if(maze[i][j]=='G')
					return new State<Position>(new Position(i,j));
		}
		return null;
	}

	@Override
	public HashMap<SearchAction, State<Position>> getAllPossibleMoves(State<Position> current) {
		HashMap<SearchAction,State<Position>> map = new HashMap<>();
		Position pos = current.getState();
		int i = pos.col;
		int j = pos.row;
		
		
		
		if(maze[i-1][j]!='#'){
			map.put(new SearchAction("MoveUp"), new State<Position>(new Position(i-1,j)));
		}
		if(maze[i+1][j]!='#'){
			map.put(new SearchAction("MoveDown"), new State<Position>(new Position(i+1,j)));
		}
		if(maze[i][j-1]!='#'){
			map.put(new SearchAction("MoveLeft"), new State<Position>(new Position(i,j-1)));
		}
		if(maze[i][j+1]!='#'){
			map.put(new SearchAction("MoveRight"), new State<Position>(new Position(i,j+1)));
		}	
		return map;
		
			
	}
	
	
}
