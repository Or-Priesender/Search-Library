package searcher;

import java.util.LinkedList;
import sharedSearch.SearchAction;
import sharedSearch.Solution;
import sharedSearch.State;

/**
 * Implements non-specific methods for any searcher.
 * @author Or Priesender
 *
 * @param <T>
 */
public abstract class AbstractSearcher<T> implements Searcher<T> {
	int numberOfNodesEvaluated = 0;
	SearchAction last=null;

	@Override
	public int getNumberOfNodesEvaluated() {

		return numberOfNodesEvaluated;
	}

	/**
	 * Back trace from goal state to initial state
	 * @param goalState
	 * @return solution of the search problem
	 */
	Solution backtrace(State<T> goalState){
		LinkedList<SearchAction> actions = new LinkedList<>();
		State<T> current = goalState;

		while(current.getCameFrom() != null){
			SearchAction a = current.getAction();
			actions.add(a);
			if(a.getMiniActions()!=null)
				actions.addAll(a.getMiniActions());
			current = current.getCameFrom();	
		}
		return new Solution(actions);

	}


}
