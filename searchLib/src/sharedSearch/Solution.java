package sharedSearch;

import java.util.LinkedList;

/**
 * Defines a search solution, contains a list of the searchAction class. 
 * @author Or Priesender
 *
 */
public class Solution {
	
	public LinkedList<SearchAction> actions;
	
	public Solution(LinkedList<SearchAction> actionList){
		this.actions = actionList;
		
	}

	LinkedList<SearchAction>  reverseList(LinkedList<SearchAction> toReverse) {
		LinkedList<SearchAction> newList = new LinkedList<>();
		if(toReverse.isEmpty())
			return toReverse;
			while(!toReverse.isEmpty()){
				newList.addLast(toReverse.removeLast());
			}
			return newList;
	}

	public LinkedList<SearchAction> getActions() {
		return actions;
	}

	public void setActions(LinkedList<SearchAction> actions) {
		this.actions = actions;
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		for(SearchAction a : actions)
			sb.append(a.getName()).append("\n");
		
		return sb.toString();
	}
}
