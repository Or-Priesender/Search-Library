package test;

public class Position  {
	public int col,row;
	
	public Position(int col,int row){
		this.col = col;
		this.row = row;
	}
	
	@Override
	public boolean equals(Object arg0) {
		Position p = (Position) arg0;
		return (this.col == p.col && this.row == p.row);
	}
	
	@Override
	public int hashCode() {
		
		return Integer.hashCode(col)+Integer.hashCode(row);
	}

	
}
