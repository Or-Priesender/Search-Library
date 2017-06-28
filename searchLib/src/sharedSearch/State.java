package sharedSearch;

/**
 * Defines a search state. Can be any kind of state, for example: graph node, maze location, etc.
 * @author Or Priesender
 *
 * @param <T>
 */
public class State<T>  {

	private T state;
	private State<T> cameFrom;
	private SearchAction action;


	private double cost=0;
	
	public State(T state) {
		this.state = state;
		
	}
	
	public T getState() {
		return state;
	}
	public void setState(T state) {
		this.state = state;
	}
	public State<T> getCameFrom() {
		return cameFrom;
	}
	public void setCameFrom(State<T> cameFrom) {
		this.cameFrom = cameFrom;
	}
	public SearchAction getAction() {
		return action;
	}
	public void setAction(SearchAction action) {
		this.action = action;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString() {
		
		return state.toString();
	}
	@Override
	public int hashCode() {
		
		return state.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		State<T> s = (State<T>) obj;
		return this.state.equals(s.state);
	}

	
	
	
}
