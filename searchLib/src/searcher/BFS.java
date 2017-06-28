package searcher;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;

import searchable.Searchable;
import sharedSearch.SearchAction;
import sharedSearch.Solution;
import sharedSearch.State;

/**
 * General BestFS implementation using a priority queue.
 * @author Or Priesender
 *
 * @param <T>
 */
public class BFS<T> extends AbstractSearcher<T> {

	/**
	 * Search method to search any searchable problem with required behavior.
	 */
	@Override
	public Solution search(Searchable<T> s) {

		Queue<State<T>> open=new PriorityQueue<>(new Comparator<State<T>>() {
			
			@Override
			public int compare(State<T> o1, State<T> o2) {
				return (int)(o1.getCost()-o2.getCost());
			}
		});//staes to be evaluated
		HashSet<State<T>> closed = new HashSet<>(); //Evaluated states
		State<T> state=s.getInitialState();
		State<T> goalState = s.getGoalState();
			open.add(state);
		while(!open.isEmpty()){
			State<T> currstate=open.poll();//remove the best node according to cost


			if(goalState.equals(currstate))
			{

				return backtrace(currstate);
			}
			if(!closed.contains(currstate)){
			HashMap<SearchAction, State<T>> map=s.getAllPossibleMoves(currstate);
			for (SearchAction a : map.keySet()) {
				State<T> n=map.get(a);

				if((!closed.contains(n)&&(!open.contains(n)))){
					n.setCameFrom(currstate);
					n.setAction(a);
					
					n.setCost(currstate.getCost()+1);
					numberOfNodesEvaluated++;
					open.add(n);



				}
				else{
					if(!open.contains(n)){
						
						if(n.getCost()>currstate.getCost()+1){
							n.setAction(a);
							n.setCameFrom(currstate);
							n.setCost(currstate.getCost()+1);
													}
					}
					else{
						open.remove(n);
						n.setAction(a);
						n.setCameFrom(currstate);
						n.setCost(currstate.getCost()+1);
						open.add(n);

					}

				}
			}

		}
			closed.add(currstate);
		}
		return null;

	}
	

	/**
	 * Returns true if there is a solution for the given problem, not returning the solution.
	 */
	@Override
	public boolean pathExists(Searchable<T> searchable) {
		Solution s = search(searchable);
		if(s==null)
			return false;
		else return true;
	}

	

	
	
}
