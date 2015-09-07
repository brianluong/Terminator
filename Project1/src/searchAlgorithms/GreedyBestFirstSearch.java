package searchAlgorithms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GreedyBestFirstSearch extends InformedSearch {

	public GreedyBestFirstSearch(char[][] maze) {
		super(maze);
	}

	public List<Index> search() {
		Index starting = SearchUtils.getStartingIndex(maze);
		List<Index> frontier = new ArrayList<>();
		Index goal = SearchUtils.getGoalIndex(maze);
		Set<Index> explored = new HashSet<>();
		List<Index> solutionPath = new ArrayList<>();
		
		frontier.add(starting);
		while (frontier.size() > 0) {
			Index expand = getClosest(frontier, goal);
			frontier.remove(expand);
			explored.add(expand);
			Index[] adjNodes = adjList.get(expand);
			
			for (Index i : adjNodes) {
				if (!explored.contains(i)) {
					i.prev = expand;
					if (SearchUtils.isGoal(i, maze)) {
						for (Index p = i; p != null; p = p.prev) {
							solutionPath.add(new Index(p.row, p.column, null));	
						}
					} else {
						frontier.add(i);
					}	
				}
			}
		}
		return solutionPath;
	}
	
	// f(n) = h(n)
	public Index getClosest(List<Index> frontier, Index goal) {
		int lowestManhattanDistance = Integer.MAX_VALUE;
		Index closestIndex = null;
		for (Index i : frontier) {
			int currentManhattanDistance = getManhattanDistance(i, goal);
			if (currentManhattanDistance < lowestManhattanDistance) {
				lowestManhattanDistance = currentManhattanDistance;
				closestIndex = i;
			}
		}
		return closestIndex;
	}
}
