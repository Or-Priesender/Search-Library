package searcher;

import java.util.Comparator;
import java.util.PriorityQueue;

import searchable.Searchable;
import sharedSearch.Solution;
import sharedSearch.State;

public class Dijkstra<T> extends AbstractSearcher<T>{
	
	//TODO: UNFINISHED 
	@Override
	public Solution search(Searchable<T> searchable) {
		
		PriorityQueue<State<T>> q = new PriorityQueue<>(new Comparator<State<T>>() { 
			@Override
			public int compare(State<T> o1, State<T> o2) {
				
				return (int) (o1.getCost()-o2.getCost());
			}
		});
		
		return null;
	}

	@Override
	public boolean pathExists(Searchable<T> searchable) {
		//TODO
		return false;
	}

}
