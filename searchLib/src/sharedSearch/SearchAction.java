package sharedSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines a search action, which can have mini actions that go along with it.
 * @author Or Priesender
 *
 */
public class SearchAction {

	private String name;
	private List<SearchAction> miniActions = new ArrayList<>();
	
	

	public List<SearchAction> getMiniActions() {
		return miniActions;
	}

	public void setMiniActions(List<SearchAction> miniActions) {
		this.miniActions = miniActions;
	}

	public SearchAction(String name){
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public boolean equals(Object obj) {
		SearchAction a = (SearchAction) obj;
		
		return this.name.equals(a.getName());
	}
	
	@Override
	public int hashCode() {
		
		return name.hashCode();
	}
	
	@Override
	public String toString() {
		
		return this.name;
	}
}
