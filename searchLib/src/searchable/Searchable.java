package searchable;

import java.util.HashMap;

import sharedSearch.SearchAction;
import sharedSearch.State;

/**
 * Defines a general searchable problem behavior.
 * @author Or Priesender
 *
 * @param <T>
 */
public interface Searchable<T> {
	State<T> getInitialState();
	State<T> getGoalState();
	HashMap<SearchAction,State<T>> getAllPossibleMoves(State<T> current);
}
