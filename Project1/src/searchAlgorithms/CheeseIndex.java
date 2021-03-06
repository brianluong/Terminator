package searchAlgorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CheeseIndex extends Index {

	List<Index> cheeses;
	
	public CheeseIndex() {
		cheeses = new ArrayList<>();
	}
	
	public CheeseIndex(int r, int c, Index p) {
		super(r, c, p);
		cheeses = new ArrayList<>();
	}
	
	public void addCheese(Index index) {
		this.cheeses.add((CheeseIndex) index);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this.row == ((CheeseIndex) o).row && this.column == ((CheeseIndex) o).column) {
			if (this.cheeses.size() == ((CheeseIndex) o).cheeses.size()) {
				for (Index cheese : this.cheeses) {
					if (!((CheeseIndex) o).cheeses.contains(cheese)) {
						return false;
					}
				}
				return true;
			}
		}
		return false;
	}
}