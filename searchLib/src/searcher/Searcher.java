package searcher;

import searchable.Searchable;
import sharedSearch.Solution;

/**
 * Defines a searcher behavior.
 * @author Or Priesender
 *
 * @param <T>
 */
public interface Searcher<T> {
Solution search(Searchable<T> searchable);
int getNumberOfNodesEvaluated();
boolean pathExists(Searchable<T> searchable);
}
