package test;



import java.util.List;

import searchable.Searchable;
import searcher.BFS;
import searcher.Searcher;
import sharedSearch.SearchAction;
import sharedSearch.Solution;

public class Main {

	public static void main(String[] args) {
		Searcher<Position> bfs = new BFS<>();
		Searchable<Position> maze = new Maze();
		Solution s = bfs.search(maze);
		List<SearchAction> list = s.getActions();
		for(SearchAction a : list)
			System.out.println(a.getName());
		System.out.println("Evaluated : " + bfs.getNumberOfNodesEvaluated());

	}

}
