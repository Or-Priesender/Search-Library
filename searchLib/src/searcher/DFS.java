package searcher;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

import searchable.Searchable;
import sharedSearch.SearchAction;
import sharedSearch.Solution;
import sharedSearch.State;

/**
 * Implementation of the classic DFS algorithm.
 * @author Or Priesender
 *
 * @param <T>
 */
public class DFS<T> extends AbstractSearcher<T> {
	
	/**
	 * Search any search problem with DFS.
	 */
	@Override
	public Solution search(Searchable<T> s) {
		HashSet<State<T>> visited = new HashSet<>(); 
		
		Stack<State<T>> stack = new Stack<>();
		State<T> state = s.getInitialState();
		stack.push(state);
		
		while (!stack.isEmpty()) {
			State<T> currState = stack.pop();
			
			if (currState.equals(s.getGoalState()))
				return backtrace(currState);
			
			if (!visited.contains(currState)) {
				visited.add(currState);
				
				HashMap<SearchAction, State<T>> map = s.getAllPossibleMoves(currState);							
				
				for (SearchAction a : map.keySet()) {
					State<T> n = map.get(a);
					
					if (!visited.contains(n)) {
						stack.push(n);
						n.setCameFrom(currState);
						n.setAction(a);
					}					
				}
			}
		}
		return null;
	}

	/**
	 * Returns true if the path exists, not returning the solution.
	 */
	@Override
	public boolean pathExists(Searchable<T> searchable) {
		Solution s = this.search(searchable);
		if(s!=null) return true;
		else return false;
	}

}
